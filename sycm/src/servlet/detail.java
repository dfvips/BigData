package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import utils.Api;
import utils.getCookie;
import utils.getTraceId;

public class detail extends HttpServlet {

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
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		PrintWriter out = response.getWriter();
		String itemId = request.getParameter("itemId");
		if(itemId==null) {
			itemId = "589904724839";
		}
		String json = api(itemId);
		out.print(json);
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
	
	public static String api(String itemId) {
		String sdata = "%7B%22id%22%3A%22"+itemId+"%22%2C%22ali_refid%22%3A%22a3_430406_1007%3A30392848%3AJ%3A7959121852737021697_0_1361066346%3Acab3829f345dbd70c679d098f55b8315%22%2C%22ali_trackid%22%3A%2285_cab3829f345dbd70c679d098f55b8315%22%2C%22spm%22%3A%22a21bo.2017.201874-sales.29%22%2C%22itemNumId%22%3A%22"+itemId+"%22%2C%22itemId%22%3A%22"+itemId+"%22%2C%22exParams%22%3A%22%7B%5C%22id%5C%22%3A%5C%22"+itemId+"%5C%22%2C%5C%22ali_refid%5C%22%3A%5C%22a3_430406_1007%3A30392848%3AJ%3A7959121852737021697_0_1361066346%3Acab3829f345dbd70c679d098f55b8315%5C%22%2C%5C%22ali_trackid%5C%22%3A%5C%2285_cab3829f345dbd70c679d098f55b8315%5C%22%2C%5C%22spm%5C%22%3A%5C%22a21bo.2017.201874-sales.29%5C%22%7D%22%2C%22detail_v%22%3A%228.0.0%22%2C%22utdid%22%3A%221%22%7D";
		String api = "https://h5api.m.taobao.com/h5/mtop.taobao.detail.getdetail/6.0/?jsv=2.6.0&appKey=12574478&t="+new Date().getTime()+"&sign=97ea6c138f920bc758801e89d60f650a&api=mtop.taobao.detail.getdetail&v=6.0&isSec=0&ecode=0&AntiFlood=true&AntiCreep=true&H5Request=true&ttid=2018%40taobao_h5_9.9.9&type=jsonp&dataType=json&data="+sdata;
		String referer = "https://h5.m.taobao.com/awp/core/detail.htm?id="+itemId+"&ali_refid=a3_430406_1007:30392848:J:7959121852737021697_0_1361066346:cab3829f345dbd70c679d098f55b8315&ali_trackid=85_cab3829f345dbd70c679d098f55b8315&spm=a21bo.2017.201874-sales.29";
		String sycm_referer = referer;
		String reString =  Api.get(api, referer, sycm_referer);
//		String getTime = getime(itemId);
		JsonObject json = new JsonObject();
//		String start_time = null;
//		String end_time = null;
		json.addProperty("status", "success");
		json.addProperty("code", 200);
//		if(getTime!=null) {
//			JsonObject timeObj = new JsonParser().parse(getTime).getAsJsonObject();
//			if(timeObj!=null) {
//				start_time = timeObj.get("start_time").getAsString();
//				end_time = timeObj.get("end_time").getAsString();
//			}
//		}
		JsonObject result = new JsonParser().parse(reString).getAsJsonObject();
		String sapi = result.get("api").getAsString();
		String v = result.get("v").getAsString();

//		String sellerId = null;
		JsonArray ret = result.get("ret").getAsJsonArray();
		json.addProperty("api", sapi);
		json.addProperty("v", v);
//		String comment = null;
		if(result!=null) {
			JsonObject data = result.get("data").getAsJsonObject();
			String smockData = null;
			if(data.get("mockData")!=null) {
				smockData = data.get("mockData").getAsString();
				JsonObject mockData = new JsonParser().parse(smockData).getAsJsonObject();
				data.add("mockData", mockData);
			}
			if(data.get("apiStack")!=null) {
				JsonArray apiStack = data.get("apiStack").getAsJsonArray();
				JsonArray newapiStack = new JsonArray();
				for (JsonElement jsonElement : apiStack) {
					JsonObject current = jsonElement.getAsJsonObject();
					String svalue = current.get("value").getAsString();
					JsonObject value = new JsonParser().parse(svalue).getAsJsonObject();
					current.add("value", value);
					newapiStack.add(current);
				}
				data.add("apiStack", newapiStack);
			}
			String desc = getDesc(itemId);
			JsonObject des = new JsonParser().parse(desc).getAsJsonObject();
			data.add("desc", des);
//			if(data.get("seller")!=null) {
//				JsonObject seller = data.get("seller").getAsJsonObject();
//				sellerId = seller.get("userId").getAsString();
//				comment = getcomment(itemId,sellerId,1,false);
//			}
			
//			data.addProperty("upTime", start_time);
//			data.addProperty("downTime", end_time);
//			JsonObject commentObj = new JsonParser().parse(comment).getAsJsonObject();
//			JsonObject rateDetail = commentObj.get("rateDetail").getAsJsonObject();
//			JsonArray rateList  = rateDetail.get("rateList").getAsJsonArray();
//			JsonObject last = rateList.get(rateList.size()-1).getAsJsonObject();
//			String rateDate = last.get("rateDate").getAsString();
//			String dat = null;
//			data.add("comment", commentObj);
//			SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
//			Date date = null;
//			try {
//				date=simdate.parse(rateDate);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			GregorianCalendar gc = new GregorianCalendar();
//			gc.setTime(date);
//			gc.add(5, -3);
//			dat = sf.format(gc.getTime());
//			data.addProperty("upTime", dat);
			json.add("data", data);
		}
		json.add("ret", ret);
		json.addProperty("timestamp", new Date().getTime());
		json.addProperty("description", "Powered By DreamFly.");
		return json.toString();
	}
	
//	public static String getime(String itemId) {
//    	String api="https://api.baimacha.com/BMCModule/BMCFunctionUsingController/getSearchShangxiajia";
//		Document doc=null;
//		String data = "{\"paramValue\":\"https://item.taobao.com/item.htm?id="+itemId+"\"}"; 
//		Connection connection=Jsoup.connect(api);
//		String json = "";
//		connection=connection.header("token","38dd6d3d-4912-402a-9701-909407d23be6");
//		connection=connection.header("Content-Type", "application/json;charset=UTF-8");
//		connection=connection.requestBody(data);
//		try {
//			doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0").timeout(50000).ignoreContentType(true).post();
//			String jsontext = doc.text();
//			System.out.println(jsontext);
//			JsonObject object = new JsonParser().parse(jsontext).getAsJsonObject();
//			JsonElement RetObject = null;
//			if(object.get("RetObject")!=null) {
//				RetObject = object.get("RetObject");
//				JsonObject js = new JsonParser().parse(RetObject.getAsString()).getAsJsonObject();
//				json = js.toString();
//			}else {
//				json = null;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//
//		}
//		return json;
//	}
	
