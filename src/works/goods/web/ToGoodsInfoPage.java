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
//import works.goods.bean.Goods;
//import works.goods.service.GoodsService;
//import works.utils.WebUtils;
//
//@WebServlet("/goods/toGoodsInfoPage")
//public class ToGoodsInfoPage extends HttpServlet{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	private GoodsService goodsService = new GoodsService();
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		//获取要看商品详情的商品id
//		Goods goods = WebUtils.copyTo(Goods.class, req);
//		//根据id查询商品详情
//		Goods goods2 = goodsService.getById(goods.getId());
//		
//		req.setAttribute("goods", goods2);
//		req.getRequestDispatcher("/WEB-INF/pages/goodsInfo.jsp").forward(req, resp);
//		
//	}
//	
//	
//
//}
//
