package com.tyut.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import javax.naming.directory.SearchResult;
import java.io.IOException;

/**
 * @author OldGj 2024/03/27
 * @version v1.0
 * @apiNote 请求体查询 - 全量查询 matchAllQuery
 */
public class ES_doc_query {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // // 查询所有数据
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        request.source(searchSourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits searchHits = response.getHits();

        for (SearchHit hit : searchHits) {
            System.out.println(hit);
        }
        client.close();
    }

}
