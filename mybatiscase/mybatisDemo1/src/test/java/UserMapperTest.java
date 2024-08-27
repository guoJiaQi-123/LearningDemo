import com.itbaizhan.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.itbaizhan.pojo.User;

public class UserMapperTest {
    @Test
    public void testFindAll() throws IOException {
        //读取核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder FactoryBuilder = new SqlSessionFactoryBuilder();
        //通过SqlSessionFactoryBuilder创建SqlSessionFactory对象
        SqlSessionFactory factory = FactoryBuilder.build(is);
        //通过SqlSessionFactory创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //SqlSession对象获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //代理对象执行方法
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
        //关闭资源
        sqlSession.close();
        is.close();

    }
    @Test
    public void testFindAll2() throws IOException {
        //读取核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder FactoryBuilder = new SqlSessionFactoryBuilder();
        //通过SqlSessionFactoryBuilder创建SqlSessionFactory对象
        SqlSessionFactory factory = FactoryBuilder.build(is);
        //通过SqlSessionFactory创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //直接通过SqlSession对象操作数据库
        List<User> userList = sqlSession.selectList("com.itbaizhan.mapper.UserMapper.findAll");
        userList.forEach(System.out::println);
        //关闭资源
        sqlSession.close();
        is.close();
    }

    @Test
    public void testAdd() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("郭家旗", "男", "上海");
        userMapper.add(user);
        //提交事务
        sqlSession.commit();

        //关闭资源
        sqlSession.close();
        is.close();
    }
}
