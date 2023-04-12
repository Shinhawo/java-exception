package sample02;


public class CustomExceptionApp2 {
	
/**
 * 고괙등급과 구매금액을 전달받아서 적립포인트를 반환하는 메서드	
 * @param grade  고객등급
 * @param amount 주문금액
 */
	public static int getDepositPoint(String grade, int amount) {
		
		if(grade == null || grade.isBlank()) { // 오류사항
			throw new CustomException("고객등급 정보가 없습니다."); // 우왕 쩐당
		}
		
		double depositRate = 0.0;
		if("골드".equals(grade)) {
			depositRate = 0.05;
		} else if("실버".equals(grade)) {
			depositRate = 0.02;
		} else if("브론즈".equals(grade)) {
			depositRate = 0.01;
		}
		return (int) (amount*depositRate);
	}
	
	public static void main(String[] args) {
		int a = getDepositPoint("골드", 5000000);
		System.out.println(a);
		
		int b = getDepositPoint(" ", 5000000);
		System.out.println(b);
	}
}
