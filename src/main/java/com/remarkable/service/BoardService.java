package com.remarkable.service;

import java.util.List;

import com.remarkable.model.BoardDTO;


public interface BoardService {

	List<BoardDTO> listAll();
	List<BoardDTO> listPage(int page);
	void write(String bTitle, String bContents, String bUser_id);
	BoardDTO contents(int bNum);
	void hitcount(int bNum);
	BoardDTO modify(int bNum);
	void modify_apply(String bTitle, String bContents, String bUser_id, int bNum);
	void delete_contents(int bNum);
	int getTotal();
	
}
