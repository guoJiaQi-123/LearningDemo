package com.tyut.aircraft.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyut.aircraft.mapper.GameMapper;
import com.tyut.aircraft.pojo.domain.Game;
import com.tyut.aircraft.pojo.domain.User;
import com.tyut.aircraft.pojo.dto.RankingDTO;
import com.tyut.aircraft.pojo.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @version v1.0
 * @author OldGj 2024/6/24
 * @apiNote 游戏业务层
 */
@Service
public class GameService {

    @Autowired
    private UserService userService;
    @Autowired
    private GameMapper gameMapper;


    public void startGame(String name, String diff) {
        // 1. 根据用户名查询用户
        ResultDTO resultDTO = getResultDTO(diff);
        LambdaQueryWrapper<Game> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.orderByDesc(Game::getPersistTime);
        lambdaQueryWrapper.eq(Game::getDifficulty, diff);
        List<Game> list = gameMapper.selectList(lambdaQueryWrapper);
        int[] array = list.stream()
                .mapToInt(Game::getPersistTime).toArray();
        int ranking = array != null ? array.length + 1 : 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= resultDTO.getPersistTime()) {
                ranking = i + 1;
                break;
            }
        }
        for (int i = ranking - 1; i < list.size(); i++) {
            list.get(i).setRanking(list.get(i).getRanking() + 1);
            gameMapper.updateById(list.get(i));
        }
        Game game = Game.builder()
                .username(name)
                .createTime(new Date())
                .persistTime(resultDTO.getPersistTime())
                .ranking(ranking)
                .result(resultDTO.getResult())
                .difficulty(diff)
                .build();
        gameMapper.insert(game);
    }

    private static ResultDTO getResultDTO(String diff) {
        int shellNum = 45;
        switch (diff) {
            case "简单":
                shellNum = 55;
                break;
            case "中等":
                shellNum = 65;
                break;
            case "困难":
                shellNum = 75;
                break;
            case "地狱":
                shellNum = 85;
                break;
            case "炼狱":
                shellNum = 200;
                break;
        }
        MyGameFrame myGameFrame = new MyGameFrame(shellNum);
        ResultDTO resultDTO = myGameFrame.launchFrame();
        return resultDTO;
    }

    public List<Game> findAll() {
        LambdaQueryWrapper<Game> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.orderByDesc(Game::getCreateTime);
        List<Game> list = gameMapper.selectList(lambdaQueryWrapper);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 M 月 d 日 H 时 m 分 s 秒");
        for (Game game : list) {
            game.setCreateTimeDTO(sdf.format(game.getCreateTime()));
            game.setPersistTimeDTO(game.getPersistTime().toString() + " 秒");
        }
        return list;
    }

    public List<Map<String, Integer>> findRanking(String diff) {
        List<Map<String, Integer>> list = new ArrayList<>();
        List<Game> gameList = gameMapper.selectRanking(diff);
        for (Game game : gameList) {
            Map<String, Integer> map = new HashMap<>();
            map.put(game.getUsername(), game.getPersistTime());
            list.add(map);
        }
        return list.stream().limit(5).collect(Collectors.toList());
    }

    public Long findAllBoard(String name) {
        LambdaQueryWrapper<Game> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Game::getUsername, name);
        Long count = gameMapper.selectCount(lambdaQueryWrapper);
        return count;
    }

    public Page<Game> findGamePage(String name, int page, int size) {
        Page<Game> page1 = new Page<>(page, size);
        LambdaQueryWrapper<Game> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Game::getUsername, name);
        Page<Game> gamePage = gameMapper.selectPage(page1, lambdaQueryWrapper);
        List<Game> list = gamePage.getRecords();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 M 月 d 日 H 时 m 分 s 秒");
        for (Game game : list) {
            game.setCreateTimeDTO(sdf.format(game.getCreateTime()));
            game.setPersistTimeDTO(game.getPersistTime().toString() + " 秒");
        }
        gamePage.setRecords(list);
        return gamePage;
    }

    public void deleteGame(Integer gid) {
        gameMapper.deleteById(gid);
    }

    /**
     * 获取当前用户最好成绩的排名
     * @param name
     * @return
     */
    public RankingDTO getRanking(String name) {
        LambdaQueryWrapper<Game> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Game::getUsername, name);
        lambdaQueryWrapper.orderByAsc(Game::getRanking);
        List<Game> gameList = gameMapper.selectList(lambdaQueryWrapper);
        if (!gameList.isEmpty()) {
            Game game = gameList.get(0);
            String difficulty = game.getDifficulty();
            LambdaQueryWrapper<Game> lambdaQueryWrapper1 = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(Game::getDifficulty, difficulty);
            lambdaQueryWrapper.orderByDesc(Game::getRanking);
            List<Game> list = gameMapper.selectList(lambdaQueryWrapper1);
            RankingDTO rankingDTO = RankingDTO.builder()
                    .index("第" + game.getRanking() + "名")
                    .diff(difficulty).build();
            return rankingDTO;
        }
        return new RankingDTO("暂无排名", "无");
    }
}
