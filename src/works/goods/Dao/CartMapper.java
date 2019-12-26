package works.goods.Dao;

import java.util.ArrayList;
import java.util.List;

import works.goods.bean.Cart;

public interface CartMapper {
	//根据id和用户id修改商品数量
	int updateCartByIdAndUserId(Cart cart);
	
	//获取购物车中的所有商品
	List<Cart> getList(Cart cart);
	
	//往购物车里新加记录
	int saveCart(Cart cart);
	
	//更新购物车数量
	int updateCart(Cart cart);
	
	//根据商品的id和用户的id来查询商品的购物车商品数量
	Cart getCartByGoodsIdAndUserId(Cart cart);
	
	//从购物车删除商品
	int deleteCartByGoodsIdAndUserId(Cart cart);
	
	// 根据购物车id和用户id获取商品详情
	ArrayList<Cart> getGoodsByCartId(Cart cart);

	// 根据购物车id删除
	int deleteByIds(Cart cart);
}
