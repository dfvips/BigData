package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class queryKeywordTrend extends HttpServlet {

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
		response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
		PrintWriter out = response.getWriter();
		String Range = request.getParameter("range");
		String searchTerm = request.getParameter("searchTerm");
		String comparedTerm = request.getParameter("comparedTerm");
//		out.println(key);
    	String json = searchKeywordTrend(Range, searchTerm, comparedTerm);
		out.println(json);
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
	
	public static String searchKeywordTrend(String Range,String searchTerm,String comparedTerm) {
		String key=queryGoodsRank.getkey();
//		out.println(key);
    	String api="https://mms.pinduoduo.com/pascal/api/unit/keyword/analysis/queryKeywordTrend";
		Document doc=null;
		Connection connection=Jsoup.connect(api);
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");   
		GregorianCalendar gc=new GregorianCalendar(); 
		gc.setTime(new Date()); 
		gc.add(5,-1);
		String now = sf.format(gc.getTime());
		int date = Integer.parseInt(Range)+1;
		gc.add(5,-date); 
		String last = sf.format(gc.getTime());
		String postdata=null;
		if(comparedTerm==null) {
			postdata="{\"mallId\":"+queryGoodsRank.getcookie("mallId")+",\"searchTerm\":\""+searchTerm+"\",\"beginDate\":\""+last+"\",\"endDate\":\""+now+"\",\"crawlerInfo\":\""+key+"\"}";
		}else {
			postdata="{\"mallId\":"+queryGoodsRank.getcookie("mallId")+",\"comparedTerm\":\""+comparedTerm+"\",\"searchTerm\":\""+searchTerm+"\",\"beginDate\":\""+last+"\",\"endDate\":\""+now+"\",\"crawlerInfo\":\""+key+"\"}";
		}
		JsonObject data=new JsonParser().parse(postdata).getAsJsonObject();
//		System.out.println(token);
		connection=connection.header("anti-content",key);
//		System.out.println(data);
		connection=connection.requestBody(data.toString());
		connection=connection.header("Referer","https://mms.pinduoduo.com/exp/tools/dataAnalysis");
		connection=connection.header("Origin","https://mms.pinduoduo.com");
		connection=connection.header("Content-Type", "application/json; charset=utf-8");
		connection=connection.header("Cookie", queryGoodsRank.getcookie("pdd"));
		try {
			doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0").timeout(50000).ignoreContentType(true).post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json=doc.body().text();
		return json;
	}
}
