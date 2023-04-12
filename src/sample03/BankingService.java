package sample03;

public class BankingService {

	/**
	 * 계좌정보에 대한 추가/조회/변경/삭제 기능을 제공하는 객체를 참조한다.
	 */
	private BankingRepository repo = new BankingRepository();
	
	/**
	 * 계좌번호와 비밀번호를 전달받아서 계좌정보를 반환한다.
	 * @param no 계좌번호
	 * @param password 비밀번호
	 * @return 계좌정보
	 */
	public Account getAccountDetail(int no, int password) {
		Account account = repo.getAccountByNo(no);
		if(account == null) {
			throw new AccountNotFountException(String.valueOf(no));
		}
		
		if(password != account.getPassword()) { 
			throw new PasswordException(); 
		}
		
		return account;
	}
	
	/**
	 * 계좌번호, 입금액을 전달받아 계쫘의 현재 잔액을 증가시킨다.
	 * @param no 계좌번호
	 * @param amount 입금액
	 */
	public void deposit(int no, long amount) {
		Account account = repo.getAccountByNo(no);
		if (account == null) {
			throw new AccountNotFountException(String.valueOf(no));
		}
		account.setBalance(account.getBalance()+amount);
	}
	
	/**
	 * 계좌번호, 비밀번호, 출금액을 전달받아서 계좌의 현재 잔액을 감소시킨다.
	 * @param no 계좌번호
	 * @param password 비밀번호
	 * @param amount 출금액
	 */
	public void withdraw (int no, int password, long amount) {
		Account account = repo.getAccountByNo(no);
		if(account == null) {
			throw new AccountNotFountException(String.valueOf(no));
		}
		if(account.getPassword() != password) {
			throw new PasswordException();
		}
		if(account.getBalance() < amount) {
			throw new NotEnoughBalnceException("현재잔액: "+account.getBalance()+", 출금액 : "+amount);
		}
		
		account.setBalance(account.getBalance() - amount);
	}
}
