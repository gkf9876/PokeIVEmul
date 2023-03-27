package com.kdw.pokeivemul.IndividualValue.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kdw.pokeivemul.IndividualValue.dao.IndividualValueDao;
import com.kdw.pokeivemul.IndividualValue.vo.IndividualValueVo;

public class IndividualValueDaoImpl implements IndividualValueDao{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List<IndividualValueVo> selectList(IndividualValueVo vo) {
		return sqlSessionTemplate.selectList("individualValue.selectList", vo);
	}

	public IndividualValueVo selectOne(IndividualValueVo vo) {
		return sqlSessionTemplate.selectOne("individualValue.selectOne", vo);
	}
}
