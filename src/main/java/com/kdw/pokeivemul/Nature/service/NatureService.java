package com.kdw.pokeivemul.Nature.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kdw.pokeivemul.Nature.dao.NatureDao;
import com.kdw.pokeivemul.Nature.dao.impl.NatureDaoImpl;
import com.kdw.pokeivemul.Nature.vo.NatureVo;

public class NatureService {
	private NatureDao dao;

	public NatureService(){
		ApplicationContext context = new GenericXmlApplicationContext("classpath*:**/applicationContext.xml");
		this.dao = context.getBean("natureDao", NatureDaoImpl.class);
	}
	
	public List<NatureVo> selectList(NatureVo vo){
		return dao.selectList(vo);
	}
	
	public NatureVo selectOne(NatureVo vo) {
		return dao.selectOne(vo);
	}
}
