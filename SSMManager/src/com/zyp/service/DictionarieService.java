package com.zyp.service;

import com.zyp.pojo.Dictionarie;
import com.zyp.pojo.User;
import com.zyp.util.Pagination;

/**
 * 字典 server
 * 
 * @author zyp 定义操作字典的接口
 */
public interface DictionarieService extends ICommonServer{

	// 添加年审
	public void addDictionarie(Dictionarie dictionarie);

	// 分页获取年审
	public String dictionarieList(Pagination pagination);

	// 删除
	public void deleteDictionarie(Dictionarie dictionarie);
	
	//通过id获取信息
	public String findDictionarieByID(String id);
}
