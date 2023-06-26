package dev.batchandscheduler.batch.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job simpleJob() {
        return jobBuilderFactory
                .get("simpleJob")
                .start(simpleStep())
                .build();
    }

    @Bean
    public Step simpleStep() {
        return this.stepBuilderFactory
                .get("simpleStep")
                .tasklet(simpleTasklet())
                .build();
    }

    @Bean
    public Tasklet simpleTasklet() {
        return (stepContribution, chunkContext) -> {
            for (int i = 10; i > 0; i--) {
                TimeUnit.SECONDS.sleep(10);
                log.debug(String.valueOf(i));
            }
            return RepeatStatus.FINISHED;
        };
    }

}
