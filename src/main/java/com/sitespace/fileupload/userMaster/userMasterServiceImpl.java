package com.sitespace.fileupload.userMaster;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitespace.fileupload.usermanagement.User;



@Service
public class userMasterServiceImpl implements userMasterService{
	@Autowired
	userMasterDao employeeMasterDao;
	
	@Override
	public userMasterResultBean addEmployeeMaster(userMasterBean employeeMasterBean) throws CustomException {
		// TODO Auto-generated method stub
		return employeeMasterDao.addEmployeeMaster(employeeMasterBean);
	}

	@Override
	public Optional<User> getEmployeeUserName(String userId) throws Exception {
		// TODO Auto-generated method stub
		return employeeMasterDao.getEmployeeUserName(userId);
	}
	
}
