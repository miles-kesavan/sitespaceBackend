package com.sitespace.common.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class CommonServicesDaoImpl implements CommonServicesDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;



//
//	@Override
//	public List<DropDownList> getManufacturerList() {
//		List<DropDownList> dropDownList = new ArrayList<DropDownList>();
//		try {
//			dropDownList = jdbcTemplate.query(CommonServicesQueryUtil.GET_MANUFACTURER_LIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));	
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return dropDownList;
//	}
//
//	@Override
//	public List<DropDownList> getStateDropdownList() {
//		List<DropDownList> dropDownList = new ArrayList<DropDownList>();
//		try {
//			dropDownList = jdbcTemplate.query(CommonServicesQueryUtil.STATE_MASTER_DROPDOWNLIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));	
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return dropDownList;
//	}
//
//	
//



}
