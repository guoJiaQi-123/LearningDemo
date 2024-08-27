package com.tyut.springdataelasticsearch.repository;

import com.tyut.springdataelasticsearch.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/6/16
 * @apiNote 操作产品文档
 */
@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {


    @Query("""
            {
                "match": {
                    "productDesc": "?0"
                }
            }
            """)
    Page<Product> findByProductDescMatch(String keyword, Pageable pageable);

    @Query("""
            {
                "match": {
                    "productDesc": {
                        "query": "?0",
                        "fuzziness": 2
                    }
                }
            }
            """)
    List<Product> findByProductDescFuzzy(String keyword);

}
