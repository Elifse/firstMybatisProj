package cloud.elifse.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Elifse
 * @Description
 * @Create 2022/5/30
 **/
public class MyBatisUtil {

    private static SqlSessionFactory factory;



    private static final ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }

    public static SqlSessionFactory getFactory() {
        return factory;
    }

    private static SqlSession getSqlSession(boolean isAutoCommit) {
        SqlSession sqlSession = local.get();
        if (sqlSession == null){
            // 通过SqlSessionFactory调用getSqlSession的时候，
            // 可以通过设置参数来是否自动提交事务。默认为false。设置为ture可以开启自动提交。
            sqlSession = factory.openSession(isAutoCommit);
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static <T extends Object> T getMapper(Class<T> c){
        SqlSession sqlSession = getSqlSession(true);
        return sqlSession.getMapper(c);
    }
}
