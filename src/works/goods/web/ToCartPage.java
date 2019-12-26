package works.goods.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import works.goods.bean.Cart;
import works.goods.service.CartService;
import works.user.bean.Users;

@WebServlet("/goods/toCartPage")
public class ToCartPage extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CartService cartService = new CartService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//判断登录
		Users user = (Users) req.getSession().getAttribute("login");
		if(user!=null) {
			
			Cart cart = new Cart();
			cart.setUser_id(user.getId());
			//获取购物车里的所有商品及其详情
			List<Cart> list = cartService.getList(cart);
			req.setAttribute("carts", list);
			
			req.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/myworks/pages/login.jsp");
		}
		
	}
	
	

}
