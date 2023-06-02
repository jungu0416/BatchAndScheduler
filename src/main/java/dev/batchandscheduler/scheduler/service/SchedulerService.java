package dev.batchandscheduler.scheduler.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
    @Scheduled(fixedDelayString = "${fixed.rate.string}") //Method는 void 타입으로 Method는 매개변수 사용 불가
    public void run() {
        System.out.println("실행 중 ..");
    }
}
