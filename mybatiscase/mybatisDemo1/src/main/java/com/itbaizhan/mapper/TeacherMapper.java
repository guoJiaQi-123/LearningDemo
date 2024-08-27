package com.itbaizhan.mapper;

import com.itbaizhan.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> findAll();

    List<Teacher> findById(int id);
}
