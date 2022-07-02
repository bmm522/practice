package velog.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class mainLogic {

	public static void main(String[] args) {
		System.out.println("출력");
		ApplicationContext context = new FileSystemXmlApplicationContext("src/velog/di/dispatcher.xml");
		
		/*
		 * plus pluslogic = new plusLogic(); print printlogic = new printLogic();
		 * 
		 * 
		 * printlogic.setPrintLoigc(pluslogic);
		 */
		
		
		
		//print printlogic = (print)context.getBean("printlogic");
		print printlogic2 = context.getBean(printLogic.class);
		printlogic2.printActionLogic();
		
	}

}
