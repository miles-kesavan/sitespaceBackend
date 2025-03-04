package com.sitespace.fileupload.assetmaster;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;



@Repository
public class assetDaolmpl implements assetDao {

	
private final static Logger LOGGER = LoggerFactory.getLogger(assetDaolmpl.class);
	


	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	//updateprofile
	 
	
			@Override
			public assetResultBean saveAsset(assetBean obj) {
				
				assetResultBean assetResultBean = new assetResultBean();
				try {
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
					
					
				    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				    Date maintanenceStartDate = new Date(sdf.parse(obj.getMaintanenceStartdt()).getTime());
				    Date maintanenceEndDate = new Date(sdf.parse(obj.getMaintanenceEnddt()).getTime());
					
					int count = jdbcTemplate.update(
						    assetQueryUtil.insert_asset, 
						    new Object[] {
						        obj.getAssetProject(), 
						        obj.getAssetTitle(), 
						        obj.getAssetLocation(),
						        obj.getAssetStatus(), 
						        obj.getAssetPoc(), 
						        maintanenceStartDate, 
						        maintanenceEndDate, 
						        obj.getUsageInstructions()
						    }
						);
					 if(count !=0 ) {
						 assetResultBean.setSuccess(true);
						 assetResultBean.setMessage("Asset Saved SuccessFully ");
					 }
				
			}catch (Exception e ) {
				e.printStackTrace();
				String[] err = e.getMessage().split(": ERROR:");
				assetResultBean.setSuccess(false);
				assetResultBean.setMessage("Error Please Try after Sometime ");
								 
			}
			return assetResultBean;	
		  }


			@Override
			public assetResultBean updateAsset(assetBean asset) {
				
				assetResultBean assetResultBean = new assetResultBean();
			  try { 
				  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
				  
				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				    Date maintanenceStartDate = new Date(sdf.parse(asset.getMaintanenceStartdt()).getTime());
				    Date maintanenceEndDate = new Date(sdf.parse(asset.getMaintanenceEnddt()).getTime());
					  
				  jdbcTemplate.update(assetQueryUtil.updateAsset, new Object[] { 
						    asset.getAssetProject(), 
						    asset.getAssetTitle(), 
						    asset.getAssetLocation(), 
						    asset.getAssetStatus(), 
						    asset.getAssetPoc(), 
						    maintanenceStartDate, 
						    maintanenceEndDate, 
						    asset.getUsageInstructions(), 
						    asset.getAssetKey() // Assuming asset_key is the primary key
						});				 
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
				public assetResultBean editAssetdetails(String assetkey) {
					// TODO Auto-generated method stub
				  assetResultBean assetResultBean = new assetResultBean();
					List<assetBean> editassetdetails = new ArrayList<assetBean>();

					try {
						JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);				
						
						//String query = "select * from public.vw_edit_jobseek_details('" + talentId +"')";
						
						editassetdetails= jdbcTemplate.query(assetQueryUtil.getAssetDetails(assetkey),new Object[] {},
						new BeanPropertyRowMapper<assetBean>(assetBean.class));
						
						
						assetResultBean.setAssetlist(editassetdetails);
						assetResultBean.setSuccess(true);			
					}	catch (Exception e) {
						e.printStackTrace();
					}
					return assetResultBean;	
			  }
			  

			 

			
			// connectionList
			@Override
			public assetResultBean assetList(String currentUserId) {
				List<assetBean> assetlist = new ArrayList<assetBean>();
				assetResultBean assetResultBean = new assetResultBean();
				try {
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

					
					assetlist= jdbcTemplate.query(assetQueryUtil.Asset_list(currentUserId),new Object[] {},
							new BeanPropertyRowMapper<assetBean>(assetBean.class));
					
					assetResultBean.setAssetlist(assetlist);
					assetResultBean.setSuccess(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

				return assetResultBean;
			}

			
			@Override
			public assetResultBean deleteAseet(assetBean delete) {
				// TODO Auto-generated method stub
				NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
				assetResultBean mobileResultBean = new assetResultBean();
				boolean isSuccess = false;
			
				try {	
					JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
					jdbcTemplate.update(assetQueryUtil.Delete_User_Account, delete.getAssetKey());
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
