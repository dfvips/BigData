package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
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

public class executedWordstore extends HttpServlet {

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
		String type=request.getParameter("type");
		if (type==null||(!type.equals("1")&&!type.equals("2"))) {
			type="1";
		}
		SqlSession sqlSession=MybatisReader.getSession();
		List<categoryinfo> list=sqlSession.getMapper(Mapper.class).searchCategoryInfo();
		sqlSession.commit();
		
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");   
		GregorianCalendar gc=new GregorianCalendar(); 
		gc.setTime(new Date()); 
		gc.add(5,-1);
		String date = sf.format(gc.getTime());
		out.print("{\"status\":200,\"success\":true,\"message\":\"\\u72b6\\u6001\\u6b63\\u5e38\",\"result\":[");
		for (int i = 0; i < list.size(); i++) {
			String catId1=list.get(i).getcat_id().toString();
			String catName=list.get(i).getcat_name();
			String json=queryKeywordRank.getKeywordRank(catId1, type, "1");
			System.out.println(json);
			JsonObject words=new JsonParser().parse(json).getAsJsonObject();
			JsonArray wordsArray=words.get("result").getAsJsonArray();
			for (int j = 0; j < wordsArray.size(); j++) {
				JsonObject wordObj=wordsArray.get(j).getAsJsonObject();
				Integer catId=Integer.parseInt(catId1);
				Integer pv=wordObj.get("pv").getAsInt();
				Integer clickNum=wordObj.get("clickNum").getAsInt();
				String ctr=wordObj.get("ctr").getAsString();
				String cvr=wordObj.get("cvr").getAsString();
				Integer competeValue=wordObj.get("competeValue").getAsInt();
				String imprAvgBid=wordObj.get("imprAvgBid").getAsString();
				String word=wordObj.get("word").getAsString();
				
				if(type.equals("1")) {
//					int num = sqlSession.getMapper(Mapper.class).queryhotword(pv, clickNum, ctr, cvr, competeValue, imprAvgBid, word, catId);
//					if(num==0) {
						try {
							sqlSession.getMapper(Mapper.class).storehotwords(pv, clickNum, ctr, cvr, competeValue, imprAvgBid, word, catId, catName,date);
							sqlSession.commit();
						}catch (Exception e) {
							// TODO: handle exception
							continue;
						}
//					}
				}else {
//					int num = sqlSession.getMapper(Mapper.class).queryhotlongtailedwords(pv, clickNum, ctr, cvr, competeValue, imprAvgBid, word, catId);
//					if (num==0) {
						try {
							sqlSession.getMapper(Mapper.class).storehotlongtailedwords(pv, clickNum, ctr, cvr, competeValue, imprAvgBid, word, catId, catName,date);
							sqlSession.commit();
						}catch (Exception e) {
							// TODO: handle exception
							continue;
						}
//					}
				}
				String res="";
				if(!(i==0&&j==0)) {
					res+=",";
				}
				res+="{\"word\":\""+word+"\",\"clickNum\":"+clickNum+",\"competeValue\":"+competeValue+",\"timestamp\":"+new Date().getTime()+"}";
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
