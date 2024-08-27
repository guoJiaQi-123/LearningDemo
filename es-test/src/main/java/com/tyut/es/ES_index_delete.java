package com.tyut.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author OldGj 2024/03/26
 * @version v1.0
 * @apiNote 删除索引
 */
public class ES_index_delete {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200, "http")));
        // 创建删除索引请求
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("user");
        // 得到响应
        AcknowledgedResponse response = esClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        boolean acknowledged = response.isAcknowledged();
        System.out.println("索引删除：" + acknowledged);
        esClient.close();
    }
}
