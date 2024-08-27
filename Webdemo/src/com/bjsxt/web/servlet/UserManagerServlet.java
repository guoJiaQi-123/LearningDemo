package com.bjsxt.web.servlet;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.Impl.UserManagerServiceImpl;
import com.bjsxt.service.UserManagerService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userManager.do")
public class UserManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag =req.getParameter("flag");
        if("addUser".equals(flag)){
            this.addUser(req,resp);
        }else if("findUser".equals(flag)){
            this.findUser(req,resp);
        }else if("preUpdate".equals(flag)){
            this.preUpdata(req,resp);
        }else if("modifyUser".equals(flag)){
            this.modifyUser(req,resp);
        }else if("deleteUser".equals(flag)){
            this.deleteUser(req,resp);
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userid = req.getParameter("userid");
        try {
            UserManagerService userManagerService=new UserManagerServiceImpl();
            userManagerService.deleteUserByUserId(Integer.parseInt(userid));
            resp.sendRedirect("ok.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }

    }

    private void modifyUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Users users = this.creatUser(req);
        String userid = req.getParameter("userid");
        users.setUserid(Integer.parseInt(userid));
        try {
            UserManagerService userManagerService = new UserManagerServiceImpl();
            userManagerService.modifyUser(users);
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    /**
     * 预更新servlet
     * @param req
     * @param resp
     */
    private void preUpdata(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userid = req.getParameter("userid");
        try {
            UserManagerService userManagerService = new UserManagerServiceImpl();
            Users user = userManagerService.findUserByUserId(Integer.parseInt(userid));
            req.setAttribute("user",user);
            req.getRequestDispatcher("usermanager/updateUser.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询用户
    private void findUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = this.creatUser(req);
        try {
            UserManagerService userManagerService=new UserManagerServiceImpl();
            List<Users> list = userManagerService.findUser(users);
            req.setAttribute("list",list);
            req.getRequestDispatcher("usermanager/viewUser.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }


    }

    //添加用户
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        Users users = this.creatUser(req);
        try {
            UserManagerService userManagerService=new UserManagerServiceImpl();
            userManagerService.addUser(users);
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
    //读取请求中的数据，创建用户
    private Users creatUser(HttpServletRequest req) {
        Users users=new Users();
        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");
        String usersex = req.getParameter("usersex");
        String phonenumber = req.getParameter("phonenumber");
        String qqnumber = req.getParameter("qqnumber");
        users.setUsername(username);
        users.setUserpwd(userpwd);
        users.setUsersex(usersex);
        users.setPhonenumber(phonenumber);
        users.setQqnumber(qqnumber);
        return users;
    }
}
