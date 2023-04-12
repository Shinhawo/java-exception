package sample01;

public class ExceptionApp4 {

	public static void test2(String str) {
		
		test(str);
	}
	
	public static void test(String str) {
		int number = Integer.parseInt(str);
		System.out.println("number -> "+ number);
	}
	
	public static void main(String[] args) {
		
		try {
			test2("1234");
			test2("1234오");
		} catch (NumberFormatException ex) {
			System.out.println("유효한 숫자형식의 문자열이 아닙니다.");
		}
	}
}
