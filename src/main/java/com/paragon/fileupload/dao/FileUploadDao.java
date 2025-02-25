package com.paragon.fileupload.dao;

import org.springframework.web.multipart.MultipartFile;

import com.paragon.fileupload.model.FileUpload;

public interface FileUploadDao{

	FileUpload uploadFile(MultipartFile file);
	
}
