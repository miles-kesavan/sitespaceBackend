package com.sitespace.fileupload.assetmaster;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//import sun.misc.BASE64Decoder;
@Api(tags="Asset Operation", description="Manages Asset Operation")
@RestController
@RequestMapping("/api/auth/Asset")
public class assetController {
	
	@Autowired
	assetService assetService;
		
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@ApiOperation(value = "File Upload Controller")

	
	@PostMapping(value = "/saveAsset")
	public @ResponseBody  assetResultBean saveAsset(@RequestBody assetBean obj) throws Exception{
		assetResultBean assetResultBean = new assetResultBean();
		try {

			assetResultBean = assetService.saveAsset(obj);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return assetResultBean;

	}
	
	
	
	
	//connection List
	
	@GetMapping("/getAssetList")
	public @ResponseBody assetResultBean assetList(@RequestParam("currentUserId")String currentUserId) {
		assetResultBean assetResultBean = new assetResultBean();

		try {
			assetResultBean = assetService.assetList(currentUserId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assetResultBean;
	}
	

	
	//UpdateSkill
	
	@PostMapping(value = "/updateAsset")
	public @ResponseBody  assetResultBean updateAsset(@RequestBody assetBean objAsset) throws Exception{
		assetResultBean assetresultBean = new assetResultBean();
		try {

			assetresultBean = assetService.updateAsset(objAsset);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return assetresultBean;

	}
		//editprofiledetails individual
		
	@PostMapping(value = "/editAssetdetails")
		public @ResponseBody assetResultBean editAssetdetails(@RequestParam ("currentUserId") String currentUserId) {
			assetResultBean assetResultBean = new assetResultBean();
			try {

				assetResultBean = assetService.editAssetdetails(currentUserId);
	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		return assetResultBean;

	}



	
	//delete my account for Ios
	
	@PostMapping(value = "/deleteAsset")
	public @ResponseBody assetResultBean deleteAseet(@RequestBody assetBean delete) {
		assetResultBean assetResultBean = new assetResultBean();
		boolean isSuccess = false;
		try {
			assetResultBean = assetService.deleteAseet(delete);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assetResultBean;
	}

	
	
	
	
	
}
