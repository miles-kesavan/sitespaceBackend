package com.sitespace.common.services;

public class CommonServicesQueryUtil {

	public static final String GETUSERNAME = "select case when (count(*)) >0 then true else false end as result from auth.app_user where user_id = ?;";
	public static final String INSERT_OTP = "INSERT INTO login_otp (user_id,email_id,otp_value,created_on,isactive) VALUES (:userId,:emailId,:otp,now(),'Y')";
	public static final String INSERT_OTP_HISTORY = "INSERT INTO login_otp_history (user_id,email_id,otp_value,created_on,isactive) VALUES (:userId,:emailId,:otp,now(),'Y')";
	public static final String VALIDATE_OTP = "SELECT case when (count(*)) >0 then true else false end as result from login_otp where user_id =? and otp_value =? and created_on between now()- interval '5 mins' and now() ";
	
	////get tokenstorage values
	public static final String GETUSERDETAILS = "SELECT user_mail as emailId,user_name as firstNameLastName,"
			+ "coalesce(sum(credit-debit)::int,0) as creditPoint,ai.perm_country as countryCode,"
			+ "case when 1 in (select regexp_split_to_table(user_role,',')::int) then coalesce(inpo.category,'') "
			+ "when 2 in (select regexp_split_to_table(user_role,',')::int) then coalesce(opo.org_type,'') "
			+ "when 3 in (select regexp_split_to_table(user_role,',')::int) then coalesce(ipo.inst_type,'') end as categoryType,"
			+ "coalesce(ud.profile_img,'https://ionicframework.com/docs/img/demos/avatar.svg') as imgUrl from auth.app_user au "
			+ "left join new.user_credit_points cp on au.talent_id = cp.user_id "
			+ "left join new.user_details ud on au.talent_id = ud.talent_id "
			+ "left join new.address_info ai on au.talent_id = ai.talent_id "
			+ "left join new.org_profile_info opo on au.talent_id = opo.talent_id "
			+ "left join new.inst_profile_info ipo on au.talent_id = ipo.talent_id "
			+ "left join new.ind_profile_info inpo on au.talent_id = inpo.talent_id "
			+ "where au.talent_id =? and au.is_active = 'Y' "
			+ "group by user_mail,ud.profile_img,user_name,ai.perm_country,user_role,"
			+ "inpo.category,opo.org_type,ipo.inst_type limit 1";
	
	public static final String GETCOUNTVALUE = "SELECT COUNT(*) FROM login_otp_history AS \"Login_otp_history\" WHERE \"Login_otp_history\".\"created_on\" BETWEEN NOW() - INTERVAL '1 HOURS' AND NOW() AND \"Login_otp_history\".\"user_id\"= ? ";
	public static final String DELETE_OTP = "DELETE from login_otp where user_id=? returning user_id as userId";
	public static final String GETOTPVALUE = "select count(*) from login_otp where user_id= ? ";
	public static final String COMPANY_MASTER_DROPDOWNLIST = "select company_code as id, company_name as text from company order by company_name asc";
	public static final String DEBIT_MEMO_DROPDOWNLIST = "select return_memo_no as id, return_memo_name as text from return_memo where company=? order by return_memo_name asc";
	public static final String GET_MANUFACTURER_LIST = "select manufacturer_code as id, manufacturer_name as text from manufacturer";

	public static final String GETOLDPASSWORD = "select password  from auth.app_user where user_id = ?";
	public static final String UPDATE_PASSWORD_WITH_EMAIL = "UPDATE auth.app_user set password=:otpForForgotPassword,pwd_changed='false' where user_id=:userNameEmailId";
	public static final String UPDATE_PASSWORD_WITHOUT_EMAIL = "UPDATE auth.app_user set password=:otpForForgotPassword,pwd_changed='false' where user_id=:userNameEmailId";
	public static final String GET_EMAIL_ID = "select email_id as emailId from user_details where emp_user_id=?";
	public static final String VALIDATE_UNIQUE = "SELECT * FROM fn_unique_validation(?,?,?)";
	public static final String STATE_MASTER_DROPDOWNLIST = "select state_id as id, state_name as text from state";

	public static final String UPDATE_FCMTOKEN ="UPDATE user_details SET fcm_token=? WHERE emp_id=?";
	
}
