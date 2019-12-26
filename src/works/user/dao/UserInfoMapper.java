package works.user.dao;

import works.user.bean.UserInfo;
import works.user.bean.Users;

public interface UserInfoMapper {
	//根据user_id查询用户的详细信息
	UserInfo getUserInfoByUserId(Users u);
	
	int updataUserInfo(UserInfo userInfo);
	
	
}
