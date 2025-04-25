package com.siteespace.fileupload.ForgotPassword;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/ForgotPassword")

public class ForgotPasswordController {

	@Autowired
	ForgotPasswordService ForgotPasswordService;

@RequestMapping(value = "/forgotpasswordemail")
public @ResponseBody  ForgotPasswordResultBean  forgotpasswordemail(@RequestBody ForgotPasswordBean objtest,HttpServletRequest request){
	ForgotPasswordResultBean  ForgotPasswordBean = new ForgotPasswordResultBean ();
	try {

		ForgotPasswordBean = ForgotPasswordService.forgotpasswordemail(objtest,request);

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return ForgotPasswordBean;

}

@RequestMapping(value = "/forgotpasswordphone")
public @ResponseBody  ForgotPasswordResultBean  forgotpasswordphone(@RequestBody ForgotPasswordBean objtest,HttpServletRequest request) {
	ForgotPasswordResultBean  ForgotPasswordBean = new ForgotPasswordResultBean ();
try {

	ForgotPasswordBean = ForgotPasswordService.forgotpasswordphone(objtest,request);

} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

return ForgotPasswordBean;

}

@RequestMapping(value = "/getdetails")
public @ResponseBody ForgotPasswordResultBean getdetails(@RequestParam("urllID") String urllID) {
	ForgotPasswordResultBean objEmployeeAdminMasterResultBean = new ForgotPasswordResultBean();

		try {
			
			objEmployeeAdminMasterResultBean = ForgotPasswordService.getdetails(urllID);
			//registerResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return objEmployeeAdminMasterResultBean;

	}


@RequestMapping(value = "/mailafteractivateuser")
public @ResponseBody ForgotPasswordResultBean mailafteractivateuser(@RequestBody ForgotPasswordBean objEmployeeAdminMasterBean){
	ForgotPasswordResultBean objEmployeeAdminMasterResultBean = new ForgotPasswordResultBean();

	try {
		
		objEmployeeAdminMasterResultBean = ForgotPasswordService.mailafteractivateuser(objEmployeeAdminMasterBean);
		//objEmployeeAdminMasterResultBean.setSuccess(true);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return objEmployeeAdminMasterResultBean;

}

@RequestMapping(value = "/forgotpasswordvisitorchek")
public @ResponseBody  ForgotPasswordResultBean  forgotpasswordvisitorchek(@RequestBody ForgotPasswordBean objtest,HttpServletRequest request){
	ForgotPasswordResultBean  ForgotPasswordBean = new ForgotPasswordResultBean ();
	try {

		ForgotPasswordBean = ForgotPasswordService.forgotpasswordvisitorchek(objtest,request);

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return ForgotPasswordBean;

}

}
