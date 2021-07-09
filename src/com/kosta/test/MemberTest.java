package com.kosta.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.kosta.dao.MemberDAO;
import com.kosta.dto.MemberDTO;



/*
 * 1.db연결
 * 2.preparedStatement를 이용하여 insert update delete => executeUpdate
 * 											select => executeQuery
 * 3.executeUpdate => row 값 받아서 확인!!
 * 	 executeQuery => ResultSet을 이용하여 받아서 출력!!
 * 4. close
 */
public class MemberTest {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		
		while(true) {
			System.out.println("==========================================================");
			System.out.print("1.회원가입 |");
			System.out.print(" 2.회원수정 |");
			System.out.print(" 3.회원삭제 |");
			System.out.print(" 4.회원보기 |");
			System.out.print(" 5.전체보기 |");
			System.out.println(" 6.종료 ");
			System.out.println("==========================================================");
			System.out.println("기능 선택");
			String choice=sc.nextLine();
			
		switch (choice) {
			
			case "1":
				System.out.print("아이디를 입력하세요 :");
				String mid=sc.nextLine();
				int re = dao.ischeck(mid);
				if(re>=1) {
					System.out.println("이미 존재하는 아이디입니다.");
				}
				else {
				System.out.print("비밀번호를 입력하세요: ");
				String mpw = sc.nextLine();
				
				System.out.print("이름을 입력하세요: ");
				String mname = sc.nextLine();
				
				System.out.print("이메일을 입력하세요: ");
				String memail = sc.nextLine();

				int result = dao.insert(mid, mpw, mname, memail);
				if(result>=1)
					System.out.println("회원 가입을 완료했습니다.");
				else
					System.out.println("회원 가입을 실패했습니다.");
				}//else
				System.out.print("\n계속 입력할까요? ");
				String yn = sc.nextLine();
				if(yn.equalsIgnoreCase("n"))
					break;
				break;
		
			case "2":
				System.out.print("수정할 아이디를 입력하세요 :");
				mid=sc.nextLine();
				re = dao.ischeck(mid);
				if(re<1) {
					System.out.println("아이디를 잘못 입력하였습니다.");
				}else {
				System.out.print("수정할 비밀번호를 입력하세요.");
				String mpw = sc.nextLine();
				
				System.out.print("수정할 이름을 입력하세요.");
				String mname = sc.nextLine();
				
				System.out.print("수정할 이메일을 입력하세요.");
				String memail= sc.nextLine();
				
				int result=dao.update(mid,mpw,mname,memail);
				if(result>=1)
					System.out.println("수정을완료 했습니다.");
				else
					System.out.println("수정을 실패 했습니다.");
				}
				break;
				
			case "3":
				System.out.println("삭제할 아이디를 입력하세요");
				mid=sc.nextLine();
				int result = dao.delete(mid);
				
				if(result>=1) {
					System.out.println("삭제를 성공 했습니다.");
				}else {
					System.out.println("삭제를 실패 했습니다.");
				}
				break;
				
				
			case "4":
				System.out.print("조회할 아이디를 입력하세요 :");
				mid=sc.nextLine();
				re = dao.ischeck(mid);
				if(re<1) {
					System.out.println("아이디를 잘못 입력하였습니다.");
				}else {
					System.out.println("번호\t 아이디\t 비밀번호\t 이름\t 이메일\t 가입일");
					System.out.println("-----------------------------------------------");
					dao.getselectAll(mid);
					
					
				}//else

				System.out.print("\n계속 입력할까요? ");
				yn = sc.nextLine();
				if(yn.equalsIgnoreCase("n"))
					break;
				break;
				
			case "5":
				System.out.println("번호\t 아이디\t 비밀번호\t 이름\t 이메일\t 가입일");
				System.out.println("-----------------------------------------------");
				dao.getAll();
				break;
				
			case "6":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
				
			}//switch
		}//while
	}//main
}//class
	
