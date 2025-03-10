package com.sitespace.common.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;



@Service
public class CommonServicesServiceImpl implements CommonServicesService {
	
	public static final String url = "https://www.google.com/recaptcha/api/siteverify";
	public static final String secret = "6LeiApIfAAAAAFIrMh9iBzdm-5BBoZEB5hh-XfkW";
	private final static String USER_AGENT = "Mozilla/5.0";
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	CommonServicesDao commonServicesDao;
	

//
//	@Override
//	public List<DropDownList> getManufacturerList() {
//		return commonServicesDao.getManufacturerList();
//	}
//	
//	@Override
//	public List<DropDownList> getStateDropdownList() {
//		return commonServicesDao.getStateDropdownList();
//	}
//

	
}
