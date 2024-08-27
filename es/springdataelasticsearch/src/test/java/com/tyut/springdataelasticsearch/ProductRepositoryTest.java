package com.tyut.springdataelasticsearch;

import com.tyut.springdataelasticsearch.pojo.Product;
import com.tyut.springdataelasticsearch.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @version v1.0
 * @author OldGj 2024/6/16
 * @apiNote 测试类
 */
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;


    /**
     * 保存文档
     */
    @Test
    public void addProduct() {
        Product product = Product.builder()
                .id(1)
                .productName("iphone16")
                .productDesc("iPhone是苹果最新旗舰手机").build();
        repository.save(product);
        // 添加一些数据
        repository.save(new Product(2, "三体1", "三体1是优秀的科幻小说"));
        repository.save(new Product(3, "三体2", "三体2是优秀的科幻小说"));
        repository.save(new Product(4, "三体3", "三体3是优秀的科幻小说"));
        repository.save(new Product(5, "elasticsearch", "elasticsearch是基于lucene开发的优秀的搜索引擎"));
    }

    /**
     * 更新文档
     */
    @Test
    public void updateProduct() {
        Product product = Product.builder()
                .id(1)
                .productName("iphone17")
                .productDesc("iPhone17是苹果最新旗舰手机").build();
        repository.save(product);
    }


    /**
     * 查询所有文档
     */
    @Test
    public void findAllProduct() {
        Iterable<Product> all = repository.findAll();
        all.forEach(System.out::println);
    }


    /**
     * 根据ID查询文档
     */
    @Test
    public void findProductById() {
        Optional<Product> product = repository.findById(1);
        product.ifPresent(System.out::println);
    }

    /**
     * 根据ID删除文档
     */
    @Test
    public void deleteProductById() {
        repository.deleteById(1);
    }


    /**
     * 根据产品描述查询产品
     */
    @Test
    public void findProductByDesc() {
//        List<Product> match = repository.findByProductDescMatch("三");
        // 测试自定义方法
        Pageable pageable = PageRequest.of(1, 2);
        Page<Product> productPage = repository.findByProductDescMatch("三", pageable);
        System.out.println("总条数"+productPage.getTotalElements());
        System.out.println("总页数"+productPage.getTotalPages());
        System.out.println("数据"+productPage.getContent());
    }

    /**
     * 自动纠错【模糊查询】
     */
    @Test
    public void findByProductDescFuzzy() {
        List<Product> productDescFuzzy = repository.findByProductDescFuzzy("elasticsearcm");
        productDescFuzzy.forEach(System.out::println);
    }


    /**
     * 分页查询
     */
    @Test
    public void findPage() {
        Pageable pageable = PageRequest.of(1, 3);
        Page<Product> productPage = repository.findAll(pageable);
        System.out.println("总条数："+productPage.getTotalElements());
        System.out.println("总页数："+productPage.getTotalPages());
        System.out.println("数据："+productPage.getContent());
        System.out.println("--");
        productPage.get().forEach(System.out::println);
    }


}
