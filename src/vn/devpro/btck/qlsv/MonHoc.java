package vn.devpro.btck.qlsv;

public class MonHoc {
	private String maMH;
	private String tenMH;
	private double heSoMH;


	public void display() {
		System.out.printf("%-10s %-25s %5.1f %n", maMH, tenMH, heSoMH);
	}


	public MonHoc() {
		super();
	}

	public MonHoc(String maMH, String tenMH, double heSoMH) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.heSoMH = heSoMH;

	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public double getHeSoMH() {
		return heSoMH;
	}

	public void setHeSoMH(double heSoMH) {
		this.heSoMH = heSoMH;
	}

}
