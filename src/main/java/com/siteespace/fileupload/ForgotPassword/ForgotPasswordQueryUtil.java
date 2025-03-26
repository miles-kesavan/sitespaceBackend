package com.siteespace.fileupload.ForgotPassword;

public class ForgotPasswordQueryUtil {

	//public static final String FIND_EMP_ID = "Select user_ref_id_emp from user_master where user_id=?";
	public static final String EmailUrlID_update = "update employee_master set socialno= ? where emp_id=?";
	public static String DETAILSFORMAIL_EMAIL= "select user_name as userName,user_mail as email from auth.app_user where talent_id =?";
//	public static final String GETEMAILURLID =" Select talentid from auth.app_user where talentid=? ";
	//public static final String forgot_pass = "select talent_id as talentId from auth.app_user where user_mail = ? ";
	public static final String GET_EMAIL = "select count(*) from auth.app_user where user_mail = ? ";
	public static final String FIND_EMP_ID_COUNT = "select count(talent_id) from auth.app_user where talent_id=?";
		
	

public static String forgot_email(String email) {
		String query = "select au.talent_id as talentId,au.user_mail as email from auth.app_user au where au.user_mail ='"+email+"'";
			
		return query;
	}

	public static String forgot_phone(String phone) {
	   String query = "select au.talent_id as talentId,au.user_phone as phoneNo from auth.app_user au where au.user_phone ='"+phone+"'";
		
		return query;
	}

	public static String GET_DETAILS(String urllID) {
		 String query = "SELECT user_name as userName,user_mail as email,talent_id as talentid from auth.app_user where talent_id=('"+urllID+"')";
				
				return query;
	}

	public static String ConfirmedPwd(String talentId, String confirmPassword) {
		String query = "update auth.app_user set user_pass='" +confirmPassword+"' where talent_id=('" + talentId +"')";
		
		return query;
	}

	


}
