package com.tyut.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author OldGj 2024/03/27
 * @version v1.0
 * @apiNote 批量添加文档
 */
public class ES_doc_insert_batch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
        // 批量添加
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("user").id("1007").source(XContentType.JSON, "name", "拉萨","age",30,"sex","女"));
        bulkRequest.add(new IndexRequest().index("user").id("1008").source(XContentType.JSON, "name", "阿萨德","age",40,"sex","男"));
        bulkRequest.add(new IndexRequest().index("user").id("1009").source(XContentType.JSON, "name", "离散","age",55,"sex","女"));
        bulkRequest.add(new IndexRequest().index("user").id("1010").source(XContentType.JSON, "name", "loc","age",30,"sex","女"));
        bulkRequest.add(new IndexRequest().index("user").id("1011").source(XContentType.JSON, "name", "参考","age",30,"sex","男"));
        bulkRequest.add(new IndexRequest().index("user").id("1012").source(XContentType.JSON, "name", "洗车","age",29,"sex","女"));
        // 发出批量请求
        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(Arrays.toString(response.getItems()));
        client.close();
    }
}
