package com.sitespace.fileupload.subcontractor;


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

	
	
	
	@RequestMapping(value = "/subcontractorRegMail")
	public @ResponseBody subcontractorResultBean verificationSuiteIntimationMail(@RequestBody subcontractorBean regobj, HttpServletRequest request) {
		subcontractorResultBean objbranchResultBean = new subcontractorResultBean();
	    try {
	       
	        String scheme = request.getScheme();
	        String serverName = request.getServerName();
	        int portNumber = request.getServerPort();

	        // JdbcTemplate setup (assuming dataSource is already configured)
//	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

//	         SQL queries to fetch user names
//	        String query = "SELECT user_name FROM auth.app_user WHERE talent_id = ?";
//	        String UserName = jdbcTemplate.queryForObject(query, new Object[]{regobj.getTalentId()}, String.class);
//	        String oniName = jdbcTemplate.queryForObject(query, new Object[]{regobj.getOrganisationName()}, String.class);

	        
	        String toemailId = "";
	        String talentId =  "";
	        String PASSWORD =  "";
	        String Username = " ";
	        

	      
	        String talentId1 = talentId.replace("/", "tc").replace("+", "tl");	       
	        Email email1 = new Email();
	        email1.setSubject("  New Belstar Registration Completed – "+Username+ " ");

	        // Construct the email body
	        StringBuffer sbq = new StringBuffer();
			sbq.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n"
					+ "<html data-editor-version=\"2\" class=\"sg-campaigns\" xmlns=\"http://www.w3.org/1999/xhtml\">\r\n"
					+ "\r\n"
					+ "<head>\r\n"
					+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1\">\r\n"
					+ "\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\r\n"
					+ "\r\n"
					+ "    <style type=\"text/css\">\r\n"
					+ "        body,\r\n"
					+ "        p,\r\n"
					+ "        div {\r\n"
					+ "            font-family: inherit;\r\n"
					+ "            font-size: 14px;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        body {\r\n"
					+ "            color: #000000;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        body a {\r\n"
					+ "            color: #1188E6;\r\n"
					+ "            text-decoration: none;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        p {\r\n"
					+ "            margin: 0;\r\n"
					+ "            padding: 0;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        table.wrapper {\r\n"
					+ "            width: 100% !important;\r\n"
					+ "            table-layout: fixed;\r\n"
					+ "            -webkit-font-smoothing: antialiased;\r\n"
					+ "            -webkit-text-size-adjust: 100%;\r\n"
					+ "            -moz-text-size-adjust: 100%;\r\n"
					+ "            -ms-text-size-adjust: 100%;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        img.max-width {\r\n"
					+ "            max-width: 100% !important;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        .column.of-2 {\r\n"
					+ "            width: 50%;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        .column.of-3 {\r\n"
					+ "            width: 33.333%;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        .column.of-4 {\r\n"
					+ "            width: 25%;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        ul ul ul ul {\r\n"
					+ "            list-style-type: disc !important;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        ol ol {\r\n"
					+ "            list-style-type: lower-roman !important;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        ol ol ol {\r\n"
					+ "            list-style-type: lower-latin !important;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        ol ol ol ol {\r\n"
					+ "            list-style-type: decimal !important;\r\n"
					+ "        }\r\n"
					+ "        \r\n"
					+ "        @media screen and (max-width:480px) {\r\n"
					+ "            .preheader .rightColumnContent,\r\n"
					+ "            .footer .rightColumnContent {\r\n"
					+ "                text-align: left !important;\r\n"
					+ "            }\r\n"
					+ "            .preheader .rightColumnContent div,\r\n"
					+ "            .preheader .rightColumnContent span,\r\n"
					+ "            .footer .rightColumnContent div,\r\n"
					+ "            .footer .rightColumnContent span {\r\n"
					+ "                text-align: left !important;\r\n"
					+ "            }\r\n"
					+ "            .preheader .rightColumnContent,\r\n"
					+ "            .preheader .leftColumnContent {\r\n"
					+ "                font-size: 80% !important;\r\n"
					+ "                padding: 5px 0;\r\n"
					+ "            }\r\n"
					+ "            table.wrapper-mobile {\r\n"
					+ "                width: 100% !important;\r\n"
					+ "                table-layout: fixed;\r\n"
					+ "            }\r\n"
					+ "            img.max-width {\r\n"
					+ "                height: auto !important;\r\n"
					+ "                max-width: 100% !important;\r\n"
					+ "            }\r\n"
					+ "            a.bulletproof-button {\r\n"
					+ "                display: block !important;\r\n"
					+ "                width: auto !important;\r\n"
					+ "                font-size: 80%;\r\n"
					+ "                padding-left: 0 !important;\r\n"
					+ "                padding-right: 0 !important;\r\n"
					+ "            }\r\n"
					+ "            .columns {\r\n"
					+ "                width: 100% !important;\r\n"
					+ "            }\r\n"
					+ "            .column {\r\n"
					+ "                display: block !important;\r\n"
					+ "                width: 100% !important;\r\n"
					+ "                padding-left: 0 !important;\r\n"
					+ "                padding-right: 0 !important;\r\n"
					+ "                margin-left: 0 !important;\r\n"
					+ "                margin-right: 0 !important;\r\n"
					+ "            }\r\n"
					+ "            .social-icon-column {\r\n"
					+ "                display: inline-block !important;\r\n"
					+ "            }\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "    <!--user entered Head Start-->\r\n"
					+ "    <link href=\"https://fonts.googleapis.com/css?family=Muli&display=swap\" rel=\"stylesheet\">\r\n"
					+ "    <style>\r\n"
					+ "        body {\r\n"
					+ "            font-family: 'Muli', sans-serif;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "    <!--End Head user entered-->\r\n"
					+ "</head>\r\n"
					+ "\r\n"
					+ "<body>\r\n"
					+ "    <center class=\"wrapper\" data-link-color=\"#1188E6\" data-body-style=\"font-size:14px; font-family:inherit; color:#000000; background-color:#FFFFFF;\">\r\n"
					+ "        <div class=\"webkit\">\r\n"
					+ "            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"wrapper\" bgcolor=\"#FFFFFF\">\r\n"
					+ "                <tr>\r\n"
					+ "                    <td valign=\"top\" bgcolor=\"#FFFFFF\" width=\"100%\">\r\n"
					+ "                        <table width=\"100%\" role=\"content-container\" class=\"outer\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
					+ "                            <tr>\r\n"
					+ "                                <td width=\"100%\">\r\n"
					+ "                                    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
					+ "                                        <tr>\r\n"
					+ "                                            <td>\r\n"
					+ "                                                <!--[if mso]>\r\n"
					+ "						  		    <center>\r\n"
					+ "						  		    <table><tr><td width=\"600\">\r\n"
					+ "						  		  <![endif]-->\r\n"
					+ "                                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:100%; max-width:600px;\" align=\"center\">\r\n"
					+ "                                                    <tr>\r\n"
					+ "                                                        <td role=\"modules-container\" style=\"padding:0px 0px 0px 0px; color:#000000; text-align:left;\" bgcolor=\"#FFFFFF\" width=\"100%\" align=\"left\">\r\n"
					+ "                                                            <table class=\"module preheader preheader-hide\" role=\"module\" data-type=\"preheader\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"display: none !important; mso-hide: all; visibility: hidden; opacity: 0; color: transparent; height: 0; width: 0;\">\r\n"
					+ "                                                                <tr>\r\n"
					+ "                                                                    <td role=\"module-content\">\r\n"
					+ "                                                                        <p></p>\r\n"
					+ "                                                                    </td>\r\n"
					+ "                                                                </tr>\r\n"
					+ "                                                            </table>\r\n"
					+ "                                                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" role=\"module\" data-type=\"columns\" style=\"padding:30px 20px 30px 20px;\" bgcolor=\"#f6f6f6\" data-distribution=\"1\">\r\n"
					+ "                                                                <tbody>\r\n"
					+ "                                                                    <tr role=\"module-content\">\r\n"
					+ "                                                                        <td height=\"100%\" valign=\"top\">\r\n"
					+ "                                                                            <table width=\"540\" style=\"width:540px; border-spacing:0; border-collapse:collapse; margin:0px 10px 0px 10px;\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" border=\"0\" bgcolor=\"\" class=\"column column-0\">\r\n"
					+ "                                                                                <tbody>\r\n"
					+ "                                                                                    <tr>\r\n"
					+ "                                                                                        <td style=\"padding:0px;margin:0px;border-spacing:0;\">\r\n"
					+ "                                                                                            <table class=\"wrapper\" role=\"module\" data-type=\"image\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"72aac1ba-9036-4a77-b9d5-9a60d9b05cba\">\r\n"
					+ "                                                                                                <tbody>\r\n"
					+ "                                                                                                    <tr>\r\n"
					+ "                                                                                                        <td style=\"font-size:6px; line-height:10px; padding:15px 0px 0px 0px;\" valign=\"top\" align=\"center\">\r\n"
					+ "\r\n"
					+ "                                                                                                            <img class=\"max-width\" border=\"0\" style=\"display:block; color:#000000; text-decoration:none; font-family:Helvetica, arial, sans-serif; font-size:16px;\" width=\"99\" alt=\"\" data-proportionally-constrained=\"true\" data-responsive=\"false\" src=\"https://cdn.mcauto-images-production.sendgrid.net/521dd7e8083fb58d/4b1d4d06-55db-41ac-ab7a-af9ef29ef8e9/1625x727.png\"\r\n"
					+ "                                                                                                                height=\"99\"></td>\r\n"
					+ "                                                                                                    </tr>\r\n"
					+ "                                                                                                </tbody>\r\n"
					+ "                                                                                            </table>\r\n"
					+ "                                                                                            <table class=\"module\" role=\"module\" data-type=\"spacer\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"27716fe9-ee64-4a64-94f9-a4f28bc172a0\">\r\n"
					+ "                                                                                                <tbody>\r\n"
					+ "                                                                                                    <tr>\r\n"
					+ "                                                                                                        <td style=\"padding:0px 0px 30px 0px;\" role=\"module-content\" bgcolor=\"\">\r\n"
					+ "                                                                                                        </td>\r\n"
					+ "                                                                                                    </tr>\r\n"
					+ "                                                                                                </tbody>\r\n"
					+ "                                                                                            </table>\r\n"
					+ "                                                                                            <table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"948e3f3f-5214-4721-a90e-625a47b1c957\" data-mc-module-version=\"2019-10-22\">\r\n"
					+ "                                                                                                <tbody>\r\n"
					+ "                                                                                                    <tr>\r\n"
					+ "                                                                                                        <td style=\"padding:32px 30px 18px 30px; line-height:22px; text-align:inherit; background-color:#ffffff;\" height=\"100%\" valign=\"top\" bgcolor=\"#ffffff\" role=\"module-content\">\r\n"
					+ "                                                                                                            <div>\r\n"
					+ "                                                                                                                <div style=\"font-family: inherit; text-align: left\"><span style=\"font-size: 18px\">Dear "+Username+",\r\n"
					+ "                                                                                                                    <br>\r\n"
					+ "                                                                                                                    <br>\r\n"
					+ "                                                                                                                    A candidate registration is completed in the TalentChek platform for Belstar. The details are:</span></div>\r\n"
					+ "                                                                                                                <div style=\"font-family: inherit; text-align: left\"><br></div>\r\n"
					+ "                                                                                                                <div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #ff9d3d; font-family: Colfax, Helvetica, Arial, sans-serif; font-size: 18px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 700; letter-spacing: normal; orphans: 2; text-align: left; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space-collapse: preserve; text-wrap: wrap; background-color: rgb(255, 255, 255); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; float: none; display: inline\">Name :"+Username+"</span></div>\r\n"
					+ "                                                                                                                <div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #ff9d3d; font-family: Colfax, Helvetica, Arial, sans-serif; font-size: 18px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 700; letter-spacing: normal; orphans: 2; text-align: left; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space-collapse: preserve; text-wrap: wrap; background-color: rgb(255, 255, 255); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; float: none; display: inline\">Email &nbsp;:"+toemailId+"</span>&nbsp;</div>\r\n"
					+ "                                                                                                                <div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #ff9d3d; font-family: Colfax, Helvetica, Arial, sans-serif; font-size: 18px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 700; letter-spacing: normal; orphans: 2; text-align: left; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space-collapse: preserve; text-wrap: wrap; background-color: rgb(255, 255, 255); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; float: none; display: inline\">Mobile No :"+toemailId+"</span></div>\r\n"
					+ "                                                                                                                <div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #ff9d3d; font-family: Colfax, Helvetica, Arial, sans-serif; font-size: 18px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 700; letter-spacing: normal; orphans: 2; text-align: left; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space-collapse: preserve; text-wrap: wrap; background-color: rgb(255, 255, 255); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; float: none; display: inline\">Password &nbsp;:"+PASSWORD+"</span>&nbsp;</div>\r\n"
					+ "                                                                                                                <div style=\"font-family: inherit; text-align: inherit\"><br></div>\r\n"
					+ "                                                                                                                <div style=\"font-family: inherit; text-align: left\"><span style=\"color: #000000; font-family: Colfax, Helvetica, Arial, sans-serif; font-size: 18px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space-collapse: preserve; text-wrap: wrap; background-color: rgb(255, 255, 255); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; float: none; display: inline\">In case any further information or action is needed on this registration, you can reach out to us. </span>\r\n"
					+ "\r\n"
					+ "                                                                                                                </div>\r\n"
					+ "                                                                                                                <br>\r\n"
					+ "                                                                                                                <br>\r\n"
					+ "                                                                                                                <div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #000000; font-family: Colfax, Helvetica, Arial, sans-serif; font-size: 18px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space-collapse: preserve; text-wrap: wrap; background-color: rgb(255, 255, 255); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; float: none; display: inline\">Best Regards,\r\n"
					+ "                                                                                                                <div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #000000; font-family: Colfax, Helvetica, Arial, sans-serif; font-size: 18px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space-collapse: preserve; text-wrap: wrap; background-color: rgb(255, 255, 255); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial; float: none; display: inline\">TalentChek Team\r\n"
					+ "                                                                                                            </div>\r\n"
					+ "                                                                                                        </td>\r\n"
					+ "                                                                                                    </tr>\r\n"
					+ "                                                                                                </tbody>\r\n"
					+ "                                                                                            </table>\r\n"
					+ "                                                                                        </td>\r\n"
					+ "                                                                                    </tr>\r\n"
					+ "                                                                                </tbody>\r\n"
					+ "                                                                            </table>\r\n"
					+ "                                                                        </td>\r\n"
					+ "                                                                    </tr>\r\n"
					+ "                                                                </tbody>\r\n"
					+ "                                                            </table>\r\n"
					+ "                                                        </td>\r\n"
					+ "                                                    </tr>\r\n"
					+ "                                                </table>\r\n"
					+ "\r\n"
					+ "                                            </td>\r\n"
					+ "                                        </tr>\r\n"
					+ "                                    </table>\r\n"
					+ "                                </td>\r\n"
					+ "                            </tr>\r\n"
					+ "                        </table>\r\n"
					+ "                    </td>\r\n"
					+ "                </tr>\r\n"
					+ "            </table>\r\n"
					+ "        </div>\r\n"
					+ "    </center>\r\n"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>");
					

	        // Set email addresses
	        String from = "support@talentchek.com";
	        String toMail = regobj.getEmailId();
	        String ccMail = "kesavan@paragondynamics.in";
	        String path = "";

	        // Split email addresses
	        String[] to = toMail.split(",");
	        String[] cc = ccMail.split(",");

	        // Set email addresses in the email object
	        email1.setFromEmailAddress(from);
	        email1.setCcEmailAddress(cc);
	        email1.setToEmailAddress(to);
	        email1.setBodyHtml(sbq.toString());

	        // Send the email
	        try {
	            objbranchResultBean.setSuccess(true);
	            objbranchResultBean.setMessage("Mail Sent Successfully");
	            MailUtility.sendMail(email1, path);

	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle email sending failure
	            throw new RuntimeException("Failed to send email", e);
	        }

	    } catch (DataAccessException e) {
	        e.printStackTrace();
	        // Handle data access failure
	        throw new RuntimeException("Data access error", e);
	    }
	    return objbranchResultBean;
	}
	
	
	
	
}
