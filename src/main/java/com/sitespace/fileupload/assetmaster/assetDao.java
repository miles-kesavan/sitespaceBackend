package com.sitespace.fileupload.assetmaster;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;



public interface assetDao {

	public assetResultBean updateAsset(assetBean obj);

	public assetResultBean saveAsset(assetBean obj);
	
	public assetResultBean editAssetdetails(String currentUserId);

	public assetResultBean assetList(String currentUserId);
	
	public assetResultBean deleteAseet(assetBean delete);


	
	



}
