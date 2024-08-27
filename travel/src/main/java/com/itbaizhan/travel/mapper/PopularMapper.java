package com.itbaizhan.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.travel.pojo.Popular;
import com.itbaizhan.travel.pojo.Product;

public interface PopularMapper extends BaseMapper<Popular> {

    Page<Popular> findPopularPage(Page<Popular> PopularPage);
}
