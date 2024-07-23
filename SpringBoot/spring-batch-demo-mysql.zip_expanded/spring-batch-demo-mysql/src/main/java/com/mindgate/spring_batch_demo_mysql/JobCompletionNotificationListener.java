package com.mindgate.spring_batch_demo_mysql;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

	
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
    	System.out.println("=========================================================================================");
    	System.out.println("!!! JOB FINISHED! Time to verify the results");
    	jdbcTemplate
          .query("SELECT firstname, lastname FROM people2", new DataClassRowMapper<>(Person.class))
          .forEach(person -> System.out.println("Found "+person+" in the database."));
    	System.out.println("=========================================================================================");
    	
    }
  }
}
