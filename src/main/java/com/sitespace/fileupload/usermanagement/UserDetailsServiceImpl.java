package com.sitespace.fileupload.usermanagement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitespace.fileupload.security.JwtUtils;
import com.sitespace.fileupload.userMaster.userMasterService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private userMasterService userMasterService;
	


	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = null;
		try {
			 user = userMasterService.getEmployeeUserName(userId)
					.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			
		}
		
		return UserDetailsImpl.build(user);
	}
	
	
	
	

}
