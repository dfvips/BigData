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

import entity.collectwords;
import mybatis.Mapper;
import mybatis.MybatisReader;

public class executedWordTrendstore extends HttpServlet {

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
		String type = request.getParameter("type");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		SqlSession sqlSession=MybatisReader.getSession();
		List<collectwords> list=null;
		if(type==null) {
			type="1";
		}
		if(type.equals("1")) {
			list = sqlSession.getMapper(Mapper.class).getCollectWord(); 
		}else if(type.equals("2")){
			list = sqlSession.getMapper(Mapper.class).getYoungWord();
		}
		sqlSession.commit();
		out.print("{\"status\":200,\"success\":true,\"message\":\"\\u72b6\\u6001\\u6b63\\u5e38\",\"result\":[");
		System.out.print(list.size());
		Integer too = 0;
		Integer fromI = 0;
		if(to==null) {
			too = list.size();
		}else {
			too = Integer.parseInt(to);
		}
		if(from==null) {
			fromI = 0;
		}else {
			fromI = Integer.parseInt(from);
		}
//		for (int i = 0; i < list.size(); i++) {
		for (int i = fromI; i < too; i++) {
//		for (int i = 286; i < list.size(); i++) {
			String word = list.get(i).getWord();
			Integer word_id = list.get(i).getWord_rise_id(); 
			String json=queryKeywordTrend.searchKeywordTrend("60", word, null);
			System.out.println(json);
			JsonObject words=new JsonParser().parse(json).getAsJsonObject();
			JsonArray wordsArray=words.get("result").getAsJsonObject().get("searchTermResult").getAsJsonArray();
			for (int j = 0; j < wordsArray.size(); j++) {
				JsonObject wordObj=wordsArray.get(j).getAsJsonObject();
				Integer pv=wordObj.get("pv").getAsInt();
				Integer clickNum=wordObj.get("clickNum").getAsInt();
				String ctr=wordObj.get("ctr").getAsString();
				String cvr=wordObj.get("cvr").getAsString();
				String competeValue=wordObj.get("competeValue").getAsString();
				String imprAvgBid=wordObj.get("imprAvgBid").getAsString();
				String date=wordObj.get("date").getAsString();
				int num = 1;
				if(type.equals("1")) {
					num = sqlSession.getMapper(Mapper.class).queryWordTrend(word, pv, clickNum, date);
				}else if(type.equals("2")) {
					num = sqlSession.getMapper(Mapper.class).queryYoungTrend(word, pv, clickNum, date);
				}
				if(num==0) {
					try {
						if(type.equals("1")) {
							sqlSession.getMapper(Mapper.class).storewordtrend(word, pv, clickNum, ctr, cvr, competeValue, imprAvgBid, date,word_id);
						}else if(type.equals("2")) {
							sqlSession.getMapper(Mapper.class).storeyoungtrend(word, pv, clickNum, ctr, cvr, competeValue, imprAvgBid, date, word_id);
						}
						sqlSession.commit();
					}catch (Exception e) {
						// TODO: handle exception
						continue;
					}
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
