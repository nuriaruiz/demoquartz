package com.example.demoquartz.playground;

import com.example.demoquartz.info.TimerInfo;
import com.example.demoquartz.jobs.HelloWorldJob;
import com.example.demoquartz.timerservice.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;

@Service
public class PlaygroundService {

    private final SchedulerService scheduler;

    @Autowired
    public PlaygroundService(final SchedulerService scheduler){
        this.scheduler = scheduler;
    }

    public void runHelloWorldJob(){
        final TimerInfo timerInfo = new TimerInfo();
        timerInfo.setTotalFireCount(5);
        timerInfo.setRepeatIntervalMs(2000);
        timerInfo.setInitialOffsetMs(1000);
        timerInfo.setCallbackData("My callback data");

       scheduler.schedule(HelloWorldJob.class, timerInfo);
    }
}
