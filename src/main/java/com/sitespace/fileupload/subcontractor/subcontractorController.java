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
@RequestMapping("/api/subContractor")
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

		        final String username = "88eaa1001@smtp-brevo.com"; // Mailtrap SMTP username
		        final String password = "52PIxEyCGLk6sm7J"; // Mailtrap SMTP password

		        Properties props = new Properties();
		        props.put("mail.smtp.host", "smtp-relay.brevo.com"); // Mailtrap SMTP host
		        props.put("mail.smtp.port", "587"); // Mailtrap port (default: 2525)
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.starttls.enable", "true");

		        Session session = Session.getInstance(props, new Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(username, password);
		            }
		        });
		        
			    String projectName=jdbcTemplate.queryForObject(subcontractorQueryUtil.getProjectName, 
						new Object[] {regobj.getContractorProjectId()},(String.class));  

		        try {
		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress("sitespace.com.au@gmail.com")); // Change as needed
		            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(regobj.getContractorEmail())); // Change recipient
		            message.setSubject("Invitation to Join "+projectName+" on SiteSpace");
		            message.setText("Dear "+regobj.getContractorName()+",\r\n"
		            		+ "\r\n"
		            		+ "You have been invited to join "+projectName+" on SiteSpace.\r\n"
		            		+ "\r\n"
		            		+ "By joining, you can pre-book the necessary equipment and assets for the site and get approvals from the site manager in advance, ensuring a smooth and hassle-free experience.\r\n"
		            		+ "\r\n"
		            		+ "Click the link below to join:\r\n"
		            		+ "\r\n"
		            		+ "https://sitespace.vercel.app/register/"+regobj.getContractorProjectId()+"\r\n"
		            		+ "\r\n"
		            		+ "If you have any questions, feel free to reach out.\r\n"
		            		+ "\r\n"
		            		+ "Thank you,\r\n"
		            		+ "Team SiteSpace");

		            Transport.send(message);
		            System.out.println("Email Sent Successfully!");

		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }
		

		
		return objbranchResultBean;
	}
	
}
