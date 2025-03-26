package com.sitespace.fileupload.siteProject;

import java.util.List;


public class siteProjectResultBean {

	

public boolean success;
private String message;

public List<siteProjectBean> assetlist;

public List<dropdownBean> projectlist;





public List<dropdownBean> getProjectlist() {
	return projectlist;
}
public void setProjectlist(List<dropdownBean> projectlist) {
	this.projectlist = projectlist;
}
public List<siteProjectBean> getAssetlist() {
	return assetlist;
}
public void setAssetlist(List<siteProjectBean> assetlist) {
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
