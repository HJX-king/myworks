package works.user.dao;

import works.user.bean.Users;

public interface UserMapper {
	//根据用户名查询用户id,查用户名是否存在
	 long getIdByUserName(Users u);//String userName
	//往users表和userInfo表里写,同时成功或同时失败
	//保存用户名密码,返回储存了多少条信息
	 
	 int saveUser(Users u) ;//String userName ,String password
	 int saveUserInfo(Users u) ;
	//根据用户名和密码获得User
	Users getUserByUnameAndPassword(Users u);//String userName, String password
	//删除users表里
	int deleteUser(Users u);
}
