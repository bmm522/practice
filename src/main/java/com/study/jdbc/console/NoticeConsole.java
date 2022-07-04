package com.study.jdbc.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.study.jdbc.entity.Notice;
import com.study.jdbc.service.NoticeService;

public class NoticeConsole {
	
	private NoticeService service;
	
	private int page;
	
	private String searchWord;

	private String searchField;
	
	
	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
		searchWord ="";
		searchField = "ID";
	}
	
	public void printNoticeList() throws ClassNotFoundException, SQLException {
		List<Notice> list = service.getList(page, searchField, searchWord);
		int count = service.getCount();
		int lastPage = count/3;
		lastPage = count%3 ==0?lastPage:lastPage+1;
		
		System.out.println("---------------------------------------------");
		System.out.printf("<검색결과> 총 %d 아이디\n", count);
		System.out.println("---------------------------------------------");
		
		for(Notice n : list) {
		System.out.printf("아이디 : %s, 비밀번호 : %s, 이름 : %s\n", n.getId(), n.getPwd(), n.getName());
		}
		System.out.println("---------------------------------------------");
		System.out.printf("                 %d/%d pages\n", page, lastPage);
	}

	public int inputNoticeMenu() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.printf("<1. 상세조회/ 2. 이전/ 3. 다음/ 4. 글쓰기/ 5. 검색/ 6. 종료> ");
		String menu_ = sc.nextLine();
		int menu = Integer.parseInt(menu_);
		
		
		return menu;
	}

	public void movePrevList() {
		if(page ==1) {
			System.out.println("이전페이지가 없음");
			return;
		}
		page--;
		
	}

	public void moveNextList() throws ClassNotFoundException, SQLException {
		int count = service.getCount();
		int lastPage = count/3;
		lastPage = count%3 ==0?lastPage:lastPage+1;
		if(page > lastPage) {
			System.out.println("다음페이지 없음");
			return;
		}
		
		page++;
		
	}

	public void inputSearchWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색 ID, PWD, NAME중에 하나를 입력하시오.");
		System.out.print(">");
		searchField = sc.nextLine();
		
		System.out.print("검색어 >");
		searchWord = sc.nextLine();
	}
	
	

	
	
}
