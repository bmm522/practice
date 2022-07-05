package com.practice.jdbc.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.practice.jdbc.entity.member;
import com.practice.jdbc.service.memberservice;

public class MemberConsole {
	
	private memberservice ms; 
	
	private int checknumber; //추가
	
	public MemberConsole() {
		ms = new memberservice();
		checknumber = 1; //추가
		
	}
	
	public void printMemberList() throws ClassNotFoundException, SQLException {
		List<member> list = ms.getMember(checknumber);
		// memberservice.getMember에서 아웃된 리스트를 담을 리스트
		
		System.out.println("-----------------------------------------------");
		list.forEach(m -> System.out.printf("ID: %s, PWD: %s, NAME: %s\n", m.getId(), m.getPwd(), m.getName()));
		System.out.println("-----------------------------------------------");
		System.out.println("           현재페이지 / 끝페이지");
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
	
	
	
	
	

}
