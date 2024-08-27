package com.itbaizhan.ajax.servlet;


import com.alibaba.fastjson.JSON;
import com.itbaizhan.ajax.pojo.User;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebServlet("/user.do")
public class UserServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        ArrayList<User> list = new ArrayList<>();
        User user1 = new User(1,"zhangsan","123",2000d,"1997-09-01");
        User user2 = new User(2,"lisi","123",3000d,"1998-08-23");
        User user3 = new User(3,"zhaoliu","123",2500d,"1996-05-16");
        User user4 = new User(4,"wangwu","123",2080d,"1995-10-12");
        User user5 = new User(5,"zhengsan","123",3200d,"1999-12-20");
        User user6 = new User(6,"liugang","123",4200d,"1994-04-10");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);

        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("list",list);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if("getData".equals(flag)){
            this.getData(req,resp);
        }else if("addUser".equals(flag)){
            this.addUser(req,resp);
        }else if("updateUser".equals(flag)){
            this.updateUser(req,resp);
        }else if("delete".equals(flag)){
            this.deleteUser(req,resp);
        }
    }

    // 获取页面初始化数据
    private void getData(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<User> list = (List<User>)
                this.getServletContext().getAttribute("list");
        String s = JSON.toJSONString(list);
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
        pw.print(s);
        pw.flush();
        pw.close();
    }

    /**
     * 处理添加用户请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = this.createUser(req);
        ServletContext servletContext = this.getServletContext();
        List<User> list = (List<User>) servletContext.getAttribute("list");
        list.add(user);
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.print("添加成功");
        pw.flush();
        pw.close();
    }

    /**
     * 处理更新用户请求
     * @param req
     * @param resp
     * @throws IOException
     */
    private void updateUser(HttpServletRequest req,
                            HttpServletResponse resp) throws IOException{
        User user = this.createUser(req);
        ServletContext servletContext = this.getServletContext();
        List<User> userList = (List<User>) servletContext.getAttribute("list");
        //list转map
        Map<Integer, User> userMap = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        //根据id获取user
        User user1 = userMap.get(user.getId());
        //删除指定的user
        userList.remove(user1);
        //添加新的user
        userList.add(user);
        //按id排序
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId();
            }
        });
        //输出至页面
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.print("更新成功");
        pw.flush();
        pw.close();
    }

    /**
     * 处理删除用户请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void deleteUser(HttpServletRequest req,
                            HttpServletResponse resp) throws ServletException, IOException{
        ServletContext servletContext = this.getServletContext();
        List<User> userList = (List<User>) servletContext.getAttribute("list");
        String userid = req.getParameter("userid");
        //list转map
        Map<Integer, User> userMap = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        //根据id获取user
        if(StringUtils.isNotEmpty(userid)){
            User user1 = userMap.get(Integer.parseInt(userid));
            //删除指定的user
            userList.remove(user1);
            resp.setContentType("text/plain;charset=utf-8");
            PrintWriter pw = resp.getWriter();
            pw.print("删除成功");
            pw.flush();
            pw.close();
        }else{
            resp.setContentType("text/plain;charset=utf-8");
            PrintWriter pw = resp.getWriter();
            pw.print("删除失败");
            pw.flush();
            pw.close();
        }
    }

    // 获取请求数据
    private User createUser(HttpServletRequest req){
        String userid = req.getParameter("userid");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String salary = req.getParameter("salary");
        String birthday = req.getParameter("birthday");

        User user = new User();
        user.setId(Integer.parseInt(userid));
        user.setUsername(username);
        user.setPassword(password);
        user.setSalary(Double.valueOf(salary));
        user.setBirthday(birthday);

        return user;
    }

}
