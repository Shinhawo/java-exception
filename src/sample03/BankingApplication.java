package sample03;

// 사용자 입력처리와, 실행결과 출력에만 집중할 수 있다
import util.KeyboardReader;

public class BankingApplication {

	public static void main(String[] args) { // static 메서드는 static만 실행가능. 객체 생성해야 멤버 사용가능
		BankingApplication application = new BankingApplication();
		application.menu();
	}
	
	private KeyboardReader reader = new KeyboardReader();
	private BankingService service = new BankingService();
			
	public void menu() {
		System.out.println("------------------------------------------------------------");
		System.out.println("1.조회 2.입금 3.출금 0.종료");
		System.out.println("------------------------------------------------------------");
		System.out.println();
		
		System.out.println("### 메뉴선택 : ");
		int menuNo= reader.readInt();
		System.out.println();
		
		// 예외야로들 일괄 처리시로w
		try {
			if(menuNo == 1) {
				조회하기(); // 예외발생 예상
			} else if(menuNo == 2) {
				입금하기(); // 예외발생 예상
			} else if(menuNo == 3) {
				출금하기(); // 예외발생 예상
			} else if(menuNo == 0) {
				종료하기();
			}
		} catch(BankingException ex) {
			System.out.println("### 오류 발생 : "+ex.toString()); // 에러페이지 대신
//			ex.printStackTrace();                              // 개발자의 편의
		} catch (Exception ex) {
			System.out.println("### 오류 발생 : 알 수 없는 오류가 발생하였습니다."); // 에러페이지 대신
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		menu(); // menu();를 try안에 넣으면 오류 발생시에 catch블록 실행후 프로그램이 종료되기 때문에
		        // menu();가 반복 실행되지않음.
	}
	
	public void 조회하기() {
		System.out.println("<< 계좌정보 조회하기 >>");
		System.out.println("### 계좌번호와 비밀번호를 입력하세요.");
		
		System.out.println("### 계좌번호 :");
		int no = reader.readInt();
		System.out.println("### 비밀번호 :");
		int password = reader.readInt();
		System.out.println();
		
		Account account =  service.getAccountDetail(no, password);
		// service에서 이미 예외처리했기 떄문에  여기까지 왔으면 account는 절대절대절대 null이 아님
		System.out.println("### 계좌상세 정보 출력");
		System.out.println("-----------------------------------");
		System.out.println("계좌번호 : " + account.getNo());
		System.out.println("예금주 : " + account.getOwner());
		System.out.println("잔고 : " + account.getBalance());
		System.out.println("-----------------------------------");

	}
	
	public void 입금하기() {
		System.out.println("<< 입금하기 >>");
		System.out.println("### 계좌번호와 입금할 금액을 입력해주세요 : ");
		System.out.println("### 계좌번호 :");
		int no = reader.readInt();
		System.out.println("### 입금액 :");
		int amount = reader.readInt();
		System.out.println();
		
		service.deposit(no, amount);
		System.out.println("["+no+"]계좌에 ["+amount+"]원이 입금되었습니다.");
	}
	
	public void 출금하기() {
		System.out.println("<< 출금하기 >>");
		System.out.println("### 계좌번호와 비밀번호, 출금할 금액을 입력해주세요 : ");
		System.out.println("### 계좌번호 :");
		int no = reader.readInt();
		System.out.println("### 비밀번호 :");
		int password = reader.readInt();
		System.out.println("### 출금액 :");
		int amount = reader.readInt();
		System.out.println();
		
		service.withdraw(no, password, amount);
		System.out.println("["+no+"] 계좌에서 ["+amount+"]원이 출금되었습니다.");
	}
	
	public void 종료하기() {
		System.out.println("<< 프로그램 종료 >>");
		System.exit(0);
	}
}
