package entity;

public class words {
	private Integer heat;
	private String query;
	private String update_date;
	private Integer cat_id;
	private String cat_name;
	
	public words() {
		
	}
	
	public words(Integer heat,String query,String update_date,Integer cat_id,String cat_name) {
		this.heat=heat;
		this.query=query;
		this.update_date=update_date;
		this.cat_id=cat_id;
		this.cat_name=cat_name;
	}
	
	public Integer getHeat() {
		return heat;
	}
	public void setHeat(Integer heat) {
		this.heat = heat;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public Integer getCat_id() {
		return cat_id;
	}
	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
}
