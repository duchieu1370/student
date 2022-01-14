package vn.devpro.btck.qlsv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QLMonHoc {
	public static ArrayList<MonHoc> list = new ArrayList<>();

	static Scanner sc = new Scanner(System.in);

	public static void capNhat() {
		int chon;
		do {

			System.out.println(" -------------------------------------------");
			System.out.println("\n|========CAP NHAT THONG TIN MON HOC=========|");
			System.out.println("|\tChon mot chuc nang:                 |");
			System.out.println("|\t1. Them moi mon hoc                 |");
			System.out.println("|\t2. Hien thi danh sach mon hoc       |");
			System.out.println("|\t3. Sua thong tin mon hoc            |");
			System.out.println("|\t4. Xoa thong tin mon hoc            |");
			System.out.println("|\t5. Sap xep danh sach mon hoc        |");
			System.out.println("|\t0. Thoat                            |");
			System.out.println(" -------------------------------------------");
			System.out.print("Lua chon cap nhat: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				themMonHoc();
				break;
			case 2:
				hienThiDs();
				break;
			case 3:
				suaMonHoc();
				break;
			case 4:
				xoaMonHoc();
				break;
			case 5:
				sapXepDs();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le ");

			}
		} while (true);

	}

	private static void themMonHoc() {
		System.out.println("\n-------THEM MON HOC MOI-------");
		System.out.println("Nhap thong tin mon hoc moi");
		System.out.print("\tNhap ten mon hoc: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong!");
			return;
		}
		System.out.print("\tNhap ma mon hoc: ");
		String ma = sc.nextLine();
		if (ma.trim().length() == 0) {
			System.out.println("\tMa mon hoc khong duoc de trong!");
			return;
		}
		// Kiem tra xem ma mon hoc da ton tai trong danh sach chua?
		int i = 0;
		while (i < list.size() && ma.trim().compareToIgnoreCase(list.get(i).getMaMH().trim()) != 0) {
			i++;
		}
		if (i < list.size()) {
			System.out.println("\tMon hoc da ton tai trong danh sach!");
			return;
		}

		System.out.print("\tNhap he so mon hoc: ");
		double heSo = Double.parseDouble(sc.nextLine());
		if (heSo < 0) {
			System.out.println("\tHe so khong duoc am!");
			return;
		}

		// Khoi tao doi tuong
		MonHoc mh = new MonHoc(ma, name, heSo);
		list.add(mh);
		System.out.println("\nThem mon hoc thanh cong!");

	}

	private static void hienThiDs() {
		System.out.println("\n-------DANH SACH MON HOC-------");
		System.out.printf("%3s %-10s %-25s %5s %n", "STT", "Ma MH", "Ten mon hoc", "He so");
		int stt = 1;
		for (MonHoc mh : list) {
			System.out.printf("%-3d", stt++);
			mh.display();
		}
		if (stt == 1) {
			System.out.println("\nDanh sach mon hoc rong!");
		}

	}

	private static void suaMonHoc() {
		int chon;
		System.out.println("\n-------SUA THONG TIN MON HOC-------");
		System.out.print("\tNhap ma mon hoc can sua: ");
		String id = sc.nextLine();
		// Tim xem mon hoc can nhap da co trong danh sach chua?
		int index = indexOf(id);
		if (index == -1) {
			System.out.println("\tMon hoc khong co trong danh sach!");
			return;
		}

		do {
			System.out.println("\nChon thong tin mon hoc can sua: ");
			System.out.println("\t1. Sua ten mon hoc");
			System.out.println("\t2. Sua he so mon hoc");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban : ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				suaTenMH(index);
				break;
			case 2:
				suaHeSo(index);
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");

			}

		} while (true);

	}

	private static void suaTenMH(int index) {
		System.out.print("\tNhap ten moi cho mon hoc: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}

		// Sua theo ten moi
		list.get(index).setTenMH(name);
		System.out.println("\tSua ten mon hoc thanh cong!");

	}

	private static void suaHeSo(int index) {
		// sua he so
		System.out.print("\tNhap he so moi mon hoc: ");
		double heSo = Double.parseDouble(sc.nextLine());
		if (heSo < 0) {
			System.out.println("\tHe so khong duoc am!");
			return;
		}
		list.get(index).setHeSoMH(heSo);
		System.out.println("\tSua he so mon hoc thanh cong!");

	}

	private static void xoaMonHoc() {
		System.out.println("\n-------XOA THONG TIN MON HOC-------");
		System.out.print("\tNhap ma mon hoc can xoa: ");
		String id = sc.nextLine();

		int index = indexOf(id);
		if (index == -1) {
			System.out.println("\tMon hoc khong co trong danh sach");
			return;
		}
		// Co the kiem tra xem mon hoc da co sinh vien hoc chua?
		int i = 0;
		while (i < QLSinhVien.list.size() && QLSinhVien.list.get(i).getMaSV() != id) {
			i++;
		}
		if (i < QLSinhVien.list.size()) {
			System.out.println("\tMon hoc da co sinh vien hoc, khong the xoa");
			return;
		}
		// Khong thi xoa
		list.remove(index);
		System.out.println("\tXoa mon hoc thanh cong!");

	}

	private static void sapXepDs() {
		Collections.sort(list, new Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				// TODO Auto-generated method stub
				return o1.getTenMH().trim().compareToIgnoreCase(o2.getTenMH().trim());
			}
		});
		System.out.println("\tSap xep thanh cong, chon lai 2 de xem chi tiet");

	}

	// Ham nhan vao id. tra ve index neu id co trong danh sach, ngc lai tra ve -1
	public static int indexOf(String id) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getMaMH().trim().equals(id.trim())) {
				return index;
			}
		}
		return -1;
	}
}
