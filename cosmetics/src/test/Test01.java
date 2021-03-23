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
		
//		//´ÓqueryCategoryInfo»ñÈ¡
//		String json="{\"success\":true,\"errorCode\":1000,\"errorMsg\":\"null\",\"result\":{\"mallId\":449142915,\"catInfoList\":[{\"id\":\"18483\",\"catName\":\"BBËª\",\"level\":\"2\",\"Children\":[{\"id\":\"18490\",\"catName\":\"BBËª\",\"level\":\"3\"}]},{\"id\":\"18484\",\"catName\":\"CCËª\",\"level\":\"2\",\"Children\":[{\"id\":\"18491\",\"catName\":\"CCËª\",\"level\":\"3\"}]},{\"id\":\"18485\",\"catName\":\"²Ê×±ÅÌ\",\"level\":\"2\",\"Children\":[{\"id\":\"18492\",\"catName\":\"²Ê×±ÅÌ\",\"level\":\"3\"}]},{\"id\":\"18486\",\"catName\":\"²Ê×±Ì××°\",\"level\":\"2\",\"Children\":[{\"id\":\"18493\",\"catName\":\"²Ê×±Ì××°\",\"level\":\"3\"}]},{\"id\":\"18487\",\"catName\":\"´½±Ê/´½Ïß±Ê\",\"level\":\"2\",\"Children\":[{\"id\":\"18494\",\"catName\":\"´½±Ê/´½Ïß±Ê\",\"level\":\"3\"}]},{\"id\":\"18488\",\"catName\":\"´½²Ê/´½ÃÛ\",\"level\":\"2\",\"Children\":[{\"id\":\"18495\",\"catName\":\"´½²Ê/´½ÃÛ\",\"level\":\"3\"}]},{\"id\":\"18489\",\"catName\":\"´½¸à/¿Úºì\",\"level\":\"2\",\"Children\":[{\"id\":\"18496\",\"catName\":\"´½¸à/¿Úºì\",\"level\":\"3\"}]},{\"id\":\"18497\",\"catName\":\"·Û±ý\",\"level\":\"2\",\"Children\":[{\"id\":\"18503\",\"catName\":\"·Û±ý\",\"level\":\"3\"}]},{\"id\":\"18498\",\"catName\":\"·Ûµ×Òº/¸à\",\"level\":\"2\",\"Children\":[{\"id\":\"18504\",\"catName\":\"·Ûµ×Òº/¸à\",\"level\":\"3\"}]},{\"id\":\"18499\",\"catName\":\"¸ôÀë/×±Ç°\",\"level\":\"2\",\"Children\":[{\"id\":\"18505\",\"catName\":\"¸ôÀë/×±Ç°\",\"level\":\"3\"}]},{\"id\":\"18500\",\"catName\":\"¼Ù½ÞÃ«\",\"level\":\"2\",\"Children\":[{\"id\":\"18506\",\"catName\":\"¼Ù½ÞÃ«\",\"level\":\"3\"}]},{\"id\":\"18501\",\"catName\":\"½ÞÃ«¸à/½ÞÃ«Ôö³¤Òº\",\"level\":\"2\",\"Children\":[{\"id\":\"18507\",\"catName\":\"½ÞÃ«¸à/½ÞÃ«Ôö³¤Òº\",\"level\":\"3\"}]},{\"id\":\"18502\",\"catName\":\"Ã¼±Ê/Ã¼·Û/Ã¼¸à\",\"level\":\"2\",\"Children\":[{\"id\":\"18508\",\"catName\":\"Ã¼±Ê/Ã¼·Û/Ã¼¸à\",\"level\":\"3\"}]},{\"id\":\"18509\",\"catName\":\"ÃÀ¼×¹¤¾ß\",\"level\":\"2\",\"Children\":[{\"id\":\"18510\",\"catName\":\"ÃÀ¼×¹¤¾ß\",\"level\":\"3\"}]},{\"id\":\"18511\",\"catName\":\"ÃÀÈÝ¹¤¾ß\",\"level\":\"2\",\"Children\":[{\"id\":\"18512\",\"catName\":\"·¢Ìù\",\"level\":\"3\"},{\"id\":\"18513\",\"catName\":\"·Û´ÌÕë\",\"level\":\"3\"},{\"id\":\"18514\",\"catName\":\"»¯×±¾µ\",\"level\":\"3\"},{\"id\":\"18515\",\"catName\":\"»¯×±ÃÞ\",\"level\":\"3\"},{\"id\":\"18516\",\"catName\":\"»¯×±Ë¢\",\"level\":\"3\"},{\"id\":\"18517\",\"catName\":\"»¯×±Ì×Ë¢\",\"level\":\"3\"},{\"id\":\"18518\",\"catName\":\"¼Ù½ÞÃ«¹¤¾ß\",\"level\":\"3\"},{\"id\":\"18519\",\"catName\":\"ÃÀ×±µ°/º£Ãà\",\"level\":\"3\"},{\"id\":\"18520\",\"catName\":\"ÃÞÇ©/ÃÞ°ô/ÃÞ°ü\",\"level\":\"3\"},{\"id\":\"18521\",\"catName\":\"ÃæÆË/·ÛÆË\",\"level\":\"3\"},{\"id\":\"18522\",\"catName\":\"Êø·¢´ø\",\"level\":\"3\"},{\"id\":\"18523\",\"catName\":\"Ë¢°ü/»¯×±°ü\",\"level\":\"3\"},{\"id\":\"18524\",\"catName\":\"Ë«ÑÛÆ¤½ºË®\",\"level\":\"3\"},{\"id\":\"18525\",\"catName\":\"Ë«ÑÛÆ¤Ìù\",\"level\":\"3\"},{\"id\":\"18526\",\"catName\":\"ÑÛÃ¼¹¤¾ß\",\"level\":\"3\"},{\"id\":\"20475\",\"catName\":\"Ï´Á³½í\",\"level\":\"3\"}]},{\"id\":\"18534\",\"catName\":\"ÃÛ·Û/É¢·Û\",\"level\":\"2\",\"Children\":[{\"id\":\"18535\",\"catName\":\"ÃÛ·Û/É¢·Û\",\"level\":\"3\"}]},{\"id\":\"18536\",\"catName\":\"ÄÐÊ¿²Ê×±\",\"level\":\"2\",\"Children\":[{\"id\":\"18537\",\"catName\":\"ÄÐÊ¿BBËª\",\"level\":\"3\"},{\"id\":\"18538\",\"catName\":\"ÄÐÊ¿²Ê×±Ì××°\",\"level\":\"3\"},{\"id\":\"18539\",\"catName\":\"ÄÐÊ¿´½¸à\",\"level\":\"3\"},{\"id\":\"18540\",\"catName\":\"ÄÐÊ¿·Û±ý\",\"level\":\"3\"},{\"id\":\"18541\",\"catName\":\"ÄÐÊ¿·Ûµ×\",\"level\":\"3\"},{\"id\":\"18542\",\"catName\":\"ÄÐÊ¿¸ß¹â\",\"level\":\"3\"},{\"id\":\"18543\",\"catName\":\"ÄÐÊ¿¸ôÀëÈé/Ëª\",\"level\":\"3\"},{\"id\":\"18544\",\"catName\":\"ÄÐÊ¿½ÞÃ«¸à/½ÞÃ«Ôö³¤Òº\",\"level\":\"3\"},{\"id\":\"18545\",\"catName\":\"ÄÐÊ¿Ã¼±Ê\",\"level\":\"3\"},{\"id\":\"18546\",\"catName\":\"ÄÐÊ¿ÃÛ·Û\",\"level\":\"3\"},{\"id\":\"18547\",\"catName\":\"ÄÐÊ¿Èùºì\",\"level\":\"3\"},{\"id\":\"18548\",\"catName\":\"ÄÐÊ¿Ð¶×±\",\"level\":\"3\"},{\"id\":\"18549\",\"catName\":\"ÄÐÊ¿ÑÛÏß\",\"level\":\"3\"},{\"id\":\"18550\",\"catName\":\"ÄÐÊ¿ÑÛÓ°\",\"level\":\"3\"},{\"id\":\"18551\",\"catName\":\"ÄÐÊ¿ÒõÓ°\",\"level\":\"3\"},{\"id\":\"18552\",\"catName\":\"ÄÐÊ¿ÕÚè¦\",\"level\":\"3\"}]},{\"id\":\"18553\",\"catName\":\"ÆäËû²Ê×±\",\"level\":\"2\",\"Children\":[{\"id\":\"18554\",\"catName\":\"ÆäËû²Ê×±\",\"level\":\"3\"}]},{\"id\":\"18555\",\"catName\":\"Èùºì/ëÙÖ¬\",\"level\":\"2\",\"Children\":[{\"id\":\"18556\",\"catName\":\"Èùºì/ëÙÖ¬\",\"level\":\"3\"}]},{\"id\":\"18557\",\"catName\":\"ÉíÌå²Ê»æ\",\"level\":\"2\",\"Children\":[{\"id\":\"18558\",\"catName\":\"ÉíÌå²Ê»æ\",\"level\":\"3\"}]},{\"id\":\"18559\",\"catName\":\"ÏãË®/Ïã·Õ\",\"level\":\"2\",\"Children\":[{\"id\":\"18560\",\"catName\":\"ÏãË®/Ïã·Õ\",\"level\":\"3\"}]},{\"id\":\"18561\",\"catName\":\"ÐÞÈÝ\",\"level\":\"2\",\"Children\":[{\"id\":\"18562\",\"catName\":\"¸ß¹â\",\"level\":\"3\"},{\"id\":\"18563\",\"catName\":\"ÒõÓ°\",\"level\":\"3\"}]},{\"id\":\"18564\",\"catName\":\"ÑÛÏß\",\"level\":\"2\",\"Children\":[{\"id\":\"18565\",\"catName\":\"ÑÛÏß\",\"level\":\"3\"}]},{\"id\":\"18566\",\"catName\":\"ÑÛÓ°\",\"level\":\"2\",\"Children\":[{\"id\":\"18567\",\"catName\":\"ÑÛÓ°\",\"level\":\"3\"}]},{\"id\":\"18568\",\"catName\":\"ÕÚè¦\",\"level\":\"2\",\"Children\":[{\"id\":\"18569\",\"catName\":\"ÕÚè¦\",\"level\":\"3\"}]},{\"id\":\"18570\",\"catName\":\"Ö¸¼×ÓÍ/ÃÀ¼×²úÆ·\",\"level\":\"2\",\"Children\":[{\"id\":\"18571\",\"catName\":\"¼×ÓÍ½º\",\"level\":\"3\"},{\"id\":\"18572\",\"catName\":\"ÆäËüÖ¸¼×²Ê×±\",\"level\":\"3\"},{\"id\":\"18573\",\"catName\":\"Ö¸¼×ÓÍ\",\"level\":\"3\"}]},{\"id\":\"20473\",\"catName\":\"¶¨×±ÅçÎí\",\"level\":\"2\",\"Children\":[{\"id\":\"20474\",\"catName\":\"¶¨×±ÅçÎí\",\"level\":\"3\"}]}]}}";
//		JsonObject categoryinfo=new JsonParser().parse(json).getAsJsonObject();
//		JsonArray catInfoList=categoryinfo.get("result").getAsJsonObject().get("catInfoList").getAsJsonArray();
//		for (int i = 0; i < catInfoList.size(); i++) {
//			JsonObject object=catInfoList.get(i).getAsJsonObject();
//			Integer cat1Id=Integer.parseInt(object.get("id").getAsString());
//			String cat1Name=object.get("catName").getAsString();
//			Integer cat1Level=Integer.parseInt(object.get("level").getAsString());
//			JsonArray Children=object.get("Children").getAsJsonArray();
//			for (int j = 0; j < Children.size(); j++) {
//				JsonObject childernObject=Children.get(j).getAsJsonObject();
//				Integer catId=Integer.parseInt(childernObject.get("id").getAsString());
//				String catName=childernObject.get("catName").getAsString();
//				Integer level=Integer.parseInt(childernObject.get("level").getAsString());
//				int count=sqlSession.getMapper(Mapper.class).storeCategoryinfo(catId, catName, level, cat1Id, cat1Name, cat1Level);
//				sqlSession.commit();
//				System.out.println("³É¹¦²åÈë"+count+"ÌõÊý¾Ý,"+catName);
//			}
//		}
//		int count=sqlSession.getMapper(Mapper.class).storeGoods(123, "²âÊÔ", "²âÊÔ", 1110, 200, "1050%", "2020-07-01", 1);
//		sqlSession.commit();
//		System.out.println("³É¹¦²åÈë"+count+"ÌõÊý¾Ý");
//		List<categoryinfo> list=sqlSession.getMapper(Mapper.class).searchCategoryInfo();
//		sqlSession.commit();
//		sqlSession.close();
////		Integer a=list.get(0).getCat1Id();
//		System.out.println(list.get(0).getCatName());
		
