package com.zyp.mapper;

import java.util.List;

import com.zyp.custom.SelectCustom;
import com.zyp.pojo.Dictionarie;
import com.zyp.util.Pagination;

/***
 * 字典mapper
 * @author zyp
 *
 */
public interface DictionarieMapper {
	/**
	 * 插入字典
	 * @param dictionarie
	 */
	public void insertDictionarie(Dictionarie dictionarie );
	
	/**
	 * 获取字典列表
	 * @param pagination 分页条件
	 * @return 字典json 数据
	 */
	public List<Dictionarie> dictionarieList(Pagination pagination);
	
	/**
	 * 获取字典的个数
	 * @param pagination 分页条件
	 * @return 字典个数
	 */
	public int dictionarieCount(Pagination pagination);
	/**
	 * 删除字典
	 * @param id
	 * @return
	 */
	public void deleteDictionarie(Dictionarie dictionarie);
	
	/**
	 * 获取下拉信息
	 * @return
	 */
	public List<SelectCustom> findIDAndNumber();
	
	public Dictionarie fingUserById(String id);
}

