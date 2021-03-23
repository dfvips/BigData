package entity;

public class goods {
	private Integer cat_id;
	private String cat_name;
	private String goods_name;
	private Integer order_num;
	private Integer visitor_num;
	private String incr_percent;
	private String update_date;
	private Integer type;
	
	public goods() {
		
	}
	public goods(Integer cat_id,String cat_name,String goods_name,Integer order_num,Integer visitor_num,String incr_percent,String update_date,Integer type) {
		this.cat_id=cat_id;
		this.cat_name=cat_name;
		this.goods_name=goods_name;
		this.order_num=order_num;
		this.visitor_num=visitor_num;
		this.incr_percent=incr_percent;
		this.update_date=update_date;
		this.type=type;
	}
	@Override
	public String toString() {
		return "goods [cat_id=" + cat_id + ", cat_name=" + cat_name + ", goods_name=" + goods_name + ", order_num=" + order_num
				+ ", visitor_num=" + visitor_num + ", incr_percent=" + incr_percent + ", update_date=" + update_date + ", type=" + type
				+ "]";
	}
	public Integer getcat_id() {
		return cat_id;
	}
	public void setcat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	public String getcat_name() {
		return cat_name;
	}
	public void setcat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getgoods_name() {
		return goods_name;
	}
	public void setgoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public Integer getorder_num() {
		return order_num;
	}
	public void setorder_num(Integer order_num) {
		this.order_num = order_num;
	}
	public Integer getvisitor_num() {
		return visitor_num;
	}
	public void setvisitor_num(Integer visitor_num) {
		this.visitor_num = visitor_num;
	}
	public String getincr_percent() {
		return incr_percent;
	}
	public void setincr_percent(String incr_percent) {
		this.incr_percent = incr_percent;
	}
	public String getupdate_date() {
		return update_date;
	}
	public void setupdate_date(String update_date) {
		this.update_date = update_date;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
