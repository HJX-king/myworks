package works.goods.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import works.goods.bean.Cart;
import works.goods.bean.Order;
import works.goods.service.CartService;
import works.goods.service.OrderService;
import works.user.bean.Address;
import works.user.bean.Users;
import works.user.service.AddressService;
import works.utils.Pagetion;

@Controller
@RequestMapping("/goods/")
public class OrderController {
	private OrderService orderService = new OrderService();
	private AddressService addressService = new AddressService();
	private CartService cartService = new CartService();
	
	
	@RequestMapping("pay")
	public String pay(Order order,HttpSession session,HttpServletRequest req) {
		Users user = (Users) session.getAttribute("login");
		
		if(user!=null) {
			order.setUser_id(user.getId());
			//更改支付状态
			boolean flg = orderService.updateOrderStatus(order);
			if(flg) {//成功,到订单展示页
				return "forward:goods/toOrderPage";
			}else {
				return "forward:goods/toCartPage";//购物车
			}
		}else {
			return "login";
		}
	}
	
	@RequestMapping("toOrder")
	public String toOrder(Order order,HttpSession session,HttpServletRequest req) {
		Users user = (Users) session.getAttribute("login");
		
		if(user!=null) {
			order.setUser_id(user.getId());
			//提交订单
			long order_id = orderService.saveOrder(order);
			if(order_id>0) {//成功
				req.setAttribute("order_id", order_id);
				return "pay";
			}else {//失败
				return "forward:goods/toCartPage";//购物车页面
			}
		}else {
			return "login";
		}
	}
	
	
	
	@RequestMapping("toToOrderPage")
	public String toToOrderPage(Cart cart,HttpSession session,HttpServletRequest req) {
		Users user = (Users) session.getAttribute("login");
		
		if(user!=null) {
			
			//用long[] ids 来接收购物车已勾选的商品id
			//查出所有当前用户的收货地址
			List<Address> addresses = addressService.getAddressByUserId(user.getId());
			req.setAttribute("addresses", addresses);
			//获取提交订单时选中的商品
			cart.setUser_id(user.getId());
			List<Cart> list = cartService.getGoodsByCartId(cart);
			
			req.setAttribute("carts", list);
			
			
			return "toOrder";
		}else {
			return "login";
		}
	}
	
	
	@RequestMapping("toOrderPage")
	public String toOrderPage(HttpSession session,HttpServletRequest req) {
		// 判断登录
		Users user = (Users) session.getAttribute("login");
		if (user != null) {

			Order order = new Order();
			order.setUser_id(user.getId());

			int count = orderService.getCount(order);

			String paging = Pagetion.paging(order, count, "goods/toOrderPage", req.getParameterMap());

			List<Order> list = orderService.getList(order);

			req.setAttribute("paging", paging);
			req.setAttribute("list", list);

			return "orders";
		} else {
			return "login";
		}
	}
}
