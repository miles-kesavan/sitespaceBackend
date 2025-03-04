package com.sitespace.fileupload.dao;

import org.springframework.web.multipart.MultipartFile;

import com.sitespace.fileupload.model.FileUpload;

public interface FileUploadDao{

	FileUpload uploadFile(MultipartFile file);
	
}
