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
//import com.alibaba.fastjson.JSONArray;
//
//import works.goods.bean.Goods;
//import works.goods.bean.TypeBean;
//import works.goods.service.GoodsService;
//import works.goods.service.TypeService;
//import works.utils.Pagetion;
//import works.utils.WebUtils;
//
//@WebServlet("/goods/toMainPage")
//public class ToMainPage extends HttpServlet{
//
//	/**
//	 * 展示所有商品,并分页
//	 */
//	private static final long serialVersionUID = 1L;
//
//	private TypeService typeService = new TypeService();
//	private GoodsService goodsService = new GoodsService();
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		//获取所有的商品分类
//		List<TypeBean> typeList  = typeService.getListAll();
//		req.setAttribute("typeList", typeList);
//		
//		
//		//拼接分页
//		//其实什么都没传
//		Goods bean = WebUtils.copyTo(Goods.class, req);//这个bean接收了前端传来的值
//		//直接获取所有数据,传了当前页
//		int count = goodsService.getCount(bean);
//		
//		String paging = Pagetion.paging(bean, count, "goods/toMainPage", req.getParameterMap());
//		
//		req.setAttribute("paging", paging);
//		
//		//获取商品及其详情
//		List<Goods> list = goodsService.getList(bean);
//		req.setAttribute("goodsList", list);
//		//这个有什么用处?
//		req.setAttribute("goods", bean);
//		//根据什么排序,因为是点击访问,所以前台会传来数据
//		String orderBy = JSONArray.toJSONString(bean.getOrderBy());
//		System.out.println(orderBy);
//		//写回前台,显示,并传给后台
//		req.setAttribute("orderBy", orderBy);
//		
//		req.getRequestDispatcher("/WEB-INF/pages/main.jsp").forward(req, resp);
//		
//	}
//	
//	
//
//}
//
