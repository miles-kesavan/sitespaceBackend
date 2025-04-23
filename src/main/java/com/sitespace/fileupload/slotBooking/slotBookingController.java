package com.sitespace.fileupload.slotBooking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//import sun.misc.BASE64Decoder;
@Api(tags="slotBooking Operation", description="Manages slotBooking Operation")
@RestController
@RequestMapping("/api/auth/slotBooking")
public class slotBookingController {
	
	@Autowired
	slotBookingService slotBookingService;
		
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@ApiOperation(value = "slotBooking Controller")

	
	@PostMapping(value = "/saveSlotBooking")
	public @ResponseBody  slotBookingResultBean saveSlotBooking(@RequestBody slotBookingBean obj) throws Exception{
		slotBookingResultBean assetResultBean = new slotBookingResultBean();
		try {

			assetResultBean = slotBookingService.saveSlotBooking(obj);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return assetResultBean;

	}
	
	
	
	
	//connection List
	
	@GetMapping("/getslotBookingList")
	public @ResponseBody slotBookingResultBean getslotBookingList(@RequestParam ("userId") String userId,@RequestParam("projectId")String projectId) {
		slotBookingResultBean assetResultBean = new slotBookingResultBean();

		try {
			assetResultBean = slotBookingService.getslotBookingList(userId,projectId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assetResultBean;
	}
	
	
	@GetMapping("/getslotBookingListProjectBased")
	public @ResponseBody slotBookingResultBean getslotBookingListProjectBased(@RequestParam("projectId")String projectId) {
		slotBookingResultBean assetResultBean = new slotBookingResultBean();

		try {
			assetResultBean = slotBookingService.getslotBookingListProjectBased(projectId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assetResultBean;
	}
	

	
	//UpdateSkill
	
	@PostMapping(value = "/updateSlotBooking")
	public @ResponseBody  slotBookingResultBean updateslotBooking(@RequestBody slotBookingBean objAsset) throws Exception{
		slotBookingResultBean assetresultBean = new slotBookingResultBean();
		try {

			assetresultBean = slotBookingService.updateslotBooking(objAsset);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return assetresultBean;

	}
		//editprofiledetails individual
		
	@GetMapping(value = "/editSlotBookingdetails")
		public @ResponseBody slotBookingResultBean editslotBookingdetails(@RequestParam ("bookingKey") String bookingKey) {
			slotBookingResultBean assetResultBean = new slotBookingResultBean();
			try {

				assetResultBean = slotBookingService.editslotBookingdetails(bookingKey);
	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		return assetResultBean;

	}



	
	//delete my account for Ios
	
	@PostMapping(value = "/deleteSlotBooking")
	public @ResponseBody slotBookingResultBean deleteslotBooking(@RequestBody slotBookingBean delete) {
		slotBookingResultBean assetResultBean = new slotBookingResultBean();
		boolean isSuccess = false;
		try {
			assetResultBean = slotBookingService.deleteslotBooking(delete);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assetResultBean;
	}

	
	
	
	
	
}
