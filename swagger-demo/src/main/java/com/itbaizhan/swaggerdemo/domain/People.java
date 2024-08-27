package com.itbaizhan.swaggerdemo.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "人员",description = "人员实体类")
public class People {
    @ApiModelProperty(
            value = "人员ID",
            name = "id",
            example = "2022005946",
            required = true
    )
    private Long id;
    @ApiModelProperty(
            value = "姓名",
            name = "name",
            example = "张三",
            required = true
    )
    private String name;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
