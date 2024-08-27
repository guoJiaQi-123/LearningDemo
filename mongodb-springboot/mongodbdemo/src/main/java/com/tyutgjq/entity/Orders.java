package com.tyutgjq.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Orders {

    private String _id;

    private String name;

    private String size;

    private Integer price;

    private Integer quantity;

    private Date date;
}
