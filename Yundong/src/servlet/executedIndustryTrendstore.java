package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.categoryinfo;
import mybatis.Mapper;
import mybatis.MybatisReader;

public class executedIndustryTrendstore extends HttpServlet {

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

		SqlSession sqlSession=MybatisReader.getSession();
		List<categoryinfo> list=sqlSession.getMapper(Mapper.class).searchCategoryInfo();
		sqlSession.commit();
		out.print("{\"status\":200,\"success\":true,\"message\":\"\\u72b6\\u6001\\u6b63\\u5e38\",\"result\":[");
		for (int i = 0; i < list.size(); i++) {
			Integer catId=list.get(i).getcat_id();
			String catName=list.get(i).getcat_name();
			String json=queryIndustryTrend.getIndustryTrend("120", catId.toString());
			JsonObject trends=new JsonParser().parse(json).getAsJsonObject();
			JsonArray trendsArray=trends.get("result").getAsJsonArray();
			for (int j = 0; j < trendsArray.size(); j++) {
				JsonObject trend = trendsArray.get(j).getAsJsonObject();
				String date = trend.get("date").getAsString();
				Integer visitorNum = trend.get("visitorNum").getAsInt();
				Integer searchNum = trend.get("searchNum").getAsInt();
				Integer clickNum = trend.get("clickNum").getAsInt();
				int num = sqlSession.getMapper(Mapper.class).queryIndustrytrend(visitorNum, searchNum, clickNum, date, catId);
				if(num==0) {
					sqlSession.getMapper(Mapper.class).storeIndustrytrend(visitorNum, searchNum, clickNum, date, catId, catName);
					sqlSession.commit();
				}
				String res="";
				if(!(i==0&&j==0)) {
					res+=",";
				}
				res+="{\"date\":\""+date+"\",\"visitorNum\":"+visitorNum+",\"searchNum\":"+searchNum+",\"clickNum\":"+clickNum+",\"timestamp\":"+new Date().getTime()+"}";
				out.print(res);
			}
		}
		sqlSession.close();	
		out.print("],\"timestamp\":"+new Date().getTime()+",\"description\":\"Powered By DreamFly.\"}");
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

}
