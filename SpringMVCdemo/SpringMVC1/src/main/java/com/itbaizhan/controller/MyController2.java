package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class MyController2 {

    @RequestMapping("/helloMVC")
    public void helloMVC(){
        System.out.println("helloMVC");
    }

    @RequestMapping("/c2/hello1")
    public String helloMVC1(){
        System.out.println("helloMVC");
        return "demo1";
    }

    @RequestMapping("/c2/hello2")
    public ModelAndView helloMVC2(){
        System.out.println("返回值为：ModelAndView类型");
        //1.获取一个ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //2.获取Model对象，本质是一个Map类型的对象
        Map<String, Object> model = modelAndView.getModel();
        //3.向Request域中设置值
        model.put("name","郭家旗");
        //4.设置一个跳转试图页面名
        modelAndView.setViewName("helloGJQ");
        //5.返回ModelAndView对象
        return modelAndView;
    }

    @RequestMapping("/c2/hello3")
    public String setRequest(HttpServletRequest request){
        request.setAttribute("name","郭家旗1");
        return "helloGJQ";
    }

    @RequestMapping("/c2/hello4")
    public String setRequest(ModelMap model){
        model.addAttribute("name","郭家旗3");
        return "helloGJQ";
    }

    @RequestMapping("/c2/hello5")
    public String setRequest(Map map){
        map.put("name","郭家旗6");
        return "helloGJQ";
    }
    @RequestMapping("/c2/hello6")
    public String setSession(HttpSession session){
        session.setAttribute("address","北京");
        return "helloGJQ";
    }

    @RequestMapping("/c2/hello7")
    public String setContext(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("age",20);
        return "helloGJQ";
    }

    @RequestMapping("/c2/hello8")
    public void myForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name","郭家旗");
//        request.getRequestDispatcher("/c2/hello9").forward(request,response);
        response.sendRedirect("/c2/hello9");
    }

    @RequestMapping("/c2/hello9")
    public void myForward2(HttpServletRequest request , HttpServletResponse response){
        System.out.println("hello");
        System.out.println(request.getAttribute("name"));
    }

    @RequestMapping("/c2/hello10")
    public String MVCForward(HttpServletRequest request){

        request.setAttribute("name","gjq");
//        return "forward:/c2/hello9";
        return "redirect:/c2/hello9";
    }


}
