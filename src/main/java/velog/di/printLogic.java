package velog.di;

public class printLogic implements print{
	private plus pluslogic;
	

	
	
	public void setPluslogic(plus pluslogic) {
		this.pluslogic = pluslogic;
	}




	public void printActionLogic() {
		System.out.printf("plusResult : %d", pluslogic.plusResult());
		
	}




	@Override
	public void setPrintLoigc(plus pluslogic) {
		// TODO Auto-generated method stub
		
	}

	
}
