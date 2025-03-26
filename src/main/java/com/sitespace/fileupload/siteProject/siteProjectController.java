package com.sitespace.fileupload.siteProject;


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sitespace.common.Email;
import com.sitespace.common.MailUtility;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//import sun.misc.BASE64Decoder;
@Api(tags="SiteProject Operation", description="Manages SiteProject Operation")
@RestController
@RequestMapping("/api/auth/siteProject")
public class siteProjectController {
	
	@Autowired
	siteProjectService siteProjectService;
		
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@ApiOperation(value = "siteProject Controller")

	
//	@PostMapping(value = "/subcontractorRegistration")
//	public @ResponseBody  siteProjectResultBean subcontractorRegistration(@RequestBody siteProjectBean obj) throws Exception{
//		siteProjectResultBean assetResultBean = new siteProjectResultBean();
//		try {
//
//			assetResultBean = assetService.subcontractorRegistration(obj);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return assetResultBean;
//
//	}
//	
	
	
	
	//connection List
	
	@GetMapping("/getProjectList")
	public @ResponseBody siteProjectResultBean getProjectList(@RequestParam("currentUserId")String currentUserId) {
		siteProjectResultBean siteProjectResultBean = new siteProjectResultBean();

		try {
			siteProjectResultBean = siteProjectService.getProjectList(currentUserId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return siteProjectResultBean;
	}
	
	@GetMapping("/getSubcontractorList")
	public @ResponseBody siteProjectResultBean getSubcontractorList(@RequestParam("currentUserId")String currentUserId) {
		siteProjectResultBean siteProjectResultBean = new siteProjectResultBean();

		try {
			siteProjectResultBean = siteProjectService.getSubcontractorList(currentUserId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return siteProjectResultBean;
	}
	
//
//	
//	//UpdateSkill
//	
//	@PostMapping(value = "/updateAsset")
//	public @ResponseBody  subcontractorResultBean updateAsset(@RequestBody subcontractorBean objAsset) throws Exception{
//		subcontractorResultBean assetresultBean = new subcontractorResultBean();
//		try {
//
//			assetresultBean = assetService.updateAsset(objAsset);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return assetresultBean;
//
//	}
//		//editprofiledetails individual
//		
//	@PostMapping(value = "/editAssetdetails")
//		public @ResponseBody subcontractorResultBean editAssetdetails(@RequestParam ("currentUserId") String currentUserId) {
//			subcontractorResultBean assetResultBean = new subcontractorResultBean();
//			try {
//
//				assetResultBean = assetService.editAssetdetails(currentUserId);
//	
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//
//		return assetResultBean;
//
//	}
//
//
//
//	
	//delete my account for Ios
	
//	@PostMapping(value = "/deleteAsset")
//	public @ResponseBody subcontractorResultBean deleteAseet(@RequestBody subcontractorBean delete) {
//		subcontractorResultBean assetResultBean = new subcontractorResultBean();
//		boolean isSuccess = false;
//		try {
//			assetResultBean = assetService.deleteAseet(delete);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return assetResultBean;
//	}

	
	
	
	
	
}
