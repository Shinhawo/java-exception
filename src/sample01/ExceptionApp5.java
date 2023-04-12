package sample01;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp5 {

	public static void test1() throws IOException, ClassNotFoundException{
		System.out.println("예외처리 위임하기 연습.");
		test2();
	}
	
	public static void test2() throws IOException, ClassNotFoundException{
		System.out.println("예외처리 위임하기 연습.");
		test3();
	}
	
	public static void test3() throws IOException , ClassNotFoundException{
		System.out.println("예외처리 위임하기 연습.");
		test4(); // test3()가 4의 예외처리 위임함, main에서 일괄처리 할거니까 또 던지기
		
		Class.forName("java.io.String");
	}
	
	public static void test4() throws IOException {
		FileWriter writer = new FileWriter("src/sample01/sample04.txt");
		writer.write("파일쓰기 연습.");
		writer.close();
	}
	
	public static void main(String[] args) {
		
		
	}
}
