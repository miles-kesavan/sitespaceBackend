package com.sitespace.fileupload.slotBooking;

import java.util.List;


public class slotBookingResultBean {

	

public boolean success;
private String message;


public List<slotBookingBean> bookingList;



public List<slotBookingBean> getBookingList() {
	return bookingList;
}
public void setBookingList(List<slotBookingBean> bookingList) {
	this.bookingList = bookingList;
}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}


public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}



	
	
}
