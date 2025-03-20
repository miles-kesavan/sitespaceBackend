package com.sitespace.fileupload.slotBooking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;



public interface slotBookingDao {

	public slotBookingResultBean updateslotBooking(slotBookingBean obj);

	public slotBookingResultBean saveSlotBooking(slotBookingBean obj);
	
	public slotBookingResultBean editslotBookingdetails(String currentUserId);

	public slotBookingResultBean getslotBookingList(String userId,String projectId);
	
	public slotBookingResultBean deleteslotBooking(slotBookingBean delete);


	
	



}
