package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import entity.IndustryTrend;
import entity.categoryinfo;
import entity.goods;
import entity.hotwords;
import mybatis.Mapper;
import mybatis.MybatisReader;

public class service {
	public static List<IndustryTrend> searchIndustryTrends(Integer catId,Integer day){
		SqlSession sqlSession=MybatisReader.getSession();
		List<IndustryTrend> list=sqlSession.getMapper(Mapper.class).getIndustrytrend(catId, day);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	public static List<hotwords> searchHotwords(Integer catId,Integer day){
		SqlSession sqlSession=MybatisReader.getSession();
		List<hotwords> list=sqlSession.getMapper(Mapper.class).getHotwords(catId, day);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	public static List<hotwords> searchHotlongtailedwords(Integer catId,Integer day){
		SqlSession sqlSession=MybatisReader.getSession();
		List<hotwords> list=sqlSession.getMapper(Mapper.class).gethotlongtailedwords(catId, day);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	public static List<goods> searchHotlist(Integer catId,Integer day){
		SqlSession sqlSession=MybatisReader.getSession();
		List<goods> list=sqlSession.getMapper(Mapper.class).getHotlist(catId, day);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	public static List<goods> searchGroupsurgelist(Integer catId,Integer day){
		SqlSession sqlSession=MybatisReader.getSession();
		List<goods> list=sqlSession.getMapper(Mapper.class).getGroupsurgelist(catId, day);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	public static List<categoryinfo> searchCategoryinfo(Integer catId){
		SqlSession sqlSession=MybatisReader.getSession();
		List<categoryinfo> list;
		if(catId==1) {
			list=sqlSession.getMapper(Mapper.class).getCategoryinfoParent();
		}else {
			list=sqlSession.getMapper(Mapper.class).getCategoryinfo(catId);
		}
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	public static List<hotwords> getHotwordRank(Integer day,Integer catId,Integer range,int flag){
		SqlSession sqlSession=MybatisReader.getSession();
		List<hotwords> list;
		if(catId==0) {
			if(flag==0) {
				list=sqlSession.getMapper(Mapper.class).getHotwordRankAllByClickNum(day, range);
			}else if (flag==1) {
				list=sqlSession.getMapper(Mapper.class).getHotwordRankAllByCompeteValue(day, range);
			}else if (flag==2) {
				list=sqlSession.getMapper(Mapper.class).getHotwordRankAllByPv(day, range);
			}else if (flag==3) {
				list=sqlSession.getMapper(Mapper.class).getHotwordRankAllByCtr(day, range);
			}else {
				list=sqlSession.getMapper(Mapper.class).getHotwordRankAllByCvr(day, range);
			}	
		}else {
			if(flag==0) {
				list=sqlSession.getMapper(Mapper.class).getHotwordRankByClickNum(day, catId,range);
			}else if (flag==1) {
				list=sqlSession.getMapper(Mapper.class).getHotwordRankByCompeteValue(day,catId,range);
			}else if (flag==2) {
				list=sqlSession.getMapper(Mapper.class).getHotwordRankByPv(day,catId,range);
			}else if (flag==3) {
				list=sqlSession.getMapper(Mapper.class).getHotwordRankByCtr(day,catId,range);
			}else {
				list=sqlSession.getMapper(Mapper.class).getHotwordRankByCvr(day,catId,range);
			}	
		}
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
}
