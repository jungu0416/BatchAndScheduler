package dev.batchandscheduler.scheduler.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SchedulerComponent {



    @Scheduled(fixedDelayString = "${fixed.rate.string}")
    public void run() {

        log.debug("실행중 ... ");

    }
}
