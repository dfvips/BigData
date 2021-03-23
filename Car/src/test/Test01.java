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
		
//		//��queryCategoryInfo��ȡ
		String json="{\"success\":true,\"errorCode\":1000,\"errorMsg\":\"null\",\"result\":{\"mallId\":545532881,\"catInfoList\":[{\"id\":\"7640\",\"catName\":\"���������\",\"level\":\"2\",\"Children\":[{\"id\":\"7818\",\"catName\":\"��ȫ����������\",\"level\":\"3\"},{\"id\":\"7820\",\"catName\":\"������ϵͳ\",\"level\":\"3\"},{\"id\":\"7821\",\"catName\":\"���׷�����/����������\",\"level\":\"3\"},{\"id\":\"7822\",\"catName\":\"������\",\"level\":\"3\"},{\"id\":\"7823\",\"catName\":\"���ø���\",\"level\":\"3\"},{\"id\":\"7824\",\"catName\":\"���ó���̥\",\"level\":\"3\"},{\"id\":\"7825\",\"catName\":\"�����\",\"level\":\"3\"},{\"id\":\"7826\",\"catName\":\"���ϵͳ\",\"level\":\"3\"},{\"id\":\"7827\",\"catName\":\"����ϵͳ\",\"level\":\"3\"},{\"id\":\"7828\",\"catName\":\"����ϵͳ\",\"level\":\"3\"},{\"id\":\"7829\",\"catName\":\"����ϵͳ\",\"level\":\"3\"},{\"id\":\"7830\",\"catName\":\"�ǳ��ó���̥\",\"level\":\"3\"},{\"id\":\"7831\",\"catName\":\"����������\",\"level\":\"3\"},{\"id\":\"7832\",\"catName\":\"����ϵͳ\",\"level\":\"3\"},{\"id\":\"7833\",\"catName\":\"������ϵͳ\",\"level\":\"3\"},{\"id\":\"7834\",\"catName\":\"��ȴϵͳ\",\"level\":\"3\"},{\"id\":\"7835\",\"catName\":\"���\",\"level\":\"3\"},{\"id\":\"7836\",\"catName\":\"��ü\",\"level\":\"3\"},{\"id\":\"7837\",\"catName\":\"��о\",\"level\":\"3\"},{\"id\":\"7838\",\"catName\":\"����ϵͳ\",\"level\":\"3\"},{\"id\":\"7839\",\"catName\":\"�����������\",\"level\":\"3\"},{\"id\":\"7840\",\"catName\":\"��ۼ�\",\"level\":\"3\"},{\"id\":\"7841\",\"catName\":\"β��/����\",\"level\":\"3\"},{\"id\":\"7842\",\"catName\":\"����ϵͳ\",\"level\":\"3\"},{\"id\":\"7843\",\"catName\":\"��Ʒ\",\"level\":\"3\"},{\"id\":\"7844\",\"catName\":\"�굲\",\"level\":\"3\"},{\"id\":\"7845\",\"catName\":\"�����\",\"level\":\"3\"},{\"id\":\"7846\",\"catName\":\"����ϵͳ\",\"level\":\"3\"},{\"id\":\"7847\",\"catName\":\"�ƶ�ϵͳ\",\"level\":\"3\"},{\"id\":\"7848\",\"catName\":\"ת��ϵͳ\",\"level\":\"3\"}]},{\"id\":\"7641\",\"catName\":\"��������/����/ά��\",\"level\":\"2\",\"Children\":[{\"id\":\"7849\",\"catName\":\"��������/����/ά��Ʒ\",\"level\":\"3\"},{\"id\":\"7850\",\"catName\":\"����������/Ĥ/������\",\"level\":\"3\"},{\"id\":\"7851\",\"catName\":\"������Ӽ�\",\"level\":\"3\"},{\"id\":\"7852\",\"catName\":\"����ά��/����\",\"level\":\"3\"},{\"id\":\"7853\",\"catName\":\"��������Ʒ\",\"level\":\"3\"},{\"id\":\"20113\",\"catName\":\"���Ṥ��\",\"level\":\"3\"}]},{\"id\":\"7645\",\"catName\":\"��������Ʒ/��װװ��/����\",\"level\":\"2\",\"Children\":[{\"id\":\"7854\",\"catName\":\"��װ/װ��\",\"level\":\"3\"},{\"id\":\"7855\",\"catName\":\"������װ/����/����Ʒ\",\"level\":\"3\"},{\"id\":\"7856\",\"catName\":\"��������\",\"level\":\"3\"},{\"id\":\"7857\",\"catName\":\"��������Ʒ\",\"level\":\"3\"}]},{\"id\":\"7646\",\"catName\":\"����Ӱ��/���õ���/����\",\"level\":\"2\",\"Children\":[{\"id\":\"7858\",\"catName\":\"���õ���/����\",\"level\":\"3\"},{\"id\":\"7859\",\"catName\":\"��������������Ʒ\",\"level\":\"3\"},{\"id\":\"7860\",\"catName\":\"�������ӷ�������\",\"level\":\"3\"},{\"id\":\"7861\",\"catName\":\"����Ӱ��\",\"level\":\"3\"},{\"id\":\"20349\",\"catName\":\"������ů��\",\"level\":\"3\"},{\"id\":\"20350\",\"catName\":\"���ر���\",\"level\":\"3\"}]},{\"id\":\"7664\",\"catName\":\"������ϴ��Ʒ/��ϴ����\",\"level\":\"2\",\"Children\":[{\"id\":\"7796\",\"catName\":\"������\",\"level\":\"3\"},{\"id\":\"7797\",\"catName\":\"����/����\",\"level\":\"3\"},{\"id\":\"7798\",\"catName\":\"��ˢ\",\"level\":\"3\"},{\"id\":\"7799\",\"catName\":\"������ϴ/����/������\",\"level\":\"3\"},{\"id\":\"7800\",\"catName\":\"����ˮͰ\",\"level\":\"3\"},{\"id\":\"7801\",\"catName\":\"����ϴ����/�豸\",\"level\":\"3\"},{\"id\":\"7802\",\"catName\":\"����������ϴ����/��Ʒ\",\"level\":\"3\"},{\"id\":\"7803\",\"catName\":\"������ϴ����\",\"level\":\"3\"},{\"id\":\"7804\",\"catName\":\"ϴ������/ϴ����\",\"level\":\"3\"},{\"id\":\"7805\",\"catName\":\"ϴ��ˮ�ܽ�ͷ\",\"level\":\"3\"},{\"id\":\"7806\",\"catName\":\"ϴ��ˮǹ\",\"level\":\"3\"},{\"id\":\"20126\",\"catName\":\"������������/��ˮ\",\"level\":\"3\"},{\"id\":\"20129\",\"catName\":\"��������ȥ����\",\"level\":\"3\"},{\"id\":\"20130\",\"catName\":\"�����\",\"level\":\"3\"},{\"id\":\"20235\",\"catName\":\"ѩ��/��ѩ����\",\"level\":\"3\"}]},{\"id\":\"7677\",\"catName\":\"������װ\",\"level\":\"2\",\"Children\":[{\"id\":\"7816\",\"catName\":\"ȫ����װ�׼�\",\"level\":\"3\"},{\"id\":\"7817\",\"catName\":\"�����Ļ�\",\"level\":\"3\"}]},{\"id\":\"7719\",\"catName\":\"����GPS�����Ǽ����\",\"level\":\"2\",\"Children\":[{\"id\":\"7807\",\"catName\":\"��ȫԤ����\",\"level\":\"3\"},{\"id\":\"7808\",\"catName\":\"���ñ��ʽGPS����\",\"level\":\"3\"},{\"id\":\"7809\",\"catName\":\"GPS֧��\",\"level\":\"3\"},{\"id\":\"7810\",\"catName\":\"GPS�����\",\"level\":\"3\"},{\"id\":\"7811\",\"catName\":\"GPS����ģ��\",\"level\":\"3\"},{\"id\":\"7812\",\"catName\":\"GPS�������\",\"level\":\"3\"},{\"id\":\"7813\",\"catName\":\"����GPS�������\",\"level\":\"3\"},{\"id\":\"7814\",\"catName\":\"���ܳ�������\",\"level\":\"3\"},{\"id\":\"7815\",\"catName\":\"���ܺ��Ӿ�����\",\"level\":\"3\"}]},{\"id\":\"7720\",\"catName\":\"������Ʒ/����Ʒ\",\"level\":\"2\",\"Children\":[{\"id\":\"7862\",\"catName\":\"CD��/��/��\",\"level\":\"3\"},{\"id\":\"7863\",\"catName\":\"��ȫ������ϯ\",\"level\":\"3\"},{\"id\":\"7864\",\"catName\":\"�ڼ�\",\"level\":\"3\"},{\"id\":\"7865\",\"catName\":\"����Ƥ����\",\"level\":\"3\"},{\"id\":\"7866\",\"catName\":\"�������ߵ�\",\"level\":\"3\"},{\"id\":\"7867\",\"catName\":\"����\",\"level\":\"3\"},{\"id\":\"7868\",\"catName\":\"����\",\"level\":\"3\"},{\"id\":\"7869\",\"catName\":\"���ô���\",\"level\":\"3\"},{\"id\":\"7870\",\"catName\":\"���������/������\",\"level\":\"3\"},{\"id\":\"7871\",\"catName\":\"��������Ͱ\",\"level\":\"3\"},{\"id\":\"7872\",\"catName\":\"�������д�\",\"level\":\"3\"},{\"id\":\"7873\",\"catName\":\"�����ֻ�֧��/�ֻ���\",\"level\":\"3\"},{\"id\":\"7874\",\"catName\":\"���ﰲȫ��\",\"level\":\"3\"},{\"id\":\"7875\",\"catName\":\"�����\",\"level\":\"3\"},{\"id\":\"7876\",\"catName\":\"�ؽ�\",\"level\":\"3\"},{\"id\":\"7877\",\"catName\":\"��ͯ��ȫ����/�̶���/�ӳ���\",\"level\":\"3\"},{\"id\":\"7878\",\"catName\":\"��ͯ���ߵ�\",\"level\":\"3\"},{\"id\":\"7879\",\"catName\":\"��������\",\"level\":\"3\"},{\"id\":\"7880\",\"catName\":\"������/������\",\"level\":\"3\"},{\"id\":\"7881\",\"catName\":\"����ʪ��\",\"level\":\"3\"},{\"id\":\"7882\",\"catName\":\"����������\",\"level\":\"3\"},{\"id\":\"7883\",\"catName\":\"�ݳ�������Ʒ\",\"level\":\"3\"},{\"id\":\"7884\",\"catName\":\"��ʻ�ҽ�̤��\",\"level\":\"3\"},{\"id\":\"7885\",\"catName\":\"��������/�ݳ���Ʒ\",\"level\":\"3\"},{\"id\":\"7886\",\"catName\":\"������ͯ��ȫ����\",\"level\":\"3\"},{\"id\":\"7887\",\"catName\":\"����ģ��\",\"level\":\"3\"},{\"id\":\"7888\",\"catName\":\"����������Ƭ/��ֽ\",\"level\":\"3\"},{\"id\":\"7889\",\"catName\":\"�����Ļ���Ʒ\",\"level\":\"3\"},{\"id\":\"7890\",\"catName\":\"������ˮ/����/���¼�\",\"level\":\"3\"},{\"id\":\"7891\",\"catName\":\"��ɲ��/������/������װ\",\"level\":\"3\"},{\"id\":\"7894\",\"catName\":\"��������\",\"level\":\"3\"},{\"id\":\"7896\",\"catName\":\"ͷ��/����\",\"level\":\"3\"},{\"id\":\"7898\",\"catName\":\"һ���Է����̱�����\",\"level\":\"3\"},{\"id\":\"7899\",\"catName\":\"һ���������ŵ�\",\"level\":\"3\"},{\"id\":\"7900\",\"catName\":\"һ�����������α�����\",\"level\":\"3\"},{\"id\":\"7901\",\"catName\":\"������\",\"level\":\"3\"},{\"id\":\"7902\",\"catName\":\"���������\",\"level\":\"3\"},{\"id\":\"7903\",\"catName\":\"�����ŵ�\",\"level\":\"3\"},{\"id\":\"7905\",\"catName\":\"��������\",\"level\":\"3\"},{\"id\":\"20131\",\"catName\":\"ͣ��������\",\"level\":\"3\"}]}]}}";
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
				System.out.println("�ɹ�����"+count+"������,"+catName);
			}
		}
