package com.kasper.mlb23batchprocessing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class MlbApiCallScheduler {
    @Autowired
    private final MlbApiService mlbApiService;

    public MlbApiCallScheduler(MlbApiService mlbApiService) {
        this.mlbApiService = mlbApiService;
    }

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void runMlbTheShowJob() {
        System.out.println("########### RUNNING JOB ###########");
        mlbApiService.runMlbApiService();
        System.out.println("########### FINISHED JOB ###########");
    }
}
