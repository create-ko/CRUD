package com.remarkable.model;

import java.sql.Timestamp;

public class ReBoardDTO {
	private int re_Num;
	private String re_Contents;
	private Timestamp re_Date;
	private int re_bNum;
	
	public ReBoardDTO(){
		
	}
	
	public ReBoardDTO(int re_Num, String re_Contents, Timestamp re_Date, int re_bNum){
		this.re_Num = re_Num;
		this.re_Contents = re_Contents;
		this.re_Date = re_Date;
		this.re_bNum = re_bNum;
	}
	
	public int getRe_Num() {
		return re_Num;
	}
	public void setRe_Num(int re_Num) {
		this.re_Num = re_Num;
	}
	public String getRe_Contents() {
		return re_Contents;
	}
	public void setRe_Contents(String re_Contents) {
		this.re_Contents = re_Contents;
	}
	public Timestamp getRe_Date() {
		return re_Date;
	}
	public void setRe_Date(Timestamp re_Date) {
		this.re_Date = re_Date;
	}
	public int getRe_bNum() {
		return re_bNum;
	}
	public void setRe_bNum(int re_bNum) {
		this.re_bNum = re_bNum;
	}
	
	
}
