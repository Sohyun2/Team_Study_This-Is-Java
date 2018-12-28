package ch06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Account20> userList = new ArrayList<Account20>();
		Scanner sc = new Scanner(System.in);
		int selectNum = 0;
		
		do {
			boolean isExist = false; // 계좌가 존재하는지 존재하지 않는지 확인 플래그			
			int cnt = -1; // 예금할 계좌번호가 List에 몇번째 인덱스에 위치하는지
			int balance = 0;
			
			System.out.println("---------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("---------------------------------");
			System.out.print("선택>");
			selectNum = sc.nextInt();
			
			switch(selectNum) {
			case 1:
				System.out.println("-----");
				System.out.println("계좌생성");
				System.out.println("-----");
				
				Account20 user = new Account20();
				
				System.out.print("계좌번호 : ");
				user.setAccountNum(sc.next());
				System.out.print("계좌주 : ");
				user.setName(sc.next());
				System.out.print("초기입금액 : ");
				user.setBalance(sc.nextInt());
				
				userList.add(user);
				
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			case 2:				
				if(userList.isEmpty()) {
					System.out.println("계좌 목록이 없습니다.");
					break;
				}

				System.out.println("-----");
				System.out.println("계좌목록");
				System.out.println("-----");
				
				for(int i=0; i<userList.size(); i++) {
					System.out.print(userList.get(i).getAccountNum() + "\t");
					System.out.print(userList.get(i).getName() + "\t");
					System.out.print(userList.get(i).getBalance() + "원");
					System.out.println();
				}
				break;
			case 3:
				System.out.println("-----");
				System.out.println("예금");
				System.out.println("-----");
								
				System.out.print("계좌번호 : ");
				String depositAccNum = sc.next();
								
				for(int i=0; i<userList.size(); i++) {
					if(depositAccNum.equals(userList.get(i).getAccountNum())) {
						isExist = true;
						cnt = i;
					}
				}
				
				if(!isExist) {
					// 계좌가 없으므로 break;
					System.out.println("계좌가 없습니다.");
					break; 
				}
				
				int deposit = 0; // 현재 예금할 금액
				balance = userList.get(cnt).getBalance();
								
				System.out.print("예금액 : ");
				deposit = sc.nextInt();
				
				userList.get(cnt).setBalance(balance + deposit);
				
				System.out.println("결과 : 예금이 성공되었습니다.");
				break;
			case 4:
				System.out.println("-----");
				System.out.println("출금");
				System.out.println("-----");
								
				System.out.print("계좌번호 : ");
				String withdrawAcc = sc.next();
				
				for(int i=0; i<userList.size(); i++) {
					if(withdrawAcc.equals(userList.get(i).getAccountNum())) {
						isExist = true;
						cnt = i;
					}
				}
				
				if(!isExist) {
					// 계좌가 없으므로 break;
					System.out.println("계좌가 없습니다.");
					break; 
				}
				
				int withdraw = 0; // 현재 출금할 금액
				balance = userList.get(cnt).getBalance();
								
				System.out.print("출금액 : ");
				withdraw = sc.nextInt();
				
				if(withdraw > balance) {
					System.out.println("잔고가 부족합니다.");
					break;
				}
				userList.get(cnt).setBalance(balance - withdraw);
				
				System.out.println("결과 : 출금이 성공되었습니다.");
				break;
			case 5:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못 선택하였습니다. 종료합니다.");
			}
		} while(selectNum != 5);
	}

}
