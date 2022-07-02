package velog.di;

public class koreaPrintLogic implements print {
	private plus pluslogic;
	
	public koreaPrintLogic(plus pluslogic){
		this.pluslogic = pluslogic;
		
	}
	
	@Override
	public void printActionLogic() {
		System.out.printf("결과 : %d",  pluslogic.plusResult());

	}

}
