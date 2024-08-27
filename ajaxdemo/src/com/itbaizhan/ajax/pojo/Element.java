package com.itbaizhan.ajax.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Element {
    //年龄
    private Integer age;
    //呢称
//    @JsonProperty("sname")
    private String ename;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH")
    private Date updateTime;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Element{" +
                "age=" + age +
                ", ename='" + ename + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
