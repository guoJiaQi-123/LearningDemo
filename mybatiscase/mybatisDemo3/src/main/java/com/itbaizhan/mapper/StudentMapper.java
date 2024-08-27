package com.itbaizhan.mapper;

import com.itbaizhan.pojo.Student;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentMapper {



    @Results(id = "studentMapper",value = {
            @Result(id = true,property = "sid",column = "sid"),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "age",column = "age"),
            /**
             * property:属性名
             * column:外键列（调用从表方法时传入的参数列）
             * one：表示该属性是一个对象
             * select:调用的从表方法
             * fetchType：是否延迟加载
             */
            @Result(property = "classes",column = "classId",
                    one = @One(select = "com.itbaizhan.mapper.ClassesMapper.findClassesByCid"
                               ,fetchType = FetchType.EAGER))
    })
    @Select("select * from student")
    List<Student> findAllStudent();




    @Select("select * from student where classId = #{cid}")
    List<Student> findAllStudentByCid(int cid);
}
