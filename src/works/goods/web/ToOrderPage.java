package works.goods.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import works.goods.bean.Order;
import works.goods.service.OrderService;
import works.user.bean.Users;
import works.utils.Pagetion;

@WebServlet("/goods/toOrderPage")
public class ToOrderPage extends HttpServlet{

	/**
	 * 跳到订单展示页
	 */
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//判断登录
		Users user = (Users) req.getSession().getAttribute("login");
		if(user!=null) {
			
			Order order = new Order();
			order.setUser_id(user.getId());
			
			int count = orderService.getCount(order);
			
			String paging = Pagetion.paging(order, count, "goods/toOrderPage", req.getParameterMap());
			
			List<Order> list = orderService.getList(order);
			
			req.setAttribute("paging", paging);
			req.setAttribute("list", list);

			req.getRequestDispatcher("/WEB-INF/pages/orders.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/myworks/pages/login.jsp");
		}
		
	}
	
	

}
