package com.sitespace.fileupload.subcontractor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;




public interface subcontractorService {
	


	public subcontractorResultBean subcontractorRegistration(subcontractorBean obj);
	
	public subcontractorResultBean updateAsset(subcontractorBean obj);

	public subcontractorResultBean assetList(String currentUserId);
	
	public subcontractorResultBean editAssetdetails(String currentUserId);
	
    subcontractorResultBean deleteAseet(subcontractorBean obj);



}