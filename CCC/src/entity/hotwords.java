package entity;

public class hotwords {
	
	private Integer pv;
	private Integer click_num;
	private String ctr;
	private String cvr;
	private Integer compete_value;
	private String impr_avg_bid;
	private String word;
	private Integer cat_id;
	private String cat_name;
	private String update_date;
	
	public  hotwords() {
		
	}
	public  hotwords(Integer pv,Integer click_num,String ctr,String cvr,Integer compete_value,String impr_avg_bid,String word,Integer cat_id,String cat_name,String update_date) {
		this.pv=pv;
		this.click_num=click_num;
		this.ctr=ctr;
		this.cvr=cvr;
		this.compete_value=compete_value;
		this.impr_avg_bid=impr_avg_bid;
		this.word=word;
		this.cat_id=cat_id;
		this.cat_name=cat_name;
		this.update_date=update_date;
	}
	
	@Override
	public String toString() {
		return "hotwords [pv=" + pv + ", click_num=" + click_num + ", ctr=" + ctr + ", cvr=" + cvr + ", compete_value="
				+ compete_value + ", impr_avg_bid=" + impr_avg_bid + ", word=" + word + ", cat_id=" + cat_id + ", cat_name="
				+ cat_name + ", update_date=" + update_date + "]";
	}
	public Integer getPv() {
		return pv;
	}
	public void setPv(Integer pv) {
		this.pv = pv;
	}
	public Integer getclick_num() {
		return click_num;
	}
	public void setclick_num(Integer click_num) {
		this.click_num = click_num;
	}
	public String getCtr() {
		return ctr;
	}
	public void setCtr(String ctr) {
		this.ctr = ctr;
	}
	public String getCvr() {
		return cvr;
	}
	public void setCvr(String cvr) {
		this.cvr = cvr;
	}
	public Integer getcompete_value() {
		return compete_value;
	}
	public void setcompete_value(Integer compete_value) {
		this.compete_value = compete_value;
	}
	public String getimpr_avg_bid() {
		return impr_avg_bid;
	}
	public void setimpr_avg_bid(String impr_avg_bid) {
		this.impr_avg_bid = impr_avg_bid;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
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

	public String getupdate_date() {
		return update_date;
	}

	public void setupdate_date(String update_date) {
		this.update_date = update_date;
	}
}
