package works.utils;

import java.util.Map;

public class Pagetion {

	//接收 javabean ,总页数,要显示页面的服务,
	public static String paging(Page page , int count , String url,Map<String, String[]> params) {
		//当前页
		int currentPage = page.getCurrentPage();
		int pageSize  = page.getPageSize();
		
		int pages = count%pageSize!=0?count/pageSize+1:count/pageSize; //计算总页数
		//如果客户端传递来的页码已经大于总页数了, 就将页码编程最后一页
		if(currentPage>pages) {
			currentPage=pages;
		}
		
		int start = (currentPage-1)*pageSize; //limit 0,10;
		if(start<0) {
			start = 0;
		}
		page.setStart(start);
		
		//拼接参数  为了点击分页按钮的时候, 可以带着参数查询数据
		//url?key=value&key=value
		StringBuilder ssb = new StringBuilder(url);
		ssb.append("?");
		for (String key : params.keySet()) {
			if(!"currentPage".equals(key)) {
				String[] values = params.get(key);
				
				for (String value : values) {
					ssb.append(key);
					ssb.append("=");
					ssb.append(value);
					ssb.append("&");
				}
			}
		}
		url = ssb.toString();
		
		//开始拼接分页按钮
		StringBuilder sb = new StringBuilder();
		if(pages>1) {
			
			//获取上一页和下一页的值
			int pre = currentPage-1<=0?1:currentPage-1;
			int next = currentPage+1>=pages?pages:currentPage+1;
			
			if(currentPage==1) {
				sb.append("<a href=\"javascript:void(0)\" style='text-decoration: none;color: #585858;'>上一页</a> ");
			}else {
				sb.append("<a href=\""+url+"currentPage="+pre+"\">上一页</a> ");
			}
			
			if(pages<10) {
		    
				for (int i = 1; i <= pages; i++) {
					if(currentPage==i) {
						sb.append("<a href=\"javascript:void(0)\" style='text-decoration: none;color: #585858;'>第"+i+"页</a> ");
					}else {
						sb.append("<a href=\""+url+"currentPage="+i+"\">第"+i+"页</a> ");
					}
				}	
				
			}else {
				
				
				for (int i = 1; i <= pages; i++) {
					//基本情况下, 在总页数比较多的时候, 显示当前页的前后三个, 第四个线程层 省略号
					//但, 如果当前页太靠近前或者后, 就会导致,最前面和最后面没有按钮货省略号显示, 按钮的总量减少
					//我们需要让前后多显示页码来凑足总量
					int num = 3;
					
					if(currentPage<=4) {
						num = num + (5 - currentPage);
					}else if(currentPage>=pages-3) {
						num = num +  4 - (pages - currentPage); //3
					}
					
					/*
					 * if(currentPage==4) { num = 3+1; } if(currentPage==3) { num = 3+2; }
					 * if(currentPage==2) { num = 3+3; } if(currentPage==1) { num = 3+4; }
					 * if(currentPage==pages) { num = 3+4; } if(currentPage==pages-1) { num=3+3; }
					 * if(currentPage==pages-2) { num=3+2; } if(currentPage==pages-3) { num=3+1; }
					 */
					if(currentPage-num<=i&&currentPage+num>=i) {
						if(currentPage==i) {
							sb.append("<a href=\"javascript:void(0)\" style='text-decoration: none;color: #585858;'>第"+i+"页</a> ");
						}else {
							sb.append("<a href=\""+url+"currentPage="+i+"\">第"+i+"页</a> ");
						}
					}else if(currentPage-(num+1)==i||currentPage+(num+1)==i) {
						sb.append("...");
					}
				}
			}
			
			if(currentPage==pages) {
				sb.append("<a href=\"javascript:void(0)\" style='text-decoration: none;color: #585858;'>下一页</a> ");
			}else {
				sb.append("<a href=\""+url+"currentPage="+next+"\">下一页</a> ");
			}
			
			//拼接跳转框
			sb.append("<input id='pageNum' type=\"number\" style='width:40px' value='"+currentPage+"'>");
			sb.append("<button onclick='gogo()'>跳转</button>");
			sb.append("<script>function gogo(){var num = document.getElementById('pageNum').value;location.href='"+url+"currentPage='+num;}</script>");
			
			//拼接总页数
			sb.append(" 总共 "+pages+"页");
		}
		
		return sb.toString();
	}
}
