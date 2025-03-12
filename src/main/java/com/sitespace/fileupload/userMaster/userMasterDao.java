package com.sitespace.fileupload.userMaster;

import java.util.Optional;

import com.sitespace.fileupload.usermanagement.User;



public interface userMasterDao {
	public userMasterResultBean addEmployeeMaster(userMasterBean objEmployee) throws CustomException;
	
	public Optional<User> getEmployeeUserName(String userId) throws CustomException;
}
