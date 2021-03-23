package mybatis;

import java.util.List;

import entity.cate;

public interface Mapper {
	public List<cate> searchCateInfo();

	public List<cate> searchAllCateInfo();

	public int fillCateInfo(Integer cat_parent, Integer cat_id, String cat_name, Integer level);

	public int fillOverview(Integer cat_id, String se_ipv_uv_hits, String se_pv_index, String uv, String pv,
			String clt_byr_cnt, String clt_times, String cart_byr_cnt, String cart_times, String pay_byr_cnt_index,
			String trade_index, String se_ipv_uv_hits_crc, String se_pv_index_crc, String uv_crc, String pv_crc,
			String clt_byr_cnt_crc, String clt_times_crc, String cart_byr_cnt_crc, String cart_times_crc,
			String pay_byr_cnt_index_crc, String trade_index_crc, String update_time, String crawl_time);

	public int fillHotsale(Integer cat_id, String trade_growth_range, String trade_growth_range_crc, String item_id,
			String pict_url, String detail_url, String item_title, String b2c_shop, String picture_url,
			String shop_title, String shop_url, String user_id, Integer cate_rank, Integer cate_rank_cqc,
			String trade_index, String pay_rate_index, String update_time, String crawl_time);

	public int fillHotsearch(Integer cat_id, String item_id, String pict_url, String detail_url, String item_title,
			String b2c_shop, String picture_url, String shop_title, String shop_url, String user_id, String trade_index,
			Integer cate_rank, String se_ipv_uv_hits, String uv_index, String update_time, String crawl_time);

	public int fillHotpurpose(Integer cat_id, String item_id, String pict_url, String detail_url, String item_title,
			String picture_url, String shop_title, String shop_url, String user_id, String trade_index,
			Integer cate_rank, Integer cate_rank_cqc, String clt_hits, String cart_hits, String update_time,
			String crawl_time);

	public int fillSearchwordHot(Integer cat_id, String click_hits, String click_rate, Integer rank, Integer order_num,
			String p4p_ref_price, String pay_rate, String se_ipv_uv_hits, String search_word, String tm_click_rate,
			String update_time, String crawl_time);

	public int fillSearchwordSoar(Integer cat_id, String click_hits, String click_rate, Integer rank, Integer order_num,
			String p4p_ref_price, String pay_rate, String se_ipv_uv_hits, String search_word, String se_rise_rate,
			String update_time, String crawl_time);

	public int fillTailwordHot(Integer cat_id, String click_hits, String click_rate, Integer rank, Integer order_num,
			String p4p_ref_price, String pay_rate, String se_ipv_uv_hits, String search_word, String tm_click_rate,
			String update_time, String crawl_time);

	public int fillTailwordSoar(Integer cat_id, String click_hits, String click_rate, Integer rank, Integer order_num,
			String p4p_ref_price, String pay_rate, String se_ipv_uv_hits, String search_word, String se_rise_rate,
			String update_time, String crawl_time);

	public int fillBrandwordHot(Integer cat_id, String avg_word_click_hits, String avg_word_click_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time);
	
	public int fillBrandwordSoar(Integer cat_id, String avg_word_click_hits, String avg_word_se_rise_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time);
	
	public int fillCorewordHot(Integer cat_id, String avg_word_click_hits, String avg_word_click_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time);
	
	public int fillCorewordSoar(Integer cat_id, String avg_word_click_hits, String avg_word_se_rise_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time);
	
	public int fillAttrwordHot(Integer cat_id, String avg_word_click_hits, String avg_word_click_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time);
	
	public int fillAttrwordSoar(Integer cat_id, String avg_word_click_hits, String avg_word_se_rise_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time);
}
