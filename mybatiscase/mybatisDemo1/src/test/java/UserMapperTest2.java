import com.itbaizhan.mapper.UserMapper;
import com.itbaizhan.pojo.PageQueryParams;
import com.itbaizhan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UserMapperTest2 {
    InputStream resourceAsStream=null;
    SqlSession sqlSession=null;
    UserMapper userMapper=null;
    @Before
    public void before() throws IOException {

        //1.读取核心配置文件
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactorBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.通过SqlSessionFactorBuilder对象创建SqlSessionFactor对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        //4.通过SqlSessionFactor对象创建SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //5.通过SqlSession对象获取代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);

    }

    @After
    public void after() throws IOException {
        //释放资源
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void testUpdate(){
        User user = new User(9,"苏红润","女","深圳");
        userMapper.update(user);

        //提交事务
        sqlSession.commit();
    }

    @Test
    public void testDelete(){
        userMapper.delete(9);
        //事务提交
        sqlSession.commit();
    }

    @Test
    public void testFindUserById(){
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByNameLike(){
        List<User> users = userMapper.findUserByNameLike("尚学堂");
        users.forEach(System.out::println);
    }

    @Test
    public void testFindPage(){
        List<User> users = userMapper.findPage(0, 3);
        users.forEach(System.out::println);
    }

    @Test
    public void testFindPage2(){
        List<User> users = userMapper.findPage2(3, 3);
        users.forEach(System.out::println);
    }

    @Test
    public void testFindPage3(){
        PageQueryParams pageQueryParams = new PageQueryParams(0, 4);
        List<User> users = userMapper.findPage3(pageQueryParams);
        users.forEach(System.out::println);
    }

    @Test
    public void testFindPage4(){
        Map<String, Object> map =new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",5);
        List<User> users = userMapper.findPage4(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testFindCount(){
        int count = userMapper.findCount();
        System.out.println(count);
    }

    @Test
    public void testAdd2(){
        User user = new User("苏红润","女","山西");
        System.out.println(user);
        userMapper.add2(user);
        System.out.println(user);

        sqlSession.commit();
    }


}
