package com.sitespace.fileupload.subcontractor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;





@Service
public class subcontractorServicelmpl  implements subcontractorService {

	@Autowired
	subcontractorDao assetDao;
	


			@Override
			public subcontractorResultBean saveAsset(subcontractorBean obj) {
				// TODO Auto-generated method stub
				return assetDao.saveAsset(obj);
			}



			@Override
			public subcontractorResultBean updateAsset(subcontractorBean objSkill) {
				
 				return assetDao.updateAsset(objSkill);
			}
			

			//editprofiledetails
			
			@Override
			public subcontractorResultBean editAssetdetails(String currentUserId) {
				// TODO Auto-generated method stub
				return assetDao.editAssetdetails(currentUserId);
			}



			@Override
			public subcontractorResultBean assetList(String currentUserId) {
				// TODO Auto-generated method stub
				return assetDao.assetList(currentUserId);
			}
			
			
			@Override
			public subcontractorResultBean deleteAseet(subcontractorBean delete) {
				// TODO Auto-generated method stub
				return assetDao.deleteAseet(delete);
			}
			

	
}
