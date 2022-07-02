package velog.Interface;

public class ABTeam implements AB{
	private int kor;
	private int eng;
	
	@Override
	public void setAB(int kor, int eng) {
		this.kor = kor;
		this.eng = eng;
		
	}

	@Override
	public int plus() {
		return kor + eng;
	}

	@Override
	public int avg() {
		return (kor + eng)/2;
		
	}


}
