package works.user.service;


import works.user.bean.UserInfo;
import works.user.bean.Users;
import works.user.dao.UserInfoMapper;
import works.utils.SqlUtils2;


public class UserInfoService {
	
	
	
	public UserInfo getUserInfoByUserId(Users u) {
		UserInfoMapper userInfoMapper =SqlUtils2.getMapper(UserInfoMapper.class);
		UserInfo userInfo=userInfoMapper.getUserInfoByUserId(u);
		SqlUtils2.release();
		return userInfo;
	}
	
	public boolean updataUserInfo(UserInfo userInfo) {
		UserInfoMapper userInfoMapper =SqlUtils2.getMapper(UserInfoMapper.class);
		if(userInfo.getInco()==null||userInfo.getInco().equals("")) {
			userInfo.setInco("tx.jpg");
		}
		int num=userInfoMapper.updataUserInfo(userInfo);
		if(num>0) {
			SqlUtils2.release();
			return true;
		}
		SqlUtils2.release();
		return false;
	}
	

}
