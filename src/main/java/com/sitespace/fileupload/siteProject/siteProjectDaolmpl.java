package com.sitespace.fileupload.siteProject;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.Properties;
import java.io.StringWriter;
import java.sql.Array;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;



@Repository
public class siteProjectDaolmpl implements siteProjectDao {

	
private final static Logger LOGGER = LoggerFactory.getLogger(siteProjectDaolmpl.class);
	


	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	//updateprofile
	 
	
			@Override
			public siteProjectResultBean subcontractorRegistration(siteProjectBean obj) {
				
				siteProjectResultBean subcontractorResultBean = new siteProjectResultBean();
				try {
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
					
			        Connection conn = jdbcTemplate.getDataSource().getConnection();

					
					   Array projectArray = conn.createArrayOf("VARCHAR", obj.getContractorProject().toArray());

				    
				    
				    Integer checkUserExist=jdbcTemplate.queryForObject(siteProjectQueryUtil.checkUserExist, 
							new Object[] {obj.getContractorEmail()},(Integer.class));  
				    
				    
				    if(checkUserExist == 0) {
				    	
				    	jdbcTemplate.update(siteProjectQueryUtil.insert_subContractorsReg, projectArray, obj.getContractorName(), obj.getContractorCompany(),
				    			obj.getContractorTrade(), obj.getContractorEmail(), 
				    			obj.getContractorPhone(), obj.getCreatedBy());
				    	
				    	subcontractorResultBean.setSuccess(true);
				    	subcontractorResultBean.setMessage("Contractor added successfully!");
				    }
				    
				    else {
				    	
				    	String updateSql = "UPDATE sub_contractors SET contractor_project = ? WHERE contractor_email = ? OR contractor_phone = ?";
			            jdbcTemplate.update(updateSql, projectArray, obj.getContractorEmail(), obj.getContractorPhone());
			            
			            subcontractorResultBean.setSuccess(true);
				    	subcontractorResultBean.setMessage("Contractor project updated successfully!");

				    }
	
		

				
			}catch (Exception e ) {
				e.printStackTrace();
				String[] err = e.getMessage().split(": ERROR:");
				subcontractorResultBean.setSuccess(false);
				subcontractorResultBean.setMessage("Error Please Try after Sometime ");
								 
			}
			return subcontractorResultBean;	
		  }


			@Override
			public siteProjectResultBean updateAsset(siteProjectBean asset) {
				
				siteProjectResultBean assetResultBean = new siteProjectResultBean();
			  try { 
				  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
				  
				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				    Date maintanenceStartDate = new Date(sdf.parse(asset.getMaintanenceStartdt()).getTime());
//				    Date maintanenceEndDate = new Date(sdf.parse(asset.getMaintanenceEnddt()).getTime());
//					  
//				  jdbcTemplate.update(subcontractorQueryUtil.updateAsset, new Object[] { 
//						    asset.getAssetProject(), 
//						    asset.getAssetTitle(), 
//						    asset.getAssetLocation(), 
//						    asset.getAssetStatus(), 
//						    asset.getAssetPoc(), 
//						    maintanenceStartDate, 
//						    maintanenceEndDate, 
//						    asset.getUsageInstructions(), 
//						    asset.getAssetKey() // Assuming asset_key is the primary key
//						});				 
			 assetResultBean.setSuccess(true);
			 assetResultBean.setMessage("Asset Updated SuccessFully ");
			  
			  } catch (Exception e) {
				  assetResultBean.setSuccess(false);
				  assetResultBean.setMessage("Error Please Try after Sometime ");
					e.printStackTrace();
			  }
			  
			  return assetResultBean;
			  
			  }
			  

			  
			////editprofile
			  
			  @Override
				public siteProjectResultBean editAssetdetails(String assetkey) {
					// TODO Auto-generated method stub
				  siteProjectResultBean assetResultBean = new siteProjectResultBean();
					List<siteProjectBean> editassetdetails = new ArrayList<siteProjectBean>();

					try {
						JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);				
						
						//String query = "select * from public.vw_edit_jobseek_details('" + talentId +"')";
						
						editassetdetails= jdbcTemplate.query(siteProjectQueryUtil.getAssetDetails(assetkey),new Object[] {},
						new BeanPropertyRowMapper<siteProjectBean>(siteProjectBean.class));
						
						
						assetResultBean.setAssetlist(editassetdetails);
						assetResultBean.setSuccess(true);			
					}	catch (Exception e) {
						e.printStackTrace();
					}
					return assetResultBean;	
			  }
			  

			 

			
			// connectionList
			@Override
			public siteProjectResultBean getProjectList(String currentUserId) {
				List<dropdownBean> projectlist = new ArrayList<dropdownBean>();
				siteProjectResultBean siteProjectResultBean = new siteProjectResultBean();
				try {
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

					
					projectlist = jdbcTemplate.query(siteProjectQueryUtil.get_project_list(currentUserId), 
                            new Object[] {}, 
                            new BeanPropertyRowMapper<dropdownBean>(dropdownBean.class));

					if (projectlist.isEmpty()) { 
						siteProjectResultBean.setSuccess(false);
						siteProjectResultBean.setMessage("No projects allocated for this user.");
						} else {
						siteProjectResultBean.setProjectlist(projectlist);
						siteProjectResultBean.setSuccess(true);
						}

				} catch (Exception e) {
					e.printStackTrace();
				}

				return siteProjectResultBean;
			}

			
			@Override
			public siteProjectResultBean deleteAseet(siteProjectBean delete) {
				// TODO Auto-generated method stub
				NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
				siteProjectResultBean mobileResultBean = new siteProjectResultBean();
				boolean isSuccess = false;
			
				try {	
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//					jdbcTemplate.update(subcontractorQueryUtil.Delete_User_Account, delete.getAssetKey());
					mobileResultBean.setSuccess(true);
					mobileResultBean.setMessage("Asset Removed SuccessFully");
				
				} catch (Exception e) {
					LOGGER.error("Error in Account delete", e);
					mobileResultBean.setSuccess(false);
					mobileResultBean.setMessage("Error Please Try after Sometime ");
				}

				// TODO Auto-generated method stub
				return mobileResultBean;
			}
			

			// ExportPDF view


		
}
