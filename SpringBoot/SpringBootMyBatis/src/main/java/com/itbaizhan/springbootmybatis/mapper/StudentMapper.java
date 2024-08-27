package com.itbaizhan.springbootmybatis.mapper;

import com.itbaizhan.springbootmybatis.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findAll();
}