package test;

import cn.edu.hncj.dao.IClassMapper;
import cn.edu.hncj.dao.IStudentMapper;
import cn.edu.hncj.pojo.Classes;
import cn.edu.hncj.pojo.Student;
import cn.edu.hncj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

public class demotest {
    @Test
    public void selectStudentBySid() {
        SqlSession sqlSession = MybatisUtils.getSession();
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        Student student = mapper.selectStudentBySid(2);
        System.out.println(student);
    }
    @Test
    public void updateStudentBySid(){
        SqlSession sqlSession = MybatisUtils.getSession();
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        Student student = new Student();
        student.setSid(1);
        student.setAge("30");
        student.setSname("小胡");
        student.setCid(2);
        mapper.updateStudentBySid(student);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void selectStudentByCid(){
        SqlSession sqlSession = MybatisUtils.getSession();
        IClassMapper mapper = sqlSession.getMapper(IClassMapper.class);
        Classes classes= mapper.findClassByCid(1);
        List<Student> studentList = classes.getStudentList();
        System.out.println(classes.getCname());
        for(Student student:studentList){
            System.out.println(student);
        }
    }
}
