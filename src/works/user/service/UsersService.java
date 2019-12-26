package works.user.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

import works.user.bean.Users;

import works.user.dao.UserMapper;
import works.utils.SqlUtils2;

public class UsersService {
	

	public boolean checkUserName(Users u) {//String userName
		UserMapper userMapper=SqlUtils2.getMapper(UserMapper.class);
		long id = userMapper.getIdByUserName(u);
		SqlUtils2.release();
		if (id <= 0) {//用户名可用
			return true;
		} else {
			return false;
		}

	}
	//给密码加密,写入数据库
	public boolean saveUser(Users u) {//String userName, String password
		UserMapper userMapper=SqlUtils2.getMapper(UserMapper.class);
//		boolean flg=checkUserName(u);
		
			MessageDigest digest;
			try {
				// 加密完成之后, 二进制已经不是原来的能在码表中找到对应字符的数值了
				digest = MessageDigest.getInstance("md5");// 不可逆加密
				byte[] bs = digest.digest(u.getPassword().getBytes());
				Encoder base64 = Base64.getEncoder(); // 将任意二进制转成字符串
				String ps = base64.encodeToString(bs);
				u.setPassword(ps);
				//插入users表
				int num = userMapper.saveUser(u);
				if(num>0) {//users表插入成功
					u.setNickName(u.getUserName());
					u.setInco("http://localhost:8090/img/getImg?fileName=tx.jpg");
					int numb=userMapper.saveUserInfo(u);
					if(numb>0) {//userInfo表插入成功
						SqlUtils2.release();
						return true;
					}else {
						System.out.println(u.getId());
						userMapper.deleteUser(u);	
						SqlUtils2.release();
					}
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

		return false;

	}

	// 密码加密后,验证登录,不为空就登录成功
	public Users getUserByUserNameAndPassword(Users u) {//String userName, String password
		UserMapper userMapper=SqlUtils2.getMapper(UserMapper.class);
		MessageDigest digest;
		try {
			//给密码加密
			// 加密完成之后, 二进制已经不是原来的能在码表中找到对应字符的数值了
			digest = MessageDigest.getInstance("md5");// 不可逆加密
			byte[] bs = digest.digest(u.getPassword().getBytes());
			Encoder base64 = Base64.getEncoder(); // 将任意二进制转成字符串
			String ps = base64.encodeToString(bs);
			u.setPassword(ps);
			//用用户名和加密后的密码,在数据库找
			Users user = userMapper.getUserByUnameAndPassword(u);
			SqlUtils2.release();
			return user;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
