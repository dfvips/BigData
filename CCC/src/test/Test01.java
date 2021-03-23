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
		String json="{\"success\":true,\"errorCode\":1000,\"errorMsg\":\"null\",\"result\":{\"mallId\":\"547260797\",\"catInfoList\":[{\"id\":\"2934\",\"catName\":\"�����������豸\",\"level\":\"2\",\"Children\":[{\"id\":\"2954\",\"catName\":\"�����������豸\",\"level\":\"3\"}]},{\"id\":\"2935\",\"catName\":\"�ʼǱ��������\",\"level\":\"2\",\"Children\":[{\"id\":\"2955\",\"catName\":\"�ʼǱ����\",\"level\":\"3\"},{\"id\":\"2956\",\"catName\":\"�ʼǱ����԰�\",\"level\":\"3\"},{\"id\":\"2957\",\"catName\":\"�ʼǱ�ɢ����\",\"level\":\"3\"},{\"id\":\"2958\",\"catName\":\"�ʼǱ��Ų���\",\"level\":\"3\"},{\"id\":\"2959\",\"catName\":\"�ʼǱ�֧��/��\",\"level\":\"3\"},{\"id\":\"2960\",\"catName\":\"�ʼǱ����̱���Ĥ\",\"level\":\"3\"},{\"id\":\"2961\",\"catName\":\"�ʼǱ���Ļ��Ĥ\",\"level\":\"3\"},{\"id\":\"2962\",\"catName\":\"�ʼǱ���Դ\",\"level\":\"3\"},{\"id\":\"2963\",\"catName\":\"�ʼǱ�����С��ֽ\",\"level\":\"3\"},{\"id\":\"2964\",\"catName\":\"�ʼǱ��㲿��\",\"level\":\"3\"},{\"id\":\"2965\",\"catName\":\"�ʼǱ�ϥ����\",\"level\":\"3\"},{\"id\":\"2966\",\"catName\":\"����ˢ\",\"level\":\"3\"},{\"id\":\"2967\",\"catName\":\"ƻ��ת����\",\"level\":\"3\"},{\"id\":\"2968\",\"catName\":\"����\",\"level\":\"3\"},{\"id\":\"5478\",\"catName\":\"�ʼǱ������Ʒ\",\"level\":\"3\"}]},{\"id\":\"2936\",\"catName\":\"�����ֻ����\",\"level\":\"2\",\"Children\":[{\"id\":\"2969\",\"catName\":\"����֧��\",\"level\":\"3\"},{\"id\":\"2970\",\"catName\":\"���س����\",\"level\":\"3\"},{\"id\":\"2971\",\"catName\":\"���ط�����\",\"level\":\"3\"}]},{\"id\":\"2937\",\"catName\":\"��������������\",\"level\":\"2\",\"Children\":[{\"id\":\"5479\",\"catName\":\"SD��/CF��/�����\",\"level\":\"3\"},{\"id\":\"19174\",\"catName\":\"�������\",\"level\":\"3\"},{\"id\":\"19175\",\"catName\":\"����/����ר�õ�ص�Դ\",\"level\":\"3\"},{\"id\":\"19176\",\"catName\":\"�����Ʒ\",\"level\":\"3\"},{\"id\":\"19177\",\"catName\":\"������\",\"level\":\"3\"},{\"id\":\"19178\",\"catName\":\"�ż���̨\",\"level\":\"3\"},{\"id\":\"19179\",\"catName\":\"��ͷ����\",\"level\":\"3\"},{\"id\":\"19180\",\"catName\":\"�������\",\"level\":\"3\"},{\"id\":\"19181\",\"catName\":\"ɫ�ʹ���\",\"level\":\"3\"},{\"id\":\"19182\",\"catName\":\"�����\",\"level\":\"3\"},{\"id\":\"19183\",\"catName\":\"Ӱ���豸\",\"level\":\"3\"}]},{\"id\":\"2938\",\"catName\":\"���������\",\"level\":\"2\",\"Children\":[{\"id\":\"2982\",\"catName\":\"��������д��/��ű�\",\"level\":\"3\"},{\"id\":\"2983\",\"catName\":\"�������\",\"level\":\"3\"},{\"id\":\"2984\",\"catName\":\"�����鱣����\",\"level\":\"3\"},{\"id\":\"2985\",\"catName\":\"�����������\",\"level\":\"3\"},{\"id\":\"2986\",\"catName\":\"��ֽ������\",\"level\":\"3\"},{\"id\":\"2987\",\"catName\":\"��ֽ����Ļ��Ĥ\",\"level\":\"3\"},{\"id\":\"2988\",\"catName\":\"����\",\"level\":\"3\"},{\"id\":\"2989\",\"catName\":\"��ֽ��������\",\"level\":\"3\"}]},{\"id\":\"2939\",\"catName\":\"��̲�Ʒ���\",\"level\":\"2\",\"Children\":[{\"id\":\"2990\",\"catName\":\"���Ӵǵ�ѧϰ�����\",\"level\":\"3\"},{\"id\":\"2991\",\"catName\":\"�������������\",\"level\":\"3\"}]},{\"id\":\"2940\",\"catName\":\"�ɵ��/�����/��װ\",\"level\":\"2\",\"Children\":[{\"id\":\"2992\",\"catName\":\"18650���\",\"level\":\"3\"},{\"id\":\"2993\",\"catName\":\"18650��غ�\",\"level\":\"3\"},{\"id\":\"2994\",\"catName\":\"Ŧ�۵��\",\"level\":\"3\"},{\"id\":\"2995\",\"catName\":\"��ͨ�ɵ��\",\"level\":\"3\"},{\"id\":\"2996\",\"catName\":\"������������װ\",\"level\":\"3\"},{\"id\":\"2998\",\"catName\":\"��������ר�ó����װ\",\"level\":\"3\"},{\"id\":\"19249\",\"catName\":\"ͨ�õ�س����װ\",\"level\":\"3\"}]},{\"id\":\"2941\",\"catName\":\"Ӱ���ܱ����\",\"level\":\"2\",\"Children\":[{\"id\":\"2999\",\"catName\":\"3D�����۾�\",\"level\":\"3\"},{\"id\":\"3000\",\"catName\":\"AV�л���\",\"level\":\"3\"},{\"id\":\"3001\",\"catName\":\"BNCͷ\",\"level\":\"3\"},{\"id\":\"3002\",\"catName\":\"��ͷ/�ӿ�\",\"level\":\"3\"},{\"id\":\"3003\",\"catName\":\"���Ӹ�ѹ��\",\"level\":\"3\"},{\"id\":\"3004\",\"catName\":\"Fͷ\",\"level\":\"3\"},{\"id\":\"3005\",\"catName\":\"��ѹ��\",\"level\":\"3\"},{\"id\":\"3006\",\"catName\":\"������/��Ƶ��/��֧��\",\"level\":\"3\"},{\"id\":\"3007\",\"catName\":\"�����������\",\"level\":\"3\"},{\"id\":\"3008\",\"catName\":\"�����й�����\",\"level\":\"3\"},{\"id\":\"3009\",\"catName\":\"�ڵ���ʡ����\",\"level\":\"3\"},{\"id\":\"3010\",\"catName\":\"KVM\",\"level\":\"3\"},{\"id\":\"3011\",\"catName\":\"�����ҵ����\",\"level\":\"3\"},{\"id\":\"3012\",\"catName\":\"RCAͷ\",\"level\":\"3\"},{\"id\":\"3013\",\"catName\":\"RFͷ\",\"level\":\"3\"},{\"id\":\"3014\",\"catName\":\"����Ƶ��AV��\",\"level\":\"3\"},{\"id\":\"3015\",\"catName\":\"��Ƶ��ת����\",\"level\":\"3\"},{\"id\":\"3016\",\"catName\":\"VGA�л���\",\"level\":\"3\"},{\"id\":\"3017\",\"catName\":\"�����л���\",\"level\":\"3\"},{\"id\":\"3018\",\"catName\":\"΢��¯���\",\"level\":\"3\"},{\"id\":\"3019\",\"catName\":\"ң���豸\",\"level\":\"3\"}]},{\"id\":\"2942\",\"catName\":\"��Ƭ������\",\"level\":\"2\",\"Children\":[{\"id\":\"3023\",\"catName\":\"�������\",\"level\":\"3\"},{\"id\":\"19253\",\"catName\":\"Lomo������ܱ�\",\"level\":\"3\"},{\"id\":\"19258\",\"catName\":\"��Ƭ����\",\"level\":\"3\"},{\"id\":\"19261\",\"catName\":\"������������ܱ�\",\"level\":\"3\"}]},{\"id\":\"2943\",\"catName\":\"MP3/MP4/¼����\",\"level\":\"2\",\"Children\":[{\"id\":\"3024\",\"catName\":\"�����߼�\",\"level\":\"3\"},{\"id\":\"3025\",\"catName\":\"����������\",\"level\":\"3\"},{\"id\":\"3026\",\"catName\":\"�������\",\"level\":\"3\"},{\"id\":\"3027\",\"catName\":\"FM/MP3������\",\"level\":\"3\"},{\"id\":\"3028\",\"catName\":\"MP3/MP4֧��\",\"level\":\"3\"},{\"id\":\"3029\",\"catName\":\"MP4��Ļ����Ĥ\",\"level\":\"3\"},{\"id\":\"3030\",\"catName\":\"MP3/MP4�����\",\"level\":\"3\"},{\"id\":\"3031\",\"catName\":\"MP3/MP4������\",\"level\":\"3\"},{\"id\":\"3032\",\"catName\":\"MP3/MP4������\",\"level\":\"3\"},{\"id\":\"3033\",\"catName\":\"����MP3/MP4���\",\"level\":\"3\"},{\"id\":\"4656\",\"catName\":\"¼����\",\"level\":\"3\"},{\"id\":\"5723\",\"catName\":\"MP3/MP4������\",\"level\":\"3\"}]},{\"id\":\"2945\",\"catName\":\"ƽ��������\",\"level\":\"2\",\"Children\":[{\"id\":\"3035\",\"catName\":\"ƽ����Ա�����/��\",\"level\":\"3\"},{\"id\":\"3036\",\"catName\":\"ƽ�������Ӽ���\",\"level\":\"3\"},{\"id\":\"3037\",\"catName\":\"ƽ����Գ����\",\"level\":\"3\"},{\"id\":\"3038\",\"catName\":\"ƽ�����֧��\",\"level\":\"3\"},{\"id\":\"3039\",\"catName\":\"ƽ����Ե���\",\"level\":\"3\"},{\"id\":\"3040\",\"catName\":\"ƽ����԰�\",\"level\":\"3\"},{\"id\":\"3041\",\"catName\":\"ƽ�������Ļ��Ĥ\",\"level\":\"3\"},{\"id\":\"3042\",\"catName\":\"ƽ�����������\",\"level\":\"3\"},{\"id\":\"3043\",\"catName\":\"ƽ������㲿��\",\"level\":\"3\"},{\"id\":\"3044\",\"catName\":\"����ƽ��������\",\"level\":\"3\"}]},{\"id\":\"2946\",\"catName\":\"�ֻ����\",\"level\":\"2\",\"Children\":[{\"id\":\"3045\",\"catName\":\"�ֻ�������/��\",\"level\":\"3\"},{\"id\":\"3046\",\"catName\":\"�ֻ������\",\"level\":\"3\"},{\"id\":\"3047\",\"catName\":\"�ֻ��㲿��\",\"level\":\"3\"},{\"id\":\"3048\",\"catName\":\"�ֻ�������\",\"level\":\"3\"},{\"id\":\"3049\",\"catName\":\"�ֻ���Ʒ\",\"level\":\"3\"},{\"id\":\"3050\",\"catName\":\"�ֻ����\",\"level\":\"3\"},{\"id\":\"3051\",\"catName\":\"�ֻ���Ĥ\",\"level\":\"3\"},{\"id\":\"3052\",\"catName\":\"�ֻ�������\",\"level\":\"3\"},{\"id\":\"3053\",\"catName\":\"�ֻ����ܰ���\",\"level\":\"3\"},{\"id\":\"3055\",\"catName\":\"�ֻ�֧��/�ֻ���\",\"level\":\"3\"},{\"id\":\"3056\",\"catName\":\"SIM�����\",\"level\":\"3\"},{\"id\":\"3057\",\"catName\":\"�����ֻ����\",\"level\":\"3\"},{\"id\":\"5487\",\"catName\":\"�ֻ��źŷŴ���\",\"level\":\"3\"},{\"id\":\"5489\",\"catName\":\"TF��/�ֻ��ڴ濨\",\"level\":\"3\"},{\"id\":\"18128\",\"catName\":\"Ӧ�������\",\"level\":\"3\"},{\"id\":\"18129\",\"catName\":\"���߳����\",\"level\":\"3\"},{\"id\":\"19268\",\"catName\":\"�ֻ��������\",\"level\":\"3\"}]},{\"id\":\"2947\",\"catName\":\"����������\",\"level\":\"2\",\"Children\":[{\"id\":\"3058\",\"catName\":\"��Ļ����Ĥ\",\"level\":\"3\"},{\"id\":\"3059\",\"catName\":\"��������������\",\"level\":\"3\"},{\"id\":\"3060\",\"catName\":\"������������\",\"level\":\"3\"},{\"id\":\"3061\",\"catName\":\"����������\",\"level\":\"3\"},{\"id\":\"3062\",\"catName\":\"���������\",\"level\":\"3\"},{\"id\":\"3063\",\"catName\":\"�������������\",\"level\":\"3\"},{\"id\":\"3064\",\"catName\":\"����������\",\"level\":\"3\"}]},{\"id\":\"2948\",\"catName\":\"��������\",\"level\":\"2\",\"Children\":[{\"id\":\"18788\",\"catName\":\"��������\",\"level\":\"3\"}]},{\"id\":\"2949\",\"catName\":\"���������\",\"level\":\"2\",\"Children\":[{\"id\":\"3065\",\"catName\":\"������ɺ�\",\"level\":\"3\"},{\"id\":\"3066\",\"catName\":\"����������\",\"level\":\"3\"},{\"id\":\"3067\",\"catName\":\"�������������\",\"level\":\"3\"},{\"id\":\"3068\",\"catName\":\"����������\",\"level\":\"3\"}]},{\"id\":\"2950\",\"catName\":\"�������\",\"level\":\"2\",\"Children\":[{\"id\":\"3069\",\"catName\":\"�������\",\"level\":\"3\"}]},{\"id\":\"2951\",\"catName\":\"�����ܱ�\",\"level\":\"2\",\"Children\":[{\"id\":\"3070\",\"catName\":\"����������\",\"level\":\"3\"},{\"id\":\"3071\",\"catName\":\"������\",\"level\":\"3\"},{\"id\":\"3072\",\"catName\":\"PSP��Ϸ���\",\"level\":\"3\"},{\"id\":\"3073\",\"catName\":\"PDA���ϵ���\",\"level\":\"3\"},{\"id\":\"3074\",\"catName\":\"���������\",\"level\":\"3\"},{\"id\":\"3075\",\"catName\":\"��д��\",\"level\":\"3\"},{\"id\":\"3076\",\"catName\":\"������΢��\",\"level\":\"3\"},{\"id\":\"3077\",\"catName\":\"������\",\"level\":\"3\"},{\"id\":\"3078\",\"catName\":\"�����豸��Ӽ���\",\"level\":\"3\"},{\"id\":\"3079\",\"catName\":\"���濨ת����\",\"level\":\"3\"},{\"id\":\"3080\",\"catName\":\"����ά�޹���\",\"level\":\"3\"},{\"id\":\"3081\",\"catName\":\"������\",\"level\":\"3\"},{\"id\":\"3082\",\"catName\":\"�ƶ�֧���ն˻�\",\"level\":\"3\"},{\"id\":\"3083\",\"catName\":\"�������\",\"level\":\"3\"}]},{\"id\":\"2952\",\"catName\":\"USB�����ܱ�\",\"level\":\"2\",\"Children\":[{\"id\":\"3084\",\"catName\":\"�������\",\"level\":\"3\"},{\"id\":\"3085\",\"catName\":\"USB HUB/ת����\",\"level\":\"3\"},{\"id\":\"3086\",\"catName\":\"USB Humping Dog\",\"level\":\"3\"},{\"id\":\"3087\",\"catName\":\"USB��Ħ��\",\"level\":\"3\"},{\"id\":\"3088\",\"catName\":\"USB����Ʒ/װ��Ʒ\",\"level\":\"3\"},{\"id\":\"3089\",\"catName\":\"USB��ů����/����\",\"level\":\"3\"},{\"id\":\"3090\",\"catName\":\"USB���µ�/���µ�\",\"level\":\"3\"},{\"id\":\"3091\",\"catName\":\"USB��\",\"level\":\"3\"},{\"id\":\"3092\",\"catName\":\"USB�绰��\",\"level\":\"3\"},{\"id\":\"3093\",\"catName\":\"USB������/������\",\"level\":\"3\"},{\"id\":\"3094\",\"catName\":\"USB�๦�����뱦\",\"level\":\"3\"},{\"id\":\"3095\",\"catName\":\"USB��ҳ�����\",\"level\":\"3\"},{\"id\":\"3096\",\"catName\":\"USB����\",\"level\":\"3\"},{\"id\":\"3097\",\"catName\":\"USB��ʪ��\",\"level\":\"3\"},{\"id\":\"3098\",\"catName\":\"USB�������\",\"level\":\"3\"},{\"id\":\"3099\",\"catName\":\"USBů�ֱ�\",\"level\":\"3\"},{\"id\":\"3100\",\"catName\":\"USBů������\",\"level\":\"3\"},{\"id\":\"3101\",\"catName\":\"USBů����/ů��Ь\",\"level\":\"3\"},{\"id\":\"3102\",\"catName\":\"USBʳƷ���Ȱ�/���º�\",\"level\":\"3\"},{\"id\":\"3103\",\"catName\":\"USB��ֽ��\",\"level\":\"3\"},{\"id\":\"3104\",\"catName\":\"USB������\",\"level\":\"3\"},{\"id\":\"3105\",\"catName\":\"USB�̻Ҹ�\",\"level\":\"3\"},{\"id\":\"3106\",\"catName\":\"USB�ӳ���\",\"level\":\"3\"},{\"id\":\"3107\",\"catName\":\"USB����/����������\",\"level\":\"3\"},{\"id\":\"3108\",\"catName\":\"USB������\",\"level\":\"3\"}]},{\"id\":\"2953\",\"catName\":\"�ƶ���Դ\",\"level\":\"2\",\"Children\":[{\"id\":\"3109\",\"catName\":\"�ƶ���Դ\",\"level\":\"3\"},{\"id\":\"5490\",\"catName\":\"���߳�籦\",\"level\":\"3\"},{\"id\":\"20374\",\"catName\":\"�����Դ\",\"level\":\"3\"}]},{\"id\":\"3898\",\"catName\":\"����\",\"level\":\"2\",\"Children\":[{\"id\":\"5670\",\"catName\":\"USB����\",\"level\":\"3\"},{\"id\":\"5671\",\"catName\":\"�Ų�\",\"level\":\"3\"},{\"id\":\"5672\",\"catName\":\"ת����ͷ\",\"level\":\"3\"}]}]}}";
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
