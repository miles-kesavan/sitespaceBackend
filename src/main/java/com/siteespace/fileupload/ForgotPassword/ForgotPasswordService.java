package com.siteespace.fileupload.ForgotPassword;

import javax.servlet.http.HttpServletRequest;

public interface ForgotPasswordService {

	public ForgotPasswordResultBean forgotpasswordemail(ForgotPasswordBean objtest, HttpServletRequest request);

	public ForgotPasswordResultBean forgotpasswordphone(ForgotPasswordBean objtest, HttpServletRequest request);

	public ForgotPasswordResultBean getdetails(String urllID);

	public ForgotPasswordResultBean mailafteractivateuser(ForgotPasswordBean objEmployeeAdminMasterBean);

	public ForgotPasswordResultBean forgotpasswordvisitorchek(ForgotPasswordBean objtest, HttpServletRequest request);

}
