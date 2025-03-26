package com.siteespace.fileupload.ForgotPassword;

public class ForgotPasswordResultBean {

	private boolean success;
	private String message;
	private ForgotPasswordBean ForgotPasswordBean;


	public ForgotPasswordBean getForgotPasswordBean() {
		return ForgotPasswordBean;
	}

	public void setForgotPasswordBean(ForgotPasswordBean forgotPasswordBean) {
		ForgotPasswordBean = forgotPasswordBean;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
