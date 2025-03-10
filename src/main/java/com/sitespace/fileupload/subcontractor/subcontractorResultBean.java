package com.sitespace.fileupload.subcontractor;

import java.util.List;


public class subcontractorResultBean {

	

public boolean success;
private String message;

public List<subcontractorBean> assetlist;



public List<subcontractorBean> getAssetlist() {
	return assetlist;
}
public void setAssetlist(List<subcontractorBean> assetlist) {
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
