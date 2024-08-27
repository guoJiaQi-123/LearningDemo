package com.itbaizhan.servlet;

import com.itbaizhan.pojo.Student;
import com.itbaizhan.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allStudent")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService service = new StudentService();
        try {
            List<Student> allStudent = service.findAllStudent();
            req.setAttribute("allStudent",allStudent);
            req.getRequestDispatcher("allStudent.jsp").forward(req,resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
