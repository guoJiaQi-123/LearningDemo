package com.tyut.servlet;

import com.tyut.domain.UserBean;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @version v1.0
 * @author OldGj 2024/6/18
 * @apiNote TODO(一句话给出该类描述)
 */
@WebServlet(urlPatterns = "/register")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserBean userBean = new UserBean();
        userBean.setUser(username);
        userBean.setPassword(password);
        try {
            boolean flag = UserBean.insertUser(userBean);
            resp.setContentType("text/html;charset=utf-8");
            if (flag) {
                resp.sendRedirect("/welcome.jsp");
            } else {
                resp.sendRedirect("/register.jsp");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
