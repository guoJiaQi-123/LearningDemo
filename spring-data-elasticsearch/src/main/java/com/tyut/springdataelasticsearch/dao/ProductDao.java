package com.tyut.springdataelasticsearch.dao;

import com.tyut.springdataelasticsearch.pojo.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author OldGj 2024/03/30
 * @version v1.0
 * @apiNote DAO层
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product, Long> {
}
