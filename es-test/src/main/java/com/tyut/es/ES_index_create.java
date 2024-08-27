package com.tyut.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @author OldGj 2024/03/26
 * @version v1.0
 * @apiNote 创建索引
 */
public class ES_index_create {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
        // 实例化创建索引请求
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("user");
        // 发送创建索引请求并接受响应
        CreateIndexResponse createIndexResponse =
                esClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        // 索引是否创建成功 响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引创建：" + acknowledged);
        esClient.close();
    }
}
