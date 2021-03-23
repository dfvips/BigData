package servlet;//搜索词

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Api;
import utils.getCookie;

public class searchWord extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		PrintWriter out = response.getWriter();
//		String type = request.getParameter("type");
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");   
		GregorianCalendar gc=new GregorianCalendar(); 
		gc.setTime(new Date()); 
		gc.add(5,-1);
		String date = sf.format(gc.getTime());
//		int flag = 1;
//		if(type!=null) {
//			flag=Integer.parseInt(type);
//		}else {
//			flag = 1;
//		}
		String json = api(date, 121410035, 121368010);
		out.print(json);
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	public static String api(String date,Integer catId,Integer parentId) {
		String api = "https://sycm.taobao.com/mc/industry/searchWord.json?dateRange="+date+"%7C"+date+"&dateType=day&pageSize=10&page=1&order=desc&orderBy=seIpvUvHits&cateId="+catId+"&device=0&indexCode=hotSearchRank%2CseIpvUvHits%2CclickHits%2CclickRate%2CpayRate&_="+new Date().getTime()+"&token="+getCookie.getcookie("token");
		String referer = "https://sycm.taobao.com/mc/mq/search_rank?activeKey=searchWord&cateFlag=0&cateId="+catId+"&dateRange="+date+"%7C"+date+"&dateType=day&device=0&parentCateId="+parentId+"&spm=a21ag.11815242.LeftMenu.d587.36a950a57Oofm7";
		String sycm_referer = "/mc/mq/search_rank";
		return Api.get(api, referer, sycm_referer);
		
	}

}