//		int num=sqlSession.getMapper(Mapper.class).searchGroupsurgelist(18754, "¡¾×ãÌùÀÏ±±¾©ÕýÆ·×ãÌùìîÊªÅÅ¶¾°¬²Ý×ãÌù°¬Ò¶¡¿¡¾ÅÅÊªÆøË¯ÃßÌù¡¿", 57, 536);
//		int num = sqlSession.getMapper(Mapper.class).storehotwords(123, 123, "11", "12", 123, "11", "dsd", 123, "12132","2020-07-01");
//		int num = sqlSession.getMapper(Mapper.class).queryhotlongtailedwords(26, 7, "0.10416666666666667", "0.6", 43, "532.5", "ºÚÍ·±ÇÌù ÄÐÊ¿", 18639);
//		int num = sqlSession.getMapper(Mapper.class).queryhotword(11417, 1936, "0.07588813303099018", "0.030876494023904383", 2134, "396.05562286275733", "Ð¡ÖíËáÄÌ", 18639);
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
		
	
	
		
//		int count=sqlSession.getMapper(Mapper.class).querywords(468, "½ÅÆøÒ©½ÅÑ÷¼ûÐ§¿ì", 18753);
//		int count=sqlSession.getMapper(Mapper.class).storewordtrend("ÂÌ²è", 51, 73, "0.23015873015873015", "0.05172413793103448", "0.0", "0.0", "2020-08-01");
//		int count=sqlSession.getMapper(Mapper.class).queryWordTrend("ÂÌ²è", 51, 70, "2020-08-01");
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
