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
	
	//레벨
	private int level = 1;
	
	public Monster(int level, BaseStatsVo baseStatsVo, NatureVo natureVo, IndividualValuesVo individualValuesVo, EVsVo eVsVo) {
		this.level = level;
		this.baseStatsVo = baseStatsVo;
		this.natureVo = natureVo;
		this.individualValuesVo = individualValuesVo;
		this.eVsVo = eVsVo;
	}

	//체력 실수치
	public int getH() {
		//체력 = 종족값 + (노력치 / 4 + 개체값) / 2 + 10 + Lv
		return (int)Math.floor((baseStatsVo.getH() + (eVsVo.getH() / 4 + individualValuesVo.getH()) / 2 + 10 + level));
	}

	//공격 실수치
	public int getA() {
		//그외 = {종족값 + (노력치 / 4 + 개체값) / 2 + 5} * 성격보정
		return (int)Math.floor((baseStatsVo.getA() + (eVsVo.getA() / 4 + individualValuesVo.getA()) / 2 + 5) * natureVo.getA());
	}

	//방어 실수치
	public int getB() {
		//그외 = {종족값 + (노력치 / 4 + 개체값) / 2 + 5} * 성격보정
		return (int)Math.floor((baseStatsVo.getB() + (eVsVo.getB() / 4 + individualValuesVo.getB()) / 2 + 5) * natureVo.getB());
	}

	//특수공격 실수치
	public int getC() {
		//그외 = {종족값 + (노력치 / 4 + 개체값) / 2 + 5} * 성격보정
		return (int)Math.floor((baseStatsVo.getC() + (eVsVo.getC() / 4 + individualValuesVo.getC()) / 2 + 5) * natureVo.getC());
	}

	//특수방어 실수치
	public int getD() {
		//그외 = {종족값 + (노력치 / 4 + 개체값) / 2 + 5} * 성격보정
		return (int)Math.floor((baseStatsVo.getD() + (eVsVo.getD() / 4 + individualValuesVo.getD()) / 2 + 5) * natureVo.getD());
	}
	
	//스피드 실수치
	public int getS() {
		//그외 = {종족값 + (노력치 / 4 + 개체값) / 2 + 5} * 성격보정
		return (int)Math.floor((baseStatsVo.getS() + (eVsVo.getS() / 4 + individualValuesVo.getS()) / 2 + 5) * natureVo.getS());
	}
	
	//공격 결정력
	//실수치 * 1.5(자속) * 기술위력 * 랭크업 * 특성(천하장사)
	public int getAttackDamage(int power, boolean stab) {
		double percent = 1;
		
		//자속 여부 확인
		if(stab)
			percent = 1.5;
		
		return (int)Math.floor(getA() * power * percent);
	}
	
	//특수공격 결정력
	//실수치 * 1.5(자속) * 기술위력 * 랭크업 * 특성(천하장사)
	public int getSpecialAttackDamage(int power, boolean stab) {
		double percent = 1;
		
		//자속 여부 확인
		if(stab)
			percent = 1.5;
		
		return (int)Math.floor(getC() * power * percent);
	}
	
	//물리내구력 수치
	//(체력 실능 * (물리/특수 방어 실능) * 50 / 22 / 데미지 난수(0.85 ~ 1)
	//(체력 실능 * (물리/특수 방어 실능) / 0.411
	public int getStamina() {
		return (int)Math.floor(getH() * getB() / 0.411);
	}
	
	public int getMaxStamina() {
		return (int)Math.floor(getH() * getB() * 50 / 22 / 0.85);
	}
	
	public int getMinStamina() {
		return (int)Math.floor(getH() * getB() * 50 / 22 / 1);
	}
	
	//툭스내구력 수치
	//(체력 실능 * (물리/특수 방어 실능) * 50 / 22 / 데미지 난수(0.85 ~ 1)
	public int getSpecialStamina() {
		return (int)Math.floor(getH() * getD() / 0.411);
	}
	
	public int getMaxSpecialStamina() {
		return (int)Math.floor(getH() * getD() * 50 / 22 / 0.85);
	}
	
	public int getMinSpecialStamina() {
		return (int)Math.floor(getH() * getD() * 50 / 22 / 1);
	}
}
