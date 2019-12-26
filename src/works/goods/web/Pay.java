//package works.goods.web;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import works.goods.bean.Order;
//import works.goods.service.OrderService;
//import works.user.bean.Users;
//import works.utils.WebUtils;
//
//@WebServlet("/goods/pay")
//public class Pay extends HttpServlet{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	private OrderService orderService = new OrderService();
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		Users user = (Users) req.getSession().getAttribute("login");
//		
//		if(user!=null) {
//			
//			Order order = WebUtils.copyTo(Order.class, req);
//			order.setUser_id(user.getId());
//			//更改支付状态
//			boolean flg = orderService.updateOrderStatus(order);
//			if(flg) {//成功,到订单展示页
//				req.getRequestDispatcher("/goods/toOrderPage").forward(req, resp);
//			}else {
//				resp.sendRedirect("/myworks/goods/toCartPage");//购物车
//			}
//		}else {
//			resp.sendRedirect("/myworks/pages/login.jsp");
//		}
//	}
//}
