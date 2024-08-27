package com.itbaizhan.travel.controller.frontdesk;

import com.itbaizhan.travel.pojo.Member;
import com.itbaizhan.travel.pojo.Popular;
import com.itbaizhan.travel.service.FavoriteService;
import com.itbaizhan.travel.service.PopularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequestMapping("/frontdesk/popular")
@Controller
public class FrontDeskPopularController {

    @Autowired
    private PopularService popularService;
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/productDetail")
    public ModelAndView productDetail(Integer pid, HttpSession session){
        Popular popularDesc = popularService.findPopularDesc(pid);
        ModelAndView modelAndView =new ModelAndView();
        Member member = (Member) session.getAttribute("member");
        if(member==null){
            modelAndView.addObject("favorite",false);
        }else {
            boolean favorite = favoriteService.isFavorite(pid, member.getMid());
            if(favorite){
                modelAndView.addObject("favorite",true);
            }else {
                modelAndView.addObject("favorite",false);
            }
        }
        modelAndView.addObject("product",popularDesc);
        modelAndView.setViewName("/frontdesk/route_detail");
        return modelAndView;
    }

}
