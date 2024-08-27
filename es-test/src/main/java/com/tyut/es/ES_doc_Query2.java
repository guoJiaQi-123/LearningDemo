package com.tyut.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.List;

/**
 * @author OldGj 2024/03/27
 * @version v1.0
 * @apiNote 条件查询
 */
public class ES_doc_Query2 {
    /*
    //1.条件查询
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))

        );
        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("age",30));
        request.source(searchSourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        response.getHits().forEach(System.out::println);
        client.close();
    }*/


    /*
    //2.分页查询
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))

        );
        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.from(0);// 从哪一页开始
        searchSourceBuilder.size(2); // 每页条数
        request.source(searchSourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        response.getHits().forEach(System.out::println);
        client.close();
    }*/


//    //3.排序查询
//    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(new HttpHost("localhost", 9200, "http"))
//
//        );
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        // 查询条件构造
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchSourceBuilder.sort("age", SortOrder.ASC); // 对age字段升序排序
//        // 查询请求中加入查询条件
//        request.source(searchSourceBuilder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        response.getHits().forEach(System.out::println);
//        client.close();
//    }


//    // 4.过滤字段查询
//    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(new HttpHost("localhost", 9200, "http"))
//
//        );
//        SearchRequest request = new SearchRequest();
//        request.indices("user"); // 指定哪个索引
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchSourceBuilder.sort("age",SortOrder.ASC);
//        //查询字段过滤
//        String[] excludes = new String[]{}; // 过滤字段
//        String[] includes = new String[]{}; // 显示字段
//        searchSourceBuilder.fetchSource(includes, excludes);
//        request.source(searchSourceBuilder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        response.getHits().forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });
//        client.close();
//    }

    // 5.组合查询
//    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(new HttpHost("localhost", 9200, "http"))
//
//        );
//        SearchRequest request = new SearchRequest();
//        request.indices("user"); // 指定哪个索引
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        // 构建组合查询条件
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age", 30));
////        boolQueryBuilder.must(QueryBuilders.matchQuery("name", "张三"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",30));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",10));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",29));
//        searchSourceBuilder.query(boolQueryBuilder);
//        request.source(searchSourceBuilder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        response.getHits().forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });
//        client.close();
//    }
    // 6.范围查询
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))

        );
        SearchRequest request = new SearchRequest();
        request.indices("user"); // 指定哪个索引
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // age字段大于10 小于等于30
        searchSourceBuilder.query(QueryBuilders.rangeQuery("age").gt(10).lt(30));
        request.source(searchSourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        response.getHits().forEach(hit -> {
            System.out.println(hit.getSourceAsString());
        });
        client.close();
    }

}
