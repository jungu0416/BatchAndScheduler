package dev.batchandscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //DB가 필요하지 않을 시 추가
public class BatchAndSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchAndSchedulerApplication.class, args);
	}

}