package com.remarkable.Utils;

public class Pages {

	private int total_num;
	private int current_num;
	private int start_num;
	private int end_num;
	
	private int record_num;		
	private int list_num;		
	private int page;			
	 
	public int getTotal_num() {
		return total_num;
	}
	public void setTotal_num(int total_num) {
		this.total_num = total_num;
	}
	public int getRecord_num() {
		return record_num;
	}
	public void setRecord_num(int record_num) {
		this.record_num = record_num;
	}
	public int getCurrent_num() {
		return current_num;
	}
	public void setCurrent_num(int current_num) {
		this.current_num = current_num;
	}
	public int getStart_num() {
		return start_num;
	}
	public void setStart_num(int start_num) {
		this.start_num = start_num;
	}
	public int getEnd_num() {
		return end_num;
	}
	public void setEnd_num(int end_num) {
		this.end_num = end_num;
	}
	
	public int getList_num() {
		return list_num;
	}
	public void setList_num(int list_num) {
		this.list_num = list_num;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
	public void car(int current_num){
		this.page = total_num/record_num;
		if(total_num%record_num >0)
			this.page +=1;
		if(current_num >page)
			current_num = page;
		
		this.start_num = ((current_num-1) / list_num) * list_num +1;
		this.end_num = start_num +list_num - 1;
		if(end_num > this.page)
			this.end_num = page;
	}

	
}
