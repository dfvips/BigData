package entity;

public class collectwords {
	
	private Integer word_rise_id;
	
	private String word;
	
	public collectwords() {
		
	}
	
	public collectwords(Integer word_rise_id,String word) {
		this.word_rise_id=word_rise_id;
		this.word=word;
	}
	
	public Integer getWord_rise_id() {
		return word_rise_id;
	}
	public void setWord_rise_id(Integer word_rise_id) {
		this.word_rise_id = word_rise_id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
}
