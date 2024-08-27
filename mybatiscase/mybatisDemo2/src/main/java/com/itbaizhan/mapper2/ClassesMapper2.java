package com.itbaizhan.mapper2;

import com.itbaizhan.pojo.Classes;

import java.util.List;

public interface ClassesMapper2 {
    List<Classes> findAllClasses();

    Classes findAllClassesByStudentId(int StudentId);
}
