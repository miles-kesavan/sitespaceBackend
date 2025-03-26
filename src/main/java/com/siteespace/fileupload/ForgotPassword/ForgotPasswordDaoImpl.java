package com.siteespace.fileupload.ForgotPassword;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sitespace.common.CipherCrypto;
import com.sitespace.common.Email;
import com.sitespace.common.MailUtility;



@Repository
public class ForgotPasswordDaoImpl implements ForgotPasswordDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public ForgotPasswordResultBean forgotpasswordemail(ForgotPasswordBean objtest,
			HttpServletRequest request) {

		 {
				
			 ForgotPasswordResultBean ForgotPasswordResultBean = new ForgotPasswordResultBean();  
			 ForgotPasswordBean mybean = new ForgotPasswordBean();
			
				try {
					String userId = null; 
					String encryptEmail =CipherCrypto.Encrypt(objtest.getEmail());
					mybean = jdbcTemplate.queryForObject(ForgotPasswordQueryUtil.forgot_email(encryptEmail),new BeanPropertyRowMapper<ForgotPasswordBean>(ForgotPasswordBean.class));
					
					userId=mybean.getTalentId();

					mybean = jdbcTemplate.queryForObject(ForgotPasswordQueryUtil.DETAILSFORMAIL_EMAIL,new Object[]{userId},new BeanPropertyRowMapper<ForgotPasswordBean>(ForgotPasswordBean.class));
					String toemail=CipherCrypto.Decrypt(mybean.getEmail()).toLowerCase();
					String talentId=CipherCrypto.Encrypt(userId);

					String talentId1=talentId.replace("/", "tc").replace("+", "tl");
					
					//String talentId2=CipherCrypto.Decrypt(talentId1);


					//String UUID= jdbcTemplate.queryForObject(ForgotPasswordQueryUtil.GETEMAILURLID,new Object[]{userId},String.class);
					
			
					Email email1 = null;
					String[] emailIds = null;
					String userMailId = "support@talentchek.com";
					String toMailIds = toemail;
					String toCCMailIds = "harini@paragondynamics.in";
					//String toCCMailIds = "babulavanya4594@gmail.com";
					
					String scheme = request.getScheme();
					String tenant = "tc";
					String host = request.getHeader("Host"); // includes server
																// name and
																// server port
					String contextPath = request.getContextPath(); // includes
																	// leading
																	// forward
																	// slash
					String resultPath = scheme + "://" + host + contextPath+"/"+tenant; /*"+mybean.getUserName()+"*/
					//System.out.println("Result path: " + resultPath);
					String imgPath ="http://talentchek.com/wp-content/uploads/2021/02/TalentChekLogo_v1.png";
					
					if (!toMailIds.isEmpty()) {
						toMailIds = toMailIds;
								//+ "," + userMailId;
					}
					
					StringBuffer sb = new StringBuffer();
					
					
					sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
							+ "<html data-editor-version=\"2\" class=\"sg-campaigns\" xmlns=\"http://www.w3.org/1999/xhtml\">\n"
							+ "    <head>\n"
							+ "      <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
							+ "      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1\">\n"
							+ "      <!--[if !mso]><!-->\n"
							+ "      <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\n"
							+ "      <!--<![endif]-->\n"
							+ "      <!--[if (gte mso 9)|(IE)]>\n"
							+ "      <xml>\n"
							+ "        <o:OfficeDocumentSettings>\n"
							+ "          <o:AllowPNG/>\n"
							+ "          <o:PixelsPerInch>96</o:PixelsPerInch>\n"
							+ "        </o:OfficeDocumentSettings>\n"
							+ "      </xml>\n"
							+ "      <![endif]-->\n"
							+ "      <!--[if (gte mso 9)|(IE)]>\n"
							+ "  <style type=\"text/css\">\n"
							+ "    body {width: 600px;margin: 0 auto;}\n"
							+ "    table {border-collapse: collapse;}\n"
							+ "    table, td {mso-table-lspace: 0pt;mso-table-rspace: 0pt;}\n"
							+ "    img {-ms-interpolation-mode: bicubic;}\n"
							+ "  </style>\n"
							+ "<![endif]-->\n"
							+ "      <style type=\"text/css\">\n"
							+ "    body, p, div {\n"
							+ "      font-family: inherit;\n"
							+ "      font-size: 14px;\n"
							+ "    }\n"
							+ "    body {\n"
							+ "      color: #000000;\n"
							+ "    }\n"
							+ "    body a {\n"
							+ "      color: #1188E6;\n"
							+ "      text-decoration: none;\n"
							+ "    }\n"
							+ "    p { margin: 0; padding: 0; }\n"
							+ "    table.wrapper {\n"
							+ "      width:100% !important;\n"
							+ "      table-layout: fixed;\n"
							+ "      -webkit-font-smoothing: antialiased;\n"
							+ "      -webkit-text-size-adjust: 100%;\n"
							+ "      -moz-text-size-adjust: 100%;\n"
							+ "      -ms-text-size-adjust: 100%;\n"
							+ "    }\n"
							+ "    img.max-width {\n"
							+ "      max-width: 100% !important;\n"
							+ "    }\n"
							+ "    .column.of-2 {\n"
							+ "      width: 50%;\n"
							+ "    }\n"
							+ "    .column.of-3 {\n"
							+ "      width: 33.333%;\n"
							+ "    }\n"
							+ "    .column.of-4 {\n"
							+ "      width: 25%;\n"
							+ "    }\n"
							+ "    ul ul ul ul  {\n"
							+ "      list-style-type: disc !important;\n"
							+ "    }\n"
							+ "    ol ol {\n"
							+ "      list-style-type: lower-roman !important;\n"
							+ "    }\n"
							+ "    ol ol ol {\n"
							+ "      list-style-type: lower-latin !important;\n"
							+ "    }\n"
							+ "    ol ol ol ol {\n"
							+ "      list-style-type: decimal !important;\n"
							+ "    }\n"
							+ "    @media screen and (max-width:480px) {\n"
							+ "      .preheader .rightColumnContent,\n"
							+ "      .footer .rightColumnContent {\n"
							+ "        text-align: left !important;\n"
							+ "      }\n"
							+ "      .preheader .rightColumnContent div,\n"
							+ "      .preheader .rightColumnContent span,\n"
							+ "      .footer .rightColumnContent div,\n"
							+ "      .footer .rightColumnContent span {\n"
							+ "        text-align: left !important;\n"
							+ "      }\n"
							+ "      .preheader .rightColumnContent,\n"
							+ "      .preheader .leftColumnContent {\n"
							+ "        font-size: 80% !important;\n"
							+ "        padding: 5px 0;\n"
							+ "      }\n"
							+ "      table.wrapper-mobile {\n"
							+ "        width: 100% !important;\n"
							+ "        table-layout: fixed;\n"
							+ "      }\n"
							+ "      img.max-width {\n"
							+ "        height: auto !important;\n"
							+ "        max-width: 100% !important;\n"
							+ "      }\n"
							+ "      a.bulletproof-button {\n"
							+ "        display: block !important;\n"
							+ "        width: auto !important;\n"
							+ "        font-size: 80%;\n"
							+ "        padding-left: 0 !important;\n"
							+ "        padding-right: 0 !important;\n"
							+ "      }\n"
							+ "      .columns {\n"
							+ "        width: 100% !important;\n"
							+ "      }\n"
							+ "      .column {\n"
							+ "        display: block !important;\n"
							+ "        width: 100% !important;\n"
							+ "        padding-left: 0 !important;\n"
							+ "        padding-right: 0 !important;\n"
							+ "        margin-left: 0 !important;\n"
							+ "        margin-right: 0 !important;\n"
							+ "      }\n"
							+ "      .social-icon-column {\n"
							+ "        display: inline-block !important;\n"
							+ "      }\n"
							+ "    }\n"
							+ "  </style>\n"
							+ "    <style>\n"
							+ "      @media screen and (max-width:480px) {\n"
							+ "        table\\0 {\n"
							+ "          width: 480px !important;\n"
							+ "          }\n"
							+ "      }\n"
							+ "    </style>\n"
							+ "      <!--user entered Head Start--><link href=\"https://fonts.googleapis.com/css?family=Chivo&display=swap\" rel=\"stylesheet\"><style>\n"
							+ "body {font-family: 'Chivo', sans-serif;}\n"
							+ "</style><!--End Head user entered-->\n"
							+ "    </head>\n"
							+ "    <body>\n"
							+ "      <center class=\"wrapper\" data-link-color=\"#1188E6\" data-body-style=\"font-size:14px; font-family:inherit; color:#000000; background-color:#FFFFFF;\">\n"
							+ "        <div class=\"webkit\">\n"
							+ "          <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"wrapper\" bgcolor=\"#FFFFFF\">\n"
							+ "            <tr>\n"
							+ "              <td valign=\"top\" bgcolor=\"#FFFFFF\" width=\"100%\">\n"
							+ "                <table width=\"100%\" role=\"content-container\" class=\"outer\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
							+ "                  <tr>\n"
							+ "                    <td width=\"100%\">\n"
							+ "                      <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
							+ "                        <tr>\n"
							+ "                          <td>\n"
							+ "                            <!--[if mso]>\n"
							+ "    <center>\n"
							+ "    <table><tr><td width=\"600\">\n"
							+ "  <![endif]-->\n"
							+ "                                    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:100%; max-width:600px;\" align=\"center\">\n"
							+ "                                      <tr>\n"
							+ "                                        <td role=\"modules-container\" style=\"padding:0px 0px 0px 0px; color:#000000; text-align:left;\" bgcolor=\"#FFFFFF\" width=\"100%\" align=\"left\"><table class=\"module preheader preheader-hide\" role=\"module\" data-type=\"preheader\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"display: none !important; mso-hide: all; visibility: hidden; opacity: 0; color: transparent; height: 0; width: 0;\">\n"
							+ "    <tr>\n"
							+ "      <td role=\"module-content\">\n"
							+ "        <p></p>\n"
							+ "      </td>\n"
							+ "    </tr>\n"
							+ "  </table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" role=\"module\" data-type=\"columns\" style=\"padding:30px 0px 30px 30px;\" bgcolor=\"#00634a\" data-distribution=\"1\">\n"
							+ "    <tbody>\n"
							+ "      <tr role=\"module-content\">\n"
							+ "        <td height=\"100%\" valign=\"top\"><table width=\"570\" style=\"width:570px; border-spacing:0; border-collapse:collapse; margin:0px 0px 0px 0px;\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" border=\"0\" bgcolor=\"\" class=\"column column-0\">\n"
							+ "      <tbody>\n"
							+ "        <tr>\n"
							+ "          <td style=\"padding:0px;margin:0px;border-spacing:0;\"><table class=\"wrapper\" role=\"module\" data-type=\"image\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"e7a863cb-901d-4c17-83f3-8e9dc3e0df35\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"font-size:6px; line-height:10px; padding:0px 0px 0px 0px;\" valign=\"top\" align=\"center\">\n"
							+ "          \n"
							+ "        <a href=\"https://www.talentchek.com/\"><img class=\"max-width\" border=\"0\" style=\"display:block; color:#000000; text-decoration:none; font-family:Helvetica, arial, sans-serif; font-size:16px; max-width:30% !important; width:30%; height:auto !important;\" width=\"171\" alt=\"Talent Verification and Hiring\" data-proportionally-constrained=\"true\" data-responsive=\"true\" src=\"http://cdn.mcauto-images-production.sendgrid.net/521dd7e8083fb58d/4de0ce9c-3840-4a5c-a293-b873725a5656/1625x727.png\"></a></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table></td>\n"
							+ "        </tr>\n"
							+ "      </tbody>\n"
							+ "    </table></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" role=\"module\" data-type=\"columns\" style=\"padding:50px 0px 0px 30px;\" bgcolor=\"#fff7ea\" data-distribution=\"1\">\n"
							+ "    <tbody>\n"
							+ "      <tr role=\"module-content\">\n"
							+ "        <td height=\"100%\" valign=\"top\"><table width=\"550\" style=\"width:550px; border-spacing:0; border-collapse:collapse; margin:0px 10px 0px 10px;\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" border=\"0\" bgcolor=\"\" class=\"column column-0\">\n"
							+ "      <tbody>\n"
							+ "        <tr>\n"
							+ "          <td style=\"padding:0px;margin:0px;border-spacing:0;\"><table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"b16a4afb-f245-4156-968e-8080176990ea\" data-mc-module-version=\"2019-10-22\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:18px 40px 0px 0px; line-height:22px; text-align:inherit;\" height=\"100%\" valign=\"top\" bgcolor=\"\" role=\"module-content\"><div><div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #f75878; font-size: 24px\">We received a request to reset your talent account password.</span></div><div></div></div></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table class=\"wrapper\" role=\"module\" data-type=\"image\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"550f2fb7-70c1-463b-9758-84b6d731ca56\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"font-size:6px; line-height:10px; padding:0px 0px 0px 0px;\" valign=\"top\" align=\"left\">\n"
							+ "          <img class=\"max-width\" border=\"0\" style=\"display:block; color:#000000; text-decoration:none; font-family:Helvetica, arial, sans-serif; font-size:16px;\" width=\"162\" alt=\"\" data-proportionally-constrained=\"true\" data-responsive=\"false\" src=\"http://cdn.mcauto-images-production.sendgrid.net/954c252fedab403f/27050768-0978-4ce8-8ad0-fa01a1949374/162x34.png\" height=\"34\">\n"
							+ "        </td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"b16a4afb-f245-4156-968e-8080176990ea.1\" data-mc-module-version=\"2019-10-22\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:18px 40px 10px 0px; line-height:18px; text-align:inherit;\" height=\"100%\" valign=\"top\" bgcolor=\"\" role=\"module-content\"><div><div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #00634a\"><strong>Protecting your data is important to us.</strong></span></div>\n"
							+ "<div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #00634a\"><strong>Please click on the button below to begin.</strong></span></div><div></div></div></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table class=\"module\" role=\"module\" data-type=\"spacer\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"c97177b8-c172-4c4b-b5bd-7604cde23e3f\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:0px 0px 10px 0px;\" role=\"module-content\" bgcolor=\"\">\n"
							+ "        </td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"module\" data-role=\"module-button\" data-type=\"button\" role=\"module\" style=\"table-layout:fixed;\" width=\"100%\" data-muid=\"9c7ac938-a540-4353-9fec-543b193bf7da\">\n"
							+ "      <tbody>\n"
							+ "        <tr>\n"
							+ "          <td align=\"left\" bgcolor=\"\" class=\"outer-td\" style=\"padding:0px 0px 0px 0px;\">\n"
							+ "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"wrapper-mobile\" style=\"text-align:center;\">\n"
							+ "              <tbody>\n"
							+ "                <tr>\n"
							+ "                <td align=\"center\" bgcolor=\"#fbca5b\" class=\"inner-td\" style=\"border-radius:6px; font-size:16px; text-align:left; background-color:inherit;\">\n"
//							+ "                  <a  href="+"https://cip.talentchek.com/authentication/urlmailform/"+talentId+" style=\"background-color:#fbca5b; border:1px solid #fbca5b; border-color:#fbca5b; border-radius:0px; border-width:1px; color:#000000; display:inline-block; font-size:14px; font-weight:normal; letter-spacing:0px; line-height:normal; padding:12px 50px 12px 50px; text-align:center; text-decoration:none; border-style:solid; font-family:inherit;\" target=\"_blank\">Reset Password</a>\n"
//							+ "                  <a  href="+"https://portal.talentchek.com/authentication/urlmailform/"+talentId+" style=\"background-color:#fbca5b; border:1px solid #fbca5b; border-color:#fbca5b; border-radius:0px; border-width:1px; color:#000000; display:inline-block; font-size:14px; font-weight:normal; letter-spacing:0px; line-height:normal; padding:12px 50px 12px 50px; text-align:center; text-decoration:none; border-style:solid; font-family:inherit;\" target=\"_blank\">Reset Password</a>\n"
							+ "                  <a  href="+"https://portal.talentchek.com/authentication/urlmailform/"+talentId1+" style=\"background-color:#fbca5b; border:1px solid #fbca5b; border-color:#fbca5b; border-radius:0px; border-width:1px; color:#000000; display:inline-block; font-size:14px; font-weight:normal; letter-spacing:0px; line-height:normal; padding:12px 50px 12px 50px; text-align:center; text-decoration:none; border-style:solid; font-family:inherit;\" target=\"_blank\">Reset Password</a>\n"

							+ "                </td>\n"
							+ "                </tr>\n"
							+ "              </tbody>\n"
							+ "            </table>\n"
							+ "          </td>\n"
							+ "        </tr>\n"
							+ "      </tbody>\n"
							+ "    </table><table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"b16a4afb-f245-4156-968e-8080176990ea.1.1\" data-mc-module-version=\"2019-10-22\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:18px 40px 10px 0px; line-height:18px; text-align:inherit;\" height=\"100%\" valign=\"top\" bgcolor=\"\" role=\"module-content\"><div><div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #00634a\">If you did not request a password change, please contact us immediately so we can keep your account secure.</span></div>\n"
							+ "<div style=\"font-family: inherit; text-align: inherit\"><br></div>\n"
							+ "<div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #00634a\">Call Us at +044 42122110 or Email at support@talentchek.com</span></div><div></div></div></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table class=\"module\" role=\"module\" data-type=\"spacer\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"c97177b8-c172-4c4b-b5bd-7604cde23e3f.1.1\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:0px 0px 80px 0px;\" role=\"module-content\" bgcolor=\"\">\n"
							+ "        </td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table></td>\n"
							+ "        </tr>\n"
							+ "      </tbody>\n"
							+ "    </table></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table class=\"module\" role=\"module\" data-type=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"38ec2680-c847-4765-8c5f-aa2aba19a2b3\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:0px 0px 0px 0px;\" role=\"module-content\" height=\"100%\" valign=\"top\" bgcolor=\"\">\n"
							+ "          <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" height=\"7px\" style=\"line-height:7px; font-size:7px;\">\n"
							+ "            <tbody>\n"
							+ "              <tr>\n"
							+ "                <td style=\"padding:0px 0px 7px 0px;\" bgcolor=\"#ffffff\"></td>\n"
							+ "              </tr>\n"
							+ "            </tbody>\n"
							+ "          </table>\n"
							+ "        </td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><div data-role=\"module-unsubscribe\" class=\"module\" role=\"module\" data-type=\"unsubscribe\" style=\"color:#444444; font-size:12px; line-height:20px; padding:16px 16px 16px 16px; text-align:Center;\" data-muid=\"4e838cf3-9892-4a6d-94d6-170e474d21e5\"><div class=\"Unsubscribe--addressLine\"></div><p style=\"font-size:12px; line-height:20px;\"><a class=\"Unsubscribe--unsubscribeLink\" href=\"{{{unsubscribe}}}\" target=\"_blank\" style=\"\">Unsubscribe</a></p></div></td>\n"
							+ "                                      </tr>\n"
							+ "                                    </table>\n"
							+ "                                    <!--[if mso]>\n"
							+ "                                  </td>\n"
							+ "                                </tr>\n"
							+ "                              </table>\n"
							+ "                            </center>\n"
							+ "                            <![endif]-->\n"
							+ "                          </td>\n"
							+ "                        </tr>\n"
							+ "                      </table>\n"
							+ "                    </td>\n"
							+ "                  </tr>\n"
							+ "                </table>\n"
							+ "              </td>\n"
							+ "            </tr>\n"
							+ "          </table>\n"
							+ "        </div>\n"
							+ "      </center>\n"
							+ "    </body>\n"
							+ "  </html>"); 
					emailIds = toMailIds.split(",");
					email1 = new Email();
					email1.setFromEmailAddress(userMailId);
					email1.setToEmailAddress(emailIds);
					
					String[] ccEmailAddress = toCCMailIds.split(",");
					email1.setBccEmailAddress(ccEmailAddress);
					email1.setSubject("TALENT CHEK-Password Reset");
					
					
					email1.setBodyHtml(sb.toString());
					 
					MailUtility.sendMail(email1, "");
					
			
					ForgotPasswordResultBean.setSuccess(true);
			
			
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				return ForgotPasswordResultBean ;
		}
	         
	}
	
	@Override
	public ForgotPasswordResultBean forgotpasswordphone(ForgotPasswordBean objtest,HttpServletRequest request) {
		
	
			
			 ForgotPasswordResultBean ForgotPasswordResultBean = new ForgotPasswordResultBean();
			 ForgotPasswordBean mybean = new ForgotPasswordBean();
				try {
					
					String phone =CipherCrypto.Encrypt(objtest.getPhoneNo());
					mybean = jdbcTemplate.queryForObject(ForgotPasswordQueryUtil.forgot_phone(phone),new BeanPropertyRowMapper<ForgotPasswordBean>(ForgotPasswordBean.class));

					String userId =mybean.getTalentId();
					
						mybean = jdbcTemplate.queryForObject(ForgotPasswordQueryUtil.DETAILSFORMAIL_EMAIL,new Object[]{userId},new BeanPropertyRowMapper<ForgotPasswordBean>(ForgotPasswordBean.class));
						String toemail=CipherCrypto.Decrypt(mybean.getEmail()).toLowerCase();
						String talentId=CipherCrypto.Encrypt(userId);
					
						String talentId1=talentId.replace("/", "tc").replace("+", "tl");


						//String UUID= jdbcTemplate.queryForObject(ForgotPasswordQueryUtil.GETEMAILURLID,new Object[]{userId},String.class);
				   
	          

						Email email1 = null;
						String[] emailIds = null;
						String userMailId = "support@talentchek.com";
						String toMailIds = toemail;
						String toCCMailIds = "harini@paragondynamics.in";
						
						String scheme = request.getScheme();
						String tenant = "tc";
						String host = request.getHeader("Host"); // includes server
																	// name and
																	// server port
						String contextPath = request.getContextPath(); // includes
																		// leading
																		// forward
																		// slash
						String resultPath = scheme + "://" + host + contextPath+"/"+tenant; /*"+mybean.getUserName()+"*/
						//System.out.println("Result path: " + resultPath);
						String imgPath ="http://talentchek.com/wp-content/uploads/2021/02/TalentChekLogo_v1.png";
						
						if (!toMailIds.isEmpty()) {
							toMailIds = toMailIds;
									//+ "," + userMailId;
						}
						
						StringBuffer sb = new StringBuffer();
						
						
						sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
								+ "<html data-editor-version=\"2\" class=\"sg-campaigns\" xmlns=\"http://www.w3.org/1999/xhtml\">\n"
								+ "    <head>\n"
								+ "      <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
								+ "      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1\">\n"
								+ "      <!--[if !mso]><!-->\n"
								+ "      <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\n"
								+ "      <!--<![endif]-->\n"
								+ "      <!--[if (gte mso 9)|(IE)]>\n"
								+ "      <xml>\n"
								+ "        <o:OfficeDocumentSettings>\n"
								+ "          <o:AllowPNG/>\n"
								+ "          <o:PixelsPerInch>96</o:PixelsPerInch>\n"
								+ "        </o:OfficeDocumentSettings>\n"
								+ "      </xml>\n"
								+ "      <![endif]-->\n"
								+ "      <!--[if (gte mso 9)|(IE)]>\n"
								+ "  <style type=\"text/css\">\n"
								+ "    body {width: 600px;margin: 0 auto;}\n"
								+ "    table {border-collapse: collapse;}\n"
								+ "    table, td {mso-table-lspace: 0pt;mso-table-rspace: 0pt;}\n"
								+ "    img {-ms-interpolation-mode: bicubic;}\n"
								+ "  </style>\n"
								+ "<![endif]-->\n"
								+ "      <style type=\"text/css\">\n"
								+ "    body, p, div {\n"
								+ "      font-family: inherit;\n"
								+ "      font-size: 14px;\n"
								+ "    }\n"
								+ "    body {\n"
								+ "      color: #000000;\n"
								+ "    }\n"
								+ "    body a {\n"
								+ "      color: #1188E6;\n"
								+ "      text-decoration: none;\n"
								+ "    }\n"
								+ "    p { margin: 0; padding: 0; }\n"
								+ "    table.wrapper {\n"
								+ "      width:100% !important;\n"
								+ "      table-layout: fixed;\n"
								+ "      -webkit-font-smoothing: antialiased;\n"
								+ "      -webkit-text-size-adjust: 100%;\n"
								+ "      -moz-text-size-adjust: 100%;\n"
								+ "      -ms-text-size-adjust: 100%;\n"
								+ "    }\n"
								+ "    img.max-width {\n"
								+ "      max-width: 100% !important;\n"
								+ "    }\n"
								+ "    .column.of-2 {\n"
								+ "      width: 50%;\n"
								+ "    }\n"
								+ "    .column.of-3 {\n"
								+ "      width: 33.333%;\n"
								+ "    }\n"
								+ "    .column.of-4 {\n"
								+ "      width: 25%;\n"
								+ "    }\n"
								+ "    ul ul ul ul  {\n"
								+ "      list-style-type: disc !important;\n"
								+ "    }\n"
								+ "    ol ol {\n"
								+ "      list-style-type: lower-roman !important;\n"
								+ "    }\n"
								+ "    ol ol ol {\n"
								+ "      list-style-type: lower-latin !important;\n"
								+ "    }\n"
								+ "    ol ol ol ol {\n"
								+ "      list-style-type: decimal !important;\n"
								+ "    }\n"
								+ "    @media screen and (max-width:480px) {\n"
								+ "      .preheader .rightColumnContent,\n"
								+ "      .footer .rightColumnContent {\n"
								+ "        text-align: left !important;\n"
								+ "      }\n"
								+ "      .preheader .rightColumnContent div,\n"
								+ "      .preheader .rightColumnContent span,\n"
								+ "      .footer .rightColumnContent div,\n"
								+ "      .footer .rightColumnContent span {\n"
								+ "        text-align: left !important;\n"
								+ "      }\n"
								+ "      .preheader .rightColumnContent,\n"
								+ "      .preheader .leftColumnContent {\n"
								+ "        font-size: 80% !important;\n"
								+ "        padding: 5px 0;\n"
								+ "      }\n"
								+ "      table.wrapper-mobile {\n"
								+ "        width: 100% !important;\n"
								+ "        table-layout: fixed;\n"
								+ "      }\n"
								+ "      img.max-width {\n"
								+ "        height: auto !important;\n"
								+ "        max-width: 100% !important;\n"
								+ "      }\n"
								+ "      a.bulletproof-button {\n"
								+ "        display: block !important;\n"
								+ "        width: auto !important;\n"
								+ "        font-size: 80%;\n"
								+ "        padding-left: 0 !important;\n"
								+ "        padding-right: 0 !important;\n"
								+ "      }\n"
								+ "      .columns {\n"
								+ "        width: 100% !important;\n"
								+ "      }\n"
								+ "      .column {\n"
								+ "        display: block !important;\n"
								+ "        width: 100% !important;\n"
								+ "        padding-left: 0 !important;\n"
								+ "        padding-right: 0 !important;\n"
								+ "        margin-left: 0 !important;\n"
								+ "        margin-right: 0 !important;\n"
								+ "      }\n"
								+ "      .social-icon-column {\n"
								+ "        display: inline-block !important;\n"
								+ "      }\n"
								+ "    }\n"
								+ "  </style>\n"
								+ "    <style>\n"
								+ "      @media screen and (max-width:480px) {\n"
								+ "        table\\0 {\n"
								+ "          width: 480px !important;\n"
								+ "          }\n"
								+ "      }\n"
								+ "    </style>\n"
								+ "      <!--user entered Head Start--><link href=\"https://fonts.googleapis.com/css?family=Chivo&display=swap\" rel=\"stylesheet\"><style>\n"
								+ "body {font-family: 'Chivo', sans-serif;}\n"
								+ "</style><!--End Head user entered-->\n"
								+ "    </head>\n"
								+ "    <body>\n"
								+ "      <center class=\"wrapper\" data-link-color=\"#1188E6\" data-body-style=\"font-size:14px; font-family:inherit; color:#000000; background-color:#FFFFFF;\">\n"
								+ "        <div class=\"webkit\">\n"
								+ "          <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"wrapper\" bgcolor=\"#FFFFFF\">\n"
								+ "            <tr>\n"
								+ "              <td valign=\"top\" bgcolor=\"#FFFFFF\" width=\"100%\">\n"
								+ "                <table width=\"100%\" role=\"content-container\" class=\"outer\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
								+ "                  <tr>\n"
								+ "                    <td width=\"100%\">\n"
								+ "                      <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
								+ "                        <tr>\n"
								+ "                          <td>\n"
								+ "                            <!--[if mso]>\n"
								+ "    <center>\n"
								+ "    <table><tr><td width=\"600\">\n"
								+ "  <![endif]-->\n"
								+ "                                    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:100%; max-width:600px;\" align=\"center\">\n"
								+ "                                      <tr>\n"
								+ "                                        <td role=\"modules-container\" style=\"padding:0px 0px 0px 0px; color:#000000; text-align:left;\" bgcolor=\"#FFFFFF\" width=\"100%\" align=\"left\"><table class=\"module preheader preheader-hide\" role=\"module\" data-type=\"preheader\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"display: none !important; mso-hide: all; visibility: hidden; opacity: 0; color: transparent; height: 0; width: 0;\">\n"
								+ "    <tr>\n"
								+ "      <td role=\"module-content\">\n"
								+ "        <p></p>\n"
								+ "      </td>\n"
								+ "    </tr>\n"
								+ "  </table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" role=\"module\" data-type=\"columns\" style=\"padding:30px 0px 30px 30px;\" bgcolor=\"#00634a\" data-distribution=\"1\">\n"
								+ "    <tbody>\n"
								+ "      <tr role=\"module-content\">\n"
								+ "        <td height=\"100%\" valign=\"top\"><table width=\"570\" style=\"width:570px; border-spacing:0; border-collapse:collapse; margin:0px 0px 0px 0px;\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" border=\"0\" bgcolor=\"\" class=\"column column-0\">\n"
								+ "      <tbody>\n"
								+ "        <tr>\n"
								+ "          <td style=\"padding:0px;margin:0px;border-spacing:0;\"><table class=\"wrapper\" role=\"module\" data-type=\"image\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"e7a863cb-901d-4c17-83f3-8e9dc3e0df35\">\n"
								+ "    <tbody>\n"
								+ "      <tr>\n"
								+ "        <td style=\"font-size:6px; line-height:10px; padding:0px 0px 0px 0px;\" valign=\"top\" align=\"center\">\n"
								+ "          \n"
								+ "        <a href=\"https://www.talentchek.com/\"><img class=\"max-width\" border=\"0\" style=\"display:block; color:#000000; text-decoration:none; font-family:Helvetica, arial, sans-serif; font-size:16px; max-width:30% !important; width:30%; height:auto !important;\" width=\"171\" alt=\"Talent Verification and Hiring\" data-proportionally-constrained=\"true\" data-responsive=\"true\" src=\"http://cdn.mcauto-images-production.sendgrid.net/521dd7e8083fb58d/4de0ce9c-3840-4a5c-a293-b873725a5656/1625x727.png\"></a></td>\n"
								+ "      </tr>\n"
								+ "    </tbody>\n"
								+ "  </table></td>\n"
								+ "        </tr>\n"
								+ "      </tbody>\n"
								+ "    </table></td>\n"
								+ "      </tr>\n"
								+ "    </tbody>\n"
								+ "  </table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" role=\"module\" data-type=\"columns\" style=\"padding:50px 0px 0px 30px;\" bgcolor=\"#fff7ea\" data-distribution=\"1\">\n"
								+ "    <tbody>\n"
								+ "      <tr role=\"module-content\">\n"
								+ "        <td height=\"100%\" valign=\"top\"><table width=\"550\" style=\"width:550px; border-spacing:0; border-collapse:collapse; margin:0px 10px 0px 10px;\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" border=\"0\" bgcolor=\"\" class=\"column column-0\">\n"
								+ "      <tbody>\n"
								+ "        <tr>\n"
								+ "          <td style=\"padding:0px;margin:0px;border-spacing:0;\"><table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"b16a4afb-f245-4156-968e-8080176990ea\" data-mc-module-version=\"2019-10-22\">\n"
								+ "    <tbody>\n"
								+ "      <tr>\n"
								+ "        <td style=\"padding:18px 40px 0px 0px; line-height:22px; text-align:inherit;\" height=\"100%\" valign=\"top\" bgcolor=\"\" role=\"module-content\"><div><div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #00634a; font-size: 24px\">We received a request to reset your talent account password.</span></div><div></div></div></td>\n"
								+ "      </tr>\n"
								+ "    </tbody>\n"
								+ "  </table><table class=\"wrapper\" role=\"module\" data-type=\"image\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"550f2fb7-70c1-463b-9758-84b6d731ca56\">\n"
								+ "    <tbody>\n"
								+ "      <tr>\n"
								+ "        <td style=\"font-size:6px; line-height:10px; padding:0px 0px 0px 0px;\" valign=\"top\" align=\"left\">\n"
								+ "          <img class=\"max-width\" border=\"0\" style=\"display:block; color:#000000; text-decoration:none; font-family:Helvetica, arial, sans-serif; font-size:16px;\" width=\"162\" alt=\"\" data-proportionally-constrained=\"true\" data-responsive=\"false\" src=\"http://cdn.mcauto-images-production.sendgrid.net/954c252fedab403f/27050768-0978-4ce8-8ad0-fa01a1949374/162x34.png\" height=\"34\">\n"
								+ "        </td>\n"
								+ "      </tr>\n"
								+ "    </tbody>\n"
								+ "  </table><table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"b16a4afb-f245-4156-968e-8080176990ea.1\" data-mc-module-version=\"2019-10-22\">\n"
								+ "    <tbody>\n"
								+ "      <tr>\n"
								+ "        <td style=\"padding:18px 40px 10px 0px; line-height:18px; text-align:inherit;\" height=\"100%\" valign=\"top\" bgcolor=\"\" role=\"module-content\"><div><div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #00634a\"><strong>Protecting your data is important to us.</strong></span></div>\n"
								+ "<div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #00634a\"><strong>Please click on the button below to begin.</strong></span></div><div></div></div></td>\n"
								+ "      </tr>\n"
								+ "    </tbody>\n"
								+ "  </table><table class=\"module\" role=\"module\" data-type=\"spacer\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"c97177b8-c172-4c4b-b5bd-7604cde23e3f\">\n"
								+ "    <tbody>\n"
								+ "      <tr>\n"
								+ "        <td style=\"padding:0px 0px 10px 0px;\" role=\"module-content\" bgcolor=\"\">\n"
								+ "        </td>\n"
								+ "      </tr>\n"
								+ "    </tbody>\n"
								+ "  </table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"module\" data-role=\"module-button\" data-type=\"button\" role=\"module\" style=\"table-layout:fixed;\" width=\"100%\" data-muid=\"9c7ac938-a540-4353-9fec-543b193bf7da\">\n"
								+ "      <tbody>\n"
								+ "        <tr>\n"
								+ "          <td align=\"left\" bgcolor=\"\" class=\"outer-td\" style=\"padding:0px 0px 0px 0px;\">\n"
								+ "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"wrapper-mobile\" style=\"text-align:center;\">\n"
								+ "              <tbody>\n"
								+ "                <tr>\n"
								+ "                <td align=\"center\" bgcolor=\"#fbca5b\" class=\"inner-td\" style=\"border-radius:6px; font-size:16px; text-align:left; background-color:inherit;\">\n"
								+ "                  <a href="+"https://portal.talentchek.com/authentication/urlmailform/"+talentId1+" style=\"background-color:#fbca5b; border:1px solid #fbca5b; border-color:#fbca5b; border-radius:0px; border-width:1px; color:#000000; display:inline-block; font-size:14px; font-weight:normal; letter-spacing:0px; line-height:normal; padding:12px 50px 12px 50px; text-align:center; text-decoration:none; border-style:solid; font-family:inherit;\" target=\"_blank\">Reset Password</a>\n"
								+ "                </td>\n"
								+ "                </tr>\n"
								+ "              </tbody>\n"
								+ "            </table>\n"
								+ "          </td>\n"
								+ "        </tr>\n"
								+ "      </tbody>\n"
								+ "    </table><table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"b16a4afb-f245-4156-968e-8080176990ea.1.1\" data-mc-module-version=\"2019-10-22\">\n"
								+ "    <tbody>\n"
								+ "      <tr>\n"
								+ "        <td style=\"padding:18px 40px 10px 0px; line-height:18px; text-align:inherit;\" height=\"100%\" valign=\"top\" bgcolor=\"\" role=\"module-content\"><div><div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #00634a\">If you did not request a password change, please contact us immediately so we can keep your account secure.</span></div>\n"
								+ "<div style=\"font-family: inherit; text-align: inherit\"><br></div>\n"
								+ "<div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #00634a\">Call Us at +044 42122110 or Email at support@talentchek.com</span></div><div></div></div></td>\n"
								+ "      </tr>\n"
								+ "    </tbody>\n"
								+ "  </table><table class=\"module\" role=\"module\" data-type=\"spacer\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"c97177b8-c172-4c4b-b5bd-7604cde23e3f.1.1\">\n"
								+ "    <tbody>\n"
								+ "      <tr>\n"
								+ "        <td style=\"padding:0px 0px 80px 0px;\" role=\"module-content\" bgcolor=\"\">\n"
								+ "        </td>\n"
								+ "      </tr>\n"
								+ "    </tbody>\n"
								+ "  </table></td>\n"
								+ "        </tr>\n"
								+ "      </tbody>\n"
								+ "    </table></td>\n"
								+ "      </tr>\n"
								+ "    </tbody>\n"
								+ "  </table><table class=\"module\" role=\"module\" data-type=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"38ec2680-c847-4765-8c5f-aa2aba19a2b3\">\n"
								+ "    <tbody>\n"
								+ "      <tr>\n"
								+ "        <td style=\"padding:0px 0px 0px 0px;\" role=\"module-content\" height=\"100%\" valign=\"top\" bgcolor=\"\">\n"
								+ "          <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" height=\"7px\" style=\"line-height:7px; font-size:7px;\">\n"
								+ "            <tbody>\n"
								+ "              <tr>\n"
								+ "                <td style=\"padding:0px 0px 7px 0px;\" bgcolor=\"#ffffff\"></td>\n"
								+ "              </tr>\n"
								+ "            </tbody>\n"
								+ "          </table>\n"
								+ "        </td>\n"
								+ "      </tr>\n"
								+ "    </tbody>\n"
								+ "  </table><div data-role=\"module-unsubscribe\" class=\"module\" role=\"module\" data-type=\"unsubscribe\" style=\"color:#444444; font-size:12px; line-height:20px; padding:16px 16px 16px 16px; text-align:Center;\" data-muid=\"4e838cf3-9892-4a6d-94d6-170e474d21e5\"><div class=\"Unsubscribe--addressLine\"></div><p style=\"font-size:12px; line-height:20px;\"><a class=\"Unsubscribe--unsubscribeLink\" href=\"{{{unsubscribe}}}\" target=\"_blank\" style=\"\">Unsubscribe</a></p></div></td>\n"
								+ "                                      </tr>\n"
								+ "                                    </table>\n"
								+ "                                    <!--[if mso]>\n"
								+ "                                  </td>\n"
								+ "                                </tr>\n"
								+ "                              </table>\n"
								+ "                            </center>\n"
								+ "                            <![endif]-->\n"
								+ "                          </td>\n"
								+ "                        </tr>\n"
								+ "                      </table>\n"
								+ "                    </td>\n"
								+ "                  </tr>\n"
								+ "                </table>\n"
								+ "              </td>\n"
								+ "            </tr>\n"
								+ "          </table>\n"
								+ "        </div>\n"
								+ "      </center>\n"
								+ "    </body>\n"
								+ "  </html>");
						emailIds = toMailIds.split(",");
						email1 = new Email();
						email1.setFromEmailAddress(userMailId);
						email1.setToEmailAddress(emailIds);
						
						String[] ccEmailAddress = toCCMailIds.split(",");
						email1.setBccEmailAddress(ccEmailAddress);
						email1.setSubject("TALENT CHEK-Password Reset");
						
						
						email1.setBodyHtml(sb.toString());
						 
						MailUtility.sendMail(email1, "");
						
					
						ForgotPasswordResultBean.setSuccess(true);
					
					
					}catch (Exception e) {
						e.printStackTrace();
					}
					return ForgotPasswordResultBean ;
			}

	@Override
	public ForgotPasswordResultBean getdetails(String urllID) {
		ForgotPasswordResultBean objEmployeeAdminMasterResultBean = new ForgotPasswordResultBean();
		ForgotPasswordBean mybean = new ForgotPasswordBean();
		try{
				String talentId1=urllID.replace("tc", "/").replace("tl", "+");
				String talentId=CipherCrypto.Decrypt(talentId1); 
			 
			mybean = jdbcTemplate.queryForObject(ForgotPasswordQueryUtil.GET_DETAILS(talentId),new BeanPropertyRowMapper<ForgotPasswordBean>(ForgotPasswordBean.class));
			 
			objEmployeeAdminMasterResultBean.setForgotPasswordBean(mybean);
			objEmployeeAdminMasterResultBean.setSuccess(true);
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return objEmployeeAdminMasterResultBean;
	}

	@Override
	public ForgotPasswordResultBean mailafteractivateuser(ForgotPasswordBean objEmployeeAdminMasterBean) {
		// TODO Auto-generated method stub
		ForgotPasswordResultBean objEmployeeAdminMasterResultBean = new ForgotPasswordResultBean();
				
				try{
					String userId=null;
					int usercount = jdbcTemplate.queryForObject(ForgotPasswordQueryUtil.FIND_EMP_ID_COUNT, Integer.class, objEmployeeAdminMasterBean.getTalentId());
					if(usercount == 1) {
							//jdbcTemplate.update(ForgotPasswordQueryUtil.ConfirmedPwd,new Object[]{objEmployeeAdminMasterBean.getTalentId(),objEmployeeAdminMasterBean.getConfirmPassword()}); 
						 String Encryptedpassword = encoder.encode(objEmployeeAdminMasterBean.getConfirmPassword());
			 
						 jdbcTemplate.update(ForgotPasswordQueryUtil.ConfirmedPwd(objEmployeeAdminMasterBean.getTalentId(),Encryptedpassword));

					}else
						 {
							 objEmployeeAdminMasterResultBean.setSuccess(false);
						 }
						 		 
					
				}catch (Exception e) {
					// TODO: handle exception
					objEmployeeAdminMasterResultBean.setSuccess(false);
					e.printStackTrace();
				}
				
				return objEmployeeAdminMasterResultBean;
			}

	@Override
	public ForgotPasswordResultBean forgotpasswordvisitorchek(ForgotPasswordBean objtest, HttpServletRequest request) {
		// TODO Auto-generated method stub
		{
			
			 ForgotPasswordResultBean ForgotPasswordResultBean = new ForgotPasswordResultBean();  
			 ForgotPasswordBean mybean = new ForgotPasswordBean();
			
				try {
					String userId = null; 
					String encryptEmail =CipherCrypto.Encrypt(objtest.getEmail());
					mybean = jdbcTemplate.queryForObject(ForgotPasswordQueryUtil.forgot_email(encryptEmail),new BeanPropertyRowMapper<ForgotPasswordBean>(ForgotPasswordBean.class));
					
					userId=mybean.getTalentId();

					mybean = jdbcTemplate.queryForObject(ForgotPasswordQueryUtil.DETAILSFORMAIL_EMAIL,new Object[]{userId},new BeanPropertyRowMapper<ForgotPasswordBean>(ForgotPasswordBean.class));
					String toemail=CipherCrypto.Decrypt(mybean.getEmail()).toLowerCase();
					String talentId=CipherCrypto.Encrypt(userId);

					String talentId1=talentId.replace("/", "tc").replace("+", "tl");
					
					//String talentId2=CipherCrypto.Decrypt(talentId1);


					//String UUID= jdbcTemplate.queryForObject(ForgotPasswordQueryUtil.GETEMAILURLID,new Object[]{userId},String.class);
					
			
					Email email1 = null;
					String[] emailIds = null;
					String userMailId = "support@talentchek.com";
					String toMailIds = toemail;
					String toCCMailIds = "harini@paragondynamics.in";
					//String toCCMailIds = "babulavanya4594@gmail.com";
					
					String scheme = request.getScheme();
					String tenant = "tc";
					String host = request.getHeader("Host"); // includes server
																// name and
																// server port
					String contextPath = request.getContextPath(); // includes
																	// leading
																	// forward
																	// slash
					String resultPath = scheme + "://" + host + contextPath+"/"+tenant; /*"+mybean.getUserName()+"*/
					//System.out.println("Result path: " + resultPath);
					String imgPath ="http://talentchek.com/wp-content/uploads/2021/02/TalentChekLogo_v1.png";
					
					if (!toMailIds.isEmpty()) {
						toMailIds = toMailIds;
								//+ "," + userMailId;
					}
					
					StringBuffer sb = new StringBuffer();
					
					
					sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
							+ "<html data-editor-version=\"2\" class=\"sg-campaigns\" xmlns=\"http://www.w3.org/1999/xhtml\">\n"
							+ "    <head>\n"
							+ "      <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
							+ "      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1\">\n"
							+ "      <!--[if !mso]><!-->\n"
							+ "      <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\n"
							+ "      <!--<![endif]-->\n"
							+ "      <!--[if (gte mso 9)|(IE)]>\n"
							+ "      <xml>\n"
							+ "        <o:OfficeDocumentSettings>\n"
							+ "          <o:AllowPNG/>\n"
							+ "          <o:PixelsPerInch>96</o:PixelsPerInch>\n"
							+ "        </o:OfficeDocumentSettings>\n"
							+ "      </xml>\n"
							+ "      <![endif]-->\n"
							+ "      <!--[if (gte mso 9)|(IE)]>\n"
							+ "  <style type=\"text/css\">\n"
							+ "    body {width: 600px;margin: 0 auto;}\n"
							+ "    table {border-collapse: collapse;}\n"
							+ "    table, td {mso-table-lspace: 0pt;mso-table-rspace: 0pt;}\n"
							+ "    img {-ms-interpolation-mode: bicubic;}\n"
							+ "  </style>\n"
							+ "<![endif]-->\n"
							+ "      <style type=\"text/css\">\n"
							+ "    body, p, div {\n"
							+ "      font-family: inherit;\n"
							+ "      font-size: 14px;\n"
							+ "    }\n"
							+ "    body {\n"
							+ "      color: #000000;\n"
							+ "    }\n"
							+ "    body a {\n"
							+ "      color: #1188E6;\n"
							+ "      text-decoration: none;\n"
							+ "    }\n"
							+ "    p { margin: 0; padding: 0; }\n"
							+ "    table.wrapper {\n"
							+ "      width:100% !important;\n"
							+ "      table-layout: fixed;\n"
							+ "      -webkit-font-smoothing: antialiased;\n"
							+ "      -webkit-text-size-adjust: 100%;\n"
							+ "      -moz-text-size-adjust: 100%;\n"
							+ "      -ms-text-size-adjust: 100%;\n"
							+ "    }\n"
							+ "    img.max-width {\n"
							+ "      max-width: 100% !important;\n"
							+ "    }\n"
							+ "    .column.of-2 {\n"
							+ "      width: 50%;\n"
							+ "    }\n"
							+ "    .column.of-3 {\n"
							+ "      width: 33.333%;\n"
							+ "    }\n"
							+ "    .column.of-4 {\n"
							+ "      width: 25%;\n"
							+ "    }\n"
							+ "    ul ul ul ul  {\n"
							+ "      list-style-type: disc !important;\n"
							+ "    }\n"
							+ "    ol ol {\n"
							+ "      list-style-type: lower-roman !important;\n"
							+ "    }\n"
							+ "    ol ol ol {\n"
							+ "      list-style-type: lower-latin !important;\n"
							+ "    }\n"
							+ "    ol ol ol ol {\n"
							+ "      list-style-type: decimal !important;\n"
							+ "    }\n"
							+ "    @media screen and (max-width:480px) {\n"
							+ "      .preheader .rightColumnContent,\n"
							+ "      .footer .rightColumnContent {\n"
							+ "        text-align: left !important;\n"
							+ "      }\n"
							+ "      .preheader .rightColumnContent div,\n"
							+ "      .preheader .rightColumnContent span,\n"
							+ "      .footer .rightColumnContent div,\n"
							+ "      .footer .rightColumnContent span {\n"
							+ "        text-align: left !important;\n"
							+ "      }\n"
							+ "      .preheader .rightColumnContent,\n"
							+ "      .preheader .leftColumnContent {\n"
							+ "        font-size: 80% !important;\n"
							+ "        padding: 5px 0;\n"
							+ "      }\n"
							+ "      table.wrapper-mobile {\n"
							+ "        width: 100% !important;\n"
							+ "        table-layout: fixed;\n"
							+ "      }\n"
							+ "      img.max-width {\n"
							+ "        height: auto !important;\n"
							+ "        max-width: 100% !important;\n"
							+ "      }\n"
							+ "      a.bulletproof-button {\n"
							+ "        display: block !important;\n"
							+ "        width: auto !important;\n"
							+ "        font-size: 80%;\n"
							+ "        padding-left: 0 !important;\n"
							+ "        padding-right: 0 !important;\n"
							+ "      }\n"
							+ "      .columns {\n"
							+ "        width: 100% !important;\n"
							+ "      }\n"
							+ "      .column {\n"
							+ "        display: block !important;\n"
							+ "        width: 100% !important;\n"
							+ "        padding-left: 0 !important;\n"
							+ "        padding-right: 0 !important;\n"
							+ "        margin-left: 0 !important;\n"
							+ "        margin-right: 0 !important;\n"
							+ "      }\n"
							+ "      .social-icon-column {\n"
							+ "        display: inline-block !important;\n"
							+ "      }\n"
							+ "    }\n"
							+ "  </style>\n"
							+ "    <style>\n"
							+ "      @media screen and (max-width:480px) {\n"
							+ "        table\\0 {\n"
							+ "          width: 480px !important;\n"
							+ "          }\n"
							+ "      }\n"
							+ "    </style>\n"
							+ "      <!--user entered Head Start--><link href=\"https://fonts.googleapis.com/css?family=Chivo&display=swap\" rel=\"stylesheet\"><style>\n"
							+ "body {font-family: 'Chivo', sans-serif;}\n"
							+ "</style><!--End Head user entered-->\n"
							+ "    </head>\n"
							+ "    <body>\n"
							+ "      <center class=\"wrapper\" data-link-color=\"#1188E6\" data-body-style=\"font-size:14px; font-family:inherit; color:#000000; background-color:#FFFFFF;\">\n"
							+ "        <div class=\"webkit\">\n"
							+ "          <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"wrapper\" bgcolor=\"#FFFFFF\">\n"
							+ "            <tr>\n"
							+ "              <td valign=\"top\" bgcolor=\"#FFFFFF\" width=\"100%\">\n"
							+ "                <table width=\"100%\" role=\"content-container\" class=\"outer\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
							+ "                  <tr>\n"
							+ "                    <td width=\"100%\">\n"
							+ "                      <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
							+ "                        <tr>\n"
							+ "                          <td>\n"
							+ "                            <!--[if mso]>\n"
							+ "    <center>\n"
							+ "    <table><tr><td width=\"600\">\n"
							+ "  <![endif]-->\n"
							+ "                                    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:100%; max-width:600px;\" align=\"center\">\n"
							+ "                                      <tr>\n"
							+ "                                        <td role=\"modules-container\" style=\"padding:0px 0px 0px 0px; color:#000000; text-align:left;\" bgcolor=\"#FFFFFF\" width=\"100%\" align=\"left\"><table class=\"module preheader preheader-hide\" role=\"module\" data-type=\"preheader\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"display: none !important; mso-hide: all; visibility: hidden; opacity: 0; color: transparent; height: 0; width: 0;\">\n"
							+ "    <tr>\n"
							+ "      <td role=\"module-content\">\n"
							+ "        <p></p>\n"
							+ "      </td>\n"
							+ "    </tr>\n"
							+ "  </table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" role=\"module\" data-type=\"columns\" style=\"padding:30px 0px 30px 30px;\" bgcolor=\"#f75878\" data-distribution=\"1\">\n"
							+ "    <tbody>\n"
							+ "      <tr role=\"module-content\">\n"
							+ "        <td height=\"100%\" valign=\"top\"><table width=\"570\" style=\"width:570px; border-spacing:0; border-collapse:collapse; margin:0px 0px 0px 0px;\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" border=\"0\" bgcolor=\"\" class=\"column column-0\">\n"
							+ "      <tbody>\n"
							+ "        <tr>\n"
							+ "          <td style=\"padding:0px;margin:0px;border-spacing:0;\"><table class=\"wrapper\" role=\"module\" data-type=\"image\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"e7a863cb-901d-4c17-83f3-8e9dc3e0df35\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"font-size:6px; line-height:10px; padding:0px 0px 0px 0px;\" valign=\"top\" align=\"center\">\n"
							+ "          \n"
							+ "        <a href=\"https://www.visitorchek.com/\"><img class=\"max-width\" border=\"0\" style=\"display:block; color:#000000; text-decoration:none; font-family:Helvetica, arial, sans-serif; font-size:16px; max-width:30% !important; width:30%; height:auto !important;\" width=\"171\" alt=\"Talent Verification and Hiring\" data-proportionally-constrained=\"true\" data-responsive=\"true\" src=\"https://visitorchek.com/assets/images/logo%20without%20text%20white.png\"></a></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table></td>\n"
							+ "        </tr>\n"
							+ "      </tbody>\n"
							+ "    </table></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" role=\"module\" data-type=\"columns\" style=\"padding:50px 0px 0px 30px;\" bgcolor=\"#fff7ea\" data-distribution=\"1\">\n"
							+ "    <tbody>\n"
							+ "      <tr role=\"module-content\">\n"
							+ "        <td height=\"100%\" valign=\"top\"><table width=\"550\" style=\"width:550px; border-spacing:0; border-collapse:collapse; margin:0px 10px 0px 10px;\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" border=\"0\" bgcolor=\"\" class=\"column column-0\">\n"
							+ "      <tbody>\n"
							+ "        <tr>\n"
							+ "          <td style=\"padding:0px;margin:0px;border-spacing:0;\"><table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"b16a4afb-f245-4156-968e-8080176990ea\" data-mc-module-version=\"2019-10-22\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:18px 40px 0px 0px; line-height:22px; text-align:inherit;\" height=\"100%\" valign=\"top\" bgcolor=\"\" role=\"module-content\"><div><div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #f75878; font-size: 24px\">We received a request to reset your visitor chek account password.</span></div><div></div></div></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table class=\"wrapper\" role=\"module\" data-type=\"image\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"550f2fb7-70c1-463b-9758-84b6d731ca56\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"font-size:6px; line-height:10px; padding:0px 0px 0px 0px;\" valign=\"top\" align=\"left\">\n"
							+ "          <img class=\"max-width\" border=\"0\" style=\"display:block; color:#000000; text-decoration:none; font-family:Helvetica, arial, sans-serif; font-size:16px;\" width=\"162\" alt=\"\" data-proportionally-constrained=\"true\" data-responsive=\"false\" src=\"http://cdn.mcauto-images-production.sendgrid.net/954c252fedab403f/27050768-0978-4ce8-8ad0-fa01a1949374/162x34.png\" height=\"34\">\n"
							+ "        </td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"b16a4afb-f245-4156-968e-8080176990ea.1\" data-mc-module-version=\"2019-10-22\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:18px 40px 10px 0px; line-height:18px; text-align:inherit;\" height=\"100%\" valign=\"top\" bgcolor=\"\" role=\"module-content\"><div><div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #f75878\"><strong>Protecting your data is important to us.</strong></span></div>\n"
							+ "<div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #f75878\"><strong>Please click on the button below to begin.</strong></span></div><div></div></div></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table class=\"module\" role=\"module\" data-type=\"spacer\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"c97177b8-c172-4c4b-b5bd-7604cde23e3f\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:0px 0px 10px 0px;\" role=\"module-content\" bgcolor=\"\">\n"
							+ "        </td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"module\" data-role=\"module-button\" data-type=\"button\" role=\"module\" style=\"table-layout:fixed;\" width=\"100%\" data-muid=\"9c7ac938-a540-4353-9fec-543b193bf7da\">\n"
							+ "      <tbody>\n"
							+ "        <tr>\n"
							+ "          <td align=\"left\" bgcolor=\"\" class=\"outer-td\" style=\"padding:0px 0px 0px 0px;\">\n"
							+ "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"wrapper-mobile\" style=\"text-align:center;\">\n"
							+ "              <tbody>\n"
							+ "                <tr>\n"
							+ "                <td align=\"center\" bgcolor=\"#fbca5b\" class=\"inner-td\" style=\"border-radius:6px; font-size:16px; text-align:left; background-color:inherit;\">\n"
//							+ "                  <a  href="+"https://cip.talentchek.com/authentication/urlmailform/"+talentId+" style=\"background-color:#fbca5b; border:1px solid #fbca5b; border-color:#fbca5b; border-radius:0px; border-width:1px; color:#000000; display:inline-block; font-size:14px; font-weight:normal; letter-spacing:0px; line-height:normal; padding:12px 50px 12px 50px; text-align:center; text-decoration:none; border-style:solid; font-family:inherit;\" target=\"_blank\">Reset Password</a>\n"
							+ "                  <a style=\"background-color:#fbca5b; border:1px solid #fbca5b; border-color:#fbca5b; border-radius:0px; border-width:1px; color:#000000; display:inline-block; font-size:14px; font-weight:normal; letter-spacing:0px; line-height:normal; padding:12px 50px 12px 50px; text-align:center; text-decoration:none; border-style:solid; font-family:inherit;\" target=\"_blank\">Reset Password</a>\n"
//							+ "                  <a  href="+"https://portal.talentchek.com/authentication/urlmailform/"+talentId1+" style=\"background-color:#fbca5b; border:1px solid #fbca5b; border-color:#fbca5b; border-radius:0px; border-width:1px; color:#000000; display:inline-block; font-size:14px; font-weight:normal; letter-spacing:0px; line-height:normal; padding:12px 50px 12px 50px; text-align:center; text-decoration:none; border-style:solid; font-family:inherit;\" target=\"_blank\">Reset Password</a>\n"
							
							

							+ "                </td>\n"
							+ "                </tr>\n"
							+ "              </tbody>\n"
							+ "            </table>\n"
							+ "          </td>\n"
							+ "        </tr>\n"
							+ "      </tbody>\n"
							+ "    </table><table class=\"module\" role=\"module\" data-type=\"text\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"b16a4afb-f245-4156-968e-8080176990ea.1.1\" data-mc-module-version=\"2019-10-22\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:18px 40px 10px 0px; line-height:18px; text-align:inherit;\" height=\"100%\" valign=\"top\" bgcolor=\"\" role=\"module-content\"><div><div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #f75878\">If you did not request a password change, please contact us immediately so we can keep your account secure.</span></div>\n"
							+ "<div style=\"font-family: inherit; text-align: inherit\"><br></div>\n"
							+ "<div style=\"font-family: inherit; text-align: inherit\"><span style=\"color: #f75878\">Call Us at +044 42122110 or Email at support@talentchek.com</span></div><div></div></div></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table class=\"module\" role=\"module\" data-type=\"spacer\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"c97177b8-c172-4c4b-b5bd-7604cde23e3f.1.1\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:0px 0px 80px 0px;\" role=\"module-content\" bgcolor=\"\">\n"
							+ "        </td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table></td>\n"
							+ "        </tr>\n"
							+ "      </tbody>\n"
							+ "    </table></td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><table class=\"module\" role=\"module\" data-type=\"divider\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"table-layout: fixed;\" data-muid=\"38ec2680-c847-4765-8c5f-aa2aba19a2b3\">\n"
							+ "    <tbody>\n"
							+ "      <tr>\n"
							+ "        <td style=\"padding:0px 0px 0px 0px;\" role=\"module-content\" height=\"100%\" valign=\"top\" bgcolor=\"\">\n"
							+ "          <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" height=\"7px\" style=\"line-height:7px; font-size:7px;\">\n"
							+ "            <tbody>\n"
							+ "              <tr>\n"
							+ "                <td style=\"padding:0px 0px 7px 0px;\" bgcolor=\"#ffffff\"></td>\n"
							+ "              </tr>\n"
							+ "            </tbody>\n"
							+ "          </table>\n"
							+ "        </td>\n"
							+ "      </tr>\n"
							+ "    </tbody>\n"
							+ "  </table><div data-role=\"module-unsubscribe\" class=\"module\" role=\"module\" data-type=\"unsubscribe\" style=\"color:#444444; font-size:12px; line-height:20px; padding:16px 16px 16px 16px; text-align:Center;\" data-muid=\"4e838cf3-9892-4a6d-94d6-170e474d21e5\"><div class=\"Unsubscribe--addressLine\"></div><p style=\"font-size:12px; line-height:20px;\"><a class=\"Unsubscribe--unsubscribeLink\" href=\"{{{unsubscribe}}}\" target=\"_blank\" style=\"\">Unsubscribe</a></p></div></td>\n"
							+ "                                      </tr>\n"
							+ "                                    </table>\n"
							+ "                                    <!--[if mso]>\n"
							+ "                                  </td>\n"
							+ "                                </tr>\n"
							+ "                              </table>\n"
							+ "                            </center>\n"
							+ "                            <![endif]-->\n"
							+ "                          </td>\n"
							+ "                        </tr>\n"
							+ "                      </table>\n"
							+ "                    </td>\n"
							+ "                  </tr>\n"
							+ "                </table>\n"
							+ "              </td>\n"
							+ "            </tr>\n"
							+ "          </table>\n"
							+ "        </div>\n"
							+ "      </center>\n"
							+ "    </body>\n"
							+ "  </html>"); 
					emailIds = toMailIds.split(",");
					email1 = new Email();
					email1.setFromEmailAddress(userMailId);
					email1.setToEmailAddress(emailIds);
					
					String[] ccEmailAddress = toCCMailIds.split(",");
					email1.setBccEmailAddress(ccEmailAddress);
					email1.setSubject("TALENT CHEK-Password Reset");
					
					
					email1.setBodyHtml(sb.toString());
					 
					MailUtility.sendMail(email1, "");
					
			
					ForgotPasswordResultBean.setSuccess(true);
			
			
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				return ForgotPasswordResultBean ;
		}
	}
			

	
	
}
