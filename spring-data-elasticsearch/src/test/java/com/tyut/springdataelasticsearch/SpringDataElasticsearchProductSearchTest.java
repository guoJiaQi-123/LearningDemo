package com.tyut.springdataelasticsearch;

import com.tyut.springdataelasticsearch.dao.ProductDao;
import com.tyut.springdataelasticsearch.pojo.Product;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @author OldGj 2024/03/30
 * @version v1.0
 * @apiNote 文档搜索测试类
 */
@SpringBootTest
public class SpringDataElasticsearchProductSearchTest {

    @Autowired
    private ProductDao productDao;

    /**
     * term 查询
     * search(termQueryBuilder) 调用搜索方法，参数查询构建器对象
     */
    @Test
    void testTermSearch() {
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("price", 536850.0);
        Iterable<Product> products = productDao.search(queryBuilder);
        products.forEach(System.out::println);
    }

    /**
     * term 查询加分页
     */
    @Test
    void testTermSearchPage() {
        // 查询条件构建
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("category", "问界M7");
        // 分页查询条件构建
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.ASC, "id"));
        // 查询
        Page<Product> products = productDao.search(queryBuilder, pageRequest);
        // 打印
        products.stream().forEach(System.out::println);
    }

}
