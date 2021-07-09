package com.kosta.dto;

public class MemberDTO {
	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private String memail;
	private String mdate; 
	
	public MemberDTO(int mno, String mid, String mpwd,String mname, String memail, String mdate) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.memail = memail;
		this.mdate = mdate;
	}

	@Override
	public String toString() {
		return "MemberDTO [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", memail=" + memail
				+ ", mdate=" + mdate + "]";
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpwd(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
	
}
