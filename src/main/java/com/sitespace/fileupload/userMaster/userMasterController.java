package com.sitespace.fileupload.userMaster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class userMasterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(userMasterController.class);
	
	@Autowired
	private userMasterService employeeMasterService;
	
	
	@ApiOperation(value = "Employee Master Controller")
	@PostMapping("/addEmployeeMaster")
	private userMasterResultBean addEmployeeMaster(@RequestBody userMasterBean employeeMasterBean) {
		userMasterResultBean employeeMasterResultBean = new userMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.addEmployeeMaster(employeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}
	
	private userMasterResultBean insertAppUserMaster(userMasterBean employeeMasterBean) {
		userMasterResultBean employeeMasterResultBean = new userMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.addEmployeeMaster(employeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;

	}
}
