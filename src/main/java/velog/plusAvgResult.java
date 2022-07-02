package velog;


public class plusAvgResult {
	private int kor;
	private int eng;
	private int plusResult;
	private int avgResult;
	
	
	int plusLogic() {
		plusResult = kor + eng;
		return plusResult;
		
		
	}
	
	int avgLogic() {
		avgResult = (kor+eng)/2;
		return avgResult;
	}
	
	void resultPrint() {
		System.out.println(plusResult);
		System.out.println(avgResult);
		
	}
}
