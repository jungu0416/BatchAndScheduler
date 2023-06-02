package dev.batchandscheduler.scheduler.api;

import dev.batchandscheduler.scheduler.response.SchedulerResponse;
import dev.batchandscheduler.scheduler.service.SchedulerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scheduler")
public class SchedulerController {
    private SchedulerService schedulerService;

    @GetMapping("/test")
    public ResponseEntity<SchedulerResponse> test(){
        //builder 패턴?
        return ResponseEntity
                .status(HttpStatus.OK).body(schedulerService.test());
    }

}
