package works.goods.service;

import java.util.List;

import works.goods.Dao.TypeMapper;
import works.goods.bean.TypeBean;
import works.utils.SqlUtils2;

public class TypeService {
	
	
	//获取所有的商品分类
	public List<TypeBean> getListAll(){
		TypeMapper typeMapper = SqlUtils2.getMapper(TypeMapper.class);
		List<TypeBean> list=typeMapper.getListAll();
		return list;
		
	}

}
