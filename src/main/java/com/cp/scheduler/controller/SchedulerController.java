package com.cp.scheduler.controller;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/platform")
public class SchedulerController {
	
@Autowired
private SchedulerFactoryBean schedulerFactory;
	
	
	@RequestMapping("/schedule")
	public void schedule() throws SchedulerException, InterruptedException{
		
		Scheduler scheduler=schedulerFactory.getScheduler();   
   
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").
//        		withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();
//        
       Trigger trigger= TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0 45 01 * * ? *")).build();

		JobDetail job=JobBuilder.newJob(com.cp.scheduler.job.MyJob.class).withIdentity("job1","group1").build();
		
		scheduler.scheduleJob(job,trigger);
		
		scheduler.start();
		
		Thread.sleep(90L * 1000L);
		
		
	}

}
