package com.practice.jdbc.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.practice.jdbc.entity.member;
import com.practice.jdbc.service.memberservice;

public class MemberConsole {
	
	private memberservice ms; 
	
	private int checknumber; //추가

	private String searchWord;
	
	
	
	public MemberConsole() {
		ms = new memberservice();
		checknumber = 1; //추가
		searchWord = "";
		
	}
	
	public void printMemberList() throws ClassNotFoundException, SQLException {
		List<member> list = ms.getMember(checknumber, searchWord);
		// memberservice.getMember에서 아웃된 리스트를 담을 리스트
		int totaldata = ms.getTotal(searchWord); // 전체데이터값을 가져오는 메서드
		
		int endPageNumber = totaldata/3; //전체 데이터에서 3으로 나눈 값을 넣어줌.
		
		if(totaldata%3 !=0) { //3으로 나눈값이 나머지가 있을 경우에 endPageNumber에 1을 추가
			endPageNumber ++;
		}
		
		System.out.printf("검색된 총 ID : %d\n", totaldata);
		System.out.println("-----------------------------------------------");
		list.forEach(m -> System.out.printf("ID: %s, PWD: %s, NAME: %s\n", m.getId(), m.getPwd(), m.getName()));
		System.out.println("-----------------------------------------------");
		System.out.printf("                 %d / %d\n", checknumber, endPageNumber);
	}

	public int printMenuList() {
		System.out.print("/ 1. 이전페이지 / 2. 다음페이지 / 3. 검색 / 4. 종료 />");
		//사용자와 상호작용 하기 위한 출력안내문
		Scanner sc = new Scanner(System.in);
		String choice_ = sc.nextLine();
		//데이터를 입력받는 로직, 숫자외 다른 문자가 입력을 받을 수도 있으니 nextLine()으로 데이터 받음.
		int choice = Integer.parseInt(choice_);
		//입력받은 String형을 int형으로 변환하여 입력이 가능하게끔 함
		
		return choice;
		//입력받은 숫자를 아웃함.
	}

	public void printPrevList() {
		if(checknumber ==1) {
			System.out.println("이전 페이지가 없음");
			return;
		}
		checknumber --;	//getMember() 안에 체크해야 할 숫자감소
	}

	public void printNextList() throws ClassNotFoundException, SQLException {
		int count = ms.getTotal(); 
		// 실행되는 도중에 값이 업데이트되거나 삭제 될 수 있으므로 지역변수로 선언
		int endPageNumber = count/3;  
		
		endPageNumber = count%3==0?endPageNumber:endPageNumber++;
		
		if(checknumber > endPageNumber) {
			System.out.println("다음 페이지가 없음");
			checknumber --; 
		}
		
		checknumber ++; //getMember() 안에 체크해야 할 숫자증가
	}

	public void searchId() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in); 
		//사용자에게 검색키워드를 입력받기
		System.out.print("ID 검색어를 입력하세요 >");
		searchWord = sc.nextLine();
		//리스트를 불러오는 getMember()에서 사용되야 하기때문에 공유를 위해 멤버변수로 선언.
//		MemberConsole checkmc = new MemberConsole();
//		List<member> checkEmpty = ms.getMember(checknumber, searchWord); // 비엇는지 안비엇는지 알려주는 용도
//		
//		if(checkEmpty.isEmpty()) {
//			System.out.println("검색결과가 없습니다");
//		}
		
		int checkEmptyNumber = ms.getTotal(searchWord);
		if(checkEmptyNumber == 0) {
			System.out.println("검색결과가 없습니다.");
		}
		
	}
	
	
	
	
	
	
	

}
