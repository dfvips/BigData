package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.cate;
import service.service;
import service.service_make;
import utils.random;

public class storeOverview extends HttpServlet {

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
		String rangestr = request.getParameter("range");
		Integer range = 0;
		if(rangestr == null) {
			range = 1;
		}else {
			Pattern pattern = Pattern.compile("^[1-9]\\d*$");
			Matcher isNum = pattern.matcher(rangestr);
			if(isNum.matches()==false) {
				range = 1;
			}else {
				range = Integer.parseInt(rangestr);
			}
		}
		PrintWriter out = response.getWriter();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(5, -range);
		String date = sf.format(gc.getTime());
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GregorianCalendar gc1 = new GregorianCalendar();
		gc1.setTime(new Date());
		gc1.add(5, 0);
		String crawl_time = sf1.format(gc1.getTime());
		String type = request.getParameter("type");
		if(type == null||(!type.equals("1")&&!type.equals("2"))) {
			type = "1";
		}
		List<cate> list = null;
		if(type.equals("1")) {
			list = service.searchAllCateInfo();
		}else {
			list = service_make.searchAllCateInfo();
		}
		int flag = 0;
		for (int i = 0; i < list.size(); i++) {
			cate cate = list.get(i);
			Integer catId = cate.getCat_id();
			Integer parentId = cate.getCat_parent();
			if (parentId.equals(-1)) {
				if(type.equals("1")) {
					parentId = 1801;
				}else {
					parentId = 50010788;
				}
			}
			String json = overview.api(date, catId, parentId);
			JsonElement obj = new JsonParser().parse(json).getAsJsonObject().get("data");
			if (obj != null) {
				JsonObject data = obj.getAsJsonObject();
				String seIpv_uv_hits = null;
				String se_pv_index = null;
				String uv = null;
				String pv = null;
				String clt_byr_cnt = null;
				String clt_times = null;
				String cart_byr_cnt = null;
				String cart_times = null;
				String pay_byr_cnt_index = null;
				String trade_index = null;
				String seIpv_uv_hits_crc = null;
				String se_pv_index_crc = null;
				String uv_crc = null;
				String pv_crc = null;
				String clt_byr_cnt_crc = null;
				String clt_times_crc = null;
				String cart_byr_cnt_crc = null;
				String cart_times_crc = null;
				String pay_byr_cnt_index_crc = null;
				String trade_index_crc = null;
				if (data.get("seIpvUvHits") != null) {
					seIpv_uv_hits = data.get("seIpvUvHits").getAsJsonObject().get("value").toString();
					if (data.get("seIpvUvHits").getAsJsonObject().get("cycleCrc") != null) {
						seIpv_uv_hits_crc = data.get("seIpvUvHits").getAsJsonObject().get("cycleCrc").toString();
					}
				}
				if (data.get("sePvIndex") != null) {
					se_pv_index = data.get("sePvIndex").getAsJsonObject().get("value").toString();
					if (data.get("sePvIndex").getAsJsonObject().get("cycleCrc") != null) {
						se_pv_index_crc = data.get("sePvIndex").getAsJsonObject().get("cycleCrc").toString();
					}
				}
				if (data.get("uvHits") != null) {
					uv = data.get("uvHits").getAsJsonObject().get("value").toString();
					if (data.get("uvHits").getAsJsonObject().get("cycleCrc") != null) {
						uv_crc = data.get("uvHits").getAsJsonObject().get("cycleCrc").toString();
					}
				}
				if (data.get("pvHot") != null) {
					pv = data.get("pvHot").getAsJsonObject().get("value").toString();
					if (data.get("pvHot").getAsJsonObject().get("cycleCrc") != null) {
						pv_crc = data.get("pvHot").getAsJsonObject().get("cycleCrc").toString();
					}
				}
				if (data.get("cltHot") != null) {
					clt_byr_cnt = data.get("cltHot").getAsJsonObject().get("value").toString();
					if (data.get("cltHot").getAsJsonObject().get("cycleCrc") != null) {
						clt_byr_cnt_crc = data.get("cltHot").getAsJsonObject().get("cycleCrc").toString();
					}
				}
				if (data.get("cltHits") != null) {
					clt_times = data.get("cltHits").getAsJsonObject().get("value").toString();
					if (data.get("cltHits").getAsJsonObject().get("cycleCrc") != null) {
						clt_times_crc = data.get("cltHits").getAsJsonObject().get("cycleCrc").toString();
					}
				}
				if (data.get("cartHot") != null) {
					cart_byr_cnt = data.get("cartHot").getAsJsonObject().get("value").toString();
					if (data.get("cartHot").getAsJsonObject().get("cycleCrc") != null) {
						cart_byr_cnt_crc = data.get("cartHot").getAsJsonObject().get("cycleCrc").toString();
					}
				}
				if (data.get("cartHits") != null) {
					cart_times = data.get("cartHits").getAsJsonObject().get("value").toString();
					if (data.get("cartHits").getAsJsonObject().get("cycleCrc") != null) {
						cart_times_crc = data.get("cartHits").getAsJsonObject().get("cycleCrc").toString();
					}
				}
				if (data.get("payByrCntIndex") != null) {
					pay_byr_cnt_index = data.get("payByrCntIndex").getAsJsonObject().get("value").toString();
					if (data.get("payByrCntIndex").getAsJsonObject().get("cycleCrc") != null) {
						pay_byr_cnt_index_crc = data.get("payByrCntIndex").getAsJsonObject().get("cycleCrc").toString();
					}
				}
				if (data.get("tradeIndex") != null) {
					trade_index = data.get("tradeIndex").getAsJsonObject().get("value").toString();
					if (data.get("tradeIndex").getAsJsonObject().get("cycleCrc") != null) {
						trade_index_crc = data.get("tradeIndex").getAsJsonObject().get("cycleCrc").toString();
					}
				}

				int num = 0;
				if(type.equals("1")) {
					num = service.fillOverview(catId, seIpv_uv_hits, se_pv_index, uv, pv, clt_byr_cnt, clt_times,
							cart_byr_cnt, cart_times, pay_byr_cnt_index, trade_index, seIpv_uv_hits_crc, se_pv_index_crc,
							uv_crc, pv_crc, clt_byr_cnt_crc, clt_times_crc, cart_byr_cnt_crc, cart_times_crc,
							pay_byr_cnt_index_crc, trade_index_crc, date, crawl_time);
				}else {
					num = service_make.fillOverview(catId, seIpv_uv_hits, se_pv_index, uv, pv, clt_byr_cnt, clt_times,
							cart_byr_cnt, cart_times, pay_byr_cnt_index, trade_index, seIpv_uv_hits_crc, se_pv_index_crc,
							uv_crc, pv_crc, clt_byr_cnt_crc, clt_times_crc, cart_byr_cnt_crc, cart_times_crc,
							pay_byr_cnt_index_crc, trade_index_crc, date, crawl_time);
				}
				if (num != 1) {
					System.out.println(catId + " : " + "error");
				}
//				System.out.println(json);
				if (!(flag == 0)) {
					json = "," + json;
				};
				if(flag == 0){
					out.print("{\"status\":200,\"success\":true,\"message\":\"\\u72b6\\u6001\\u6b63\\u5e38\",\"updateTime\":\""+date+"\",\"result\":[");
				}
				out.print(json);
			} else {
				out.print("{\"status\":200,\"success\":true,\"message\":\"\\u72b6\\u6001\\u5f02\\u5e38\",\"updateTime\":\""+date+"\",\"result\":[");
				out.print(json);
				break;
			}
			flag++;
			if (i < list.size() - 1) {
				try {
					Integer time = random.getDelay();
					Thread.currentThread();
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("执行存储完毕");
			}
		}
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
