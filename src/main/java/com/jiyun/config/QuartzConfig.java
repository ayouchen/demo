package com.jiyun.config;

import com.jiyun.task.QuarzTaskJob;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

//@Component
public class QuartzConfig {

    @Bean
    public JobDetailFactoryBean getjobDetailFactoryBean(){
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(QuarzTaskJob.class);
        return  jobDetailFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean getCronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setCronExpression("0/2 * * * * ?");
        return  cronTriggerFactoryBean;
    }

    @Bean
    public SchedulerFactoryBean getschedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean
    ,MyAdapterJobFactory myAdapterJobFactory){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        schedulerFactoryBean.setJobFactory(myAdapterJobFactory);
        if (myAdapterJobFactory == null){
            System.out.println("这个对象为null");
        }else {
            System.out.println("这个对象不为null");
        }
        return  schedulerFactoryBean;
    }
}
