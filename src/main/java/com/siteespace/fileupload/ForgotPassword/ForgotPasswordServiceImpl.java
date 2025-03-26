package com.siteespace.fileupload.ForgotPassword;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService{
	@Autowired
	ForgotPasswordDao ForgotPasswordDao;

	@Override
	public ForgotPasswordResultBean forgotpasswordemail(ForgotPasswordBean objtest, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return ForgotPasswordDao.forgotpasswordemail(objtest,request);
	}

	@Override
	public ForgotPasswordResultBean forgotpasswordphone(ForgotPasswordBean objtest, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return ForgotPasswordDao.forgotpasswordphone(objtest,request);
	}

	@Override
	public ForgotPasswordResultBean getdetails(String urllID) {
		// TODO Auto-generated method stub
		return ForgotPasswordDao.getdetails(urllID);
	}

	@Override
	public ForgotPasswordResultBean mailafteractivateuser(ForgotPasswordBean objEmployeeAdminMasterBean) {
		// TODO Auto-generated method stub
		return ForgotPasswordDao.mailafteractivateuser(objEmployeeAdminMasterBean);
	}

	@Override
	public ForgotPasswordResultBean forgotpasswordvisitorchek(ForgotPasswordBean objtest, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return ForgotPasswordDao.forgotpasswordvisitorchek(objtest,request);
	}


}
