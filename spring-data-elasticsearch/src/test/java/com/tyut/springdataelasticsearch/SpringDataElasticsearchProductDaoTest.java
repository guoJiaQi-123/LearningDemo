package com.tyut.springdataelasticsearch;

import com.tyut.springdataelasticsearch.dao.ProductDao;
import com.tyut.springdataelasticsearch.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author OldGj 2024/03/30
 * @version v1.0
 * @apiNote springData集成elasticSearch文档操作测试
 */
@SpringBootTest
public class SpringDataElasticsearchProductDaoTest {

    @Autowired
    private ProductDao productDao;

    /**
     * 测试新增文档数据
     */
    @Test
    void testCreate() {
        Product product = new Product();
        product.setId(1L);
        product.setCategory("小米SU7");
        product.setPrice(215900.0);
        product.setTitle("小米汽车");
        product.setImages("海湾蓝");
        productDao.save(product);
    }


    /**
     * 测试修改文档数据
     */
    @Test
    void testUpdate() {
        Product product = new Product();
        product.setId(1L);
        product.setCategory("问界M7");
        product.setPrice(536800.0);
        product.setTitle("华为汽车");
        product.setImages("海湾蓝");
        productDao.save(product);
    }


    /**
     * 测试按照ID查询文档数据
     */
    @Test
    void testFindById() {
        Product product = productDao.findById(1L).get();
        System.out.println(product);
    }

    /**
     * 测试删除文档数据
     */
    @Test
    void testDelete() {
        Product product = new Product();
        product.setId(1L);
        productDao.delete(product);
    }

    /**
     * 测试批量插入文档数据
     */
    @Test
    void testCreateAll() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(1L + i);
            product.setCategory("问界M7");
            product.setPrice(536800.0 + i * 50);
            product.setTitle("华为汽车");
            product.setImages("海湾蓝");
            productList.add(product);
        }
        productDao.saveAll(productList);
    }

    /**
     * 测试分页查询
     */
    @Test
    void testFindPage() {
        //设置排序(排序方式，正序还是倒序，排序的 id)
        /*
         * page:从哪一页开始
         * size：一页读取多少条数据
         * sort：设置排序(排序方式，正序还是倒序，根据什么字段排序)
         */
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "price"));
        Page<Product> all = productDao.findAll(pageRequest);
        all.stream().forEach(System.out::println);
    }
}
