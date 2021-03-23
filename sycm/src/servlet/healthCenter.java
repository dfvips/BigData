package servlet;//违规检测

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import utils.Api;
import utils.unicode;

public class healthCenter extends HttpServlet {

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
		String json = api();
//		String json = "{\"msg\":\"success\",\"total\":4,\"code\":\"SUCCESS\",\"success\":true,\"module\":[{\"entityType\":\"USER\",\"punishStatus\":\"DONE\",\"isRead\":false,\"entityId\":641275372,\"sellerIdentity\":\"TAOBAO\",\"isNew\":false,\"recordId\":320989,\"sellerId\":641275372,\"recordStatus\":\"DONE\",\"punishTime\":1601254624000,\"pointRange\":\"SERIOUS\",\"ruleType\":\"不当获取使用信息\",\"punishPoint\":0,\"pointRangeName\":\"严重违规\",\"sellerIdentityName\":\"淘宝\",\"punishId\":17783769229},{\"entityType\":\"USER\",\"punishStatus\":\"DONE\",\"isRead\":false,\"entityId\":641275372,\"sellerIdentity\":\"TAOBAO\",\"isNew\":false,\"recordId\":305336,\"sellerId\":641275372,\"recordStatus\":\"DONE\",\"punishTime\":1594475712000,\"pointRange\":\"NORMAL\",\"ruleType\":\"违背承诺\",\"punishPoint\":0,\"pointRangeName\":\"一般违规\",\"sellerIdentityName\":\"淘宝\",\"punishId\":16885728210},{\"entityType\":\"ITEM\",\"punishStatus\":\"DONE\",\"isRead\":false,\"entityId\":539697154724,\"sellerIdentity\":\"TAOBAO\",\"isNew\":false,\"recordId\":166645,\"sellerId\":641275372,\"recordStatus\":\"DONE\",\"punishTime\":1561614207000,\"pointRange\":\"MARKET\",\"ruleType\":\"闲鱼管理规则\",\"punishPoint\":0,\"pointRangeName\":\"市场管理\",\"sellerIdentityName\":\"淘宝\",\"punishId\":14629045309},{\"entityType\":\"USER\",\"punishStatus\":\"DONE\",\"isRead\":false,\"entityId\":641275372,\"sellerIdentity\":\"TAOBAO\",\"isNew\":false,\"recordId\":167771,\"sellerId\":641275372,\"recordStatus\":\"DONE\",\"punishTime\":1559548500000,\"pointRange\":\"NORMAL\",\"ruleType\":\"虚假交易\",\"punishPoint\":2,\"pointRangeName\":\"一般违规\",\"sellerIdentityName\":\"淘宝\",\"punishId\":14465127763}],\"count\":4,\"list\":[{\"entityType\":\"USER\",\"punishStatus\":\"DONE\",\"isRead\":false,\"entityId\":641275372,\"sellerIdentity\":\"TAOBAO\",\"isNew\":false,\"recordId\":320989,\"sellerId\":641275372,\"recordStatus\":\"DONE\",\"punishTime\":1601254624000,\"pointRange\":\"SERIOUS\",\"ruleType\":\"不当获取使用信息\",\"punishPoint\":0,\"pointRangeName\":\"严重违规\",\"sellerIdentityName\":\"淘宝\",\"punishId\":17783769229},{\"entityType\":\"USER\",\"punishStatus\":\"DONE\",\"isRead\":false,\"entityId\":641275372,\"sellerIdentity\":\"TAOBAO\",\"isNew\":false,\"recordId\":305336,\"sellerId\":641275372,\"recordStatus\":\"DONE\",\"punishTime\":1594475712000,\"pointRange\":\"NORMAL\",\"ruleType\":\"违背承诺\",\"punishPoint\":0,\"pointRangeName\":\"一般违规\",\"sellerIdentityName\":\"淘宝\",\"punishId\":16885728210},{\"entityType\":\"ITEM\",\"punishStatus\":\"DONE\",\"isRead\":false,\"entityId\":539697154724,\"sellerIdentity\":\"TAOBAO\",\"isNew\":false,\"recordId\":166645,\"sellerId\":641275372,\"recordStatus\":\"DONE\",\"punishTime\":1561614207000,\"pointRange\":\"MARKET\",\"ruleType\":\"闲鱼管理规则\",\"punishPoint\":0,\"pointRangeName\":\"市场管理\",\"sellerIdentityName\":\"淘宝\",\"punishId\":14629045309},{\"entityType\":\"USER\",\"punishStatus\":\"DONE\",\"isRead\":false,\"entityId\":641275372,\"sellerIdentity\":\"TAOBAO\",\"isNew\":false,\"recordId\":167771,\"sellerId\":641275372,\"recordStatus\":\"DONE\",\"punishTime\":1559548500000,\"pointRange\":\"NORMAL\",\"ruleType\":\"虚假交易\",\"punishPoint\":2,\"pointRangeName\":\"一般违规\",\"sellerIdentityName\":\"淘宝\",\"punishId\":14465127763}],\"msgInfo\":\"success\",\"msgCode\":\"SUCCESS\",\"empty\":false}";
		JsonElement resultdata = new JsonParser().parse(json);
		JsonObject result = new JsonObject();
		result.addProperty("status", 200);
		result.addProperty("success", true);
		result.addProperty("message", unicode.toUnicode("状态正常"));
		result.add("result", resultdata);
		if (resultdata.getAsJsonObject().get("list") != null) {
			if (resultdata.getAsJsonObject().get("list").getAsJsonArray().size() == 0) {
				result.addProperty("diag", unicode.toUnicode("账号正常,无违规"));
			} else {
				JsonArray list = resultdata.getAsJsonObject().get("list").getAsJsonArray();
				JsonArray module = resultdata.getAsJsonObject().get("module").getAsJsonArray();
				JsonArray nlist = new JsonArray();
				JsonArray nmodule = new JsonArray();
				for (int i = 0; i < module.size(); i++) {
					JsonObject current = module.get(i).getAsJsonObject();
					long punishTime = current.get("punishTime").getAsLong();
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String punishDate = sf.format(punishTime);
					current.addProperty("punishDate", punishDate);
					nmodule.add(current);
				}
				for (int i = 0; i < list.size(); i++) {
					JsonObject current = list.get(i).getAsJsonObject();
					long punishTime = current.get("punishTime").getAsLong();
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String punishDate = sf.format(punishTime);
					current.addProperty("punishDate", punishDate);
					nlist.add(current);
				}
				JsonObject results = resultdata.getAsJsonObject();
				results.add("list", nlist);
				results.add("module", nmodule);
				result.add("result", results);
			}
		}
		result.addProperty("timestamp", new Date().getTime());
		result.addProperty("description", "Powered By DreamFly.");
		String res = unicode.handtxt(result);
		out.print(res);
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

	public static String api() {
		String api = "https://healthcenter2.taobao.com/punish/record/list.json?page=1&pageSize=20";
		String referer = "https://healthcenter.taobao.com/home/health_home.htm?spm=a211vu.server-web-home.todowidget.6.64f02d58BOVGlb";
		String sycm_referer = "https://healthcenter.taobao.com/home/health_home.htm?spm=a211vu.server-web-home.todowidget.6.64f02d58BOVGlb";
		return Api.get(api, referer, sycm_referer);
	}

}
