package works.goods.service;

import java.util.List;

import works.goods.Dao.CartMapper;
import works.goods.bean.Cart;
import works.utils.SqlUtils2;

public class CartService {
	
	
	//根据购物车id和用户id更新商品数量
	public boolean updateCartByIdAndUserId(Cart cart) {
		CartMapper cartMapper =SqlUtils2.getMapper(CartMapper.class);
		int num =cartMapper.updateCartByIdAndUserId(cart);
		SqlUtils2.release();
		return num>0;
	}
	//获取购物车中的所有商品
	public List<Cart> getList(Cart cart){
		CartMapper cartMapper =SqlUtils2.getMapper(CartMapper.class);
		List<Cart> list=cartMapper.getList(cart);
		SqlUtils2.release();
		return list;
	}
	//加入购物车
	public boolean addToCart(Cart cart) {
		CartMapper cartMapper =SqlUtils2.getMapper(CartMapper.class);
		//去购物车里找是否已经存在这样商品
		Cart c =cartMapper.getCartByGoodsIdAndUserId(cart);
		int i=0;
		if(c!=null&&c.getNum()>0) {//存在这个商品,做更新数量
			//先把商品数量改成购物车原有数量+新增数量
			cart.setNum(cart.getNum()+c.getNum());
			i=cartMapper.updateCart(cart);
		}else {
			cart.setCreate_time(System.currentTimeMillis());
			i=cartMapper.saveCart(cart);
		}
		SqlUtils2.release();
		return i>0;
	}
	// 根据购物车id和用户id删除购物车记录
	 
	public boolean deleteByIdAndUserId(Cart cart) {
		CartMapper cartMapper =SqlUtils2.getMapper(CartMapper.class);
		int num = cartMapper.deleteCartByGoodsIdAndUserId(cart);
		SqlUtils2.release();
		return num >0;
	}
	//获取提交订单时选中的商品
	public List<Cart> getGoodsByCartId(Cart cart){
		CartMapper cartMapper =SqlUtils2.getMapper(CartMapper.class);
		//根据购物车id和用户id获取商品详情
		List<Cart> list= cartMapper.getGoodsByCartId(cart);
		return list;
	}
}
