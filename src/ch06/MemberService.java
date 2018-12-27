package ch06;


//Question14, Question15와 함께 진행..
public class MemberService {
	// 13번 문제
	private String name;
	private String id;
	private String password;
	private int age;
	
	public MemberService() {
		
	}
	
	// 14번 문제
	public MemberService(String name, String id) {
		this.name = name;
		this.id = id;
	}

	// 15번 문제
	public boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		} else return false;
	}
	
	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		
		boolean result = memberService.login("hong", "12345"); 
		
		if(result) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}
}
