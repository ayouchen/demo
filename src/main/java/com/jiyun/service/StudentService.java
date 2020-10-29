package com.jiyun.service;

import com.jiyun.entity.Students;
import com.jiyun.mapper.StudentTkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

//    @Autowired
//    StudentMapper studentMapper;

    @Autowired
    StudentTkMapper studentTkMapper;

    //获取所有学生对象
    public List<Students> getAllStudent(Students student) {
        return studentTkMapper.findStudentByCondition(student);
    }

    //删除学生对象
    public void delStudentBySno(Integer sno){
        studentTkMapper.deleteByPrimaryKey(sno);
    }

    public void editStudentBySno(Students student){
        studentTkMapper.updateByPrimaryKeySelective(student);
    }

    public void addStudentBySno(Students student){
        studentTkMapper.insertSelective(student);
    }

    public Students getStudentById(Integer sno) {
        return  studentTkMapper.selectByPrimaryKey(sno);
    }

    public Students getStudentByName(String name){
        List<Students> studentByName = studentTkMapper.getStudentByName(name);
        if (studentByName.isEmpty()){
            return null;
        }
        return  studentByName.get(0);
    }


}
