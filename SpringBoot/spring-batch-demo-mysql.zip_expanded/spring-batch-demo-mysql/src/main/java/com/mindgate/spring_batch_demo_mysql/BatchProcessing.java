package com.mindgate.spring_batch_demo_mysql;

import org.springframework.stereotype.Component;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
@Component
public class BatchProcessing {
	

	/*
	 * this does the actual job
	 * 1) read from csv - reader() and convert to java object
	 * 2) process the java object - process()
	 * 3) write to the db - writer() method
	 * 4) perform job in chunks - job()
	 * 5) mention the job steps - step()
	 */
	/*
	 * The first 3 methods defines the input, processor and output
	 */
	/*
	 * creates an ItemReader. 
	 * It looks for a file called sample-data.csv and 
	 * parses each line item with enough information to turn it into a Person.
	 */
	@Bean
	public FlatFileItemReader<Person> reader() {
	  return new FlatFileItemReaderBuilder<Person>()
	    .name("personItemReader")
	    .resource(new ClassPathResource("sample-data.csv"))
	    .delimited()
	    .names("firstname", "lastname")
	    .targetType(Person.class)
	    .build();
	}
	/*
	 * creates an instance of PersonItemProcessor that we defined earlier, 
	 * meant to convert the data to upper case.
	 */
	@Bean
	public PersonItemProcessor processor() {
		
	  return new PersonItemProcessor();
	}
	/*
	 * creates an ItemWriter, 
	 * This one is aimed at a JDBC destination and automatically gets a copy of the datasource created by Spring Boot. 
	 * It includes the SQL statement needed to insert a single Person, driven by java bean/record component
	 */
	@Bean
	public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
	  return new JdbcBatchItemWriterBuilder<Person>()
	    .sql("INSERT INTO people2 (firstname, lastname) VALUES (:firstname, :lastname)")
	    .dataSource(dataSource)
	    .beanMapped()
	    .build();
	}
	/*
	 * These two method shows the actual job configuration
	 */
	/*
	 * importUserJob: Defines the Job
	 */
	@Bean
	public Job importUserJob(JobRepository jobRepository,Step step1, JobCompletionNotificationListener listener) {
	  return new JobBuilder("importUserJob", jobRepository)
	    .listener(listener)
	    .start(step1)
	    .build();
	}
	/*
	 * step1: Defines a single step
	 */
	@Bean
	public Step step1(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
	          FlatFileItemReader<Person> reader, PersonItemProcessor processor, JdbcBatchItemWriter<Person> writer) {
	  return new StepBuilder("step3", jobRepository)
	    .<Person, Person> chunk(5, transactionManager)
	    .reader(reader)
	    .processor(processor)
	    .writer(writer)
	    .build();
	}
	
}
