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
		String json="{\"success\":true,\"errorCode\":1000,\"errorMsg\":\"null\",\"result\":{\"mallId\":\"547260797\",\"catInfoList\":[{\"id\":\"2934\",\"catName\":\"无线上网卡设备\",\"level\":\"2\",\"Children\":[{\"id\":\"2954\",\"catName\":\"无线上网卡设备\",\"level\":\"3\"}]},{\"id\":\"2935\",\"catName\":\"笔记本电脑配件\",\"level\":\"2\",\"Children\":[{\"id\":\"2955\",\"catName\":\"笔记本电池\",\"level\":\"3\"},{\"id\":\"2956\",\"catName\":\"笔记本电脑包\",\"level\":\"3\"},{\"id\":\"2957\",\"catName\":\"笔记本散热器\",\"level\":\"3\"},{\"id\":\"2958\",\"catName\":\"笔记本炫彩贴\",\"level\":\"3\"},{\"id\":\"2959\",\"catName\":\"笔记本支架/桌\",\"level\":\"3\"},{\"id\":\"2960\",\"catName\":\"笔记本键盘保护膜\",\"level\":\"3\"},{\"id\":\"2961\",\"catName\":\"笔记本屏幕贴膜\",\"level\":\"3\"},{\"id\":\"2962\",\"catName\":\"笔记本电源\",\"level\":\"3\"},{\"id\":\"2963\",\"catName\":\"笔记本个性小贴纸\",\"level\":\"3\"},{\"id\":\"2964\",\"catName\":\"笔记本零部件\",\"level\":\"3\"},{\"id\":\"2965\",\"catName\":\"笔记本膝上桌\",\"level\":\"3\"},{\"id\":\"2966\",\"catName\":\"键盘刷\",\"level\":\"3\"},{\"id\":\"2967\",\"catName\":\"苹果转换线\",\"level\":\"3\"},{\"id\":\"2968\",\"catName\":\"其他\",\"level\":\"3\"},{\"id\":\"5478\",\"catName\":\"笔记本清洁用品\",\"level\":\"3\"}]},{\"id\":\"2936\",\"catName\":\"车载手机配件\",\"level\":\"2\",\"Children\":[{\"id\":\"2969\",\"catName\":\"车载支架\",\"level\":\"3\"},{\"id\":\"2970\",\"catName\":\"车载充电器\",\"level\":\"3\"},{\"id\":\"2971\",\"catName\":\"车载发射器\",\"level\":\"3\"}]},{\"id\":\"2937\",\"catName\":\"单反单电相机配件\",\"level\":\"2\",\"Children\":[{\"id\":\"5479\",\"catName\":\"SD卡/CF卡/相机卡\",\"level\":\"3\"},{\"id\":\"19174\",\"catName\":\"背包箱具\",\"level\":\"3\"},{\"id\":\"19175\",\"catName\":\"单反/单电专用电池电源\",\"level\":\"3\"},{\"id\":\"19176\",\"catName\":\"清洁用品\",\"level\":\"3\"},{\"id\":\"19177\",\"catName\":\"机身附件\",\"level\":\"3\"},{\"id\":\"19178\",\"catName\":\"脚架云台\",\"level\":\"3\"},{\"id\":\"19179\",\"catName\":\"镜头附件\",\"level\":\"3\"},{\"id\":\"19180\",\"catName\":\"其他配件\",\"level\":\"3\"},{\"id\":\"19181\",\"catName\":\"色彩管理\",\"level\":\"3\"},{\"id\":\"19182\",\"catName\":\"闪光灯\",\"level\":\"3\"},{\"id\":\"19183\",\"catName\":\"影棚设备\",\"level\":\"3\"}]},{\"id\":\"2938\",\"catName\":\"电子书配件\",\"level\":\"2\",\"Children\":[{\"id\":\"2982\",\"catName\":\"电子书手写笔/电磁笔\",\"level\":\"3\"},{\"id\":\"2983\",\"catName\":\"电子书灯\",\"level\":\"3\"},{\"id\":\"2984\",\"catName\":\"电子书保护套\",\"level\":\"3\"},{\"id\":\"2985\",\"catName\":\"电子书防护包\",\"level\":\"3\"},{\"id\":\"2986\",\"catName\":\"电纸书充电器\",\"level\":\"3\"},{\"id\":\"2987\",\"catName\":\"电纸书屏幕贴膜\",\"level\":\"3\"},{\"id\":\"2988\",\"catName\":\"其它\",\"level\":\"3\"},{\"id\":\"2989\",\"catName\":\"电纸书数据线\",\"level\":\"3\"}]},{\"id\":\"2939\",\"catName\":\"电教产品配件\",\"level\":\"2\",\"Children\":[{\"id\":\"2990\",\"catName\":\"电子辞典学习机配件\",\"level\":\"3\"},{\"id\":\"2991\",\"catName\":\"点读机点读笔配件\",\"level\":\"3\"}]},{\"id\":\"2940\",\"catName\":\"干电池/充电电池/套装\",\"level\":\"2\",\"Children\":[{\"id\":\"2992\",\"catName\":\"18650电池\",\"level\":\"3\"},{\"id\":\"2993\",\"catName\":\"18650电池盒\",\"level\":\"3\"},{\"id\":\"2994\",\"catName\":\"纽扣电池\",\"level\":\"3\"},{\"id\":\"2995\",\"catName\":\"普通干电池\",\"level\":\"3\"},{\"id\":\"2996\",\"catName\":\"其它数码充电套装\",\"level\":\"3\"},{\"id\":\"2998\",\"catName\":\"相机摄像机专用充电套装\",\"level\":\"3\"},{\"id\":\"19249\",\"catName\":\"通用电池充电套装\",\"level\":\"3\"}]},{\"id\":\"2941\",\"catName\":\"影音周边配件\",\"level\":\"2\",\"Children\":[{\"id\":\"2999\",\"catName\":\"3D立体眼镜\",\"level\":\"3\"},{\"id\":\"3000\",\"catName\":\"AV切换器\",\"level\":\"3\"},{\"id\":\"3001\",\"catName\":\"BNC头\",\"level\":\"3\"},{\"id\":\"3002\",\"catName\":\"插头/接口\",\"level\":\"3\"},{\"id\":\"3003\",\"catName\":\"电视高压包\",\"level\":\"3\"},{\"id\":\"3004\",\"catName\":\"F头\",\"level\":\"3\"},{\"id\":\"3005\",\"catName\":\"分压盒\",\"level\":\"3\"},{\"id\":\"3006\",\"catName\":\"分配器/分频器/分支器\",\"level\":\"3\"},{\"id\":\"3007\",\"catName\":\"隔离器耦合器\",\"level\":\"3\"},{\"id\":\"3008\",\"catName\":\"机顶盒共享器\",\"level\":\"3\"},{\"id\":\"3009\",\"catName\":\"节电器省电器\",\"level\":\"3\"},{\"id\":\"3010\",\"catName\":\"KVM\",\"level\":\"3\"},{\"id\":\"3011\",\"catName\":\"其它家电配件\",\"level\":\"3\"},{\"id\":\"3012\",\"catName\":\"RCA头\",\"level\":\"3\"},{\"id\":\"3013\",\"catName\":\"RF头\",\"level\":\"3\"},{\"id\":\"3014\",\"catName\":\"视音频线AV线\",\"level\":\"3\"},{\"id\":\"3015\",\"catName\":\"射频器转换器\",\"level\":\"3\"},{\"id\":\"3016\",\"catName\":\"VGA切换器\",\"level\":\"3\"},{\"id\":\"3017\",\"catName\":\"网络切换器\",\"level\":\"3\"},{\"id\":\"3018\",\"catName\":\"微波炉面板\",\"level\":\"3\"},{\"id\":\"3019\",\"catName\":\"遥控设备\",\"level\":\"3\"}]},{\"id\":\"2942\",\"catName\":\"胶片相机配件\",\"level\":\"2\",\"Children\":[{\"id\":\"3023\",\"catName\":\"其他配件\",\"level\":\"3\"},{\"id\":\"19253\",\"catName\":\"Lomo配件及周边\",\"level\":\"3\"},{\"id\":\"19258\",\"catName\":\"胶片胶卷\",\"level\":\"3\"},{\"id\":\"19261\",\"catName\":\"拍立得配件及周边\",\"level\":\"3\"}]},{\"id\":\"2943\",\"catName\":\"MP3/MP4/录音笔\",\"level\":\"2\",\"Children\":[{\"id\":\"3024\",\"catName\":\"耳机线夹\",\"level\":\"3\"},{\"id\":\"3025\",\"catName\":\"耳塞保护套\",\"level\":\"3\"},{\"id\":\"3026\",\"catName\":\"耳机配件\",\"level\":\"3\"},{\"id\":\"3027\",\"catName\":\"FM/MP3发射器\",\"level\":\"3\"},{\"id\":\"3028\",\"catName\":\"MP3/MP4支架\",\"level\":\"3\"},{\"id\":\"3029\",\"catName\":\"MP4屏幕保护膜\",\"level\":\"3\"},{\"id\":\"3030\",\"catName\":\"MP3/MP4充电器\",\"level\":\"3\"},{\"id\":\"3031\",\"catName\":\"MP3/MP4保护套\",\"level\":\"3\"},{\"id\":\"3032\",\"catName\":\"MP3/MP4连接线\",\"level\":\"3\"},{\"id\":\"3033\",\"catName\":\"其它MP3/MP4配件\",\"level\":\"3\"},{\"id\":\"4656\",\"catName\":\"录音笔\",\"level\":\"3\"},{\"id\":\"5723\",\"catName\":\"MP3/MP4播放器\",\"level\":\"3\"}]},{\"id\":\"2945\",\"catName\":\"平板电脑配件\",\"level\":\"2\",\"Children\":[{\"id\":\"3035\",\"catName\":\"平板电脑保护套/壳\",\"level\":\"3\"},{\"id\":\"3036\",\"catName\":\"平板电脑外接键盘\",\"level\":\"3\"},{\"id\":\"3037\",\"catName\":\"平板电脑充电器\",\"level\":\"3\"},{\"id\":\"3038\",\"catName\":\"平板电脑支架\",\"level\":\"3\"},{\"id\":\"3039\",\"catName\":\"平板电脑底座\",\"level\":\"3\"},{\"id\":\"3040\",\"catName\":\"平板电脑包\",\"level\":\"3\"},{\"id\":\"3041\",\"catName\":\"平板电脑屏幕贴膜\",\"level\":\"3\"},{\"id\":\"3042\",\"catName\":\"平板电脑数据线\",\"level\":\"3\"},{\"id\":\"3043\",\"catName\":\"平板电脑零部件\",\"level\":\"3\"},{\"id\":\"3044\",\"catName\":\"其它平板电脑配件\",\"level\":\"3\"}]},{\"id\":\"2946\",\"catName\":\"手机配件\",\"level\":\"2\",\"Children\":[{\"id\":\"3045\",\"catName\":\"手机保护套/壳\",\"level\":\"3\"},{\"id\":\"3046\",\"catName\":\"手机充电器\",\"level\":\"3\"},{\"id\":\"3047\",\"catName\":\"手机零部件\",\"level\":\"3\"},{\"id\":\"3048\",\"catName\":\"手机防尘塞\",\"level\":\"3\"},{\"id\":\"3049\",\"catName\":\"手机饰品\",\"level\":\"3\"},{\"id\":\"3050\",\"catName\":\"手机电池\",\"level\":\"3\"},{\"id\":\"3051\",\"catName\":\"手机贴膜\",\"level\":\"3\"},{\"id\":\"3052\",\"catName\":\"手机数据线\",\"level\":\"3\"},{\"id\":\"3053\",\"catName\":\"手机智能按键\",\"level\":\"3\"},{\"id\":\"3055\",\"catName\":\"手机支架/手机座\",\"level\":\"3\"},{\"id\":\"3056\",\"catName\":\"SIM卡相关\",\"level\":\"3\"},{\"id\":\"3057\",\"catName\":\"其它手机配件\",\"level\":\"3\"},{\"id\":\"5487\",\"catName\":\"手机信号放大器\",\"level\":\"3\"},{\"id\":\"5489\",\"catName\":\"TF卡/手机内存卡\",\"level\":\"3\"},{\"id\":\"18128\",\"catName\":\"应急充电器\",\"level\":\"3\"},{\"id\":\"18129\",\"catName\":\"无线充电器\",\"level\":\"3\"},{\"id\":\"19268\",\"catName\":\"手机拍照配件\",\"level\":\"3\"}]},{\"id\":\"2947\",\"catName\":\"数码相机配件\",\"level\":\"2\",\"Children\":[{\"id\":\"3058\",\"catName\":\"屏幕保护膜\",\"level\":\"3\"},{\"id\":\"3059\",\"catName\":\"其它数码相机配件\",\"level\":\"3\"},{\"id\":\"3060\",\"catName\":\"数码相机充电器\",\"level\":\"3\"},{\"id\":\"3061\",\"catName\":\"数码相机电池\",\"level\":\"3\"},{\"id\":\"3062\",\"catName\":\"数码相机包\",\"level\":\"3\"},{\"id\":\"3063\",\"catName\":\"数码相机适配器\",\"level\":\"3\"},{\"id\":\"3064\",\"catName\":\"数据连接线\",\"level\":\"3\"}]},{\"id\":\"2948\",\"catName\":\"摄像机配件\",\"level\":\"2\",\"Children\":[{\"id\":\"18788\",\"catName\":\"摄像机配件\",\"level\":\"3\"}]},{\"id\":\"2949\",\"catName\":\"数码包收纳\",\"level\":\"2\",\"Children\":[{\"id\":\"3065\",\"catName\":\"电池收纳盒\",\"level\":\"3\"},{\"id\":\"3066\",\"catName\":\"耳机绕线器\",\"level\":\"3\"},{\"id\":\"3067\",\"catName\":\"数码收纳整理包\",\"level\":\"3\"},{\"id\":\"3068\",\"catName\":\"线缆收纳器\",\"level\":\"3\"}]},{\"id\":\"2950\",\"catName\":\"数码相框\",\"level\":\"2\",\"Children\":[{\"id\":\"3069\",\"catName\":\"数码相框\",\"level\":\"3\"}]},{\"id\":\"2951\",\"catName\":\"数码周边\",\"level\":\"2\",\"Children\":[{\"id\":\"3070\",\"catName\":\"触摸屏手套\",\"level\":\"3\"},{\"id\":\"3071\",\"catName\":\"读卡器\",\"level\":\"3\"},{\"id\":\"3072\",\"catName\":\"PSP游戏配件\",\"level\":\"3\"},{\"id\":\"3073\",\"catName\":\"PDA掌上电脑\",\"level\":\"3\"},{\"id\":\"3074\",\"catName\":\"其它充电器\",\"level\":\"3\"},{\"id\":\"3075\",\"catName\":\"手写笔\",\"level\":\"3\"},{\"id\":\"3076\",\"catName\":\"数码显微镜\",\"level\":\"3\"},{\"id\":\"3077\",\"catName\":\"数据线\",\"level\":\"3\"},{\"id\":\"3078\",\"catName\":\"数码设备外接键盘\",\"level\":\"3\"},{\"id\":\"3079\",\"catName\":\"闪存卡转接套\",\"level\":\"3\"},{\"id\":\"3080\",\"catName\":\"数码维修工具\",\"level\":\"3\"},{\"id\":\"3081\",\"catName\":\"音乐枕\",\"level\":\"3\"},{\"id\":\"3082\",\"catName\":\"移动支付终端机\",\"level\":\"3\"},{\"id\":\"3083\",\"catName\":\"其它电池\",\"level\":\"3\"}]},{\"id\":\"2952\",\"catName\":\"USB电脑周边\",\"level\":\"2\",\"Children\":[{\"id\":\"3084\",\"catName\":\"其它电池\",\"level\":\"3\"},{\"id\":\"3085\",\"catName\":\"USB HUB/转换器\",\"level\":\"3\"},{\"id\":\"3086\",\"catName\":\"USB Humping Dog\",\"level\":\"3\"},{\"id\":\"3087\",\"catName\":\"USB按摩器\",\"level\":\"3\"},{\"id\":\"3088\",\"catName\":\"USB摆设品/装饰品\",\"level\":\"3\"},{\"id\":\"3089\",\"catName\":\"USB保暖坐垫/靠垫\",\"level\":\"3\"},{\"id\":\"3090\",\"catName\":\"USB保温碟/保温垫\",\"level\":\"3\"},{\"id\":\"3091\",\"catName\":\"USB灯\",\"level\":\"3\"},{\"id\":\"3092\",\"catName\":\"USB电话机\",\"level\":\"3\"},{\"id\":\"3093\",\"catName\":\"USB电脑锁/防盗器\",\"level\":\"3\"},{\"id\":\"3094\",\"catName\":\"USB多功能数码宝\",\"level\":\"3\"},{\"id\":\"3095\",\"catName\":\"USB翻页激光笔\",\"level\":\"3\"},{\"id\":\"3096\",\"catName\":\"USB风扇\",\"level\":\"3\"},{\"id\":\"3097\",\"catName\":\"USB加湿器\",\"level\":\"3\"},{\"id\":\"3098\",\"catName\":\"USB迷你冰箱\",\"level\":\"3\"},{\"id\":\"3099\",\"catName\":\"USB暖手宝\",\"level\":\"3\"},{\"id\":\"3100\",\"catName\":\"USB暖手鼠标垫\",\"level\":\"3\"},{\"id\":\"3101\",\"catName\":\"USB暖手套/暖脚鞋\",\"level\":\"3\"},{\"id\":\"3102\",\"catName\":\"USB食品加热包/保温盒\",\"level\":\"3\"},{\"id\":\"3103\",\"catName\":\"USB碎纸机\",\"level\":\"3\"},{\"id\":\"3104\",\"catName\":\"USB吸尘器\",\"level\":\"3\"},{\"id\":\"3105\",\"catName\":\"USB烟灰缸\",\"level\":\"3\"},{\"id\":\"3106\",\"catName\":\"USB延长线\",\"level\":\"3\"},{\"id\":\"3107\",\"catName\":\"USB氧吧/空气清新器\",\"level\":\"3\"},{\"id\":\"3108\",\"catName\":\"USB驱蚊器\",\"level\":\"3\"}]},{\"id\":\"2953\",\"catName\":\"移动电源\",\"level\":\"2\",\"Children\":[{\"id\":\"3109\",\"catName\":\"移动电源\",\"level\":\"3\"},{\"id\":\"5490\",\"catName\":\"无线充电宝\",\"level\":\"3\"},{\"id\":\"20374\",\"catName\":\"户外电源\",\"level\":\"3\"}]},{\"id\":\"3898\",\"catName\":\"插座\",\"level\":\"2\",\"Children\":[{\"id\":\"5670\",\"catName\":\"USB插座\",\"level\":\"3\"},{\"id\":\"5671\",\"catName\":\"排插\",\"level\":\"3\"},{\"id\":\"5672\",\"catName\":\"转换插头\",\"level\":\"3\"}]}]}}";
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
