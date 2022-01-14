package vn.devpro.btck.qltk;

import java.util.Scanner;

import vn.devpro.btck.qlbd.BangDiem;

public class QLTimKiem {

	static Scanner sc = new Scanner(System.in);

	public static void QLTimKiem() {
		BangDiem bd = new BangDiem();
		int chon;
		do {

			System.out.println(" -------------------------------------------");
			System.out.println("\n|========== TIM KIEM THONG TIN  ============|");
			System.out.println("|\tChon mot chuc nang:                 |");
			System.out.println("|\t1. Tim kiem theo danh sach theo sv  |");
			System.out.println("|\t2. Tim kiem theo danh sach theo mh  |");
			System.out.println("|\t0. Thoat                            |");
			System.out.println(" -------------------------------------------");
			System.out.print("Lua chon cap nhat: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				bd.hienThiTheoSV();
				;
				break;
			case 2:
				bd.hienThiTheoMH();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le ");

			}
		} while (true);

	}

}
