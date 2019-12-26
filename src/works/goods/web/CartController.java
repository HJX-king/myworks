package works.goods.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import works.goods.bean.Cart;
import works.goods.service.CartService;
import works.user.bean.Users;
import works.utils.ResponseMsg;

@Controller
@RequestMapping("/goods/")
public class CartController {
	private CartService cartService = new CartService();

	@RequestMapping("toCartPage")
	public String toCartPage(HttpSession session, HttpServletRequest req) {
		// 判断登录
		Users user = (Users) session.getAttribute("login");
		if (user != null) {
			Cart cart = new Cart();
			cart.setUser_id(user.getId());
			// 获取购物车里的所有商品及其详情
			List<Cart> list = cartService.getList(cart);
			req.setAttribute("carts", list);
			return "cart";
		} else {
			return "login";
		}

	}

	@RequestMapping("addToCart")
	public ResponseMsg addToCart(Cart cart, HttpSession session) {
		Users u = (Users) session.getAttribute("login");
		ResponseMsg msg = new ResponseMsg();
		if (u != null) {
			cart.setUser_id(u.getId());
			// 加入购物车
			boolean flg = cartService.addToCart(cart);
			if (flg) {
				msg.setCode(1);
				msg.setMessage("恭喜您,商品已经成功添加到购物车");
			} else {
				msg.setCode(-1);
				msg.setMessage("对不起,添加失败");
			}
		} else {
			msg.setCode(3);
		}
		return msg;
	}

	@RequestMapping("updateCart")
	public ResponseMsg updateCart(Cart cart, HttpSession session) {
		// 判断登录
		Users user = (Users) session.getAttribute("login");
		ResponseMsg msg = new ResponseMsg();
		if (user != null) {
			cart.setUser_id(user.getId());
			// 如果已存在,更新数量,不存在则添加商品进购物车
			boolean flg = cartService.updateCartByIdAndUserId(cart);
			if (flg) {
				msg.setCode(1);
			} else {
				msg.setCode(-1);
				msg.setMessage("对不起,修改数量失败");
			}

		} else {
			msg.setCode(3);
		}
		return msg;

	}
	@RequestMapping("deleteCart")
	public ResponseMsg deleteCart(Cart cart, HttpSession session) {
		Users user = (Users) session.getAttribute("login");

		ResponseMsg msg = new ResponseMsg();
		if (user != null) {
			cart.setUser_id(user.getId());
			boolean flg = cartService.deleteByIdAndUserId(cart);
			if (flg) {
				msg.setCode(1);
			} else {
				msg.setCode(-1);
				msg.setMessage("对不起,删除失败");
			}
		} else {
			msg.setCode(3);
		}
		return msg;

	}

}
