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

public class executedHotwords extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		PrintWriter out = response.getWriter();
		SqlSession sqlSession = MybatisReader.getSession();
		List<categoryinfo> list = sqlSession.getMapper(Mapper.class).searchCategoryInfo();
		sqlSession.commit();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(5, -1);
		String date = sf.format(gc.getTime());
		out.print("{\"status\":200,\"success\":true,\"message\":\"\\u72b6\\u6001\\u6b63\\u5e38\",\"result\":[");
		for (int i = 0; i < list.size(); i++) {
			String catId = list.get(i).getcat_id().toString();
			Integer catid = Integer.parseInt(catId);
			String catIdParent = list.get(i).getparent_cat_id().toString();
			String catName = list.get(i).getcat_name();
			String json = queryHotWordCateListByLvl.getHotWords(catId, catIdParent);
			System.out.println(json);
			JsonObject words = new JsonParser().parse(json).getAsJsonObject();
			JsonObject wordsObj = words.get("result").getAsJsonObject();
			if (wordsObj.get("items").toString().contains("null") == false) {
				JsonArray wordsArray = wordsObj.get("items").getAsJsonArray();
				for (int j = 0; j < wordsArray.size(); j++) {
					JsonObject wordObj = wordsArray.get(j).getAsJsonObject();
					Integer heat = wordObj.get("heat").getAsInt();
					String query = wordObj.get("query").getAsString();
//					int num = sqlSession.getMapper(Mapper.class).querywords(heat, query, catid);
//					if (num == 0) {
						try {
							sqlSession.getMapper(Mapper.class).storeallhotword(heat, query, date, catid, catName);
							sqlSession.commit();
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						String res = "";
						if (!(i == 0 && j == 0)) {
							res += ",";
						}
						res += "{\"heat\":\"" + heat + "\",\"query\":\"" + query + "\",\"timestamp\":"
								+ new Date().getTime() + "}";
						out.print(res);
//					}
				}
			}
		}
		sqlSession.close();
		out.print("],\"timestamp\":" + new Date().getTime() + ",\"description\":\"Powered By DreamFly.\"}");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
