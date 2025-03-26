package com.sitespace.fileupload.siteProject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;





@Service
public class siteProjectServicelmpl  implements siteProjectService {

	@Autowired
	siteProjectDao siteProjectDao;
	


			@Override
			public siteProjectResultBean subcontractorRegistration(siteProjectBean obj) {
				// TODO Auto-generated method stub
				return siteProjectDao.subcontractorRegistration(obj);
			}



			@Override
			public siteProjectResultBean updateAsset(siteProjectBean objSkill) {
				
 				return siteProjectDao.updateAsset(objSkill);
			}
			

			//editprofiledetails
			
			@Override
			public siteProjectResultBean editAssetdetails(String currentUserId) {
				// TODO Auto-generated method stub
				return siteProjectDao.editAssetdetails(currentUserId);
			}



			@Override
			public siteProjectResultBean getProjectList(String currentUserId) {
				// TODO Auto-generated method stub
				return siteProjectDao.getProjectList(currentUserId);
			}
			
			
			@Override
			public siteProjectResultBean getSubcontractorList(String currentUserId) {
				// TODO Auto-generated method stub
				return siteProjectDao.getSubcontractorList(currentUserId);
			}
			
			
			
			
			@Override
			public siteProjectResultBean deleteAseet(siteProjectBean delete) {
				// TODO Auto-generated method stub
				return siteProjectDao.deleteAseet(delete);
			}
			

	
}
