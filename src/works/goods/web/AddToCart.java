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
//@WebServlet("/goods/addToCart")
//public class AddToCart extends HttpServlet{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private CartService cartService =new CartService();
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Users u=(Users) req.getSession().getAttribute("login");
//		ResponseMsg msg =new ResponseMsg();
//		if(u!=null) {
//			Cart cart=WebUtils.copyTo(Cart.class, req);
//			cart.setUser_id(u.getId());
//			//加入购物车
//			boolean flg=cartService.addToCart(cart);
//			if (flg) {
//				msg.setCode(1);
//				msg.setMessage("恭喜您,商品已经成功添加到购物车");
//			}else {
//				msg.setCode(-1);
//				msg.setMessage("对不起,添加失败,要不您再试试...");
//			}
//		}else {
//			msg.setCode(Message.LOUT_CODE);
//		}
//		resp.getOutputStream().write(msg.toString().getBytes());
//	}
//
//}
