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

public class queryKeywordRank extends HttpServlet {

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
		String Type = request.getParameter("type");
		String catId=request.getParameter("catId");
		String json=getKeywordRank(catId, Type, Range);
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
	
	public static String getKeywordRank(String catId,String Type,String Range) {
		String key=queryGoodsRank.getkey();
		if(Range==null) {
			Range="1";
		}
		if(Type==null) {
			Type="1";
		}
		if(catId==null) {
			catId="18637";
		}
		if(!Range.equals("1")&&!Range.equals("3")&&!Range.equals("7")&&!Range.equals("15")) {
			int range=Integer.parseInt(Range);
			if(range<3) {
				Range="3";
			}else if(range<7) {
				Range="7";
			}else {
				Range="15";
			}
		}
//		out.println(key);
    	String api="https://mms.pinduoduo.com/pascal/api/unit/keyword/analysis/queryKeywordRank";
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");   
		GregorianCalendar gc=new GregorianCalendar(); 
		gc.setTime(new Date()); 
		gc.add(5,-1);
		String now = sf.format(gc.getTime());
		int date = Integer.parseInt(Range)+1;
		gc.add(5,-date); 
		String last = sf.format(gc.getTime());
		Document doc=null;
		Connection connection=Jsoup.connect(api);
		//Type1 热搜词 Type2 热门长尾词
		String postdata="{\"mallId\":"+queryGoodsRank.getcookie("mallId")+",\"catId\":"+catId+",\"dateRange\":"+Range+",\"beginDate\":\""+"2020-10-14"+"\",\"endDate\":\""+"2020-10-14"+"\",\"keywordRankType\":"+Type+",\"crawlerInfo\":\""+key+"\"}";
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
//			doc = connection.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3741.400 QQBrowser/10.5.3863.400").timeout(50000).ignoreContentType(true).post();
			doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0").timeout(50000).ignoreContentType(true).post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json=doc.body().text();
		return json;
	}
}
