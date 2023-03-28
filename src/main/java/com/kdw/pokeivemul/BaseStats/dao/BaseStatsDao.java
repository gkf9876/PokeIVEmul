package com.kdw.pokeivemul.IndividualValue.dao;

import java.util.List;

import com.kdw.pokeivemul.IndividualValue.vo.IndividualValueVo;

public interface IndividualValueDao {
	public List<IndividualValueVo> selectList(IndividualValueVo vo);
	public IndividualValueVo selectOne(IndividualValueVo vo);
}
