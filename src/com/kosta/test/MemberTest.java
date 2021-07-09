package com.kosta.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.kosta.dao.MemberDAO;
import com.kosta.dto.MemberDTO;



/*
 * 1.db����
 * 2.preparedStatement�� �̿��Ͽ� insert update delete => executeUpdate
 * 											select => executeQuery
 * 3.executeUpdate => row �� �޾Ƽ� Ȯ��!!
 * 	 executeQuery => ResultSet�� �̿��Ͽ� �޾Ƽ� ���!!
 * 4. close
 */
public class MemberTest {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		
		while(true) {
			System.out.println("==========================================================");
			System.out.print("1.ȸ������ |");
			System.out.print(" 2.ȸ������ |");
			System.out.print(" 3.ȸ������ |");
			System.out.print(" 4.ȸ������ |");
			System.out.print(" 5.��ü���� |");
			System.out.println(" 6.���� ");
			System.out.println("==========================================================");
			System.out.println("��� ����");
			String choice=sc.nextLine();
			
		switch (choice) {
			
			case "1":
				System.out.print("���̵� �Է��ϼ��� :");
				String mid=sc.nextLine();
				int re = dao.ischeck(mid);
				if(re>=1) {
					System.out.println("�̹� �����ϴ� ���̵��Դϴ�.");
				}
				else {
				System.out.print("��й�ȣ�� �Է��ϼ���: ");
				String mpw = sc.nextLine();
				
				System.out.print("�̸��� �Է��ϼ���: ");
				String mname = sc.nextLine();
				
				System.out.print("�̸����� �Է��ϼ���: ");
				String memail = sc.nextLine();

				int result = dao.insert(mid, mpw, mname, memail);
				if(result>=1)
					System.out.println("ȸ�� ������ �Ϸ��߽��ϴ�.");
				else
					System.out.println("ȸ�� ������ �����߽��ϴ�.");
				}//else
				System.out.print("\n��� �Է��ұ��? ");
				String yn = sc.nextLine();
				if(yn.equalsIgnoreCase("n"))
					break;
				break;
		
			case "2":
				System.out.print("������ ���̵� �Է��ϼ��� :");
				mid=sc.nextLine();
				re = dao.ischeck(mid);
				if(re<1) {
					System.out.println("���̵� �߸� �Է��Ͽ����ϴ�.");
				}else {
				System.out.print("������ ��й�ȣ�� �Է��ϼ���.");
				String mpw = sc.nextLine();
				
				System.out.print("������ �̸��� �Է��ϼ���.");
				String mname = sc.nextLine();
				
				System.out.print("������ �̸����� �Է��ϼ���.");
				String memail= sc.nextLine();
				
				int result=dao.update(mid,mpw,mname,memail);
				if(result>=1)
					System.out.println("�������Ϸ� �߽��ϴ�.");
				else
					System.out.println("������ ���� �߽��ϴ�.");
				}
				break;
				
			case "3":
				System.out.println("������ ���̵� �Է��ϼ���");
				mid=sc.nextLine();
				int result = dao.delete(mid);
				
				if(result>=1) {
					System.out.println("������ ���� �߽��ϴ�.");
				}else {
					System.out.println("������ ���� �߽��ϴ�.");
				}
				break;
				
				
			case "4":
				System.out.print("��ȸ�� ���̵� �Է��ϼ��� :");
				mid=sc.nextLine();
				re = dao.ischeck(mid);
				if(re<1) {
					System.out.println("���̵� �߸� �Է��Ͽ����ϴ�.");
				}else {
					System.out.println("��ȣ\t ���̵�\t ��й�ȣ\t �̸�\t �̸���\t ������");
					System.out.println("-----------------------------------------------");
					dao.getselectAll(mid);
					
					
				}//else

				System.out.print("\n��� �Է��ұ��? ");
				yn = sc.nextLine();
				if(yn.equalsIgnoreCase("n"))
					break;
				break;
				
			case "5":
				System.out.println("��ȣ\t ���̵�\t ��й�ȣ\t �̸�\t �̸���\t ������");
				System.out.println("-----------------------------------------------");
				dao.getAll();
				break;
				
			case "6":
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
				
			}//switch
		}//while
	}//main
}//class
	
