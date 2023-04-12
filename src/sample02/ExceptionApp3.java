package sample02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionApp3 {
	//////////////////////////////////////////////////////////////////////////
	// 예외전환하기를 사용한 경우                                                   
	//  - main 메서드에서 호출하는 메서드들이 Exception 예외를 발생하도록 실제 발생한         
	//    예외객체는 catch 블록을 이용해서 가로챘다.                                  
	//  - throw 키워드를 이용해서 Exception예외를 강제 발생시켰다.					   
	//  - main메서드에서 호출하느 모든 메서드들이 Exception 예외를 발생시키기 떄문에 main    
	//    메서드에서 일괄처리가 훨씬 쉬워진다.                                        
	/////////////////////////////////////////////////////////////////////////
	public static void writeText(String text) throws Exception { // Cheked Exception
		try {
			FileWriter writer = new FileWriter("src/sample02/sample.txt");
			writer.write(text);
			writer.close();
		} catch(IOException ex) {
			throw new Exception("읽고 쓰기 오류 발생", ex);
		}
	}
	
	public static Date toDate(String text) throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(text);
			return date;
		} catch (ParseException ex) {
			throw new Exception("날짜 변환 오류 발생" , ex); 
		}
	}
	
	public static void main(String[] args) {
		
		try {
			writeText("예외 전환하기 연습입니다.");
			Date date = toDate("19gf98-06-24");
			System.out.println(date);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
