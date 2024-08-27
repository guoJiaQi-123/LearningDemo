package com.itbaizhan.springbootdemo2.controller;

import com.itbaizhan.springbootdemo2.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {

    @GetMapping("/show")
    public String show(Model model, HttpServletRequest request, HttpSession session) {
        model.addAttribute("msg", "你好，太原理工");

        List<User> users = new ArrayList<>();
        users.add(new User("1", "郭家旗", 20));
        users.add(new User("2", "苏红润", 19));
        users.add(new User("3", "郭佳颖", 24));
        model.addAttribute("users", users);

        request.setAttribute("req", "HttpServletRequest");
        session.setAttribute("ses", "HttpSession");
        session.getServletContext().setAttribute("app", "ServletContext");

        model.addAttribute("id", 100);
        model.addAttribute("name", "guojiaqi");
        return "index";
    }

    @GetMapping("/show2")
    @ResponseBody
    public String show2(int id, String name) {
        return id + " : " + name;
    }

    @GetMapping("/show3/{id}/{name}")
    @ResponseBody
    public String show3(@PathVariable int id,@PathVariable String name){
        return id+" : "+name;
    }
}
