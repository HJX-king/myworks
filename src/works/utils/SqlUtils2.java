package works.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlUtils2 {
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> local= new ThreadLocal<>();
	
	static {
		InputStream is;
		try {
			//读取配置文件
			is=Resources.getResourceAsStream("mybatis-config.xml");
			//加载配置文件
			factory=new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static<E> E getMapper(Class<E> clazz) {
		if(local.get()==null) {
			//获取连接
			SqlSession session=factory.openSession();
			local.set(session);
		}
		E e= local.get().getMapper(clazz);
		return e;
	}
	public static void release() {
		SqlSession sqlSession =local.get();
		if(sqlSession!=null) {
			sqlSession.commit();
			sqlSession.close();
			local.remove();
		}
	}

}
