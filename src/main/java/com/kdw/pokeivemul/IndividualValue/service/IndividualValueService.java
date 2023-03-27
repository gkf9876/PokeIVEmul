package com.kdw.pokeivemul.IndividualValue.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kdw.pokeivemul.IndividualValue.dao.IndividualValueDao;
import com.kdw.pokeivemul.IndividualValue.dao.impl.IndividualValueDaoImpl;
import com.kdw.pokeivemul.IndividualValue.vo.IndividualValueVo;

public class IndividualValueService {
	private IndividualValueDao dao;

	public IndividualValueService(){
		ApplicationContext context = new GenericXmlApplicationContext("classpath*:**/applicationContext.xml");
		this.dao = context.getBean("individualValueDao", IndividualValueDaoImpl.class);
	}
	
	public List<IndividualValueVo> selectList(IndividualValueVo vo){
		return dao.selectList(vo);
	}
	
	public IndividualValueVo selectOne(IndividualValueVo vo) {
		return dao.selectOne(vo);
	}
}
