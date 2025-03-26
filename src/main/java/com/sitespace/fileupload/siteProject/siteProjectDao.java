package com.sitespace.fileupload.siteProject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;



public interface siteProjectDao {

	public siteProjectResultBean updateAsset(siteProjectBean obj);

	public siteProjectResultBean subcontractorRegistration(siteProjectBean obj);
	
	public siteProjectResultBean editAssetdetails(String currentUserId);

	public siteProjectResultBean getProjectList(String currentUserId);
	
	public siteProjectResultBean deleteAseet(siteProjectBean delete);


	
	



}
