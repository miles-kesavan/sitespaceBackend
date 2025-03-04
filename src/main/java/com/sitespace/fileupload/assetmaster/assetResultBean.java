package com.sitespace.fileupload.assetmaster;

import java.util.List;


public class assetResultBean {

	

public boolean success;
private String message;

public List<assetBean> assetlist;



public List<assetBean> getAssetlist() {
	return assetlist;
}
public void setAssetlist(List<assetBean> assetlist) {
	this.assetlist = assetlist;
}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}


public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}


	
	
}
