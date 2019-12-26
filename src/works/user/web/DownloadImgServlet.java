//package works.user.web;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/downloadImg")
//public class DownloadImgServlet extends HttpServlet{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String fileName=req.getParameter("fileName");
//		FileInputStream fis=new FileInputStream("d:\\imgs\\"+fileName);
//		OutputStream os=resp.getOutputStream();
//		//告诉浏览器, 本次动作是下载
//		//非英文的名称会出现乱码问题, 需要我们重新转成网络码 URLEncoder.encode()
//		resp.setHeader("Content-Disposition", "attachment;fileName="+URLEncoder.encode(fileName,"utf-8"));
//		byte[] bs=new byte[8192];
//		int len;
//		while((len=fis.read(bs))!=-1) {
//			os.write(bs, 0, len);
//		}
//		fis.close();
//	}
//	
//
//}
