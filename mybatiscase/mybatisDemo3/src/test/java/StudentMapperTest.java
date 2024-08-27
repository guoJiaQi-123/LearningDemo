import com.itbaizhan.mapper.StudentMapper;
import com.itbaizhan.mapper.UserMapper;
import com.itbaizhan.pojo.Student;
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

public class StudentMapperTest {
    InputStream resourceAsStream =null;
    SqlSession sqlSession = null;
    StudentMapper studentMapper = null;

    @Before
    public void before() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(resourceAsStream);
        sqlSession = factory.openSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void testFindAllStudent(){
        List<Student> allStudent = studentMapper.findAllStudent();
        allStudent.forEach(System.out::println);
    }
}
