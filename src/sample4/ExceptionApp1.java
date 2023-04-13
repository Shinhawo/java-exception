package sample4;

import java.io.FileWriter;
import java.io.IOException;


public class ExceptionApp1 {

	public static void writeText1(String text) {
		
		FileWriter writer = null; // 여기다 선언해야 try, catch 둘다에서 쓸 수 있당깨
		                          // null이기 때문에 여기서도 오류 발생 가능 -> if(writer != null)
		try {
			writer = new FileWriter("src/sample4/sample.txt");
			writer.write("연습1");
			// 입출력 작업이 모두 완료되면, 자원에 대한 점유를 해제시키는 메서드를 실행한다.
			writer.close();
		}catch (IOException ex) {
			try {
				if(writer != null) {
				// 입출력 작업 중 오류가 발생하면, 자원에 대한 점유를 해제시키는 메서드를 실행한다.
				writer.close();  
				}
			} catch (IOException e) {
				
			}
			throw new RuntimeException("입출력오류",ex);
		}
	
	}
	
	public static void writerText2(String text) {
		
		FileWriter writer = null;
		try {
			writer = new FileWriter("src/sample4/sample.txt");
			writer.write("연습");
		} catch (IOException ex) {
			throw new RuntimeException("입출력오류",ex);
		} finally {
			try {
				if(writer != null) {
					writer.close();
				}
			} catch (IOException ex) {}
		}
	}
	
	// AutoCloseable 인터페이스를 구현한 클래스는 자동자원해제 방식을 사용할 수 있다.
	/*
	 * try (AutoCloseabled인터페이스를 구현한 객체를 생성하는 코드){
	 * 
	 * } catch(예외클래스 변수명)
	 */
	public static void writerText3(String text) {
		try (FileWriter writer = new FileWriter("src/sample4/sample.txt")){			
			writer.write("연습");
			writer.write("연습");
			writer.write("연습");
			writer.write("연습");
		} catch (IOException ex) {
			throw new RuntimeException("입출력 오류", ex);
		}
	} 
	
}
