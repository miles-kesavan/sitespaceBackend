package com.sitespace.fileupload.slotBooking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;





@Service
public class slotBookingServicelmpl  implements slotBookingService {

	@Autowired
	slotBookingDao saveslotBookingDao;
	


			@Override
			public slotBookingResultBean saveSlotBooking(slotBookingBean obj) {
				// TODO Auto-generated method stub
				return saveslotBookingDao.saveSlotBooking(obj);
			}



			@Override
			public slotBookingResultBean updateslotBooking(slotBookingBean objSkill) {
				
 				return saveslotBookingDao.updateslotBooking(objSkill);
			}
			

			//editprofiledetails
			
			@Override
			public slotBookingResultBean editslotBookingdetails(String currentUserId) {
				// TODO Auto-generated method stub
				return saveslotBookingDao.editslotBookingdetails(currentUserId);
			}



			@Override
			public slotBookingResultBean getslotBookingList() {
				// TODO Auto-generated method stub
				return saveslotBookingDao.getslotBookingList();
			}
			
			
			@Override
			public slotBookingResultBean deleteslotBooking(slotBookingBean delete) {
				// TODO Auto-generated method stub
				return saveslotBookingDao.deleteslotBooking(delete);
			}
			

	
}
