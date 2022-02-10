package com.example.demoquartz.utils;

import com.example.demoquartz.info.TimerInfo;
import org.quartz.*;

import java.util.Date;

public class TimerUtils {

    public TimerUtils(){}

    // metodo para construir job details
    // jobClass es el job sobre el que vamos a relacionar la informcion
    // con la informacion del tiempo de ejecucion: timerinfo
    public static JobDetail buildJobDetail(final Class jobClass, final TimerInfo timerInfo){
        final JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobClass.getSimpleName(), timerInfo);
        return JobBuilder
                .newJob(jobClass)
                .withIdentity(jobClass.getSimpleName())
                .setJobData(jobDataMap)
                .build();
    }

    // metodo para construir el trigger
    public static Trigger buildTrigger(final Class jobClass, final TimerInfo timerInfo){
        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(timerInfo.getRepeatIntervalMs());

        if (timerInfo.isRunForever()){
            builder.repeatForever();
        }else{
            builder.withRepeatCount(timerInfo.getTotalFireCount()-1);
        }

        return TriggerBuilder.newTrigger().withIdentity(jobClass.getSimpleName())
                .withSchedule(builder)
                .startAt(new Date(System.currentTimeMillis() + timerInfo.getInitialOffsetMs())).build();
    }

}
