package com.mindgate.dao;

public class DBOperations {
	private Datasource datasource;

	public Datasource getDatasource() {
		return datasource;
	}

	public void setDatasource(Datasource datasource) {
		this.datasource = datasource;
	}
	
	public void connect() {
		System.out.println("--- Connection established using below details -----");
		System.out.println("URL="+datasource.getUrl()); // if you get exception then object is not initialized
		System.out.println("Username="+datasource.getUsername());
		System.out.println("Password="+datasource.getPassword());
		System.out.println("DriverClassName="+datasource.getDriverClassName());
	}
	public void store() {
		connect();
		System.out.println("-- store method of dao runs insert query ---");
	}
}
