package servlet;//高意向

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

public class hotpurpose extends HttpServlet {

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
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");   
		GregorianCalendar gc=new GregorianCalendar(); 
		gc.setTime(new Date()); 
		gc.add(5,-1);
		String date = sf.format(gc.getTime());
		String json = api(date, 121408011, 121390006);
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
		String api = "https://sycm.taobao.com/mc/mq/mkt/rank/item/hotpurpose.json?dateRange="+date+"%7C"+date+"&dateType=day&pageSize=10&page=1&order=desc&orderBy=cartHits&cateId="+catId+"&device=0&sellerType=-1&indexCode=cltHits%2CcartHits%2CtradeIndex&_="+new Date().getTime()+"&token="+getCookie.getcookie("token");
		String referer = "https://sycm.taobao.com/mc/mq/market_rank?activeKey=item&cateFlag=0&cateId="+catId+"&dateRange="+date+"%7C"+date+"&dateType=day&device=0&parentCateId="+parentId+"&sellerType=-1&spm=a21ag.11815242.LeftMenu.d591.3a3450a56LhtO2";
		String sycm_referer = "/mc/mq/market_rank";
		return Api.get(api, referer, sycm_referer);
	}

}
