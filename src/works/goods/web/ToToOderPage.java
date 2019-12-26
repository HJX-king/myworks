//package works.goods.web;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import works.goods.bean.Cart;
//import works.goods.service.CartService;
//import works.user.bean.Address;
//import works.user.bean.Users;
//import works.user.service.AddressService;
//import works.utils.WebUtils;
//
//@WebServlet("/goods/toToOrderPage")
//public class ToToOderPage extends HttpServlet{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	private AddressService addressService = new AddressService();
//	private CartService cartService = new CartService();
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
//			//接收数据
//			//用long[] ids 来接收购物车已勾选的商品id
//			Cart cart = WebUtils.copyTo(Cart.class, req);
//			//查出所有当前用户的收货地址
//			List<Address> addresses = addressService.getAddressByUserId(user.getId());
//			req.setAttribute("addresses", addresses);
//			//获取提交订单时选中的商品
//			cart.setUser_id(user.getId());
//			List<Cart> list = cartService.getGoodsByCartId(cart);
//			
//			req.setAttribute("carts", list);
//			
//			
//			req.getRequestDispatcher("/WEB-INF/pages/toOrder.jsp").forward(req, resp);
//		}else {
//			resp.sendRedirect("/myworks/pages/login.jsp");
//		}
//	}
//}
