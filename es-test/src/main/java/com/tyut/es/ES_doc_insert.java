package com.tyut.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author OldGj 2024/03/27
 * @version v1.0
 * @apiNote 文档 - 新增文档
 */
public class ES_doc_insert {
    public static void main(String[] args) throws IOException {
        // 与ES服务器建立连接
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");
        User user = new User();
        user.setName("张三");
        user.setAge(30);
        user.setSex("男");
        // user对象转JSON字符串
        ObjectMapper mapper = new ObjectMapper();
        String UserJSON = mapper.writeValueAsString(user);

        request.source(UserJSON, XContentType.JSON);
        // 新增文档
        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());

        // 关闭连接
        esClient.close();
    }
}
