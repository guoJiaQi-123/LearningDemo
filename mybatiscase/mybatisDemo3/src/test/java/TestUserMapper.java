import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itbaizhan.mapper.UserMapper;
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
import java.util.List;

public class TestUserMapper {
    InputStream resourceAsStream =null;
    SqlSession sqlSession = null;
    UserMapper userMapper = null;

    @Before
    public void before() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(resourceAsStream);
        sqlSession = factory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void testFindAllUser(){
        List<User> allUser =userMapper.findAllUser();
        allUser.forEach(System.out::println);
    }

    @Test
    public void testAdd(){
        User user = new User("王旭伟","男","朔州");
        userMapper.add(user);
        sqlSession.commit();
    }

    @Test
    public void testPagehelper(){
        //1.查询前设置分页参数，参数一：页数，从1开始。参数二：每页条数
        PageHelper.startPage(1,3);
        //2.正常查询
        List<User> allUser = userMapper.findAllUser();
        //3.封装结果集
        PageInfo userPageInfo = new PageInfo(allUser);
        //4.打印页面对象的属性
        System.out.println("结果集："+userPageInfo.getList());
        System.out.println("总条数："+userPageInfo.getTotal());
        System.out.println("总页数："+userPageInfo.getPages());
        System.out.println("当前页："+userPageInfo.getPageNum());
        System.out.println("每页条数："+userPageInfo.getSize());

    }
}
