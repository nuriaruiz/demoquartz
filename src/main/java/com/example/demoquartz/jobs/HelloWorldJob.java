package com.example.demoquartz.jobs;

import com.example.demoquartz.info.TimerInfo;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class HelloWorldJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext){
        log.info("Hello World!");
    }
}
