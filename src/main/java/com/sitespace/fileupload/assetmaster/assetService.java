package com.sitespace.fileupload.assetmaster;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;




public interface assetService {
	


	public assetResultBean saveAsset(assetBean obj);
	
	public assetResultBean updateAsset(assetBean obj);

	public assetResultBean assetList(String currentUserId);
	
	public assetResultBean editAssetdetails(String currentUserId);
	
    assetResultBean deleteAseet(assetBean obj);



}