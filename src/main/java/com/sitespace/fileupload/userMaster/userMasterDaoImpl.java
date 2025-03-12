package com.sitespace.fileupload.userMaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sitespace.common.CipherCrypto;
import com.sitespace.common.ErrorMessage;
import com.sitespace.fileupload.usermanagement.User;


@Repository
public class userMasterDaoImpl implements userMasterDao{
	private final static Logger LOGGER = LoggerFactory.getLogger(userMasterDaoImpl.class);
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public userMasterResultBean addEmployeeMaster(userMasterBean objEmployee) throws CustomException {
		userMasterResultBean objEmployeeMasterResultBean = new userMasterResultBean();
		objEmployeeMasterResultBean.setSuccess(false);
		try {
			
			
			
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("userId", objEmployee.getUsername());
			empMap.put("password", objEmployee.getPassword());
			empMap.put("empUserName", objEmployee.getEmpName());
			empMap.put("emailId", objEmployee.getEmail());
			empMap.put("empUserId", objEmployee.getUsername());
			String empId =  jdbcTemplate.queryForObject(userMasterQueryUtil.GETEMPID, String.class);
			empMap.put("empId", empId);
			
			int insetEmp = namedParameterJdbcTemplate.update(userMasterQueryUtil.INSERT_Employee, empMap);
			
			int insertAppUser = namedParameterJdbcTemplate.update(userMasterQueryUtil.INSERT_AppUser, empMap);
			objEmployeeMasterResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error in addEmployeeMaster", e);
			objEmployeeMasterResultBean.setSuccess(false);
			objEmployeeMasterResultBean.setMessage(ErrorMessage.ERROR_ADD);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		
		return objEmployeeMasterResultBean;
	}

	@Override
	public Optional<User> getEmployeeUserName(String userId) throws CustomException {
		// TODO Auto-generated method stub
		Optional<User> userDetails = Optional.empty();
		//List<User> user = new ArrayList<User>();
		
		
		String talentId = userId ;
		String mobileNo = CipherCrypto.Encrypt(userId);
		String emailId = CipherCrypto.Encrypt(userId);
				
		
	//	System.out.println("Inside getEmployeeUserName method");

		try {
			User user= jdbcTemplate.queryForObject(userMasterQueryUtil.GETUSERDETAILS, new Object[] { talentId,talentId,emailId,mobileNo },
					new BeanPropertyRowMapper<User>(User.class)); 
			//userDetails = 
			userDetails = Optional.of(user);
			user.setEmail(user.getEmail());
			user.setRole(user.getRole());
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeUserName", e);
		    e.printStackTrace();
		}
		return userDetails;
	}

}
