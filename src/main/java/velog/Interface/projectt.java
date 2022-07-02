package velog.Interface;

public class projectt {

	public static void main(String[] args) {
		AB AB = new ABTeam();
		AB.setAB(20, 40);
		
		System.out.printf("result : %d%n", AB.plus());
		System.out.printf("result : %d", AB.avg());
		
		
	}

}
