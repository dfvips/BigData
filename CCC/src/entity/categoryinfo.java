package entity;

public class categoryinfo {
	private Integer cat_id;
	private String cat_name;
	private Integer level;
	private Integer parent_cat_id;
	private String parent_cat_name;
	private Integer parent_cat_level;
	
	public categoryinfo() {
		
	}
	
	public categoryinfo(Integer cat_id,String cat_name,Integer level,Integer parent_cat_id,String parent_cat_name,Integer parent_cat_level) {
		this.cat_id=cat_id;
		this.cat_name=cat_name;
		this.level=level;
		this.parent_cat_id=parent_cat_id;
		this.parent_cat_name=parent_cat_name;
		this.parent_cat_level=parent_cat_level;
	}
	
	@Override
	public String toString() {
		return "categoryinfo [cat_id=" + cat_id + ", cat_name=" + cat_name + ", level=" + level + ", parent_cat_id=" + parent_cat_id
				+ ", parent_cat_name=" + parent_cat_name + ", parent_cat_level=" + parent_cat_level + "]";
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getparent_cat_id() {
		return parent_cat_id;
	}
	public void setparent_cat_id(Integer parent_cat_id) {
		this.parent_cat_id = parent_cat_id;
	}
	public String getparent_cat_name() {
		return parent_cat_name;
	}
	public void setparent_cat_name(String parent_cat_name) {
		this.parent_cat_name = parent_cat_name;
	}

	public Integer getparent_cat_level() {
		return parent_cat_level;
	}

	public void setparent_cat_level(Integer parent_cat_level) {
		this.parent_cat_level = parent_cat_level;
	}
}
