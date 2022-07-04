package study.jdbc;

import java.sql.SQLException;

import com.study.jdbc.console.NoticeConsole;

public class program3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NoticeConsole console = new NoticeConsole();
		//int page;
		
		EXIT:while(true) {
			
			console.printNoticeList();
			
			int menu = console.inputNoticeMenu();
			
			
			switch(menu) {
				case 1: // 상세조회
					break;
				case 2: // 이전
					//page--;
					console.movePrevList();
					break;
				case 3: // 다음
					//page++;
					console.moveNextList();
					break;
				case 4: // 글쓰기
					break;
				case 5: // 검색
					console.inputSearchWord();
					break;
				
				case 6: // 종료
					System.out.println("끝낫습니다");
					break EXIT;
				default:
					System.out.println("다시 입력하시오");
					break;
			}
		}
	}

}
