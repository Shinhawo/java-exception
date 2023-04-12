package sample02;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionApp2 {
	
	///////////////////////////////////////////////////////////////
	// 예외변환하기를 사용하지 않은 경우
	//  - main 메서드에서 호출하는 메서드들이 다양한 예외를 발생시킨다.
	//  - 예외를 일괄처리하는 main메서드에서 처리할 예외의 갯수가 매우 많아진다.
	//  - 
	///////////////////////////////////////////////////////////////
	
	public static void writeText(String text) throws IOException {
		FileWriter writer = new FileWriter("src/sample02/sample.txt");
		writer.write(text);
		writer.close();
	}
	
	public static Date toDate(String text) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(text);
		return date;
	}
	
	public static void main(String[] args) {
		
		try {
		writeText("예외변환하기");
		Date date = toDate("2023-04-11");
		System.out.println(date);
		}
		
		// 처리해야 할 예외가 많아질 수 있다.
		 catch(IOException ex) {
			ex.printStackTrace();
		}catch (ParseException ex) {
			ex.printStackTrace();
		}
		
	}
}
