package com.itbaizhan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GetRequestDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码，解决中文乱码问题
        req.setCharacterEncoding("UTF-8");
        //获取用户名
        String userName = req.getParameter("userName");
        System.out.println(userName);
        //获取用户名密码
        String userPwd = req.getParameter("userPwd");
        //获取复选框数据
        String[] arr = req.getParameterValues("userLike");
        //获取表单中所有的Key值
        Enumeration<String> parameterNames = req.getParameterNames();
        List<String> paraList =new ArrayList<>();
        while (parameterNames.hasMoreElements()){
            paraList.add(parameterNames.nextElement());
        }
        List<String> list = Arrays.asList(arr);
        //获取请求中所有的数据
        Map<String, String[]> parameterMap = req.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("userName: "+userName);
        pw.println("userPwd: "+userPwd);
        pw.println("userLike: "+list);
        pw.println("names: "+paraList);
        while (iterator.hasNext()){
            Map.Entry<String, String[]> entry = iterator.next();
            String key = entry.getKey();
            String[] value = entry.getValue();
            pw.println(key + " = " + Arrays.asList(value));
        }
        pw.flush();
        pw.close();
    }
}