//		int count=sqlSession.getMapper(Mapper.class).storeGoods(123, "����", "����", 1110, 200, "1050%", "2020-07-01", 1);
//		sqlSession.commit();
//		System.out.println("�ɹ�����"+count+"������");
//		List<categoryinfo> list=sqlSession.getMapper(Mapper.class).searchCategoryInfo();
//		sqlSession.commit();
//		sqlSession.close();
////		Integer a=list.get(0).getCat1Id();
//		System.out.println(list.get(0).getCatName());
		
//		int num=sqlSession.getMapper(Mapper.class).searchGroupsurgelist(18754, "�������ϱ�����Ʒ������ʪ�Ŷ�����������Ҷ������ʪ��˯������", 57, 536);
//		int num = sqlSession.getMapper(Mapper.class).storehotwords(123, 123, "11", "12", 123, "11", "dsd", 123, "12132","2020-07-01");
//		int num = sqlSession.getMapper(Mapper.class).queryhotlongtailedwords(26, 7, "0.10416666666666667", "0.6", 43, "532.5", "��ͷ���� ��ʿ", 18639);
//		int num = sqlSession.getMapper(Mapper.class).queryhotword(11417, 1936, "0.07588813303099018", "0.030876494023904383", 2134, "396.05562286275733", "С������", 18639);
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
		
	
	
		
//		int count=sqlSession.getMapper(Mapper.class).querywords(468, "����ҩ������Ч��", 18753);
//		int count=sqlSession.getMapper(Mapper.class).storewordtrend("�̲�", 51, 73, "0.23015873015873015", "0.05172413793103448", "0.0", "0.0", "2020-08-01");
//		int count=sqlSession.getMapper(Mapper.class).queryWordTrend("�̲�", 51, 70, "2020-08-01");
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
