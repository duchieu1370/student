package vn.devpro.btck.qlbd;

import java.util.ArrayList;
import java.util.Scanner;

import vn.devpro.btck.qlsv.QLMonHoc;
import vn.devpro.btck.qlsv.QLSinhVien;

public class QLBangDiem {
	public static ArrayList<BangDiem> list = new ArrayList<>();

	static Scanner sc = new Scanner(System.in);

	public static void capNhat() {
		BangDiem bd = new BangDiem();
		int chon;
		do {

			System.out.println(" -------------------------------------------");
			System.out.println("\n|======== CAP NHAT THONG TIN DIEM ==========|");
			System.out.println("|\tChon mot chuc nang:                 |");
			System.out.println("|\t1. Them moi diem                    |");
			System.out.println("|\t2. Sua diem                         |");
			System.out.println("|\t3. Xoa diem                         |");
			System.out.println("|\t4. Hien thi danh sach theo sv       |");
			System.out.println("|\t5. Hien thi danh sach theo mh       |");
			System.out.println("|\t0. Thoat                            |");
			System.out.println(" -------------------------------------------");
			System.out.print("Lua chon cap nhat: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				themDiem();
				break;
			case 2:
				suaDiem();
				break;
			case 3:
				xoaDiem();
				break;
			case 4:
				bd.hienThiTheoSV();
			    break;
			case 5:
				bd.hienThiTheoMH();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le ");

			}
		} while (true);

	}

	// - Thêm điểm của một sinh viên học một môn học, nhập mã sv sau đó nhập mã môn
			// học
			// muốn thêm điểm. Việc thêm điểm cần lưu ý: Một sinh viên có thể học nhiều môn
			// học,
			// một môn học có nhiều sinh viên học, một sinh viên chỉ học 1 lần với 1 môn học
			// (chỉ có 1 lần điểm), chỉ được thêm điểm cho các sinh viên có trong danh sách
			// sinh viên và học
			// các môn học có trong danh sách môn học, điểm môn học theo thang điểm 10.
			private static void themDiem() {
				System.out.println("\n-------THEM DIEM SINH VIEN-------");
				System.out.println("Nhap thong tin can thiet");
				System.out.print("\tNhap ma sinh vien: ");
				String masv = sc.nextLine();
				if (masv.trim().length() == 0) {
					System.out.println("\tMa sinh vien khong duoc de trong!");
					return;
				}
				// kiem tra sinh vien co trong danh sach vien chua?

				int index = QLSinhVien.indexOf(masv);
				if (index == -1) {
					System.out.println("\tSinh vien khong co trong danh sach!");
					return;
				}

				System.out.print("\tNhap ma mon hoc: ");
				String mamh = sc.nextLine();
				if (mamh.trim().length() == 0) {
					System.out.println("\tMa mon hoc khong duoc de trong!");
					return;
				}
				// Kiem tra xem mon hoc da ton tai trong danh sach chua?
				int index1 = QLMonHoc.indexOf(mamh);
				if (index1 == -1) {
					System.out.println("\tMon hoc khong co trong danh sach!");
					return;
				}

				System.out.print("\tNhap diem mon hoc (0 -> 10): ");
				int diem = Integer.parseInt(sc.nextLine());
				if (diem < 0 && diem > 10) {
					System.out.println("\tDiem ban nhap sai!");
					return;
				}

				// Khoi tao doi tuong
				BangDiem bd = new BangDiem(diem, null, null);
				list.add(bd);
				System.out.println("\nThem diem mon hoc thanh cong!");

			}


			//- Sửa thông tin điểm một môn học của một sinh viên, không được sửa mã sv, không được 
			//sửa mã môn học, chỉ sửa điểm. Nhập mã sv sau đó nhập mã môn muốn sửa điểm, điểm 
			//theo thang điểm 10.
			private static void suaDiem() {
				int chon;
				System.out.println("\n-------SUA DIEM-------");
				System.out.print("\tNhap ma sinh vien: ");
				String masv = sc.nextLine();
				if (masv.trim().length() == 0) {
					System.out.println("\tMa sinh vien khong duoc de trong!");
					return;
				}
				// kiem tra sinh vien co trong danh sach vien chua?

				int index = QLSinhVien.indexOf(masv);
				if (index == -1) {
					System.out.println("\tSinh vien khong co trong danh sach!");
					return;
				}

				System.out.print("\tNhap ma mon hoc: ");
				String mamh = sc.nextLine();
				if (mamh.trim().length() == 0) {
					System.out.println("\tMa mon hoc khong duoc de trong!");
					return;
				}
				// Kiem tra xem mon hoc da ton tai trong danh sach chua?
				int index1 = QLMonHoc.indexOf(mamh);
				if (index1 == -1) {
					System.out.println("\tMon hoc khong co trong danh sach!");
					return;
				}
				
				System.out.print("\tNhap diem mon hoc (0 -> 10): ");
				int diem = Integer.parseInt(sc.nextLine());
				if (diem < 0 && diem > 10) {
					System.out.println("\tDiem ban nhap sai!");
					return;
				}
				
				// Tim xem diem da duoc nhap chua?
				int index2 = indexOf(diem);
				if (index2 == -1) {
					System.out.println("\tDiem chua duoc nhap vao danh sach!");
					return;
				}
				System.out.print("\tNhap diem moi: ");
				System.out.print("\tNhap diem mon hoc (0 -> 10): ");
				int diemnew = Integer.parseInt(sc.nextLine());
				if (diemnew < 0 && diemnew > 10) {
					System.out.println("\tDiem ban nhap sai!");
					return;
				}
				
				// Sua theo ten moi
				list.get(index).setDiem(diemnew);;
				System.out.println("\tSua diem thanh cong!");
			}

			//- Xóa điểm một môn học của một sinh viên: Nhập mã sinh viên, nhập mã môn học muốn 
			//xóa điểm
			private static void xoaDiem() {
				System.out.println("\n-------XOA DIEM-------");
				System.out.print("\tNhap ma sinh vien: ");
				String masv = sc.nextLine();
				if (masv.trim().length() == 0) {
					System.out.println("\tMa sinh vien khong duoc de trong!");
					return;
				}
				// kiem tra sinh vien co trong danh sach vien chua?

				int index = QLSinhVien.indexOf(masv);
				if (index == -1) {
					System.out.println("\tSinh vien khong co trong danh sach!");
					return;
				}

				System.out.print("\tNhap ma mon hoc: ");
				String mamh = sc.nextLine();
				if (mamh.trim().length() == 0) {
					System.out.println("\tMa mon hoc khong duoc de trong!");
					return;
				}
				// Kiem tra xem mon hoc da ton tai trong danh sach chua?
				int index1 = QLMonHoc.indexOf(mamh);
				if (index1 == -1) {
					System.out.println("\tMon hoc khong co trong danh sach!");
					return;
				}
				
				// xoa
				list.remove(index);
				System.out.println("\tXoa mon hoc thanh cong!");

			}

			// Ham nhan vao id. tra ve index neu id co trong danh sach, ngc lai tra ve -1
			 public static int indexOf(double diem) {
				for (int index = 0; index < list.size(); index++) {
					if (list.get(index).getDiem() == diem) {
						return index;
					}
				}
				return -1;
			}

}