	public static String getcomment(String itemId,String sellerId,Integer page,boolean end) {
    	String api="https://rate.tmall.com/list_detail_rate.htm?itemId="+itemId+"&sellerId="+sellerId+"&currentPage="+page+"&&callback=_DLP_2646_der_3_currentPage_1_pageSize_10_";
		Document doc=null;
		Connection connection=Jsoup.connect(api);
		String json = "";
		connection=connection.header("cookie",getCookie.getcookie("tbcookie"));
		connection=connection.header("referer", "https://detail.m.tmall.com/item.htm?spm=a320p.7692363.0.0.272c3ea8K1rWBL&id="+itemId+"&pic=//img.alicdn.com/bao/uploaded/i4/2207251917954/O1CN01i5GKuc28cyver3IrD_!!0-item_pic.jpg_Q50s50.jpg_.webp&itemTitle=BEST/%E8%93%93%E6%96%AF%E7%8E%AB%E7%91%B0%E6%89%8B%E8%86%9C%E6%8A%A4%E6%89%8B%E6%89%8B%E5%A5%97%E5%AB%A9%E7%99%BD%E4%BF%9D%E6%B9%BF%E8%A1%A5%E6%B0%B4%E5%8E%BB%E6%AD%BB%E7%9A%AE%E8%80%81%E8%8C%A7%E6%89%8B%E9%83%A8%E4%BF%9D%E5%85%BB%E6%8A%A4%E7%90%86&price=98.00&from=h5&skuId=4614088254427");
		try {
			doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0").timeout(50000).ignoreContentType(true).post();
			json = doc.text();
			System.out.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(end==false) {
			return getTraceId.toJson(json);
		}else {
			json = getTraceId.toJson(json);
			JsonObject object = new JsonParser().parse(json).getAsJsonObject();
			JsonObject rateDetail = object.get("rateDetail").getAsJsonObject();
			JsonObject paginator = rateDetail.get("paginator").getAsJsonObject();
			Integer lastPage = paginator.get("lastPage").getAsInt();
			json = getcomment(itemId,sellerId,lastPage,true);
			return json;
		}
	}
	
	public static String getDesc(String itemId) {
	String api = "https://h5api.m.taobao.com/h5/mtop.taobao.detail.getdesc/6.0/?data=%7b%22id%22%3a%22"+itemId+"%22%2c%22type%22%3a%220%22%7d";
	Document doc=null;
	Connection connection=Jsoup.connect(api);
	String json = "";
	connection=connection.header("referer", "https://detail.m.tmall.com/item.htm?id="+itemId);
	try {
		doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0").timeout(50000).ignoreContentType(true).get();
		json = doc.text();
		System.out.println(json);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return json;
}
	
//	public static String getImgInfo(String itemId) {
//		String api = "https://tds.alicdn.com/json/item_imgs.htm?cb=jsonp_image_info&t=TB175vQWxv1gK0jSZFFXXb0sXXa&sid=2089352068&id="+itemId+"&s=44e2c9b9da31edac70fcb605bda057b1&v=2&m=1";
//		Document doc=null;
//		Connection connection=Jsoup.connect(api);
//		String json = "";
//		connection=connection.header("referer", "https://detail.m.tmall.com/item.htm?id=611149431505");
//		try {
//			doc = connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0").timeout(50000).ignoreContentType(true).get();
//			json = doc.text();
//			json = getTraceId.toJson(json);
//			System.out.println(json);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return json;
//	}
	
//	public static String api(String itemId,boolean flag) {
//		String api = "https://acs.m.taobao.com/h5/mtop.taobao.detail.getdetail/6.0/?data=%7B%22itemNumId%22%3A%22"+itemId+"%22%7D";
//		System.out.println(api);
//		String referer = "https://h5.m.taobao.com/awp/core/detail.htm?id="+itemId+"&ali_refid=a3_430406_1007:30392848:J:7959121852737021697_0_1361066346:cab3829f345dbd70c679d098f55b8315&ali_trackid=85_cab3829f345dbd70c679d098f55b8315&spm=a21bo.2017.201874-sales.29";
//		String sycm_referer = referer;
//		String reString =  Api.get(api, referer, sycm_referer);
//		System.out.println(reString);
//		JsonObject json = new JsonParser().parse(reString).getAsJsonObject();
//		json.addProperty("status", "success");
//		json.addProperty("code", 200);
//		json.addProperty("timestamp", new Date().getTime());
//		json.addProperty("description", "Powered By DreamFly.");
//		return json.toString();
//	}
}
