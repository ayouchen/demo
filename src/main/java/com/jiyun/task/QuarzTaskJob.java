package com.jiyun.task;

import com.jiyun.entity.Students;
import com.jiyun.service.StudentService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class QuarzTaskJob implements Job {

    @Autowired
    StudentService studentService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("i'm fine!!!");
        Students studentBySno = studentService.getStudentById(1);
        System.out.println(studentBySno.toString());
        System.out.println("end!!!");
    }
}
