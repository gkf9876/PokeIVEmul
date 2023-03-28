package com.kdw.pokeivemul.baseStats.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kdw.pokeivemul.baseStats.dao.BaseStatsDao;
import com.kdw.pokeivemul.baseStats.dao.impl.BaseStatsDaoImpl;
import com.kdw.pokeivemul.baseStats.vo.BaseStatsVo;

public class BaseStatsService {
	private BaseStatsDao dao;

	public BaseStatsService(){
		ApplicationContext context = new GenericXmlApplicationContext("classpath*:**/applicationContext.xml");
		this.dao = context.getBean("baseStatsDao", BaseStatsDaoImpl.class);
	}
	
	public List<BaseStatsVo> selectList(BaseStatsVo vo){
		return dao.selectList(vo);
	}
	
	public BaseStatsVo selectOne(BaseStatsVo vo) {
		return dao.selectOne(vo);
	}
}
