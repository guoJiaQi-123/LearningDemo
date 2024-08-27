package com.tyut.aircraft.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyut.aircraft.pojo.domain.Game;
import com.tyut.aircraft.pojo.dto.RankingDTO;
import com.tyut.aircraft.service.GameService;
import com.tyut.aircraft.util.BaseContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/6/21
 * @apiNote 页面跳转控制层
 */
@RequestMapping("/air")
@Controller
public class PageController {


    @Autowired
    private GameService gameService;
    String name = "";

    //后台页面访问
    @RequestMapping("/{page}")
    public ModelAndView showBackStagePage(@PathVariable String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        if (page.equals("index")) {
            if (!StringUtils.hasText(name)) {
                name = BaseContext.getCurrentName();
            }
            List<Game> list = gameService.findAll();
            long allBoard = gameService.findAllBoard(name);
            modelAndView.addObject("gameList", list);
            modelAndView.addObject("allBoard", allBoard);
            RankingDTO rankingDTO = gameService.getRanking(name);
            modelAndView.addObject("ranking", rankingDTO);
            modelAndView.setViewName("/air/index");
        } else if (page.equals("user_ranking")) {
            List<Map<String, Integer>> ranking_rm = gameService.findRanking("入门");
            List<Map<String, Integer>> ranking_jd = gameService.findRanking("简单");
            List<Map<String, Integer>> ranking_zd = gameService.findRanking("中等");
            List<Map<String, Integer>> ranking_kn = gameService.findRanking("困难");
            List<Map<String, Integer>> ranking_dy = gameService.findRanking("地狱");
            List<Map<String, Integer>> ranking_ly = gameService.findRanking("炼狱");
            modelAndView.addObject("ranking_rm", ranking_rm);
            modelAndView.addObject("ranking_jd", ranking_jd);
            modelAndView.addObject("ranking_zd", ranking_zd);
            modelAndView.addObject("ranking_kn", ranking_kn);
            modelAndView.addObject("ranking_dy", ranking_dy);
            modelAndView.addObject("ranking_ly", ranking_ly);
            modelAndView.setViewName("/air/user_ranking");
        } else if (page.equals("user_login")) {
            name = "";
        } else if (page.equals("user_history")) {
            request.setAttribute("name", name);
            request.getRequestDispatcher("/user/history").forward(request, response);
        } else {
            modelAndView.setViewName("/air/" + page);
        }
        return modelAndView;
    }


    // 忽略访问项目logo
    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }

}
