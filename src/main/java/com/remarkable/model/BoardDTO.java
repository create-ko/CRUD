package com.remarkable.model;

import java.sql.Timestamp;

public class BoardDTO {
	private int bNum;
	private String bTitle;
	private String bContents;
	private String bUser_id;
	private Timestamp bDate;
	private int bHit;

	public BoardDTO(){
		
	}
	public BoardDTO(int bNum, String bTitle, String bContents, String bUser_id, Timestamp bDate, int bHit){
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bContents = bContents;
		this.bUser_id = bUser_id;
		this.bDate = bDate;
		this.bHit = bHit;
	}
	
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContents() {
		return bContents;
	}
	public void setbContents(String bContents) {
		this.bContents = bContents;
	}
	public String getbUser_id() {
		return bUser_id;
	}
	public void setbUser_id(String bUser_id) {
		this.bUser_id = bUser_id;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	
}