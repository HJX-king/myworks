package works.goods.Dao;

import java.util.List;

import works.goods.bean.TypeBean;

public interface TypeMapper {
	//查询出所有类别
	List<TypeBean> getListAll();
}
