package com.sitespace.fileupload.userMaster;

public class userMasterQueryUtil {
	
	public static final String INSERT_Employee = " INSERT INTO employee (emp_id, email_id, emp_user_id,emp_name,created_by,created_date) VALUES (:empId, :emailId, :empUserId, '',now())";
	
	public static final String INSERT_AppUser = "INSERT INTO auth.app_user(user_id,password,reference_id)values(:empUserId,:password,:empId)";
	

	public static String GETUSERDETAILS = " SELECT \r\n"
			+ "    au.user_name AS username,\r\n"
			+ "    COALESCE(au.user_mail, '') AS email,\r\n"
			+ "    au.user_pass AS password,user_role as role\r\n"
			+ "FROM \r\n"
			+ "    auth.app_user au\r\n"
			+ "WHERE \r\n"
			+ "    (au.space_id = ? OR LOWER(au.space_id) = ? OR au.user_mail = ? OR au.user_name = ?) \r\n"
			+ "    AND au.is_active = true\r\n"
			+ "LIMIT 1";

//	public static String GETUSERDETAILS = "select au.user_name as username,au.user_mail as email,au.user_pass as password,au.talent_id as userId ,user_phone as userPhone ,au.profile_img as profilePic from auth.app_user au where (talent_id= ? or user_mail=? or user_phone=?)";

	
	public static String GETEMPID = "SELECT CASE WHEN MAX(emp_id) IS NULL  THEN 'E0001' ELSE rpad(MAX(emp_id),1,'E')|| lpad(cast(cast((SUBSTRING(MAX(emp_id),2)) as int)+1  as text),4,'0') END FROM employee";
}
