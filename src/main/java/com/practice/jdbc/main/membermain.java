package com.practice.jdbc.main;

import java.sql.SQLException;

import com.practice.jdbc.console.MemberConsole;

public class membermain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MemberConsole mc = new MemberConsole();
		
		EXIT:
		while(true) { //명령어를 입력했을 때 다시 콘솔창에 출력되기 위해 while문으로 계속출력.
			mc.printMemberList();
			
			int choice = mc.printMenuList();
			switch(choice) { //printMenuList로부터 받은 choice번호를 구분하여 명령을 실행하는 switch문
			case 1: // 이전페이지를 명령하는 숫자
				break;
			case 2: // 다음페이지를 명령하는 숫자
				break;
			case 3: // 검색을 명령하는 숫자
				break;
			case 4: // 종료를 명령하는 숫자
				System.out.println("----------------");
				System.out.println("종료 합니다.");
				System.out.println("----------------");
				break EXIT; // while문에 EXIT를 달아 반복문을 빠져나옴. 
			default: // 다른 숫자를 입력했을때.
				System.out.println("잘못 입력하셧습니다.");
				break;
			}	
		
		}
	}

}
