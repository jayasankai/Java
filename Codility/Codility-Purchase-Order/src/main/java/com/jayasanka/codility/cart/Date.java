package com.jayasanka.codility.cart;

import java.util.Calendar;

public class Date {
	int month;
	int day;
	int year;
	
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public Date (Date other) {
		this.month = other.month;
		this.day = other.day;
		this.year = other.year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void setAll(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public boolean isAfter(Date compareTo) {
		Calendar currentCal = Calendar.getInstance();
		currentCal.set(this.year, this.month, this.day);
		
		Calendar otherCal = Calendar.getInstance();
		otherCal.set(compareTo.year, compareTo.month, compareTo.day);
		
		return otherCal.after(currentCal);
	}
	
	@Override
	public boolean equals(Object date) {
		if (date instanceof Date) {			
			Calendar currentCal = Calendar.getInstance();
			currentCal.set(this.year, this.month, this.day);
			
			Date otherDate = (Date)date;
			Calendar otherCal = Calendar.getInstance();
			otherCal.set(otherDate.year, otherDate.month, otherDate.day);
			
			return otherCal.equals(currentCal);
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("%02d/%02d/%04d", this.month, this.day, this.year);
	}
}
