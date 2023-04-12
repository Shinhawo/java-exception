package sample01;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp1 {

	public static void main(String[] args) {

		// Checked Exception이 발생하는 수행문 실행하고, 예외처리하기
		
		// IOException
//		FileWriter writer = new FileWriter("src/sample01.sample01.txt");
	
		try {
		FileWriter writer = new FileWriter("src/sample01.sample01.txt");
		writer.write("예외처리 실습해보기");
		writer.close();
		} catch(IOException ex) {
			System.out.println("IOException이 발생하였습니다.");
		}
		
	}

}

