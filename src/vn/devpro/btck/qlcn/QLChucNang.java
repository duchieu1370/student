package vn.devpro.btck.qlcn;

import java.util.Scanner;

import vn.devpro.btck.qlbd.QLBangDiem;
import vn.devpro.btck.qlsv.QLMonHoc;
import vn.devpro.btck.qlsv.QLSinhVien;
import vn.devpro.btck.qltk.QLTimKiem;

public class QLChucNang {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		do {
			System.out.println(" -------------------------------------------");
			System.out.println("|=======CHUONG TRINH QUAN LY CHUC NANG======|");
			System.out.println("|\tChon mot chuc nang:                 |");
			System.out.println("|\t1. Cap nhat thong tin sinh vien     |");
			System.out.println("|\t2. Tim kiem thong tin               |");
			System.out.println("|\t0. Thoat                            |");
			System.out.println(" -------------------------------------------");
			int chon = -1;
			try {
				System.out.print("Nhap lua chon cua ban: ");
				chon = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}

			switch (chon) {
			case 1:
				capNhatThongTinSv();
				break;
			case 2:
				QLTimKiem.QLTimKiem();
				break;
			case 0:
				System.out.println("Da thoat khoi chuong trinh");
				System.exit(0);
			default: System.out.println("Chon chuc nang khong hop le!");
			}

		} while (true);

	}

	private static void capNhatThongTinSv() {
		int chon;
		do {
			System.out.println(" -------------------------------------------");
			System.out.println("\n|=======CAP NHAT THONG TIN SINH VIEN========|");
			System.out.println("|\tChon mot chuc nang:                 |");
			System.out.println("|\t1. Cap nhat danh sach sinh vien     |");
			System.out.println("|\t2. Cap nhat danh sach mon hoc       |");
			System.out.println("|\t3. Cap nhat bang diem               |");
			System.out.println("|\t0. Thoat                            |");
			System.out.println(" -------------------------------------------");

			System.out.print("Lua chon chuc nang muon cap nhat: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				QLSinhVien.capNhat();
				break;
			case 2:
				QLMonHoc.capNhat();
				break;
			case 3:
				QLBangDiem.capNhat();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon chuc nang cap nhat khong hop le!");

			}
		} while (true);

	}

}
