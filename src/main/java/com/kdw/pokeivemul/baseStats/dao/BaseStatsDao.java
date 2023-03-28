package com.kdw.pokeivemul.baseStats.dao;

import java.util.List;

import com.kdw.pokeivemul.baseStats.vo.BaseStatsVo;

public interface BaseStatsDao {
	public List<BaseStatsVo> selectList(BaseStatsVo vo);
	public BaseStatsVo selectOne(BaseStatsVo vo);
}
