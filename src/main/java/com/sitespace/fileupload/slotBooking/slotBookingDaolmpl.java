package com.sitespace.fileupload.slotBooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.sitespace.fileupload.assetmaster.assetQueryUtil;

import java.util.Properties;
import java.io.StringWriter;
import java.sql.Array;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;



@Repository
public class slotBookingDaolmpl implements slotBookingDao {

	
private final static Logger LOGGER = LoggerFactory.getLogger(slotBookingDaolmpl.class);
	


	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	//updateprofile
	 
	
	@Override
	public slotBookingResultBean saveSlotBooking(slotBookingBean obj) {

		slotBookingResultBean bookingResultBean = new slotBookingResultBean();
	    try {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		    Date bookingTimeDt = new Date(sdf.parse(obj.getBookingTimeDt()).getTime());

	        int count = jdbcTemplate.update(
	            slotBookingQueryUtil.insert_slotBooking, 
	            new Object[] {
	                obj.getBookingProject(), 
	                obj.getBookingTitle(), 
	                obj.getBookingFor(), 
	                String.join(",", obj.getBookedAssets()), // Convert list to comma-separated string
	                bookingTimeDt, 
	                obj.getBookingDurationMins(), 
	                obj.getBookingDescription(), 
	                obj.getBookingNotes(), 
	                obj.getBookingCreatedBy()
	            }
	        );

	        if (count != 0) {
	            bookingResultBean.setSuccess(true);
	            bookingResultBean.setMessage("Slot Booking Saved Successfully");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        bookingResultBean.setSuccess(false);
	        bookingResultBean.setMessage("Error! Please try again later.");
	    }
	    return bookingResultBean;
	}


	@Override
	public slotBookingResultBean updateslotBooking(slotBookingBean booking) {
	    slotBookingResultBean resultBean = new slotBookingResultBean();
	    
	    try { 
	    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	        // Convert List<String> to a comma-separated string if needed
	        String bookedAssetsStr = String.join(",", booking.getBookedAssets());
	        
	  	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		    Date bookingTimeDt = new Date(sdf.parse(booking.getBookingTimeDt()).getTime());

	        int count = jdbcTemplate.update(
	            slotBookingQueryUtil.UPDATE_BOOKING, 
	            new Object[] { 
	                booking.getBookingProject(), 
	                booking.getBookingTitle(), 
	                booking.getBookingFor(), 
	                booking.getBookingStatus(), 
	                bookingTimeDt,  // Stored as String
	                booking.getBookingDurationMins(), 
	                booking.getBookingDescription(), 
	                booking.getBookingNotes(), 
	                bookedAssetsStr,  // Updating bookedAssets as a String
	                booking.getBookingKey()  // Using bookingKey as identifier
	            }
	        );

	        if (count != 0) {
	        	resultBean.setSuccess(true);
	        	resultBean.setMessage("Booking Updated Successfully");
	        }

	    } catch (Exception e) {
	        resultBean.setSuccess(false);
	        resultBean.setMessage("Error occurred, please try again later.");
	        e.printStackTrace(); // Consider using a logger instead
	    }
	    
	    return resultBean;
	}
			  
			////editprofile
			  
			  @Override
				public slotBookingResultBean editslotBookingdetails(String assetkey) {
					// TODO Auto-generated method stub
				  slotBookingResultBean assetResultBean = new slotBookingResultBean();
					List<slotBookingBean> editassetdetails = new ArrayList<slotBookingBean>();

					try {
						JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);				
						
						//String query = "select * from public.vw_edit_jobseek_details('" + talentId +"')";
						
						editassetdetails= jdbcTemplate.query(slotBookingQueryUtil.geteditslotBookingdetails(assetkey),new Object[] {},
						new BeanPropertyRowMapper<slotBookingBean>(slotBookingBean.class));
						
						
						assetResultBean.setBookingList(editassetdetails);
						assetResultBean.setSuccess(true);			
					}	catch (Exception e) {
						e.printStackTrace();
					}
					return assetResultBean;	
			  }
			  

			 

			
			// connectionList
			  @Override
			  public slotBookingResultBean getslotBookingList(String userId,String projectId) {
			      List<slotBookingBean> bookingList = new ArrayList<>();
			      slotBookingResultBean bookingResultBean = new slotBookingResultBean();

			      try {
			          JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			          // Execute query and get list of maps
			          List<Map<String, Object>> rows = jdbcTemplate.queryForList(
			              slotBookingQueryUtil.SLOT_BOOKING_LIST(userId,projectId), 
			              new Object[]{}
			          );

			          for (Map<String, Object> row : rows) {
			              slotBookingBean booking = new slotBookingBean();
			              booking.setBookingKey((String) row.get("booking_key"));
			              booking.setBookingProject((String) row.get("booking_project"));
			              booking.setBookingTitle((String) row.get("booking_title"));
			              booking.setBookingFor((String) row.get("booking_for"));
			              booking.setBookingStatus((String) row.get("booking_status"));
			              booking.setBookingTimeDt(((String) row.get("booking_timedt")));
			              booking.setBookingDurationMins((Integer) row.get("booking_duration_mins"));
			              booking.setBookingDescription((String) row.get("booking_description"));
			              booking.setBookingNotes((String) row.get("booking_notes"));
			              booking.setBookingCreatedBy((String) row.get("booking_created_by"));
			            

			              // Handling booked_assets (PostgreSQL VARCHAR[] or comma-separated string)
			              Object bookedAssetsObj = row.get("booked_assets");
			              if (bookedAssetsObj instanceof Array) {
			                  String[] assets = (String[]) ((Array) bookedAssetsObj).getArray();
			                  booking.setBookedAssets(Arrays.asList(assets));
			              } else if (bookedAssetsObj instanceof String) {
			                  booking.setBookedAssets(Arrays.asList(((String) bookedAssetsObj).split(",")));
			              } else {
			                  booking.setBookedAssets(new ArrayList<>());
			              }

			              bookingList.add(booking);
			          }

			          bookingResultBean.setBookingList(bookingList);
			          bookingResultBean.setSuccess(true);

			      } catch (Exception e) {
			          e.printStackTrace();
			          bookingResultBean.setSuccess(false);
			          bookingResultBean.setMessage("Error retrieving slot booking list.");
			      }

			      return bookingResultBean;
			  }


