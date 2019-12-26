//package works.user.web;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//@WebServlet("/user/logout")
//public class Logout extends HttpServlet{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		HttpSession hs=req.getSession();
//		hs.removeAttribute("login");
//		Cookie c = new Cookie("autologin", "");
//		c.setPath("/myworks");// 设置路径为当前项目下
//		c.setMaxAge(0);
//		
//		resp.addCookie(c);
//		resp.sendRedirect("/myworks/pages/main.jsp");
//	}
//	
//
//}
