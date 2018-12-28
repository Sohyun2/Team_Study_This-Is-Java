package ch06;

public class AccountExample {
	public static void main(String[] args) {
		
		Account19 account = new Account19();
		
		account.setBalance(780000);
		System.out.println("현재 잔고 : " + account.getBalance());
		
		account.setBalance(-100);
		System.out.println("현재 잔고 : " + account.getBalance());
	}
}
