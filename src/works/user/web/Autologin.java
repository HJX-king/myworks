//package works.user.web;
//
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//import works.user.bean.Users;
//import works.user.service.UsersService;
//
//
//@WebFilter("/*")
//public class Autologin implements Filter {
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
////		HttpServletRequest hsr = (HttpServletRequest) request;
////		HttpServletResponse hrp = (HttpServletResponse) response;
////		Object obj = hsr.getSession().getAttribute("login");
////		if (obj == null) {// 没有登录,查看cookie里是否存有值
////			Cookie[] cookies = hsr.getCookies();
////			// 如果
////			if (cookies != null) {
////			
////				for (Cookie cookie : cookies) {
////					if (cookie.getName().equals("autologin")) {//找到cookie
////					
////						String value = cookie.getValue();
////						String[] strs = value.split("=");
////						UsersService us= new UsersService();
////						Users user=us.getUserByUserNameAndPassword(strs[0],strs[1]);
////						if(user!=null) {//cookie里的用户名密码有效
////							hsr.getSession().setAttribute("login", user);
////						}else {//cookie里的用户名密码无效
////							Cookie c = new Cookie("autologin", "");
//// 							c.setPath("/myworks");// 设置路径为当前项目下
//// 							c.setMaxAge(0);
//// 							hrp.addCookie(c);
////						}
////					}
////
////				}
////
////			}
////
////		}
////		chain.doFilter(hsr, hrp);
//
//	}
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		// TODO Auto-generated method stub
//
//	}
//
//}
