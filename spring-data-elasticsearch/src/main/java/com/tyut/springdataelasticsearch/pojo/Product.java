package com.tyut.springdataelasticsearch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author OldGj 2024/03/30
 * @version v1.0
 * @apiNote 数据实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
// 和文档的映射关系 实体类映射操作
@Document(indexName = "product", shards = 3, replicas = 1) // 索引  分片  副本
public class Product {

    //必须有 id,这里的 id 是全局唯一的标识，等同于 es 中的"_id"
    @Id
    private Long id;//商品唯一标识

    /**
     * type : 字段数据类型
     * analyzer : 分词器类型
     * index : 是否索引(默认:true)
     * Keyword : 短语,不进行分词
     */
    @Field(type = FieldType.Text)
    private String title;//商品名称

    @Field(type = FieldType.Keyword)
    private String category;//分类名称

    @Field(type = FieldType.Double)
    private Double price;//商品价格

    @Field(type = FieldType.Keyword, index = false)
    private String images;//图片地址

}
