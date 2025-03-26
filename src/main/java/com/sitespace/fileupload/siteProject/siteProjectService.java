package com.sitespace.fileupload.siteProject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;




public interface siteProjectService {
	


	public siteProjectResultBean subcontractorRegistration(siteProjectBean obj);
	
	public siteProjectResultBean updateAsset(siteProjectBean obj);

	public siteProjectResultBean getProjectList(String currentUserId);
	
	public siteProjectResultBean editAssetdetails(String currentUserId);
	
    siteProjectResultBean deleteAseet(siteProjectBean obj);



}