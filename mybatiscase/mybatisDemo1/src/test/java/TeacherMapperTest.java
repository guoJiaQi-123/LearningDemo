import com.itbaizhan.mapper.TeacherMapper;
import com.itbaizhan.pojo.Teacher;
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

public class TeacherMapperTest {
    InputStream is =null;
    SqlSession sqlSession =null;
    TeacherMapper teacherMapper=null;
    @Before
    public void before() throws IOException {
         is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(is);
         sqlSession = factory.openSession();
         teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    }

    @After
    public void after() throws IOException {
        is.close();
        sqlSession.close();
    }


    @Test
    public void testFindAll(){
        List<Teacher> all =teacherMapper.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testFindById(){
        List<Teacher> teachers = teacherMapper.findById(1);
        teachers.forEach(System.out::println);
    }
}
