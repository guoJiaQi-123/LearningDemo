import com.itbaizhan.mapper.ProductMapper;
import com.itbaizhan.pojo.Product;
import com.itbaizhan.pojo.ProductExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {
    InputStream resourceAsStream =null;
    SqlSession sqlSession =null;
    ProductMapper productMapper =null;
    @Before
    public void before() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(resourceAsStream);
        sqlSession = factory.openSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
    }

    @After
    public void after() throws IOException {
        resourceAsStream.close();
        sqlSession.close();
    }

    //测试新增
    @Test
    public void TestAdd(){
        Product product = new Product("百战python课",15000.0);
        productMapper.insert(product);
        sqlSession.commit();
    }

    //测试修改
    @Test
    public void testUpdate(){
        Product product = new Product(4, "百战python课", 25000.0);
        productMapper.updateByPrimaryKey(product);
        sqlSession.commit();

    }

    //测试删除
    @Test
    public void testDelete(){
        productMapper.deleteByPrimaryKey(4);
        sqlSession.commit();
    }

    //根据ID查询
    @Test
    public void selectById(){
        Product product = productMapper.selectByPrimaryKey(1);
        System.out.println(product);
    }

    //查询所有
    @Test
    public void findAll(){
        ProductExample productExample = new ProductExample();
        List<Product> products = productMapper.selectByExample(productExample);
        products.forEach(System.out::println);
    }

    //根据产品名字查询
    @Test
    public void findByNameLike(){
        // 查询扩展对象，可以构建查询条件
        ProductExample productExample = new ProductExample();
        // 构建查询条件
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductnameLike("%百战%");
        // 查询
        List<Product> products = productMapper.selectByExample(productExample);
        products.forEach(System.out::println);
    }
}
