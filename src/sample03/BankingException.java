package sample03;

public class BankingException extends RuntimeException{

	public BankingException() {}
	
	public BankingException(String message) {
		super(message);
	}
}

//클래스 이름이 오류에 대한 설명이 되므로 따로 메세지가 필요없다.
class PasswordException extends BankingException{
	
	public PasswordException() {
	
	}
}

class AccountNotFountException extends BankingException{
	
	public AccountNotFountException(String message) {
		super(message);
	}
}

class NotEnoughBalnceException extends BankingException{
	
	public NotEnoughBalnceException(String message) {
		super(message);
	}
}