package com.itbaizhan.mapper2;

import com.itbaizhan.pojo.Teacher;

import java.util.List;

public interface TeacherMapper2 {
    List<Teacher> findAllTeacherByClassesId(int classesId);
}
