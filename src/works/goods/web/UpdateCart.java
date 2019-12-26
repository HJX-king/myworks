//package works.goods.web;
//
//
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
//
//@WebServlet("/goods/updateCart")
//public class UpdateCart extends HttpServlet{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	private CartService cartService = new CartService();
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		//判断登录
//		Users user = (Users) req.getSession().getAttribute("login");
//		ResponseMsg msg = new ResponseMsg();
//		if(user!=null) {
//			//接收数据
//			Cart cart = WebUtils.copyTo(Cart.class, req);
//			
//			cart.setUser_id(user.getId());
//			//如果已存在,更新数量,不存在则添加商品进购物车
//			boolean flg = cartService.updateCartByIdAndUserId(cart);
//			if(flg) {
//				msg.setCode(1);
//			}else {
//				msg.setCode(-1);
//				msg.setMessage("对不起,修改数量失败");
//			}
//			
//		}else {
//			msg.setCode(Message.LOUT_CODE);
//		}
//		resp.getOutputStream().write(msg.toString().getBytes());
//	}
//	
//	
//
//}
