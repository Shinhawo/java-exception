package sample01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionApp2 {

	public static void main(String[] args) {
		
		try {                                   //   패키지명 / 파일명
			FileReader reader = new FileReader("src/sample01/sample01.sample01.txt");
			BufferedReader br = new BufferedReader(reader);
			String text = br.readLine();
			System.out.println(text);
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println("지정된 파일을 찾을 수 없습니다.");
		} catch (IOException ex) {
			System.out.println("읽기 작업 중 오류가 발생하였습니다.");
		}
	}

}
