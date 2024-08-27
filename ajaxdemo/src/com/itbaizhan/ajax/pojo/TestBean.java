package com.itbaizhan.ajax.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itbaizhan.ajax.util.GenderJsonDeserializer;
import com.itbaizhan.ajax.util.GenderJsonSerializer;

import java.util.Date;
import java.util.List;

public class TestBean {

    private String id;

    private String name;

    private Integer sex;

    private List<Element> elements;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 上自定义的序列化类
     * @return
     */
    @JsonSerialize(using = GenderJsonSerializer.class)
    public Integer getSex() {
        return sex;
    }

    /**
     * 加上自定义的反序列化类
     * @param sex
     */
    @JsonDeserialize(using = GenderJsonDeserializer.class)
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", elements=" + elements +
                '}';
    }
}
