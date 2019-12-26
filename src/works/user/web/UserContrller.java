package works.user.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import works.user.bean.Address;
import works.user.bean.UserInfo;
import works.user.bean.Users;
import works.user.service.AddressService;
import works.user.service.UserInfoService;
import works.user.service.UsersService;
import works.utils.ResponseMsg;

@Controller
@RequestMapping("/user/")
public class UserContrller {
	private UsersService us = new UsersService();
 	private UserInfoService userInfoService = new UserInfoService();
 	private AddressService addressService = new AddressService();

	@RequestMapping("/toLogin")
	public String toLogin() {

		return "login";
	}

	@ResponseBody
	@RequestMapping("login")
	public ResponseMsg login(Users u, HttpSession session) {
		ResponseMsg msg = new ResponseMsg();
		
		if (u.getUserName() == null || u.getUserName().equals("")) {
			msg.setCode(-1);
			msg.setMessage("用户名不能为空!");

			return msg;
		}
		if (u.getPassword() == null || u.getPassword().equals("")) {
			msg.setCode(-1);
			msg.setMessage("密码不能为空!");

			return msg;
		}

		// 验证用户名,密码
		Users user = us.getUserByUserNameAndPassword(u);
		if (user != null) {// 用户名和密码正确
			session.setAttribute("login", user);

//			if (rem != null) {
//				Cookie cookie = new Cookie("autologin", u.getUserName().concat("=").concat(u.getPassword()));
//				cookie.setPath("/myworks");
//				cookie.setMaxAge(3600 * 24 * 7);
//				resp.addCookie(cookie);
//
//			} else {
//				Cookie cookie = new Cookie("autologin", "");
//				cookie.setPath("/myworks");
//				cookie.setMaxAge(0);
//				resp.addCookie(cookie);
//			}

			msg.setCode(1);
			msg.setMessage("登录成功!");
			return msg;
		} else {// 用户名或密码不正确
			msg.setCode(-1);
			msg.setMessage("用户名或密码不正确!");
			return msg;
		}
	}
	@RequestMapping("toRegister")
	public String toRegister() {
		return "register";
	}
	@ResponseBody
	@RequestMapping("register")
	public ResponseMsg register(Users u, String repassword) {
		ResponseMsg msg=new ResponseMsg();
		if(u.getUserName()==null||u.getUserName().equals("")) {
			msg.setCode(-1);
			msg.setMessage("用户名不能为空!");
			
			return msg;
		}
		if(u.getPassword()==null||u.getPassword().equals("")) {
			msg.setCode(-1);
			msg.setMessage("密码不能为空!");
		
			return msg;
		}
		if(!repassword.equals(u.getPassword())) {
			msg.setCode(-1);
			msg.setMessage("两次密码不一致!");
			
			return msg;
		}
		
		boolean flg=us.checkUserName(u);
		if(!flg) {
			msg.setCode(-1);
			msg.setMessage("用户名已经被注册");
			return msg;
		}else {//用户名可用
			//将数据写入数据库
			boolean f=us.saveUser(u);
			if(f) {
				//登录成功
				msg.setCode(1);
				msg.setMessage("注册成功");
				return msg;
			}else {
				msg.setCode(1);
				msg.setMessage("注册失败,用户名或密码错误!");
				return msg;
 			}
		}
	}
		@ResponseBody
		@RequestMapping("logout")
		public String login (HttpSession hs,HttpServletResponse resp) {
		
			hs.removeAttribute("login");
		/*
		 * Cookie c = new Cookie("autologin", ""); c.setPath("/myworks");// 设置路径为当前项目下
		 * c.setMaxAge(0);
		 * 
		 * resp.addCookie(c);
		 */
			return "main";
		}
		
		@ResponseBody
		@RequestMapping("checkUserName")
		public ResponseMsg checkUserName(Users u) {
			ResponseMsg msg =new ResponseMsg();
			// 在数据库中查找是否有这个用户名
			boolean flg = us.checkUserName(u);
			if(flg) {
				msg.setCode(1);
				msg.setMessage("ok");
			}else {
				msg.setCode(-1);
				msg.setMessage("用户名已注册");
				
			}
			return msg;
		}
//		@ResponseBody
//		@RequestMapping("imgcode")
//		public ResponseMsg imgcode(Users u) {
//			ResponseMsg msg =new ResponseMsg();
//			// 在数据库中查找是否有这个用户名
//			boolean flg = us.checkUserName(u);
//			if(flg) {
//				msg.setCode(1);
//			}else {
//				msg.setCode(-1);
//				
//			}
//			return msg;
//		}
//		
		@RequestMapping("toUserInfo")
		public String toUserInfo(HttpSession hs,HttpServletRequest req) {
			Users user= (Users)hs.getAttribute("login");
			
			if (user != null) {
				List<Address> addressList=addressService.getAddressByUserId(user.getId());
				
				UserInfo userInfo=userInfoService.getUserInfoByUserId(user);
				
				req.setAttribute("userInfo", userInfo);//向前台传值
				
				req.setAttribute("addressList", addressList);
				return "userinfo";
			} else {
				return "login";

			}
		}
		
		@RequestMapping("updateUserInfo")
		public String updateUserInfo(UserInfo userInfo,HttpSession hs) {
			Users user= (Users)hs.getAttribute("login");
			
			if(user!=null) {
				userInfo.setUserId(user.getId());
				userInfoService.updataUserInfo(userInfo);
				user.setInco(userInfo.getInco());
				user.setNickName(userInfo.getNickName());
				
				return "forward:toUserInfo";
				
			}else {
				return "login";
				
			}
		}
		
}
