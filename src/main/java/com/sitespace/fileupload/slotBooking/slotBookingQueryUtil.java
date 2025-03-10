package com.sitespace.fileupload.slotBooking;

import java.util.ArrayList;

public class slotBookingQueryUtil {

	public static final String insert_asset = " INSERT INTO asset_master (asset_project, asset_title, asset_location,asset_status, asset_poc, maintanence_startdt, maintanence_enddt, usage_instructions,created_dt)  \r\n"
			+ "VALUES (?,?,?,?,?,?,?,?,now())";
	
	public static final String insert_slotBooking = " INSERT INTO slot_booking (\r\n"
			+ "    booking_project, \r\n"
			+ "    booking_title, \r\n"
			+ "    booking_for, \r\n"
			+ "    booked_assets, \r\n"
			+ "    booking_status, \r\n"
			+ "    booking_timedt, \r\n"
			+ "    booking_duration_mins, \r\n"
			+ "    booking_description, \r\n"
			+ "    booking_notes, \r\n"
			+ "    booking_created_by, \r\n"
			+ "    booking_created_dt\r\n"
			+ ") VALUES (?, ?, ?, string_to_array(?, ','), 'Pending', ?, ?, ?, ?, ?, now())";
	
	public static final String Get_emp_id = "SELECT COALESCE(exp_id) AS expId FROM new.experience_info WHERE talent_id = ?";
	
	
	public  static final String UPDATE_BOOKING = "UPDATE slot_booking \r\n"
			+ "SET \r\n"
			+ "    booking_project = ?, \r\n"
			+ "    booking_title = ?, \r\n"
			+ "    booking_for = ?, \r\n"
			+ "    booking_status = ?, \r\n"
			+ "    booking_timedt = ?, \r\n"
			+ "    booking_duration_mins = ?, \r\n"
			+ "    booking_description = ?, \r\n"
			+ "    booking_notes = ?, \r\n"
			+ "    booked_assets = string_to_array(?, ',')  -- Converting comma-separated string to array\r\n"
			+ "WHERE booking_key = ?";



	public static String geteditslotBookingdetails(String bookingkey) {
		String query = "SELECT \r\n"
				+ "    booking_project AS bookingProject, \r\n"
				+ "    booking_title AS bookingTitle, \r\n"
				+ "    booking_for AS bookingFor, \r\n"
				+ "    array_to_string(booked_assets, ',') AS bookedAssets,  -- Convert array to CSV string\r\n"
				+ "    booking_status AS bookingStatus, \r\n"
				+ "    TO_CHAR(booking_timedt, 'YYYY-MM-DD') AS bookingTimeDt, -- Convert timestamp to String\r\n"
				+ "    booking_duration_mins AS bookingDurationMins, \r\n"
				+ "    booking_description AS bookingDescription, \r\n"
				+ "    booking_notes AS bookingNotes, \r\n"
				+ "    booking_created_by AS bookingCreatedBy, \r\n"
				+ "    booking_key AS bookingKey\r\n"
				+ "FROM slot_booking \r\n"
				+ "WHERE booking_key = '"+bookingkey+"'";
		
		System.out.println(query);
		return query ;
	}

	

	public static String SLOT_BOOKING_LIST() {
		String query="SELECT \r\n"
				+ "    booking_key,\r\n"
				+ "    booking_project,\r\n"
				+ "    booking_title,\r\n"
				+ "    booking_for,\r\n"
				+ "    booked_assets, -- This is an array (VARCHAR[] in PostgreSQL or comma-separated string)\r\n"
				+ "    booking_status,\r\n"
				+ "    TO_CHAR(booking_timedt, 'YYYY-MM-DD HH24:MI:SS') AS booking_timedt, -- Convert to string format\r\n"
				+ "    booking_duration_mins,\r\n"
				+ "    booking_description,\r\n"
				+ "    booking_notes,\r\n"
				+ "    booking_created_by\r\n"
				+ "FROM \r\n"
				+ "    slot_booking";
			
		return query;
	}
	
	
	public static String Delete_User_Account ="delete from asset_master where asset_key = ? ";
	
	public static final String get_profile_images = "Select nu.profile_img as uploadImg,prev_prof_img1 as uploadImg1,prev_prof_img2 as uploadImg2 from new.user_details nu  \r\n"
			+ "inner join new.ind_profile_info ip on ip.talent_id = nu.talent_id\r\n"
			+ "where nu.talent_id=? ";

}
