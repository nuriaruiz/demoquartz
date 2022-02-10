package com.example.demoquartz.timerservice;

import com.example.demoquartz.info.TimerInfo;
import com.example.demoquartz.utils.TimerUtils;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Service
public class SchedulerService {
    private static final Logger log = LoggerFactory.getLogger(SchedulerService.class);
    private final Scheduler scheduler;

    @Autowired
    public SchedulerService(Scheduler scheduler){
        this.scheduler = scheduler;
    }

    @PostConstruct
    public void init(){
        try {
            this.scheduler.start();
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }

    @PreDestroy
    public void preDestroy(){
        try {
            this.scheduler.shutdown();
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }


    public void schedule(final Class jobClass, final TimerInfo timerInfo){
        final JobDetail jobDetail = TimerUtils.buildJobDetail(jobClass, timerInfo);
        final Trigger trigger = TimerUtils.buildTrigger(jobClass, timerInfo);

        try {
            this.scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }

    }
}
