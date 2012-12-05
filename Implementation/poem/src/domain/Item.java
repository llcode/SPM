package domain;

public class Item {
	// Act as a record for form items.
	private Integer poemid;
	private Integer sentenceid;
	private String sentence;
	private char punc;
	private boolean exist;

	public int getPoemid() {
		return poemid;
	}

	public void setPoemid(Integer poemid) {
		this.poemid = poemid;
	}

	public int getSentenceid() {
		return sentenceid;
	}

	public void setSentenceid(Integer sentenceid) {
		this.sentenceid = sentenceid;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public char getPunc() {
		return punc;
	}

	public void setPunc(char punc) {
		this.punc = punc;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}
}
