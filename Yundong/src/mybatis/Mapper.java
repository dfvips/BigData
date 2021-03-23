package mybatis;

import java.util.List;

import entity.IndustryTrend;
import entity.categoryinfo;
import entity.collectgoods;
import entity.collectwords;
import entity.goods;
import entity.hotwords;


public interface Mapper {

	public int storeCategoryinfo(Integer catId, String catName, Integer level, Integer cat1Id, String cat1Name, Integer cat1Level);
	
	public int storeHotlist(Integer catId,String catName,String goodsName,Integer orderNum,Integer visitorNum,String incrPercent,String date,Integer type);
	
	public int storeGroupsurgelist(Integer catId,String catName,String goodsName,Integer orderNum,Integer visitorNum,String incrPercent,String date,Integer type);
	
	public List<categoryinfo> searchCategoryInfo();
	
	public int searchHotlist(Integer catId,String goodsName,Integer orderNum,Integer visitorNum);
	
	public int searchGroupsurgelist(Integer catId,String goodsName,Integer orderNum,Integer visitorNum);
	
	public int storehotwords(Integer pv,Integer clickNum,String ctr,String cvr,Integer competeValue,String imprAvgBid,String word,Integer catId,String catName,String date);
	
	public int storehotlongtailedwords(Integer pv,Integer clickNum,String ctr,String cvr,Integer competeValue,String imprAvgBid,String word,Integer catId,String catName,String date);

	public int queryhotword(Integer pv,Integer clickNum,String ctr,String cvr,Integer competeValue,String imprAvgBid,String word,Integer catId);
	
	public int queryhotlongtailedwords(Integer pv,Integer clickNum,String ctr,String cvr,Integer competeValue,String imprAvgBid,String word,Integer catId);

	public int storeIndustrytrend(Integer visitorNum,Integer searchNum,Integer clickNum,String date,Integer catId,String catName);
	
	public int queryIndustrytrend(Integer visitorNum,Integer searchNum,Integer clickNum,String date,Integer catId);
	
	public int storeallhotword(Integer heat,String query,String update_date,Integer cat_id,String cat_name);
	
	public int storewordtrend(String word,Integer pv,Integer click_num,String ctr,String cvr,String compete_value,String impr_avg_bid,String update_date,Integer word_id);
	
	public int storeyoungtrend(String word,Integer pv,Integer click_num,String ctr,String cvr,String compete_value,String impr_avg_bid,String update_date,Integer word_id);
	
	public int querywords(Integer heat,String query,Integer cat_id);
	
	public int queryWordTrend(String word,Integer pv,Integer click_num,String update_date);
	
	public int queryYoungTrend(String word,Integer pv,Integer click_num,String update_date);
	
	public List<hotwords> getHotwords(Integer catId,Integer day);
	
	public List<hotwords> gethotlongtailedwords(Integer catId,Integer day);
	
	public List<IndustryTrend> getIndustrytrend(Integer catId,Integer day);

	public List<goods> getHotlist(Integer catId,Integer day);

	public List<goods> getGroupsurgelist(Integer catId,Integer day);
	
	public List<categoryinfo> getCategoryinfoParent();
	
	public List<categoryinfo> getCategoryinfo(Integer catId);
	
	public List<hotwords>getHotwordRankByClickNum(Integer day,Integer catId,Integer range);
	
	public List<hotwords>getHotwordRankAllByClickNum(Integer day,Integer range);
	
	public List<hotwords>getHotwordRankByCompeteValue(Integer day,Integer catId,Integer range);
	
	public List<hotwords>getHotwordRankAllByCompeteValue(Integer day,Integer range);
	
	public List<hotwords>getHotwordRankByPv(Integer day,Integer catId,Integer range);
	
	public List<hotwords>getHotwordRankAllByPv(Integer day,Integer range);
	
	public List<hotwords>getHotwordRankByCtr(Integer day,Integer catId,Integer range);
	
	public List<hotwords>getHotwordRankAllByCtr(Integer day,Integer range);
	
	public List<hotwords>getHotwordRankByCvr(Integer day,Integer catId,Integer range);
	
	public List<hotwords>getHotwordRankAllByCvr(Integer day,Integer range);
	
	public List<goods>getGood(Integer catId);
	
	public List<collectwords>getCollectWord();
	
	public List<collectwords>getYoungWord();
	
	public List<collectgoods>getCollectGoods();
	
	public int updateHotCollect(String publish_date,Integer hot_rise_id);
	
	public int storeHotTrend (String update_date,String sell,String comment,String sum_sell,String good_num,String hot_rise_id,String normal_price,String group_price,String activity_start,String activity_end,String activity_img);
	
	public int queryHotNum(String query,Integer hot_rise_id);
	
}
