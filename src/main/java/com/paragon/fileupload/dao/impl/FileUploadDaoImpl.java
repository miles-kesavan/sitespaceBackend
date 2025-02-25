package com.paragon.fileupload.dao.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.paragon.fileupload.dao.FileUploadDao;
import com.paragon.fileupload.model.FileUpload;

@Repository
public class FileUploadDaoImpl implements FileUploadDao {

	@Value("${export.files.absolutePath}")
	private String exportFilesPath;

	@Override
	public FileUpload uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		
		FileUpload ResultBean = new FileUpload();
		
		String serverPath = "";

		if (!file.isEmpty()) {
			try {

				byte[] bytes = file.getBytes();
				
				String localPath = exportFilesPath;
				String name = file.getOriginalFilename();
				int dot = name.lastIndexOf('.');
				String base = (dot == -1) ? name : name.substring(0, dot);
				File dir = new File(localPath);
			
					base = name;
					File serverFile = new File(dir + File.separator + base);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					
					serverPath=base;
					ResultBean.setImgPath(serverPath);
					ResultBean.setFilePath(base);

				ResultBean.setSuccess(true);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ResultBean;
	}

	
}
