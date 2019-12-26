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
//import works.goods.bean.Cart;
//import works.goods.service.CartService;
//import works.user.bean.Users;
//import works.utils.Message;
//import works.utils.ResponseMsg;
//import works.utils.WebUtils;
//@WebServlet("/goods/deleteCart")
//public class DeleteCart extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	private CartService cartService = new CartService();
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Users user = (Users) req.getSession().getAttribute("login");
//
//		ResponseMsg msg = new ResponseMsg();
//		if (user != null) {
//
//			Cart cart = WebUtils.copyTo(Cart.class, req);
//			cart.setUser_id(user.getId());
//			boolean flg = cartService.deleteByIdAndUserId(cart);
//			if (flg) {
//				msg.setCode(1);
//			} else {
//				msg.setCode(-1);
//				msg.setMessage("对不起,删除失败");
//			}
//		} else {
//			msg.setCode(Message.LOUT_CODE);
//		}
//
//		resp.getOutputStream().write(msg.toString().getBytes());
//	}
//
//}
