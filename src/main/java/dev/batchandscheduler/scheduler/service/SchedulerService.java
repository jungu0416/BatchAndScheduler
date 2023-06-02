package dev.batchandscheduler.scheduler.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SchedulerService {
    @Scheduled(fixedDelayString = "${fixed.rate.string}") //Method는 void 타입으로 Method는 매개변수 사용 불가
    public void run() {
        log.debug("실행중 ... ");
    }
}
