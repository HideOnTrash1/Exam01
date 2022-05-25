package cn.edu.hncj.utils;

import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

//    public static SqlSession getSession() throws IOException {
//        String resource = "mybatis-config.xml";
//        InputStream in = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        return sqlSession;
//    }
private static SqlSessionFactory sqlSessionFactory=null;

    static {
        try {
            InputStream reader = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
