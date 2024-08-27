package com.itbaizhan.mapper2;


import com.itbaizhan.pojo.Classes;
import com.itbaizhan.pojo.Student;

import java.util.List;

public interface StudentMapper2 {
    List<Student> findAllStudentByClassId(int classesId);

    List<Student> findAllStudent();
}
