package com.tyut.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author OldGj 2024/03/26
 * @version v1.0
 * @apiNote ES客户端测试连接
 */
public class Elasticsearch01_Client {
    public static void main(String[] args) throws IOException {

        // 客户端与服务端建立连接
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 关闭客户端
        esClient.close();
    }
}
