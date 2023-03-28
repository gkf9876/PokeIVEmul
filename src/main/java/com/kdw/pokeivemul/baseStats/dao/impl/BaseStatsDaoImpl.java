package com.kdw.pokeivemul.baseStats.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kdw.pokeivemul.baseStats.dao.BaseStatsDao;
import com.kdw.pokeivemul.baseStats.vo.BaseStatsVo;

public class BaseStatsDaoImpl implements BaseStatsDao{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List<BaseStatsVo> selectList(BaseStatsVo vo) {
		return sqlSessionTemplate.selectList("baseStats.selectList", vo);
	}

	public BaseStatsVo selectOne(BaseStatsVo vo) {
		return sqlSessionTemplate.selectOne("baseStats.selectOne", vo);
	}
}
