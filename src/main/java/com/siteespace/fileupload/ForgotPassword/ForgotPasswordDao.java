package com.siteespace.fileupload.ForgotPassword;

import javax.servlet.http.HttpServletRequest;

public interface ForgotPasswordDao {

	ForgotPasswordResultBean forgotpasswordemail(ForgotPasswordBean objtest, HttpServletRequest request);

	ForgotPasswordResultBean forgotpasswordphone(ForgotPasswordBean objtest, HttpServletRequest request);

	ForgotPasswordResultBean getdetails(String urllID);

	ForgotPasswordResultBean mailafteractivateuser(ForgotPasswordBean objEmployeeAdminMasterBean);

	ForgotPasswordResultBean forgotpasswordvisitorchek(ForgotPasswordBean objtest, HttpServletRequest request);

	
}
