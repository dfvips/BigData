package entity;

public class IndustryTrend {
	private Integer visitor_num;
	private Integer search_num;
	private Integer click_num;
	private String update_date;
	private Integer cat_id;
	private String cat_name;
	
	
	public IndustryTrend(Integer visitor_num,Integer search_num,Integer click_num,String update_date,Integer cat_id,String cat_name) {
		this.visitor_num=visitor_num;
		this.search_num=search_num;
		this.click_num=click_num;
		this.update_date=update_date;
		this.cat_id=cat_id;
		this.cat_name=cat_name;
	}
	
	public IndustryTrend() {
		
	}
	/**
	 * @return the visitor_num
	 */
	public Integer getvisitor_num() {
		return visitor_num;
	}
	@Override
	public String toString() {
		return "IndustryTrend [visitor_num=" + visitor_num + ", search_num=" + search_num + ", click_num=" + click_num
				+ ", update_date=" + update_date + ", cat_id=" + cat_id + ", cat_name=" + cat_name + "]";
	}

	/**
	 * @param visitor_num the visitor_num to set
	 */
	public void setvisitor_num(Integer visitor_num) {
		this.visitor_num = visitor_num;
	}
	/**
	 * @return the search_num
	 */
	public Integer getsearch_num() {
		return search_num;
	}
	/**
	 * @param search_num the search_num to set
	 */
	public void setsearch_num(Integer search_num) {
		this.search_num = search_num;
	}
	/**
	 * @return the click_num
	 */
	public Integer getclick_num() {
		return click_num;
	}
	/**
	 * @param click_num the click_num to set
	 */
	public void setclick_num(Integer click_num) {
		this.click_num = click_num;
	}
	/**
	 * @return the update_date
	 */
	public String getupdate_date() {
		return update_date;
	}
	/**
	 * @param update_date the update_date to set
	 */
	public void setupdate_date(String update_date) {
		this.update_date = update_date;
	}
	/**
	 * @return the cat_id
	 */
	public Integer getcat_id() {
		return cat_id;
	}
	/**
	 * @param cat_id the cat_id to set
	 */
	public void setcat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	/**
	 * @return the cat_name
	 */
	public String getcat_name() {
		return cat_name;
	}
	/**
	 * @param cat_name the cat_name to set
	 */
	public void setcat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	
}
