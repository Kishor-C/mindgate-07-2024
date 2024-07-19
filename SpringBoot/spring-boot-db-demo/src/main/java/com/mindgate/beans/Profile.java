package com.mindgate.beans;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="profile") // optional if table name is same as class name
public class Profile {
	// 5 properties to map to the columns: profile_id, name, password, dob, phone
	
	@Id // is mentioned only on top of the primary key column property
	@Column(name = "profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // to auto-generate primary keys
	private int profileId; 
	
	@Column(name = "name") // optional if column name & property names are same
	private String name;
	
	@Column(name = "password")
	private String password;
	
	private LocalDate dob; // @Column is omitted, maps to dob column
	private long phone;  // maps to phone colSumn
	// generate setters and getters
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
}
