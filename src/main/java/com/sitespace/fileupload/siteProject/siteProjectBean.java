package com.sitespace.fileupload.siteProject;

import java.util.List;

public class siteProjectBean {

	private String contractorkey;
	private String emailId;
	
    private List<String> contractorProject;  // Array of project IDs

	private String contractorProjectId;
	private String contractorName;
	private String contractorCompany;
	private String contractorTrade;
	private String contractorEmail;
	private String contractorPhone;
	private String createdBy;
	
	
	

	public String getContractorName() {
		return contractorName;
	}
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	public String getContractorCompany() {
		return contractorCompany;
	}
	public void setContractorCompany(String contractorCompany) {
		this.contractorCompany = contractorCompany;
	}
	public String getContractorTrade() {
		return contractorTrade;
	}
	public void setContractorTrade(String contractorTrade) {
		this.contractorTrade = contractorTrade;
	}
	public String getContractorEmail() {
		return contractorEmail;
	}
	public void setContractorEmail(String contractorEmail) {
		this.contractorEmail = contractorEmail;
	}
	public String getContractorPhone() {
		return contractorPhone;
	}
	public void setContractorPhone(String contractorPhone) {
		this.contractorPhone = contractorPhone;
	}
	public String getContractorkey() {
		return contractorkey;
	}
	public void setContractorkey(String contractorkey) {
		this.contractorkey = contractorkey;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContractorProjectId() {
		return contractorProjectId;
	}
	public void setContractorProjectId(String contractorProjectId) {
		this.contractorProjectId = contractorProjectId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public List<String> getContractorProject() {
		return contractorProject;
	}
	public void setContractorProject(List<String> contractorProject) {
		this.contractorProject = contractorProject;
	}  

	
	
	
	
	
}
