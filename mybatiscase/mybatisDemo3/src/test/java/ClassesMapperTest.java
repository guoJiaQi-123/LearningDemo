import com.itbaizhan.mapper.ClassesMapper;
import com.itbaizhan.pojo.Classes;
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

public class ClassesMapperTest {
    InputStream resourceAsStream =null;
            SqlSession sqlSession =null;
    ClassesMapper classesMapper =null;
    @Before
    public void before() throws IOException {
         resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(resourceAsStream);
         sqlSession = factory.openSession();
         classesMapper = sqlSession.getMapper(ClassesMapper.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void testFindAllClasses(){
        List<Classes> allClasses =
                classesMapper.findAllClasses();
        allClasses.forEach(System.out::println);
    }
}
