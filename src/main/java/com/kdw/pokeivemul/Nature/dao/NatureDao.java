package com.kdw.pokeivemul.Nature.dao;

import java.util.List;

import com.kdw.pokeivemul.Nature.vo.NatureVo;

public interface NatureDao {
	public List<NatureVo> selectList(NatureVo vo);
	public NatureVo selectOne(NatureVo vo);
}
