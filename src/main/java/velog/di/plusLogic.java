package velog.di;

public class plusLogic implements plus{
	private int kor = 30;
	private int eng = 40;
	
	public int plusResult() {
		return kor+eng;
		
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
}
