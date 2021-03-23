package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.IndustryTrend;
import entity.categoryinfo;
import entity.collectwords;
import entity.goods;
import entity.hotwords;
import mybatis.Mapper;
import mybatis.MybatisReader;
import service.service;

public class Test01 {
	@Test
	public void test() {
		// TODO Auto-generated method stub
		SqlSession sqlSession=MybatisReader.getSession();
		
//		//从queryCategoryInfo获取
		String json="{\"success\":true,\"errorCode\":1000,\"errorMsg\":\"null\",\"result\":{\"mallId\":545532881,\"catInfoList\":[{\"id\":\"7640\",\"catName\":\"汽车零配件\",\"level\":\"2\",\"Children\":[{\"id\":\"7818\",\"catName\":\"安全带及调节器\",\"level\":\"3\"},{\"id\":\"7820\",\"catName\":\"变速箱系统\",\"level\":\"3\"},{\"id\":\"7821\",\"catName\":\"车底防护板/发动机挡板\",\"level\":\"3\"},{\"id\":\"7822\",\"catName\":\"车顶架\",\"level\":\"3\"},{\"id\":\"7823\",\"catName\":\"车用附件\",\"level\":\"3\"},{\"id\":\"7824\",\"catName\":\"乘用车轮胎\",\"level\":\"3\"},{\"id\":\"7825\",\"catName\":\"挡泥板\",\"level\":\"3\"},{\"id\":\"7826\",\"catName\":\"点火系统\",\"level\":\"3\"},{\"id\":\"7827\",\"catName\":\"电气系统\",\"level\":\"3\"},{\"id\":\"7828\",\"catName\":\"动力系统\",\"level\":\"3\"},{\"id\":\"7829\",\"catName\":\"防盗系统\",\"level\":\"3\"},{\"id\":\"7830\",\"catName\":\"非乘用车轮胎\",\"level\":\"3\"},{\"id\":\"7831\",\"catName\":\"隔音隔热棉\",\"level\":\"3\"},{\"id\":\"7832\",\"catName\":\"供油系统\",\"level\":\"3\"},{\"id\":\"7833\",\"catName\":\"进排气系统\",\"level\":\"3\"},{\"id\":\"7834\",\"catName\":\"冷却系统\",\"level\":\"3\"},{\"id\":\"7835\",\"catName\":\"轮毂\",\"level\":\"3\"},{\"id\":\"7836\",\"catName\":\"轮眉\",\"level\":\"3\"},{\"id\":\"7837\",\"catName\":\"滤芯\",\"level\":\"3\"},{\"id\":\"7838\",\"catName\":\"内饰系统\",\"level\":\"3\"},{\"id\":\"7839\",\"catName\":\"其他汽车配件\",\"level\":\"3\"},{\"id\":\"7840\",\"catName\":\"外观件\",\"level\":\"3\"},{\"id\":\"7841\",\"catName\":\"尾翼/顶翼\",\"level\":\"3\"},{\"id\":\"7842\",\"catName\":\"悬挂系统\",\"level\":\"3\"},{\"id\":\"7843\",\"catName\":\"油品\",\"level\":\"3\"},{\"id\":\"7844\",\"catName\":\"雨挡\",\"level\":\"3\"},{\"id\":\"7845\",\"catName\":\"雨刮器\",\"level\":\"3\"},{\"id\":\"7846\",\"catName\":\"照明系统\",\"level\":\"3\"},{\"id\":\"7847\",\"catName\":\"制动系统\",\"level\":\"3\"},{\"id\":\"7848\",\"catName\":\"转向系统\",\"level\":\"3\"}]},{\"id\":\"7641\",\"catName\":\"汽车美容/保养/维修\",\"level\":\"2\",\"Children\":[{\"id\":\"7849\",\"catName\":\"其它美容/保养/维修品\",\"level\":\"3\"},{\"id\":\"7850\",\"catName\":\"汽车美容漆/膜/蜡工具\",\"level\":\"3\"},{\"id\":\"7851\",\"catName\":\"汽车添加剂\",\"level\":\"3\"},{\"id\":\"7852\",\"catName\":\"汽车维修/工具\",\"level\":\"3\"},{\"id\":\"7853\",\"catName\":\"汽车养护品\",\"level\":\"3\"},{\"id\":\"20113\",\"catName\":\"补漆工具\",\"level\":\"3\"}]},{\"id\":\"7645\",\"catName\":\"汽车外饰品/加装装潢/防护\",\"level\":\"2\",\"Children\":[{\"id\":\"7854\",\"catName\":\"加装/装潢\",\"level\":\"3\"},{\"id\":\"7855\",\"catName\":\"其它加装/外饰/防护品\",\"level\":\"3\"},{\"id\":\"7856\",\"catName\":\"汽车防护\",\"level\":\"3\"},{\"id\":\"7857\",\"catName\":\"汽车外饰品\",\"level\":\"3\"}]},{\"id\":\"7646\",\"catName\":\"汽车影音/车用电子/电器\",\"level\":\"2\",\"Children\":[{\"id\":\"7858\",\"catName\":\"车用电子/电器\",\"level\":\"3\"},{\"id\":\"7859\",\"catName\":\"其它汽车电子用品\",\"level\":\"3\"},{\"id\":\"7860\",\"catName\":\"汽车电子防盗安防\",\"level\":\"3\"},{\"id\":\"7861\",\"catName\":\"汽车影音\",\"level\":\"3\"},{\"id\":\"20349\",\"catName\":\"车载冷暖箱\",\"level\":\"3\"},{\"id\":\"20350\",\"catName\":\"车载冰箱\",\"level\":\"3\"}]},{\"id\":\"7664\",\"catName\":\"车用清洗用品/清洗工具\",\"level\":\"2\",\"Children\":[{\"id\":\"7796\",\"catName\":\"擦车巾\",\"level\":\"3\"},{\"id\":\"7797\",\"catName\":\"车掸/蜡拖\",\"level\":\"3\"},{\"id\":\"7798\",\"catName\":\"车刷\",\"level\":\"3\"},{\"id\":\"7799\",\"catName\":\"车用清洗/除蜡/除胶剂\",\"level\":\"3\"},{\"id\":\"7800\",\"catName\":\"车用水桶\",\"level\":\"3\"},{\"id\":\"7801\",\"catName\":\"车用洗车机/设备\",\"level\":\"3\"},{\"id\":\"7802\",\"catName\":\"其它车用清洗工具/用品\",\"level\":\"3\"},{\"id\":\"7803\",\"catName\":\"汽车清洗手套\",\"level\":\"3\"},{\"id\":\"7804\",\"catName\":\"洗车海绵/洗车泥\",\"level\":\"3\"},{\"id\":\"7805\",\"catName\":\"洗车水管接头\",\"level\":\"3\"},{\"id\":\"7806\",\"catName\":\"洗车水枪\",\"level\":\"3\"},{\"id\":\"20126\",\"catName\":\"汽车玻璃防雾/驱水\",\"level\":\"3\"},{\"id\":\"20129\",\"catName\":\"汽车铁锈去除剂\",\"level\":\"3\"},{\"id\":\"20130\",\"catName\":\"清洁软胶\",\"level\":\"3\"},{\"id\":\"20235\",\"catName\":\"雪铲/除雪工具\",\"level\":\"3\"}]},{\"id\":\"7677\",\"catName\":\"汽车改装\",\"level\":\"2\",\"Children\":[{\"id\":\"7816\",\"catName\":\"全车改装套件\",\"level\":\"3\"},{\"id\":\"7817\",\"catName\":\"赛车文化\",\"level\":\"3\"}]},{\"id\":\"7719\",\"catName\":\"汽车GPS导航仪及配件\",\"level\":\"2\",\"Children\":[{\"id\":\"7807\",\"catName\":\"安全预警仪\",\"level\":\"3\"},{\"id\":\"7808\",\"catName\":\"车用便捷式GPS导航\",\"level\":\"3\"},{\"id\":\"7809\",\"catName\":\"GPS支架\",\"level\":\"3\"},{\"id\":\"7810\",\"catName\":\"GPS充电器\",\"level\":\"3\"},{\"id\":\"7811\",\"catName\":\"GPS导航模块\",\"level\":\"3\"},{\"id\":\"7812\",\"catName\":\"GPS导航软件\",\"level\":\"3\"},{\"id\":\"7813\",\"catName\":\"其它GPS导航配件\",\"level\":\"3\"},{\"id\":\"7814\",\"catName\":\"智能车机导航\",\"level\":\"3\"},{\"id\":\"7815\",\"catName\":\"智能后视镜导航\",\"level\":\"3\"}]},{\"id\":\"7720\",\"catName\":\"汽车用品/内饰品\",\"level\":\"2\",\"Children\":[{\"id\":\"7862\",\"catName\":\"CD包/夹/袋\",\"level\":\"3\"},{\"id\":\"7863\",\"catName\":\"安全座椅凉席\",\"level\":\"3\"},{\"id\":\"7864\",\"catName\":\"摆件\",\"level\":\"3\"},{\"id\":\"7865\",\"catName\":\"包真皮座套\",\"level\":\"3\"},{\"id\":\"7866\",\"catName\":\"宝宝增高垫\",\"level\":\"3\"},{\"id\":\"7867\",\"catName\":\"抱枕\",\"level\":\"3\"},{\"id\":\"7868\",\"catName\":\"车挂\",\"level\":\"3\"},{\"id\":\"7869\",\"catName\":\"车用窗帘\",\"level\":\"3\"},{\"id\":\"7870\",\"catName\":\"车用置物袋/置物箱\",\"level\":\"3\"},{\"id\":\"7871\",\"catName\":\"车载垃圾桶\",\"level\":\"3\"},{\"id\":\"7872\",\"catName\":\"车载旅行床\",\"level\":\"3\"},{\"id\":\"7873\",\"catName\":\"车载手机支架/手机座\",\"level\":\"3\"},{\"id\":\"7874\",\"catName\":\"宠物安全扣\",\"level\":\"3\"},{\"id\":\"7875\",\"catName\":\"宠物垫\",\"level\":\"3\"},{\"id\":\"7876\",\"catName\":\"地胶\",\"level\":\"3\"},{\"id\":\"7877\",\"catName\":\"儿童安全带套/固定器/延长带\",\"level\":\"3\"},{\"id\":\"7878\",\"catName\":\"儿童防踢垫\",\"level\":\"3\"},{\"id\":\"7879\",\"catName\":\"方向盘套\",\"level\":\"3\"},{\"id\":\"7880\",\"catName\":\"防滑垫/防护垫\",\"level\":\"3\"},{\"id\":\"7881\",\"catName\":\"防雾湿巾\",\"level\":\"3\"},{\"id\":\"7882\",\"catName\":\"后视提篮镜\",\"level\":\"3\"},{\"id\":\"7883\",\"catName\":\"驾车个人用品\",\"level\":\"3\"},{\"id\":\"7884\",\"catName\":\"驾驶室脚踏板\",\"level\":\"3\"},{\"id\":\"7885\",\"catName\":\"其他内饰/驾乘用品\",\"level\":\"3\"},{\"id\":\"7886\",\"catName\":\"汽车儿童安全座椅\",\"level\":\"3\"},{\"id\":\"7887\",\"catName\":\"汽车模型\",\"level\":\"3\"},{\"id\":\"7888\",\"catName\":\"汽车内饰贴片/贴纸\",\"level\":\"3\"},{\"id\":\"7889\",\"catName\":\"汽车文化产品\",\"level\":\"3\"},{\"id\":\"7890\",\"catName\":\"汽车香水/净化/降温剂\",\"level\":\"3\"},{\"id\":\"7891\",\"catName\":\"手刹套/档把套/套饰套装\",\"level\":\"3\"},{\"id\":\"7894\",\"catName\":\"汽车座垫\",\"level\":\"3\"},{\"id\":\"7896\",\"catName\":\"头枕/腰靠\",\"level\":\"3\"},{\"id\":\"7898\",\"catName\":\"一次性方向盘保护套\",\"level\":\"3\"},{\"id\":\"7899\",\"catName\":\"一次性汽车脚垫\",\"level\":\"3\"},{\"id\":\"7900\",\"catName\":\"一次性汽车座椅保护套\",\"level\":\"3\"},{\"id\":\"7901\",\"catName\":\"遮阳挡\",\"level\":\"3\"},{\"id\":\"7902\",\"catName\":\"汽车后备箱垫\",\"level\":\"3\"},{\"id\":\"7903\",\"catName\":\"汽车脚垫\",\"level\":\"3\"},{\"id\":\"7905\",\"catName\":\"汽车座套\",\"level\":\"3\"},{\"id\":\"20131\",\"catName\":\"停车号码牌\",\"level\":\"3\"}]}]}}";
		JsonObject categoryinfo=new JsonParser().parse(json).getAsJsonObject();
		JsonArray catInfoList=categoryinfo.get("result").getAsJsonObject().get("catInfoList").getAsJsonArray();
		for (int i = 0; i < catInfoList.size(); i++) {
			JsonObject object=catInfoList.get(i).getAsJsonObject();
			Integer cat1Id=Integer.parseInt(object.get("id").getAsString());
			String cat1Name=object.get("catName").getAsString();
			Integer cat1Level=Integer.parseInt(object.get("level").getAsString());
			JsonArray Children=object.get("Children").getAsJsonArray();
			for (int j = 0; j < Children.size(); j++) {
				JsonObject childernObject=Children.get(j).getAsJsonObject();
				Integer catId=Integer.parseInt(childernObject.get("id").getAsString());
				String catName=childernObject.get("catName").getAsString();
				Integer level=Integer.parseInt(childernObject.get("level").getAsString());
				int count=sqlSession.getMapper(Mapper.class).storeCategoryinfo(catId, catName, level, cat1Id, cat1Name, cat1Level);
				sqlSession.commit();
				System.out.println("成功插入"+count+"条数据,"+catName);
			}
		}
//		int count=sqlSession.getMapper(Mapper.class).storeGoods(123, "测试", "测试", 1110, 200, "1050%", "2020-07-01", 1);
//		sqlSession.commit();
//		System.out.println("成功插入"+count+"条数据");
//		List<categoryinfo> list=sqlSession.getMapper(Mapper.class).searchCategoryInfo();
//		sqlSession.commit();
//		sqlSession.close();
////		Integer a=list.get(0).getCat1Id();
//		System.out.println(list.get(0).getCatName());
		
//		int num=sqlSession.getMapper(Mapper.class).searchGroupsurgelist(18754, "【足贴老北京正品足贴祛湿排毒艾草足贴艾叶】【排湿气睡眠贴】", 57, 536);
//		int num = sqlSession.getMapper(Mapper.class).storehotwords(123, 123, "11", "12", 123, "11", "dsd", 123, "12132","2020-07-01");
//		int num = sqlSession.getMapper(Mapper.class).queryhotlongtailedwords(26, 7, "0.10416666666666667", "0.6", 43, "532.5", "黑头鼻贴 男士", 18639);
//		int num = sqlSession.getMapper(Mapper.class).queryhotword(11417, 1936, "0.07588813303099018", "0.030876494023904383", 2134, "396.05562286275733", "小猪酸奶", 18639);
//		int num = sqlSession.getMapper(Mapper.class).storeIndustrytrend(123, 114, 333, "2020-07-01", 1212, "2212");
//		int num = sqlSession.getMapper(Mapper.class).queryIndustrytrend(14707, 168632, 29301, "2020-06-10",18639);
//		List<IndustryTrend> list=sqlSession.getMapper(Mapper.class).getIndustrytrend(18639, 10);
//		sqlSession.commit();
//		sqlSession.close();
		
//		
//		List<goods> list=sqlSession.getMapper(Mapper.class).getGood(18640);
//		sqlSession.commit();
//		sqlSession.close();
//		System.out.println(list);
//		
////		Integer a=list.get(0).getCat1Id();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println((list.get(i).toString()));
//		}
//		List <IndustryTrend> list = service.searchIndustryTrends(18639, 10);
//		Integer catId = 18638;
//		SqlSession sqlSession=MybatisReader.getSession();
//		List<categoryinfo> list;
//		if(catId==1) {
//			System.out.println(catId+" 1");
//			list=sqlSession.getMapper(Mapper.class).getCategoryinfoParent();
//		}else {
//			System.out.println(catId+" 2");
//			list=sqlSession.getMapper(Mapper.class).getCategoryinfo(18638);
//		}
//		sqlSession.commit();
//		sqlSession.close();
//		List <categoryinfo> list = service.searchCategoryinfo(18745);
//		List <hotwords> list = service.getHotwordRank(10,18743,50);
//		System.out.println(list);
//		List <hotwords> list = service.getHotwordRank(1,0,10,0);
//		List <hotwords> list1 = service.getHotwordRank(1,0,10,1);
//		List <hotwords> list2 = service.getHotwordRank(1,0,10,2);
//		List <hotwords> list3 = service.getHotwordRank(1,0,10,3);
//		List <hotwords> list4 = service.getHotwordRank(1,0,10,4);
//		
//		
//		
//		List <hotwords> list5 = service.getHotwordRank(1,0,10,0);
//		List <hotwords> list6 = service.getHotwordRank(1,0,10,1);
//		List <hotwords> list7 = service.getHotwordRank(1,0,10,2);
//		List <hotwords> list8 = service.getHotwordRank(1,0,10,3);
//		List <hotwords> list9 = service.getHotwordRank(1,0,10,4);
//		
//		System.out.println(list);
//		System.out.println(list1);
//		System.out.println(list2);
//		System.out.println(list3);
//		System.out.println(list4);
//		System.out.println(list5);
//		System.out.println(list6);
//		System.out.println(list7);
//		System.out.println(list8);
//		System.out.println(list9);
		
	
	
		
//		int count=sqlSession.getMapper(Mapper.class).querywords(468, "脚气药脚痒见效快", 18753);
//		int count=sqlSession.getMapper(Mapper.class).storewordtrend("绿茶", 51, 73, "0.23015873015873015", "0.05172413793103448", "0.0", "0.0", "2020-08-01");
//		int count=sqlSession.getMapper(Mapper.class).queryWordTrend("绿茶", 51, 70, "2020-08-01");
//		int aaa = sqlSession.getMapper(Mapper.class).queryHotNum("%2020-08-29%", 10383);
//		sqlSession.commit();
//		System.out.println(aaa);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(5, 0);
		String update_time = sf.format(gc.getTime());
		System.out.println(update_time.substring(0, 10));
	}

}
