package vn.devpro.btck.qlbd;

import java.util.ArrayList;
import java.util.Scanner;

import vn.devpro.btck.qlsv.MonHoc;
import vn.devpro.btck.qlsv.QLMonHoc;
import vn.devpro.btck.qlsv.QLSinhVien;
import vn.devpro.btck.qlsv.SinhVien;

public class BangDiem {

	private double diem;
	private ArrayList<MonHoc> list = new ArrayList<>();
	private ArrayList<SinhVien> listSv = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void display() {
		System.out.printf("%4.1f %n", diem);
	}

	public void hienThiTheoSV() {
		System.out.print("\tNhap ma sinh vien: ");
		String ma = sc.nextLine();
		System.out.println("\t\t\tBANG DIEM CA NHAN");
		System.out.println("\tMa sinh vien: " + ma);
		// Truy van sinh vien trong ds SV thong qua maSV

		int index = QLSinhVien.indexOf(ma);
		if (index == -1) {
			System.out.println("Khong co ket qua nao");
			return;
		}
		String hoDemSv = QLSinhVien.list.get(index).getHoDem();
		String tenSv = QLSinhVien.list.get(index).getTen();
		System.out.println("\tTen sinh vien: " + hoDemSv + " " + tenSv);

		int stt = 1;
		double tong = 0;
		double sumHs = 0;
		double diemTongKet = 0;
		System.out.printf("%3s %-10s %-25s %5s %4s %n", "STT", "Ma mon hoc", "Ten mon hoc", "He so", "Diem");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%-3d", stt++);
			list.get(i).display();
			sumHs += list.get(i).getHeSoMH();
			tong += (list.get(i).getHeSoMH() * diem);
			diemTongKet = tong / sumHs;
		}
		System.out.printf("\t\t\tDiem tong ket: %,10.2f %n", diemTongKet);
	}

	public void hienThiTheoMH() {
		System.out.print("\tNhap ma sinh vien: ");
		String mam = sc.nextLine();
		System.out.println("\t\t\tBANG DIEM CA NHAN");
		System.out.println("\tMa mon hoc: " + mam);
		// Truy van mon hoc trong ds MH thong qua maMH

		int index1 = QLMonHoc.indexOf(mam);
		if (index1 == -1) {
			return;
		}
		String tenMon = QLMonHoc.list.get(index1).getTenMH();
		System.out.println("\tTen mon hoc: " + tenMon);

		int stt = 1;
		double diemTong = 0;
		double soSv = 0;
		System.out.printf("%3s %-12s %-30s %10s %9s %4s %n", "STT", "Ma sv", "Ten sv", "Nam sinh", "Gioi tinh", "Diem");
		for (int i = 0; i < listSv.size(); i++) {
			System.out.printf("%-3d", stt++);
			listSv.get(i).display();
			diemTong += diem;//em chưa tính được điểm trung bình môn ạ

		}
		System.out.printf("\t\t\tDiem trung binh: %,10.2f %n", diemTong);
	}
	
	
	public BangDiem() {
		super();
	}

	public BangDiem(double diem, ArrayList<MonHoc> list, ArrayList<SinhVien> listSv) {
		super();
		this.diem = diem;

		this.list = list;
		this.listSv = listSv;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}


	public ArrayList<MonHoc> getList() {
		return list;
	}

	public void setList(ArrayList<MonHoc> list) {
		this.list = list;
	}

	public ArrayList<SinhVien> getListSv() {
		return listSv;
	}

	public void setListSv(ArrayList<SinhVien> listSv) {
		this.listSv = listSv;
	}

}
