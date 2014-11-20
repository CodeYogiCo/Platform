package com.cp.scheduler.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.quartz.JobBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import com.cp.scheduler.job.MyJob;

@Component
@Configuration
public class SchedulerConfig {
	
	
	
	@Bean
	public SchedulerFactoryBean getSchedulerFactoryBean() throws IOException{
	SchedulerFactoryBean scheduleFactoryBean= new SchedulerFactoryBean();
	//scheduleFactoryBean.setQuartzProperties(getPropety());
	//scheduleFactoryBean.setConfigLocation("classpath:quartz.properties");
	//scheduleFactoryBean.setTriggers(getTrigger().getObject());
	return scheduleFactoryBean;
	}
	
	@Bean
	public CronTriggerFactoryBean getTrigger(){
		CronTriggerFactoryBean cronTriggerFactory= new CronTriggerFactoryBean();
		cronTriggerFactory.setJobDetail(JobBuilder.newJob(MyJob.class).build());
		cronTriggerFactory.setCronExpression("0/5 * * ? * SAT-SUN");
		return cronTriggerFactory;
	}
	
	@Bean
	public Properties getPropety() throws IOException{
		Properties property= new Properties();
		InputStream inputStrem= getClass().getClassLoader().getResourceAsStream("quartz.properties");
		property.load(inputStrem);
		return property;
	}




}
