package com.sitespace.fileupload.subcontractor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;



public interface subcontractorDao {

	public subcontractorResultBean updateAsset(subcontractorBean obj);

	public subcontractorResultBean saveAsset(subcontractorBean obj);
	
	public subcontractorResultBean editAssetdetails(String currentUserId);

	public subcontractorResultBean assetList(String currentUserId);
	
	public subcontractorResultBean deleteAseet(subcontractorBean delete);


	
	



}
