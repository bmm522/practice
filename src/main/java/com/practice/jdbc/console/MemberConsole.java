package com.practice.jdbc.console;

import java.sql.SQLException;
import java.util.List;

import com.practice.jdbc.entity.member;
import com.practice.jdbc.service.memberservice;

public class MemberConsole {
	
	private memberservice ms; 
	
	public MemberConsole() {
		ms = new memberservice();
		
	}
	
	public void printList() throws ClassNotFoundException, SQLException {
		List<member> list = ms.getMember();
		// memberservice.getMember에서 아웃된 리스트를 담을 리스트
		
		System.out.println("-----------------------------------------------");
		list.forEach(m -> System.out.printf("ID: %s, PWD: %s, NAME: %s\n", m.getId(), m.getPwd(), m.getName()));
		System.out.println("-----------------------------------------------");
	}
	
	
	

}
