package com.jiyun.thymeleafhomeworkdemo.tkmapper;

import com.jiyun.entity.Students;
import com.jiyun.mapper.StudentTkMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class TkMapperTest {
    @Autowired
    StudentTkMapper studentTkMapper;
    @Test
    public void testSelectTkMapper(){
        List<Students> students = studentTkMapper.selectAll();
        students.forEach(e->{
            System.out.println(e.toString());
        });
    }

    @Test
    public void testInsertTkMapper(){
        Students studnet = new Students();
        studnet.setName("lalala");
        studnet.setPwd("lalala");
        studnet.setSex('1');
        studnet.setSno(6);
        studnet.setBirthday(new Date());
        studentTkMapper.insert(studnet);
    }

    @Test
    public void testDeleteTkMapper(){
        Students student = new Students();
        student.setId(20121225);
        studentTkMapper.deleteByPrimaryKey(student);
    }

    @Test
    public void testUpdateTkMapper(){
        Students studeant = new Students();
        studeant.setId(20121226);
        studeant.setSno(6);
        studeant.setPwd("6");
        studeant.setName("6");
        studeant.setSex('0');
        studeant.setBirthday(new Date());
        studentTkMapper.updateByPrimaryKey(studeant);
    }

    @Test
    public void testSelectByCondition(){
        Students students = new Students();
        students.setName("1");
        List<Students> studentByCondition = studentTkMapper.findStudentByCondition(students);
        studentByCondition.forEach(e->{
            System.out.println(e.toString());
        });
    }

    @Test
    public void testGetStudentByName(){
        List<Students> studentByName = studentTkMapper.getStudentByName("111");
        System.out.println(studentByName);
    }
}
