package com.tyut.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author OldGj 2024/03/26
 * @version v1.0
 * @apiNote 查看索引
 */
public class ES_index_get {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 创建查看索引请求
        GetIndexRequest getIndexRequest = new GetIndexRequest("user");
        GetIndexResponse indexResponse = esClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.getAliases());
        System.out.println(indexResponse.getMappings());
        System.out.println(indexResponse.getSettings());
        esClient.close();
    }
}
