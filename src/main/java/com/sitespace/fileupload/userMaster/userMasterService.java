package com.sitespace.fileupload.userMaster;

import java.util.Optional;

import com.sitespace.fileupload.usermanagement.User;



public interface userMasterService {

	userMasterResultBean addEmployeeMaster(userMasterBean employeeMasterBean) throws Exception;
	
	Optional<User> getEmployeeUserName(String userId) throws Exception;
}
