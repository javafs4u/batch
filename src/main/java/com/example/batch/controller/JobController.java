package com.example.batch.controller;


import com.example.batch.config.MyBatchConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("IMPORT1")
    private Job import1;

    @Autowired
    @Qualifier("CSVIMPORT")
    private Job csvImport;

    @Autowired
    @Qualifier("IMPORT2")
    private Job import2;

    @Autowired
    private MyBatchConfig config;

    @GetMapping("/invoke")
    public String handle() throws Exception {

        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(import1, jobParameters);
        return "Batch job has been invoked";
    }

    @GetMapping("/csv")
    public String handleCSVToFile() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(import2, jobParameters);
        return "CSV Batch job has been invoked";
    }

    @GetMapping("/csv2")
    public String handleCSVCustomerToDB() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(csvImport, jobParameters);
        return "CSV Batch job has been invoked";
    }
}
