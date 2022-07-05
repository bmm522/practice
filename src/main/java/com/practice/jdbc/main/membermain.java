package com.practice.jdbc.main;

import java.sql.SQLException;

import com.practice.jdbc.console.MemberConsole;

public class membermain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MemberConsole mc = new MemberConsole();
		mc.printList();
	}

}
