package works;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSource;

public class MyDataSourceFcatory extends UnpooledDataSourceFactory{

	public MyDataSourceFcatory() {
		
		this.dataSource = new DruidDataSource();
	}
}
