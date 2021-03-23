package entity;

public class wordtrend {
	private Integer pv;
	private Integer click_num;
	private String ctr;
	private String cvr;
	private Integer compete_value;
	private String impr_avg_bid;
	private String word;
	private Integer word_id;
	
	public wordtrend(Integer pv,Integer click_num,String ctr,String cvr,Integer compete_value,String impr_avg_bid,String word,Integer word_id) {
		this.pv=pv;
		this.click_num=click_num;
		this.ctr=ctr;
		this.cvr=cvr;
		this.compete_value=compete_value;
		this.impr_avg_bid=impr_avg_bid;
		this.word=word;
		this.word_id=word_id;		
	}
	
	public wordtrend() {
		
	}
	
	public Integer getPv() {
		return pv;
	}
	public void setPv(Integer pv) {
		this.pv = pv;
	}
	public Integer getClick_num() {
		return click_num;
	}
	public void setClick_num(Integer click_num) {
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
	public Integer getCompete_value() {
		return compete_value;
	}
	public void setCompete_value(Integer compete_value) {
		this.compete_value = compete_value;
	}
	public String getImpr_avg_bid() {
		return impr_avg_bid;
	}
	public void setImpr_avg_bid(String impr_avg_bid) {
		this.impr_avg_bid = impr_avg_bid;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public Integer getWord_id() {
		return word_id;
	}

	public void setWord_id(Integer word_id) {
		this.word_id = word_id;
	}
	private String update_date;
}
