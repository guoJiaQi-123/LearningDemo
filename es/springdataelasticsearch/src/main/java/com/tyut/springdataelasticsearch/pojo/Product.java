package com.tyut.springdataelasticsearch.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @version v1.0
 * @author OldGj 2024/6/16
 * @apiNote 产品类
 */
@Document(indexName = "product", createIndex = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * 产品ID
     */
    @Id
    @Field(type = FieldType.Integer, store = true, index = true)
    private Integer id;

    /**
     * 产品名
     */
    @Field(type = FieldType.Text, store = true, index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String productName;

    /**
     * 产品描述
     */
    @Field(type = FieldType.Text, store = true, index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String productDesc;


}
