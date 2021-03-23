package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import entity.cate;
import mybatis.Mapper_make;
import mybatis.MybatisReader_make;

public class service_make {
	public static List<cate> searchCateInfo() {
		SqlSession sqlSession = MybatisReader_make.getSession();
		List<cate> list = sqlSession.getMapper(Mapper_make.class).searchCateInfo();
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	public static int fillCateInfo(Integer cat_parent, Integer cat_id, String cat_name, Integer level) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillCateInfo(cat_parent, cat_id, cat_name, level);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static List<cate> searchAllCateInfo() {
		SqlSession sqlSession = MybatisReader_make.getSession();
		List<cate> list = sqlSession.getMapper(Mapper_make.class).searchAllCateInfo();
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	public static int fillOverview(Integer cat_id, String se_ipv_uv_hits, String se_pv_index, String uv, String pv,
			String clt_byr_cnt, String clt_times, String cart_byr_cnt, String cart_times, String pay_byr_cnt_index,
			String trade_index, String se_ipv_uv_hits_crc, String se_pv_index_crc, String uv_crc, String pv_crc,
			String clt_byr_cnt_crc, String clt_times_crc, String cart_byr_cnt_crc, String cart_times_crc,
			String pay_byr_cnt_index_crc, String trade_index_crc, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillOverview(cat_id, se_ipv_uv_hits, se_pv_index, uv, pv,
				clt_byr_cnt, clt_times, cart_byr_cnt, cart_times, pay_byr_cnt_index, trade_index, se_ipv_uv_hits_crc,
				se_pv_index_crc, uv_crc, pv_crc, clt_byr_cnt_crc, clt_times_crc, cart_byr_cnt_crc, cart_times_crc,
				pay_byr_cnt_index_crc, trade_index_crc, update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static int fillHotsale(Integer cat_id, String trade_growth_range, String trade_growth_range_crc,
			String item_id, String pict_url, String detail_url, String item_title, String b2c_shop, String picture_url,
			String shop_title, String shop_url, String user_id, Integer cate_rank, Integer cate_rank_cqc,
			String trade_index, String pay_rate_index, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillHotsale(cat_id, trade_growth_range, trade_growth_range_crc,
				item_id, pict_url, detail_url, item_title, b2c_shop, picture_url, shop_title, shop_url, user_id,
				cate_rank, cate_rank_cqc, trade_index, pay_rate_index, update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static int fillHotsearch(Integer cat_id, String item_id, String pict_url, String detail_url,
			String item_title, String b2c_shop, String picture_url, String shop_title, String shop_url, String user_id,
			String trade_index, Integer cate_rank, String se_ipv_uv_hits, String uv_index, String update_time,
			String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillHotsearch(cat_id, item_id, pict_url, detail_url, item_title,
				b2c_shop, picture_url, shop_title, shop_url, user_id, trade_index, cate_rank, se_ipv_uv_hits, uv_index,
				update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static int fillHotpurpose(Integer cat_id, String item_id, String pict_url, String detail_url,
			String item_title, String picture_url, String shop_title, String shop_url, String user_id,
			String trade_index, Integer cate_rank, Integer cate_rank_cqc, String clt_hits, String cart_hits,
			String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillHotpurpose(cat_id, item_id, pict_url, detail_url, item_title,
				picture_url, shop_title, shop_url, user_id, trade_index, cate_rank, cate_rank_cqc, clt_hits, cart_hits,
				update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static int fillSearchwordHot(Integer cat_id, String click_hits, String click_rate, Integer rank,
			Integer order_num, String p4p_ref_price, String pay_rate, String se_ipv_uv_hits, String search_word,
			String tm_click_rate, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillSearchwordHot(cat_id, click_hits, click_rate, rank, order_num,
				p4p_ref_price, pay_rate, se_ipv_uv_hits, search_word, tm_click_rate, update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;

	}

	public static int fillSearchwordSoar(Integer cat_id, String click_hits, String click_rate, Integer rank,
			Integer order_num, String p4p_ref_price, String pay_rate, String se_ipv_uv_hits, String search_word,
			String se_rise_rate, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillSearchwordSoar(cat_id, click_hits, click_rate, rank, order_num,
				p4p_ref_price, pay_rate, se_ipv_uv_hits, search_word, se_rise_rate, update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static int fillTailwordHot(Integer cat_id, String click_hits, String click_rate, Integer rank,
			Integer order_num, String p4p_ref_price, String pay_rate, String se_ipv_uv_hits, String search_word,
			String tm_click_rate, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillTailwordHot(cat_id, click_hits, click_rate, rank, order_num,
				p4p_ref_price, pay_rate, se_ipv_uv_hits, search_word, tm_click_rate, update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;

	}

	public static int fillTailwordSoar(Integer cat_id, String click_hits, String click_rate, Integer rank,
			Integer order_num, String p4p_ref_price, String pay_rate, String se_ipv_uv_hits, String search_word,
			String se_rise_rate, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillTailwordSoar(cat_id, click_hits, click_rate, rank, order_num,
				p4p_ref_price, pay_rate, se_ipv_uv_hits, search_word, se_rise_rate, update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static int fillBrandwordHot(Integer cat_id, String avg_word_click_hits, String avg_word_click_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillBrandwordHot(cat_id, avg_word_click_hits, avg_word_click_rate,
				avg_word_pay_rate, avg_word_se_ipv_uv_hits, rank, search_word, p4p_ref_price, rel_se_word_cnt,
				update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static int fillBrandwordSoar(Integer cat_id, String avg_word_click_hits, String avg_word_se_rise_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillBrandwordSoar(cat_id, avg_word_click_hits,
				avg_word_se_rise_rate, avg_word_pay_rate, avg_word_se_ipv_uv_hits, rank, search_word, p4p_ref_price,
				rel_se_word_cnt, update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static int fillCorewordHot(Integer cat_id, String avg_word_click_hits, String avg_word_click_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillCorewordHot(cat_id, avg_word_click_hits, avg_word_click_rate,
				avg_word_pay_rate, avg_word_se_ipv_uv_hits, rank, search_word, p4p_ref_price, rel_se_word_cnt,
				update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static int fillCorewordSoar(Integer cat_id, String avg_word_click_hits, String avg_word_se_rise_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillCorewordSoar(cat_id, avg_word_click_hits,
				avg_word_se_rise_rate, avg_word_pay_rate, avg_word_se_ipv_uv_hits, rank, search_word, p4p_ref_price,
				rel_se_word_cnt, update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static int fillAttrwordHot(Integer cat_id, String avg_word_click_hits, String avg_word_click_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillAttrwordHot(cat_id, avg_word_click_hits, avg_word_click_rate,
				avg_word_pay_rate, avg_word_se_ipv_uv_hits, rank, search_word, p4p_ref_price, rel_se_word_cnt,
				update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	public static int fillAttrwordSoar(Integer cat_id, String avg_word_click_hits, String avg_word_se_rise_rate,
			String avg_word_pay_rate, String avg_word_se_ipv_uv_hits, Integer rank, String search_word,
			String p4p_ref_price, String rel_se_word_cnt, String update_time, String crawl_time) {
		SqlSession sqlSession = MybatisReader_make.getSession();
		int num = sqlSession.getMapper(Mapper_make.class).fillAttrwordSoar(cat_id, avg_word_click_hits,
				avg_word_se_rise_rate, avg_word_pay_rate, avg_word_se_ipv_uv_hits, rank, search_word, p4p_ref_price,
				rel_se_word_cnt, update_time, crawl_time);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

}
