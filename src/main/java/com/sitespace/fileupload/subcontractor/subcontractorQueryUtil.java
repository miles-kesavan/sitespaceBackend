package com.sitespace.fileupload.subcontractor;

import java.util.ArrayList;

public class subcontractorQueryUtil {

	public static final String insert_subContractorsReg = "INSERT INTO sub_contractors (contractor_name, contractor_company,\r\n"
			+ "contractor_trade, contractor_email, contractor_phone, created_by,space_id_ref, created_dt)\r\n"
			+ "VALUES ( ?, ?, ?, ?, ?, ?, NOW())RETURNING contractor_key";
	
	
	public static final String insert_project = "INSERT INTO user_project_mapping (user_id, project_id) \" +\r\n"
			+ "             \"VALUES (?, ?)";
	
	
	public static final String insert_AuthForsubContReg = "INSERT INTO auth.app_user (user_name, user_pass, user_email, user_role, is_active) \" +\r\n"
			+ "             \"VALUES (?, ?, ?, 'contractor', true) RETURNING space_id";
	
	public static final String Get_emp_id = "SELECT COALESCE(exp_id) AS expId FROM new.experience_info WHERE talent_id = ?";
	
	
	public  static final String updateAsset = "UPDATE sub_contractors SET contractor_project = ? WHERE contractor_email = ? OR contractor_phone = ?";



	public static String getAssetDetails(String assetkey) {
		String query = "SELECT asset_project, asset_title, asset_location, asset_status,\r\n"
				+ "asset_poc, maintanence_startdt, maintanence_enddt, usage_instructions \r\n"
				+ "FROM asset_master WHERE asset_key = '"+assetkey+"'";
		
		System.out.println(query);
		return query ;
	}

	

	public static String Asset_list(String currentUserId) {
		String query="SELECT \r\n"
				+ "    asset_project AS assetProject,asset_key as assetKey, \r\n"
				+ "    asset_title AS assetTitle, \r\n"
				+ "    asset_location AS assetLocation, \r\n"
				+ "    asset_status AS assetStatus, \r\n"
				+ "    asset_poc AS assetPoc, \r\n"
				+ "    maintanence_startdt AS maintanenceStartdt, \r\n"
				+ "    maintanence_enddt AS maintanenceEnddt, \r\n"
				+ "    usage_instructions AS usageInstructions\r\n"
				+ "FROM asset_master;\r\n"
				+ "";
			
		return query;
	}
		
	
	public static String Delete_User_Account ="delete from asset_master where asset_key = ? ";
	
	public static String checkUserExist = "select count(*) from sub_contractors where contractor_email =?";
	
	public static String getContractorID = "select contractor_key from sub_contractors where contractor_email =?";
	
	public static String getProjectName = "SELECT project_title FROM project_master WHERE project_key = ? LIMIT 1";
	
	public static final String get_profile_images = "Select nu.profile_img as uploadImg,prev_prof_img1 as uploadImg1,prev_prof_img2 as uploadImg2 from new.user_details nu  \r\n"
			+ "inner join new.ind_profile_info ip on ip.talent_id = nu.talent_id\r\n"
			+ "where nu.talent_id=? ";

}
