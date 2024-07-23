package com.mindgate.spring_batch_demo;

import org.springframework.batch.item.ItemProcessor;

// this needs to implement ItemProcessor<I,O> and implement process method
// this takes a data and converts to another form
// but we will be taking person and converting to person with
// firstname & lastname in uppercase
public class PersonItemProcessor implements ItemProcessor<Person, Person>{

	/*
	 * process(Person) takes the person from reader & returns the transformed
	 * object to writer
	 */
	@Override
	public Person process(Person item) throws Exception {
		String firstname = item.getFirstname().toUpperCase();
		String lastname = item.getLastname().toUpperCase();
		Person transformedPerson = new Person(firstname, lastname);
		System.out.println(item+" Transformed to "+transformedPerson);
		return transformedPerson;
	}	
}
