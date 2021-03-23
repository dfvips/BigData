package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class queryCategoryInfo extends HttpServlet {

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
		String catId=request.getParameter("catId");
//		System.out.println(catId);
//		out.println(key);
    	String json = getCategoryInfo(catId);
    	JsonObject resdata=new JsonParser().parse(json).getAsJsonObject();
    	JsonObject res=new JsonObject();
    	JsonObject result=new JsonObject();
    	JsonArray catasArray=new JsonArray();
        res.addProperty("success", true);
        res.addProperty("errorCode", 1000);
        res.addProperty("errorMsg", "null");
        result.addProperty("mallId", 545532881);
    	JsonArray catInfoList=resdata.get("result").getAsJsonObject().get("catInfoList").getAsJsonArray();
    	for (int i = 0; i < catInfoList.size(); i++) {
    		String level = catInfoList.get(0).getAsJsonObject().get("level").getAsString(); 
    		JsonObject catInfo2=new JsonObject();
			if(level.equals("2")) {
				String id=catInfoList.get(i).getAsJsonObject().get("id").getAsString(); 
				String catName=catInfoList.get(i).getAsJsonObject().get("catName").getAsString(); 
				level = catInfoList.get(i).getAsJsonObject().get("level").getAsString(); 
				catInfo2.addProperty("id", id);
				catInfo2.addProperty("catName", catName);
				catInfo2.addProperty("level", level);
				String catInfo3Json=getCategoryInfo(id);
				JsonObject catInfo3base=new JsonParser().parse(catInfo3Json).getAsJsonObject();
//				System.out.println(catInfo3base);
				JsonArray catInfoList3=catInfo3base.get("result").getAsJsonObject().get("catInfoList").getAsJsonArray();
				JsonArray catArray3=new JsonArray();
				for (int j = 0; j < catInfoList3.size(); j++) {
					JsonObject catInfo3=new JsonObject();
					String id3=catInfoList3.get(j).getAsJsonObject().get("id").getAsString(); 
					String catName3=catInfoList3.get(j).getAsJsonObject().get("catName").getAsString(); 
					String level3 = catInfoList3.get(j).getAsJsonObject().get("level").getAsString(); 
					catInfo3.addProperty("id", id3);
					catInfo3.addProperty("catName", catName3);
					catInfo3.addProperty("level", level3);
					catArray3.add(catInfo3);
				}
				catInfo2.add("Children", catArray3);
				catasArray.add(catInfo2);
		        result.add("catInfoList", catasArray);
		        res.add("result", result);
		        json = res.toString();
			}else {
				break;
			}
		}
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
	
	public static String getCategoryInfo(String catId) {
		String api="https://mms.pinduoduo.com/pascal/api/unit/keyword/analysis/queryCategoryInfo";
		String key=queryGoodsRank.getkey();
		Document doc=null;
		Connection connection=Jsoup.connect(api);
		String postdata=null;
		if(catId==null) {
			postdata="{\"mallId\":"+queryGoodsRank.getcookie("mallId")+",\"cat1Id\":7639,\"crawlerInfo\":\""+key+"\"}";
		}else {
			postdata="{\"mallId\":"+queryGoodsRank.getcookie("mallId")+",\"cat1Id\":7639,\"cat2Id\":"+catId+",\"crawlerInfo\":\""+key+"\"}";
		}
		JsonObject data=new JsonParser().parse(postdata).getAsJsonObject();
//		System.out.println(token);
		connection=connection.header("anti-content",key);
		System.out.println(data);
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
