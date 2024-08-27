package com.bjsxt.web.servlet;

import com.bjsxt.commons.Constants;
import com.bjsxt.exception.UserNotFoundException;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.Impl.UserLoginServiceImpl;
import com.bjsxt.service.UserLoginService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/login.do")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");
        //获取用户输入的验证码
        String code = req.getParameter("code");
        try {
            HttpSession httpSession = req.getSession();
            //获取动态生成的正确的验证码
            String rightCode = (String) httpSession.getAttribute(Constants.VALIDATE_SESSION_KEY);
            //如果用户输入的验证码与正确的验证码相同
            if(rightCode.equals(code)){
                UserLoginService userLoginService=new UserLoginServiceImpl();
                Users users = userLoginService.userLogin(username, userpwd);
                //建立服务端与客户端的会话状态
                httpSession.setAttribute(Constants.USER_SESSION_KEY,users);
                //实现用户只能在一处登录
                ServletContext servletContext = this.getServletContext();
                //先从上下文对象中根据用户ID获取session
                HttpSession oldSession = (HttpSession) servletContext.getAttribute(users.getUserid() + "");
                //如果该用户ID对应的Session对象为不为空，说明此时该用户在别处登录
                if(oldSession!=null){
                    //将该用户在别处登录的设置的Session从上下文对象中删除
                    servletContext.removeAttribute(users.getUserid()+"");
                    //销毁已经登录的会话状态
                    oldSession.invalidate();
                }
                //将现有登录的会话状态放入上下文对象中
                servletContext.setAttribute(""+users.getUserid(),httpSession);
                //使用重定向方式跳转页面
                resp.sendRedirect("main.jsp");
            }else {
                req.setAttribute(Constants.REQUEST_MSG,"输入验证码错误！请重新输入！");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }

        }catch (UserNotFoundException e){
            req.setAttribute(Constants.REQUEST_MSG,e.getMessage());
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }catch (Exception e){
            resp.sendRedirect("error.jsp");
        }


    }
}
