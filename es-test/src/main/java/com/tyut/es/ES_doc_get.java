package com.tyut.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author OldGj 2024/03/27
 * @version v1.0
 * @apiNote 文档查询
 */
public class ES_doc_get {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
        GetRequest getRequest = new GetRequest();
        getRequest.index("user").id("1001");
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());

        client.close();
    }
}
