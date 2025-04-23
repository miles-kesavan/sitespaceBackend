package com.sitespace.fileupload.slotBooking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;




public interface slotBookingService {
	


	public slotBookingResultBean saveSlotBooking(slotBookingBean obj);
	
	public slotBookingResultBean updateslotBooking(slotBookingBean obj);

	public slotBookingResultBean getslotBookingList(String userId,String projectId);
	
	public slotBookingResultBean getslotBookingListProjectBased(String projectId);
	
	public slotBookingResultBean editslotBookingdetails(String currentUserId);
	
    slotBookingResultBean deleteslotBooking(slotBookingBean obj);



}