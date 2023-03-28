package com.kdw.pokeivemul.Nature.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kdw.pokeivemul.Nature.dao.NatureDao;
import com.kdw.pokeivemul.Nature.vo.NatureVo;

public class NatureDaoImpl implements NatureDao{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List<NatureVo> selectList(NatureVo vo) {
		return sqlSessionTemplate.selectList("nature.selectList", vo);
	}

	public NatureVo selectOne(NatureVo vo) {
		return sqlSessionTemplate.selectOne("nature.selectList", vo);
	}

}
