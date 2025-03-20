package com.sitespace.fileupload.subcontractor;


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sitespace.common.Email;
import com.sitespace.common.MailUtility;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//import sun.misc.BASE64Decoder;
@Api(tags="Subcontractor Operation", description="Manages Asset Operation")
@RestController
@RequestMapping("/api/auth/subContractor")
public class subcontractorController {
	
	@Autowired
	subcontractorService assetService;
		
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@ApiOperation(value = "subcontractor Controller")

	
	@PostMapping(value = "/subcontractorRegistration")
	public @ResponseBody  subcontractorResultBean subcontractorRegistration(@RequestBody subcontractorBean obj) throws Exception{
		subcontractorResultBean assetResultBean = new subcontractorResultBean();
		try {

			assetResultBean = assetService.subcontractorRegistration(obj);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return assetResultBean;

	}
	
	
	
	
//	//connection List
//	
//	@GetMapping("/getAssetList")
//	public @ResponseBody subcontractorResultBean assetList(@RequestParam("currentUserId")String currentUserId) {
//		subcontractorResultBean assetResultBean = new subcontractorResultBean();
//
//		try {
//			assetResultBean = assetService.assetList(currentUserId);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return assetResultBean;
//	}
//	
//
//	
//	//UpdateSkill
//	
//	@PostMapping(value = "/updateAsset")
//	public @ResponseBody  subcontractorResultBean updateAsset(@RequestBody subcontractorBean objAsset) throws Exception{
//		subcontractorResultBean assetresultBean = new subcontractorResultBean();
//		try {
//
//			assetresultBean = assetService.updateAsset(objAsset);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return assetresultBean;
//
//	}
//		//editprofiledetails individual
//		
//	@PostMapping(value = "/editAssetdetails")
//		public @ResponseBody subcontractorResultBean editAssetdetails(@RequestParam ("currentUserId") String currentUserId) {
//			subcontractorResultBean assetResultBean = new subcontractorResultBean();
//			try {
//
//				assetResultBean = assetService.editAssetdetails(currentUserId);
//	
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//
//		return assetResultBean;
//
//	}
//
//
//
//	
	//delete my account for Ios
	
//	@PostMapping(value = "/deleteAsset")
//	public @ResponseBody subcontractorResultBean deleteAseet(@RequestBody subcontractorBean delete) {
//		subcontractorResultBean assetResultBean = new subcontractorResultBean();
//		boolean isSuccess = false;
//		try {
//			assetResultBean = assetService.deleteAseet(delete);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return assetResultBean;
//	}

	
	
	
	@PostMapping(value = "/subcontractorRegMail")
	public @ResponseBody subcontractorResultBean verificationSuiteIntimationMail(@RequestBody subcontractorBean regobj) {
		subcontractorResultBean objbranchResultBean = new subcontractorResultBean();
		try {
			final String username = "sitespace@protonmail.com";
	        final String password = "Kesavan@1542"; // Get from ProtonMail Bridge

	        Properties props = new Properties();
	        props.put("mail.smtp.host", "127.0.0.1");
	        props.put("mail.smtp.port", "1025");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");

	        Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        });

	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kesavan1542@gmail.com"));
	            message.setSubject("Test Email");
	            message.setText("Hello from Java using ProtonMail Bridge!");

	            Transport.send(message);
	            System.out.println("Email Sent Successfully!");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	
		}
		catch (Exception e) {
            e.printStackTrace();
        }
		
		return objbranchResultBean;
	}
	
}
