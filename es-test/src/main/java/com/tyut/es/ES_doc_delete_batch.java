package com.tyut.es;


import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author OldGj 2024/03/27
 * @version v1.0
 * @apiNote 批量文档删除
 */
public class ES_doc_delete_batch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
        // 批量删除
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new DeleteRequest().index("user").id("1001"));
        bulkRequest.add(new DeleteRequest().index("user").id("1003"));
        bulkRequest.add(new DeleteRequest().index("user").id("1002"));

        // 发送批量请求
        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(Arrays.toString(response.getItems()));
        System.out.println(response.getTook());
        client.close();
    }
}
