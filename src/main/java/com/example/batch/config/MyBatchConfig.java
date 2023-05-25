package com.example.batch.config;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class MyBatchConfig {
    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;


    public Step step1() {
        return stepBuilderFactory.get("STEP1").<String, String>chunk(1)
                .reader(new Reader("read_"))
                .processor(new Processor())
                .writer(new Writer())
                .build();
    }

    @Bean("IMPORT1")
    public Job runJob1() {
        return jobBuilderFactory.get("IMPORT1").flow(step1()).end().build();
    }


    public Job runJob() {
        return jobBuilderFactory.get("IMPORT").flow(step1()).end().build();
    }

}
