package works.goods.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;

import works.goods.bean.Goods;
import works.goods.bean.TypeBean;
import works.goods.service.GoodsService;
import works.goods.service.TypeService;
import works.utils.Pagetion;

@Controller
@RequestMapping("/goods/")
public class GoodsContrller {
	private TypeService typeService = new TypeService();
	private GoodsService goodsService = new GoodsService();

	@RequestMapping("toMainPage")
	public String toMainPage(Goods bean, HttpServletRequest req) {
		// 获取所有的商品分类
		List<TypeBean> typeList = typeService.getListAll();
		req.setAttribute("typeList", typeList);

		// 拼接分页
		// 直接获取所有数据,传了当前页
		int count = goodsService.getCount(bean);

		String paging = Pagetion.paging(bean, count, "goods/toMainPage", req.getParameterMap());

		req.setAttribute("paging1", paging);

		// 获取商品及其详情
		List<Goods> list = goodsService.getList(bean);
		req.setAttribute("goodsList", list);
		// 这个有什么用处?
		req.setAttribute("goods", bean);
		// 根据什么排序,因为是点击访问,所以前台会传来数据
		String orderBy = JSONArray.toJSONString(bean.getOrderBy());
		System.out.println(orderBy);
		// 写回前台,显示,并传给后台
		req.setAttribute("orderBy", orderBy);

		return "main";

	}

	@RequestMapping("toGoodsInfoPage")
	public String toGoodsInfoPage(Goods goods,HttpServletRequest req) {
		// 根据id查询商品详情
		Goods gd = goodsService.getById(goods.getId());
		req.setAttribute("good", gd);
		System.out.println(gd);
		System.out.println(req.getAttribute("good"));
		return "goodsInfo";
	}

}
