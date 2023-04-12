package sample02;

/**
 * 사용자 정의 예외 unchecked 클래스다.
 * @author jhta
 *
 */
public class CustomException extends RuntimeException{

	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message, Throwable couse) {
		super(message, couse);
	}
}
