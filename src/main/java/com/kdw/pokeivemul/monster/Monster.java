package com.kdw.pokeivemul.monster;

import com.kdw.pokeivemul.EVs.vo.EVsVo;
import com.kdw.pokeivemul.IndividualValues.vo.IndividualValuesVo;
import com.kdw.pokeivemul.Nature.vo.NatureVo;
import com.kdw.pokeivemul.baseStats.vo.BaseStatsVo;

public class Monster {
	//종족값
	private BaseStatsVo baseStatsVo;
	
	//성격
	private NatureVo natureVo;
	
	//개체치
	private IndividualValuesVo individualValuesVo;
	
	//노력치
	private EVsVo eVsVo;
	
	//지닌도구
	
	//특성
	
	//실수치
	
	//레벨
	private int level = 1;
	
	public Monster(int level, BaseStatsVo baseStatsVo, NatureVo natureVo, IndividualValuesVo individualValuesVo, EVsVo eVsVo) {
		this.level = level;
		this.baseStatsVo = baseStatsVo;
		this.natureVo = natureVo;
		this.individualValuesVo = individualValuesVo;
		this.eVsVo = eVsVo;
	}

	public int getH() {
		//체력 = 종족값 + (노력치 / 4 + 개체값) / 2 + 10 + Lv
		return (int)Math.floor((baseStatsVo.getH() + (eVsVo.getH() / 4 + individualValuesVo.getH()) / 2 + 10 + level));
	}

	public int getA() {
		//그외 = {종족값 + (노력치 / 4 + 개체값) / 2 + 5} * 성격보정
		return (int)Math.floor((baseStatsVo.getA() + (eVsVo.getA() / 4 + individualValuesVo.getA()) / 2 + 5) * natureVo.getA());
	}

	public int getB() {
		//그외 = {종족값 + (노력치 / 4 + 개체값) / 2 + 5} * 성격보정
		return (int)Math.floor((baseStatsVo.getB() + (eVsVo.getB() / 4 + individualValuesVo.getB()) / 2 + 5) * natureVo.getB());
	}

	public int getC() {
		//그외 = {종족값 + (노력치 / 4 + 개체값) / 2 + 5} * 성격보정
		return (int)Math.floor((baseStatsVo.getC() + (eVsVo.getC() / 4 + individualValuesVo.getC()) / 2 + 5) * natureVo.getC());
	}

	public int getD() {
		//그외 = {종족값 + (노력치 / 4 + 개체값) / 2 + 5} * 성격보정
		return (int)Math.floor((baseStatsVo.getD() + (eVsVo.getD() / 4 + individualValuesVo.getD()) / 2 + 5) * natureVo.getD());
	}
	public int getS() {
		//그외 = {종족값 + (노력치 / 4 + 개체값) / 2 + 5} * 성격보정
		return (int)Math.floor((baseStatsVo.getS() + (eVsVo.getS() / 4 + individualValuesVo.getS()) / 2 + 5) * natureVo.getS());
	}
}
