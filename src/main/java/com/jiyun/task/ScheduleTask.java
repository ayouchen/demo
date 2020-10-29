package com.jiyun.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class ScheduleTask {

    @Scheduled(cron = "0/2 * * * * ?")
    public void sayhello(){
        System.out.println("Hello world!!!");
    }

}
