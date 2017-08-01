package com.remarkable.service;

import java.util.List;

import com.remarkable.model.ReBoardDTO;

public interface ReBoardService {
	
	
	List<ReBoardDTO> re_listAll(int re_bNum);
	void re_create(int re_bNum, String re_Contents);
	void re_delete(int re_Num);
	void re_modify(int re_Num);
	
}
