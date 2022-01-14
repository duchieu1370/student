package vn.devpro.btck.qlsv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QLSinhVien {

	public static ArrayList<SinhVien> list = new ArrayList<>();

	static Scanner sc = new Scanner(System.in);

	public static void capNhat() {
		int chon;
		do {

			System.out.println(" -------------------------------------------");
			System.out.println("\n|=======CAP NHAT THONG TIN SINH VIEN========|");
			System.out.println("|\tChon mot chuc nang:                 |");
			System.out.println("|\t1. Them moi sinh vien               |");
			System.out.println("|\t2. Hien thi danh sach sinh vien     |");
			System.out.println("|\t3. Sua thong tin sinh vien          |");
			System.out.println("|\t4. Xoa thong tin sinh vien          |");
			System.out.println("|\t5. Sap xep danh sach sinh vien      |");
			System.out.println("|\t0. Thoat                            |");
			System.out.println(" -------------------------------------------");
			System.out.print("Lua chon cap nhat: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				themSinhVien();
				break;
			case 2:
				hienThiDs();
				break;
			case 3:
				suaSinhVien();
				break;
			case 4:
				xoaSinhVien();
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

	private static void themSinhVien() {
		System.out.println("\n-------THEM SINH VIEN MOI-------");
		System.out.println("Nhap thong tin sinh vien moi");
		System.out.println("\tTen sinh vien ");
		System.out.print("\tNhap ho dem: ");
		String ho = sc.nextLine();
		if (ho.trim().length() == 0) {
			System.out.println("\tHo dem khong duoc de trong!");
			return;
		}

		System.out.print("\tNhap ten: ");
		String ten = sc.nextLine();
		if (ten.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong!");
			return;
		}

		System.out.print("\tNhap ma sinh vien: ");
		String ma = sc.nextLine();
		if (ma.trim().length() == 0) {
			System.out.println("\tMa sinh vien khong duoc de trong!");
			return;
		}
		// Kiem tra xem ma sv da ton tai trong danh sach chua?
		int i = 0;
		while (i < list.size() && ma.trim().compareToIgnoreCase(list.get(i).getMaSV().trim()) != 0) {
			i++;
		}
		if (i < list.size()) {
			System.out.println("\tSinh vien da ton tai trong danh sach!");
			return;
		}

		System.out.print("\tNhap nam sinh (dd/MM/yyyy): ");
		String day = sc.nextLine();
		if (day.trim().length() == 0) {
			System.out.println("\tNam sinh khong duoc de trong!");
			return;
		}

		System.out.print("\tNhap gioi tinh (Nam/Nu): ");
		String gt = sc.nextLine();
		if (gt.trim().length() == 0) {
			System.out.println("\tGioi tinh khong duoc de trong!");
			return;
		}

		// Khoi tao doi tuong
		SinhVien sv = new SinhVien(ma, ho, ten, day, gt);
		list.add(sv);
		System.out.println("\nThem sinh vien thanh cong!");

	}

	private static void hienThiDs() {
		System.out.println("\n-------DANH SACH SINH VIEN-------");
		System.out.printf("%3s %-12s %-30s %10s %9s %n", "STT", "Ma sinh vien", "Ho va ten", "Nam sinh", "Gioi tinh");
		int stt = 1;
		for (SinhVien sv : list) {
			System.out.printf("%-3d", stt++);
			sv.display();
		}
		if (stt == 1) {
			System.out.println("\nDanh sach sinh vien rong!");
		}

	}

	private static void suaSinhVien() {
		int chon;
		System.out.println("\n-------SUA THONG TIN SINH VIEN-------");
		System.out.print("\tNhap ma sinh vien can sua: ");
		String id = sc.nextLine();
		// Tim xem mon hoc can nhap da co trong danh sach chua?
		int index = indexOf(id);
		if (index == -1) {
			System.out.println("\tSinh vien khong co trong danh sach!");
			return;
		}

		do {
			System.out.println("\nChon thong tin sinh vien can sua: ");
			System.out.println("\t1. Sua ho dem sinh vien");
			System.out.println("\t2. Sua ten sinh vien");
			System.out.println("\t3. Sua nam sinh");
			System.out.println("\t4. Sua gioi tinh");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban : ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				suaHoSV(index);
				break;
			case 2:
				suaTenSV(index);
				break;
			case 3:
				suaNam(index);
				break;
			case 4:
				suaGender(index);
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");

			}

		} while (true);

	}

	private static void suaHoSV(int index) {
		System.out.print("\tNhap ho dem moi cho sinh vien: ");
		String ho = sc.nextLine();
		if (ho.trim().length() == 0) {
			System.out.println("\tHo dem khong duoc de trong");
			return;
		}

		// Sua theo ten moi
		list.get(index).setHoDem(ho);
		System.out.println("\tSua ho dem sinh vien thanh cong!");
		
	}

	private static void suaTenSV(int index) {
		System.out.print("\tNhap ten moi cho sinh vien: ");
		String ten = sc.nextLine();
		if (ten.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}

		// Sua theo ten moi
		list.get(index).setTen(ten);;
		System.out.println("\tSua ten sinh vien thanh cong!");

	}

	private static void suaNam(int index) {
		System.out.print("\tNhap nam sinh moi (dd/MM/yyyy): ");
		String day = sc.nextLine();
		if (day.trim().length() == 0) {
			System.out.println("\tNam sinh khong duoc de trong");
			return;
		}
		list.get(index).setNamSinh(day);
		System.out.println("\tSua nam sinh thanh cong!");

	}

	private static void suaGender(int index) {
		// sua diem
		System.out.print("\tNhap gioi tinh (Nam/Nu): ");
		String gt = sc.nextLine();
		if (gt.trim().length() == 0) {
			System.out.println("\tGioi tinh khong duoc de trong");
			return;
		}
		list.get(index).setGioiTinh(gt);;
		System.out.println("\tSua gioi tinh thanh cong!");

	}

	private static void xoaSinhVien() {
		System.out.println("\n-------XOA THONG TIN SINH VIEN-------");
		System.out.print("\tNhap ma sinh vien can xoa: ");
		String id = sc.nextLine();

		int index = indexOf(id);
		if (index == -1) {
			System.out.println("\tSinh vien khong co trong danh sach!");
			return;
		}
		// Co thi kiem tra xem loai hang da su dung trong danh sach hang hoa chua?
		int i = 0;
		while (i < QLMonHoc.list.size() && QLMonHoc.list.get(i).getMaMH() != id) {
			i++;
		}
		if (i < QLSinhVien.list.size()) {
			System.out.println("\tSinh vien da co diem, khong the xoa");
			return;
		}
		// Khong the xoa
		list.remove(index);
		System.out.println("\tXoa mon hoc thanh cong!");

	}

	private static void sapXepDs() {
		Collections.sort(list, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				return o1.getTen().trim().compareToIgnoreCase(o2.getTen().trim());
			}
		});
		System.out.println("\tSap xep thanh cong, chon lai 2 de xem chi tiet");

	}

	// Ham nhan vao id. tra ve index neu id co trong danh sach, ngc lai tra ve -1
	public static int indexOf(String id) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getMaSV().trim().equals(id.trim())) {
				return index;
			}
		}
		return -1;
	}
}
