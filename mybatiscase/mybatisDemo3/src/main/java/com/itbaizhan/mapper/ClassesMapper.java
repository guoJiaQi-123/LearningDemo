package com.itbaizhan.mapper;

import com.itbaizhan.pojo.Classes;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ClassesMapper {

    //根据Cid查询班级
    @Select("select * from classes where cid = #{cid}")
    Classes findClassesByCid(int cid);




    //查询所有班级
    @Results(id = "classesMapper",value = {
            @Result(id = true,property = "cid",column = "cid"),
            @Result(property = "className",column = "className"),
            @Result(property = "studentList",column = "cid",
                    many = @Many(select = "com.itbaizhan.mapper.StudentMapper.findAllStudentByCid",
                    fetchType = FetchType.LAZY))
    })
    @Select("select * from classes")
    List<Classes> findAllClasses();


}