				// connectionList
			  @Override
			  public slotBookingResultBean getslotBookingListProjectBased(String projectId) {
			      List<slotBookingBean> bookingList = new ArrayList<>();
			      slotBookingResultBean bookingResultBean = new slotBookingResultBean();

			      try {
			          JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			          // Execute query and get list of maps
			          List<Map<String, Object>> rows = jdbcTemplate.queryForList(
			              slotBookingQueryUtil.SLOT_BOOKING_Project_Based_LIST(projectId), 
			              new Object[]{}
			          );

			          for (Map<String, Object> row : rows) {
			              slotBookingBean booking = new slotBookingBean();
			              booking.setBookingKey((String) row.get("booking_key"));
			              booking.setBookingProject((String) row.get("booking_project"));
			              booking.setBookingTitle((String) row.get("booking_title"));
			              booking.setBookingFor((String) row.get("booking_for"));
			              booking.setBookingStatus((String) row.get("booking_status"));
			              booking.setBookingTimeDt(((String) row.get("booking_timedt")));
			              booking.setBookingDurationMins((Integer) row.get("booking_duration_mins"));
			              booking.setBookingDescription((String) row.get("booking_description"));
			              booking.setBookingNotes((String) row.get("booking_notes"));
			              booking.setBookingCreatedBy((String) row.get("booking_created_by"));
			            

			              // Handling booked_assets (PostgreSQL VARCHAR[] or comma-separated string)
			              Object bookedAssetsObj = row.get("booked_assets");
			              if (bookedAssetsObj instanceof Array) {
			                  String[] assets = (String[]) ((Array) bookedAssetsObj).getArray();
			                  booking.setBookedAssets(Arrays.asList(assets));
			              } else if (bookedAssetsObj instanceof String) {
			                  booking.setBookedAssets(Arrays.asList(((String) bookedAssetsObj).split(",")));
			              } else {
			                  booking.setBookedAssets(new ArrayList<>());
			              }

			              bookingList.add(booking);
			          }

			          bookingResultBean.setBookingList(bookingList);
			          bookingResultBean.setSuccess(true);

			      } catch (Exception e) {
			          e.printStackTrace();
			          bookingResultBean.setSuccess(false);
			          bookingResultBean.setMessage("Error retrieving slot booking list.");
			      }

			      return bookingResultBean;
			  }

			
			@Override
			public slotBookingResultBean deleteslotBooking(slotBookingBean delete) {
				// TODO Auto-generated method stub
				NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
				slotBookingResultBean mobileResultBean = new slotBookingResultBean();
				boolean isSuccess = false;
			
				try {	
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
					jdbcTemplate.update(slotBookingQueryUtil.Delete_User_Account, delete.getBookingKey());
					mobileResultBean.setSuccess(true);
					mobileResultBean.setMessage("Asset Removed SuccessFully");
				
				} catch (Exception e) {
					LOGGER.error("Error in Account delete", e);
					mobileResultBean.setSuccess(false);
					mobileResultBean.setMessage("Error Please Try after Sometime ");
				}

				// TODO Auto-generated method stub
				return mobileResultBean;
			}
			

			// ExportPDF view


		
}
