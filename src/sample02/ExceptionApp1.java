package sample02;

public class ExceptionApp1 {

	/**
	 * 문자열을 전달받아서 정수로 변환해서 반환한다.
	 * @param text 숫자로 구성된 문자열
	 * @return 정수값
	 */
	public static int toInt(String text) {
		int number = Integer.parseInt(text);
		return number;
	}
	
	public static void main(String[] args) {
		
		try {
			int value = toInt("1234뿅");
			System.out.println(value);
		} catch (NumberFormatException ex) {
			
			// 오류 메세지 : For input string: "1234뿅"
			String errorMessage =  ex.getMessage();
			System.out.println("오류 메세지 : "+errorMessage);
			
			//toString() -> java.lang.NumberFormatException: For input string: "1234뿅"
			String text = ex.toString();
			System.out.println("toString() -> "+text);
			
//			java.lang.NumberFormatException: For input string: "1234뿅"
//			at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
//			at java.base/java.lang.Integer.parseInt(Integer.java:652)
//			at java.base/java.lang.Integer.parseInt(Integer.java:770)
//			at sample02.ExceptionApp1.toInt(ExceptionApp1.java:11)
//			at sample02.ExceptionApp1.main(ExceptionApp1.java:18)
			ex.printStackTrace();
			
			System.out.println("문자열에 숫자가 아닌 문자가 섞여있음. 코딩 똑바로 하쇼.");
		}
		
	}
}
