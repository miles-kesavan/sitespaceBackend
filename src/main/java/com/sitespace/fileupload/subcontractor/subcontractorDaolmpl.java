package com.sitespace.fileupload.subcontractor;

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
public class subcontractorDaolmpl implements subcontractorDao {

	
private final static Logger LOGGER = LoggerFactory.getLogger(subcontractorDaolmpl.class);
	


	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	//updateprofile
	 
	
			@Override
			public subcontractorResultBean subcontractorRegistration(subcontractorBean obj) {
				
				subcontractorResultBean subcontractorResultBean = new subcontractorResultBean();
				try {
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
					

				    
				    Integer checkUserExist=jdbcTemplate.queryForObject(subcontractorQueryUtil.checkUserExist, 
							new Object[] {obj.getContractorEmail()},(Integer.class));  
				    
				    
				    if(checkUserExist == 0) {
				    	
				    	
				    	
				    	String spaceId = jdbcTemplate.queryForObject(subcontractorQueryUtil.insert_AuthForsubContReg, new Object[]{obj.getContractorName(), obj.getContractorPass(),
				    			 obj.getContractorEmail()}, String.class);
				    	
				    	
				    	String contractorId = jdbcTemplate.queryForObject(subcontractorQueryUtil.insert_subContractorsReg, new Object[]{obj.getContractorName(), obj.getContractorCompany(),
				    			obj.getContractorTrade(), obj.getContractorEmail(), 
				    			obj.getContractorPhone(), obj.getCreatedBy(),spaceId}, String.class);
				    	
				    	jdbcTemplate.update(subcontractorQueryUtil.insert_project, contractorId, obj.getContractorProjectId());

				    	
				    	subcontractorResultBean.setSuccess(true);
				    	subcontractorResultBean.setMessage("Contractor added successfully!");
				    }
				    
				    else {
				    	
				    	String contractorId=jdbcTemplate.queryForObject(subcontractorQueryUtil.getContractorID, 
								new Object[] {obj.getContractorEmail()},(String.class)); 
				    	
				    	jdbcTemplate.update(subcontractorQueryUtil.insert_project, contractorId, obj.getContractorProjectId());
			            
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
			public subcontractorResultBean updateAsset(subcontractorBean asset) {
				
				subcontractorResultBean assetResultBean = new subcontractorResultBean();
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
				public subcontractorResultBean editAssetdetails(String assetkey) {
					// TODO Auto-generated method stub
				  subcontractorResultBean assetResultBean = new subcontractorResultBean();
					List<subcontractorBean> editassetdetails = new ArrayList<subcontractorBean>();

					try {
						JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);				
						
						//String query = "select * from public.vw_edit_jobseek_details('" + talentId +"')";
						
						editassetdetails= jdbcTemplate.query(subcontractorQueryUtil.getAssetDetails(assetkey),new Object[] {},
						new BeanPropertyRowMapper<subcontractorBean>(subcontractorBean.class));
						
						
						assetResultBean.setAssetlist(editassetdetails);
						assetResultBean.setSuccess(true);			
					}	catch (Exception e) {
						e.printStackTrace();
					}
					return assetResultBean;	
			  }
			  

			 

			
			// connectionList
			@Override
			public subcontractorResultBean assetList(String currentUserId) {
				List<subcontractorBean> assetlist = new ArrayList<subcontractorBean>();
				subcontractorResultBean assetResultBean = new subcontractorResultBean();
				try {
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

					
					assetlist= jdbcTemplate.query(subcontractorQueryUtil.Asset_list(currentUserId),new Object[] {},
							new BeanPropertyRowMapper<subcontractorBean>(subcontractorBean.class));
					
					assetResultBean.setAssetlist(assetlist);
					assetResultBean.setSuccess(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

				return assetResultBean;
			}

			
			@Override
			public subcontractorResultBean deleteAseet(subcontractorBean delete) {
				// TODO Auto-generated method stub
				NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
				subcontractorResultBean mobileResultBean = new subcontractorResultBean();
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
