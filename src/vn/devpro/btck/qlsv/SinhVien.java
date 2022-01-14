package vn.devpro.btck.qlsv;

public class SinhVien {

	private String maSV;
	private String hoDem;
	private String ten;
	private String namSinh;
	private String gioiTinh;

    public void display() {
		System.out.printf("%-12s %-30s %10s %9s %n", maSV, hoDem + " " + ten, namSinh, gioiTinh);
	}
	
	public SinhVien() {
		super();
	}
	

	public SinhVien(String maSV, String hoDem, String ten, String namSinh, String gioiTinh) {
		super();
		this.maSV = maSV;
		this.hoDem = hoDem;
		this.ten = ten;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}
