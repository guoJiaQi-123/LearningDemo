package com.itbaizhan.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itbaizhan.springbootmybatisplus.domain.Student;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {

    @SuppressWarnings("all")
    void deleteAll();


}
