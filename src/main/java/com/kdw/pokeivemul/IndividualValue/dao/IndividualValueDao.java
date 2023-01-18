package com.kdw.pokeivemul.IndividualValue.dao;

import java.util.List;

import com.kdw.pokeivemul.IndividualValue.vo.IndividualValueVo;

public interface IndividualValueDao {
	public List<IndividualValueVo> selectList(String orderBy, String asc);
	public IndividualValueVo selectOne(String name);
}
