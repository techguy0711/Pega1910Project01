package com.revature.bean;

import java.util.Date;
import java.util.Timer;

public class TuitionReimbursementForm {
	private String firstName;
	private String lastName;
	private String username;
	private Date date;
	private Timer time;
	private String city;
	private String state;
	private String zip;
	private String Description;
	private Double cost;
	private String gradingFormat;
	private String typeOfEvent;
	private String workRelatedJustification;
	private int DaysMissedFromWork;
	
	public TuitionReinbusmentForm(String firstName, String lastName, String username, Date date, Timer time,
			String city, String state, String zip, String description, Double cost, String gradingFormat,
			String typeOfEvent, String workRelatedJustification, int daysMissedFromWork) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.date = date;
		this.time = time;
		this.city = city;
		this.state = state;
		this.zip = zip;
		Description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.typeOfEvent = typeOfEvent;
		this.workRelatedJustification = workRelatedJustification;
		DaysMissedFromWork = daysMissedFromWork;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Timer getTime() {
		return time;
	}
	public void setTime(Timer time) {
		this.time = time;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public String getTypeOfEvent() {
		return typeOfEvent;
	}
	public void setTypeOfEvent(String typeOfEvent) {
		this.typeOfEvent = typeOfEvent;
	}
	public String getWorkRelatedJustification() {
		return workRelatedJustification;
	}
	public void setWorkRelatedJustification(String workRelatedJustification) {
		this.workRelatedJustification = workRelatedJustification;
	}
	public int getDaysMissedFromWork() {
		return DaysMissedFromWork;
	}
	public void setDaysMissedFromWork(int daysMissedFromWork) {
		DaysMissedFromWork = daysMissedFromWork;
	}
	@Override
	public String toString() {
		return "TuitionReinbusmentForm [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", date=" + date + ", time=" + time + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", Description=" + Description + ", cost=" + cost + ", gradingFormat=" + gradingFormat
				+ ", typeOfEvent=" + typeOfEvent + ", workRelatedJustification=" + workRelatedJustification
				+ ", DaysMissedFromWork=" + DaysMissedFromWork + "]";
	}
}