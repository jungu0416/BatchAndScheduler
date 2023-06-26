package dev.batchandscheduler.scheduler.component;

import dev.batchandscheduler.batch.config.BatchConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class SchedulerComponent {

    private final JobLauncher jobLauncher;
    private final BatchConfig batchConfig;

    @Scheduled(fixedDelayString = "${fixed.rate.string}")
    public void batchOne() {
        //job parameter 설정
        Map<String, JobParameter> confMap = new HashMap<>();

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        confMap.put("time", new JobParameter(date));
        JobParameters jobParameters = new JobParameters(confMap);

        try {
            jobLauncher.run(batchConfig.simpleJob(), jobParameters);
        } catch (Exception e) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            log.info(String.format("ERROR TIME : %s", sdf.format(date)));;
            e.printStackTrace();
        }

    }
}
