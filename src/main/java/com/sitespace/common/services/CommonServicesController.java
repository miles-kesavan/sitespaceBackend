package com.sitespace.common.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/api/auth/app/commonServices")
public class CommonServicesController {
	@Autowired
	CommonServicesService commonServicesService;
	

//	
//	@RequestMapping(value= "/getCompanyMasterDropdownList")
//	public List<DropDownList> getCompanyMasterList(){
//			return commonServicesService.getCompanyMasterList();	
//	}
//	
//	
	
}
