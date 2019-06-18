package com.itstyle.quartz.service;

import java.util.List;
import com.itstyle.quartz.entity.QuartzEntity;
public interface IJobService {
	
    List<QuartzEntity> listQuartzEntity(QuartzEntity quartz,Integer pageNo,Integer pageSize);	
    
    Long listQuartzEntity(QuartzEntity quartz);	
}
