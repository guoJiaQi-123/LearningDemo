import com.itbaizhan.mapper.UserMapper;
import com.itbaizhan.mapper.UserMapper2;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest3 {
    InputStream resourceAsStream=null;
    SqlSession sqlSession=null;
    UserMapper2 userMapper2=null;
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
        userMapper2 = sqlSession.getMapper(UserMapper2.class);

    }

    @After
    public void after() throws IOException {
        //释放资源
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void testFindUserByCondition(){
        User user = new User();
        List<User> users = userMapper2.findUserByCondition(user);
        users.forEach(System.out::println);

        user.setUsername("尚学堂");
        List<User> users2 = userMapper2.findUserByCondition(user);
        users2.forEach(System.out::println);

    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(11);
        user.setUsername("程序员");
        userMapper2.updateUser(user);
        sqlSession.commit();
    }

    @Test
    public void testFindUserByUsername(){
        List<User> users = userMapper2.findUserByUsername("北京");
        users.forEach(System.out::println);
    }

    @Test
    public void testDeleteBatch(){
        int[] ids = new int[]{8,10,11};
        userMapper2.deleteBatch(ids);
        //事务提交
        sqlSession.commit();

    }
    @Test
    public void testAddBatch(){
        User user1 = new User("郭家旗","男","祁县");
        User user2 = new User("苏红润","女","吉县");
        List<User> list= new ArrayList<>();
        list.add(user1);
        list.add(user2);
        userMapper2.addBatch(list);
        sqlSession.commit();
    }

    @Test
    public void testFindUser(){
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("sex","男");
        queryMap.put("address","北京");
        List<User> user = userMapper2.findUser(queryMap);
        user.forEach(System.out::println);

    }
}
