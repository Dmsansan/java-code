package com.itstyle.quartz.job;

import java.io.Serializable;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.itstyle.quartz.service.IJobService;
/**
 * 实现序列化接口、防止重启应用出现quartz Couldn't retrieve job because a required class was not found 的问题
 */
public class TestJob implements  Job,Serializable {

	private static final long serialVersionUID = 1L;
	   
    @Autowired  
    private IJobService jobService; 
    
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(jobService);//注入jobService 执行相关业务操作
		System.out.println("任务执行成功");
	}
}
