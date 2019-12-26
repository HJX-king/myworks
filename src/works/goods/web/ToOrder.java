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
//@WebServlet("/goods/toOrder")
//public class ToOrder extends HttpServlet{
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
//			//提交订单
//			long order_id = orderService.saveOrder(order);
//			if(order_id>0) {//成功
//				req.setAttribute("order_id", order_id);
//				req.getRequestDispatcher("/WEB-INF/pages/pay.jsp").forward(req, resp);
//			}else {//失败
//				resp.sendRedirect("/myworks/goods/toCartPage");//购物车页面
//			}
//		}else {
//			resp.sendRedirect("/myworks/pages/login.jsp");
//		}
//	}
//}
