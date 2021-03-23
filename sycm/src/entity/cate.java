package entity;

public class cate {

	private Integer cat_id;
	private String cat_name;
	private Integer cat_parent;
	private Integer level;

	public cate(Integer cat_id, String cat_name, Integer cat_parent,Integer level) {
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.cat_parent = cat_parent;
		this.level = level;
	}

	@Override
	public String toString() {
		return "cate [cat_id=" + cat_id + ", cat_name=" + cat_name + ", cat_parent=" + cat_parent + ", level=" + level + "]";
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

	public Integer getCat_parent() {
		return cat_parent;
	}

	public void setCat_parent(Integer cat_parent) {
		this.cat_parent = cat_parent;
	}

	public cate() {

	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
