package cn.edu.hncj.dao;

import cn.edu.hncj.pojo.Classes;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IClassMapper {
    @Results(id = "find", value = {
            @Result(property = "cid" , column = "cid"),
            @Result(property = "cname" , column = "cname"),
            @Result(property = "studentList", javaType = List.class,column = "cid",many = @Many(select = "cn.edu.hncj.dao.IStudentMapper.selectCLassByCid"))
    })
    @Select("select * from class where cid = #{cid}")
    public Classes findClassByCid(@Param("cid") int cid);


}
