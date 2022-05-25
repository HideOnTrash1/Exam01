package cn.edu.hncj.dao;

import cn.edu.hncj.pojo.Student;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IStudentMapper {

    @Select("select * from student where sid= #{sid}")
    Student selectStudentBySid(int sid);

    @Update("update student set sname = #{sname} , age = #{age} ,cid = #{cid} where sid = #{sid}")
    int updateStudentBySid(Student student);

    @Select("select * from student where cid = #{cid}")
    public List<Student> selectCLassByCid(int cid);
}
