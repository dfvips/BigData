package servlet;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class queryGoodsRank extends HttpServlet {

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
		String catId = request.getParameter("catId");
		if(Range==null) {
			Range="3";
		}
		if(Type==null) {
			Type="1";
		}
		if (catId==null) {
			catId="18639";
		}
		String json=getGoodRank(catId, Range, Type);
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
	public static String getkey() {
		String api="http://api.dfvips.com/";
		Document doc=null;
		Connection connection=Jsoup.connect(api);
		try {
			//doc = connection.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3741.400 QQBrowser/10.5.3863.400").header("Referer","http://dfvips.com").timeout(50000).ignoreContentType(true).get();
			//doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36").timeout(50000).ignoreContentType(true).header("Referer","http://dfvips.com").timeout(50000).ignoreContentType(true).get();
			doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0").timeout(50000).ignoreContentType(true).header("Referer","http://dfvips.com").timeout(50000).ignoreContentType(true).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json=doc.body().text();
		JsonObject jsonObject=new JsonParser().parse(json).getAsJsonObject();
		String anti_content=jsonObject.get("anti_content").getAsString();
		return anti_content;
	}
	public static String getcookie(String value) {
		String fileName="cookie.properties";
		String filePath = getWebPath(fileName);
		filePath=filePath.replace("\\classes", "");
		Reader myReader;
		String cookie="";
		try {
			myReader = new FileReader(filePath);
	        Properties prop = new Properties();// 创建Properties类
	        prop.load(myReader);// 用Properties类对象加载文件
	        cookie=prop.getProperty(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 读取property文件
		return cookie;
	}
    public static String getWebPath(String fileName) {
        // file:/D:/JavaWeb/.metadata/.me_tcat/webapps/TestBeanUtils/WEB-INF/classes/
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        // 去掉返回路径中各种不需要的东西
        path = path.replace('/', '\\'); // 将/换成\
        path = path.replace("file:", ""); // 去掉file:
        // path = path.replace("classes\\", ""); // 去掉class\
        path = path.substring(1); // 去掉第一个\,如 \D:\JavaWeb...
 
        // 如果有文件名，则在路径上加入文件名
        if (fileName.isEmpty() == false) {
            path += fileName;
        }
        return path.replace("%20", " ");
    }
    
    public static String getGoodRank(String catId,String Range,String Type) {
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
		if(!Type.equals("1")&&!Type.equals("2")) {
			Type="1";
		}
		String key=getkey();
//		out.println(key);
    	String api="https://mms.pinduoduo.com/pascal/api/unit/keyword/analysis/queryGoodsRank";
		Document doc=null;
		Connection connection=Jsoup.connect(api);
		//Type 1 热销排行榜 Type 2  拼团飙升榜
		String postdata=null;
		if(catId==null) {
			postdata = "{\"mallId\":"+queryGoodsRank.getcookie("mallId")+",\"catId\":18637,\"dateRange\":"+Range+",\"goodsRankType\":"+Type+",\"crawlerInfo\":\""+key+"\"}";
		}else {
			postdata = "{\"mallId\":"+queryGoodsRank.getcookie("mallId")+",\"catId\":"+catId+",\"dateRange\":"+Range+",\"goodsRankType\":"+Type+",\"crawlerInfo\":\""+key+"\"}";
		}
		//String postdata=="{\"mallId\":449142915,\"catId\":18637,\"beginDate\":\"2020-08-05\",\"endDate\":\"2020-08-05\",\"dateRange\":1,\"goodsRankType\":2,\"crawlerInfo\":\""+key+"\"}";
		JsonObject data=new JsonParser().parse(postdata).getAsJsonObject();
//		System.out.println(token);
		connection=connection.header("anti-content",key);
//		System.out.println(data);
		connection=connection.requestBody(data.toString());
		connection=connection.header("Referer","https://mms.pinduoduo.com/exp/tools/dataAnalysis");
		connection=connection.header("Origin","https://mms.pinduoduo.com");
		connection=connection.header("Content-Type", "application/json; charset=utf-8");
		connection=connection.header("Cookie", getcookie("pdd"));
		try {
			//doc = connection.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3741.400 QQBrowser/10.5.3863.400").timeout(50000).ignoreContentType(true).post();
			//doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36").timeout(50000).ignoreContentType(true).post();
			doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0").timeout(50000).ignoreContentType(true).post();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json=doc.body().text();
		return json;
    }
}
