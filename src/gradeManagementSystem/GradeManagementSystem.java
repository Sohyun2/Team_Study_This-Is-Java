package gradeManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeManagementSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String c = "y";

		List<Student> stuArr = new ArrayList<Student>();

		do {
			// tmp variable
			String selectName = null;
			int index = -1; // 검색한 학생이 몇번째 위치하는지..

			System.out.println("-----MENU-----");
			System.out.println("1. Input student info");
			System.out.println("2. Print out all students");
			System.out.println("3. Search student info");
			System.out.println("4. Delete student info");
			System.out.println("5. Correct student info");
			System.out.print("==Select number you want >> ");
			int selectNum = sc.nextInt();
			
			switch (selectNum) {
			case 1: // Input student Info

				System.out.println("==1. Input student info==");
				Student stu = new Student();

				System.out.print("Name : ");
				stu.setName(sc.next());
				System.out.print("Id : ");
				stu.setStuNum(sc.nextInt());

				System.out.print("Korea : ");
				stu.setKor(sc.nextInt());
				System.out.print("English : ");
				stu.setEng(sc.nextInt());
				System.out.print("Math : ");
				stu.setMath(sc.nextInt());

				stu.setSum();
				stu.setAvg();

				stuArr.add(stu);

				break;
				
			case 2: // Print out all students
				if(isNull(stuArr)) break; // Check if the list is null

				System.out.println("==2. Print out all students==");
				System.out.printf("Name\tId\tKorea\tEnglish\tMath\tSum\tAverage\t\n");
				
				for (int i = 0; i < stuArr.size(); i++) {
					show(stuArr.get(i));
				}
				break;
				
			case 3: // Search student info
				if(isNull(stuArr)) break; // Check if the list is null

				System.out.println("==3. Search student info==");
				
				index = searchPerson(stuArr, selectName); // 학생검색
				if (index == -1) break;

				show(stuArr.get(index));
				break;
				
			case 4: // Delete student info
				if(isNull(stuArr)) break; // Check if the list is null

				System.out.println("==4. Delete student info==");
				
				index = searchPerson(stuArr, selectName); // 학생검색
				if (index == -1) break;
				
				stuArr.remove(index);
				System.out.println("Remove Completed!");

				break;
			case 5: // Correct student info
				if(isNull(stuArr)) break; // Check if the list is null

				System.out.println("==5. Correct student info==");

				index = searchPerson(stuArr, selectName); // 학생검색
				if (index == -1) break;
				
				System.out.println("What subject would you like to change?");
				System.out.println("1.Korea  2.English  3.Math");
				System.out.print(">>");
				int modifyNum = sc.nextInt();
				
				System.out.print("Input Score>>");
				int score = sc.nextInt();
				switch(modifyNum) {
				case 1://국어성적
					stuArr.get(index).setKor(score);
					stuArr.get(index).setSum();
					stuArr.get(index).setAvg();
					break;
				case 2:
					stuArr.get(index).setEng(score);
					stuArr.get(index).setSum();
					stuArr.get(index).setAvg();
					break;
				case 3:
					stuArr.get(index).setMath(score);
					stuArr.get(index).setSum();
					stuArr.get(index).setAvg();
					break;
				}
				
				System.out.println("Completed!!");
				break;
			}
			System.out.print("Continue(y/Y) >> ");
			c = sc.next();
		} while (c.equals("y") || c.equals("Y"));

		System.out.println("exit");
	}

	public static int searchPerson(List<Student> stuArr, String selectName) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input name you want >> ");
		selectName = sc.next();
		
		// 먼저 해당 이름이 존재하는지 확인
		int index = -1; // 검색한 학생이 몇번째에 위치하는지..

		for (int i = 0; i < stuArr.size(); i++) {
			if (stuArr.get(i).getName().equals(selectName)) {
				return i;
			}
		}

		// 검색하지 못한 경우..
		System.out.println("404 Not Found!");
		
		return index;
	}

	public static void show(Student tmpStu) {
		System.out.printf(tmpStu.getName() + "\t");
		System.out.printf(tmpStu.getStuNum() + "\t");
		System.out.printf(tmpStu.getKor() + "\t");
		System.out.printf(tmpStu.getEng() + "\t");
		System.out.printf(tmpStu.getMath() + "\t");
		System.out.printf(tmpStu.getSum() + "\t");
		System.out.printf(tmpStu.getAvg() + "\t");
		System.out.println();
	}
	
	public static boolean isNull(List<Student> stuArr) {
		if(stuArr.isEmpty()) {
			System.out.println("List is null!!!");
			return true;
		}		
		return false; // List is not null
	}
}
