package com.jiyun.mapper;

import com.jiyun.entity.Students;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface StudentTkMapper extends Mapper<Students> {
    List<Students> findStudentByCondition(Students student);

    @Select("select * from students where name = #{name}")
    List<Students> getStudentByName(String name);
}
