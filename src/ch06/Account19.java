package ch06;

// 19번 문제의 Account입니다.
public class Account19 {
	private final int MIN_VALUE = 0;
	private final int MAX_VALUE = 1000000;

	private int balance;
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance<MIN_VALUE || balance>MAX_VALUE) return;
		
		this.balance = balance;
	}
	
	
}
