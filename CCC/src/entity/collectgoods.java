package entity;

public class collectgoods {
	
	private Integer hot_rise_id;
	
	private String goods_name;
	
	public collectgoods() {
		
	}
	
	public collectgoods(Integer hot_rise_id,String goods_name) {
		this.hot_rise_id = hot_rise_id;
		this.goods_name = goods_name;
	}
	
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public Integer getHot_rise_id() {
		return hot_rise_id;
	}
	public void setHot_rise_id(Integer hot_rise_id) {
		this.hot_rise_id = hot_rise_id;
	}
	
	
}
