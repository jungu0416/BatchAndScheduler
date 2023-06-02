package dev.batchandscheduler.scheduler.service;

import dev.batchandscheduler.scheduler.response.SchedulerResponse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    public SchedulerResponse test(){
        return null;
    }

    //Controller 없이 Service 에서 logic 실행
    @Scheduled(fixedDelayString = "${fixed.rate.string}") //Method는 void 타입으로 Method는 매개변수 사용 불가
    public void run() {
        System.out.println("실행 중 ..");
    }
}
