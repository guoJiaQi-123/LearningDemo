package com.tyut.aircraft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyut.aircraft.pojo.domain.Game;

import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/6/24
 * @apiNote TODO(一句话给出该类描述)
 */
public interface GameMapper extends BaseMapper<Game> {
    List<Game> selectRanking(String diff);
}
