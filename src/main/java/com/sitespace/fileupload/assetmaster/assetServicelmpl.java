package com.sitespace.fileupload.assetmaster;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;





@Service
public class assetServicelmpl  implements assetService {

	@Autowired
	assetDao assetDao;
	


			@Override
			public assetResultBean saveAsset(assetBean obj) {
				// TODO Auto-generated method stub
				return assetDao.saveAsset(obj);
			}



			@Override
			public assetResultBean updateAsset(assetBean objSkill) {
				
 				return assetDao.updateAsset(objSkill);
			}
			

			//editprofiledetails
			
			@Override
			public assetResultBean editAssetdetails(String currentUserId) {
				// TODO Auto-generated method stub
				return assetDao.editAssetdetails(currentUserId);
			}



			@Override
			public assetResultBean assetList(String currentUserId) {
				// TODO Auto-generated method stub
				return assetDao.assetList(currentUserId);
			}
			
			
			@Override
			public assetResultBean deleteAseet(assetBean delete) {
				// TODO Auto-generated method stub
				return assetDao.deleteAseet(delete);
			}
			

	
}
