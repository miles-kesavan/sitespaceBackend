package com.sitespace.fileupload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sitespace.fileupload.dao.FileUploadDao;
import com.sitespace.fileupload.model.FileUpload;

@Service
public class FileUploadService {

	@Autowired
	FileUploadDao fileUploadDao;

	public FileUpload uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return fileUploadDao.uploadFile(file);
	}
}
