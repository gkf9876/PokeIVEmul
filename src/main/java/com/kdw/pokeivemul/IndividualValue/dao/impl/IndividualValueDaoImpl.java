package com.kdw.pokeivemul.IndividualValue.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kdw.pokeivemul.IndividualValue.dao.IndividualValueDao;
import com.kdw.pokeivemul.IndividualValue.vo.IndividualValueVo;

public class IndividualValueDaoImpl implements IndividualValueDao{

	public List<IndividualValueVo> selectList(String orderBy, String asc) {
		
		List<IndividualValueVo> result = new ArrayList<IndividualValueVo>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\LGRnD\\Desktop\\db");
			
			Statement stat = conn.createStatement();
			String query = ""
					+ "	SELECT "
					+ "		* "
					+ "	FROM "
					+ "		TB_INDIVIDUAL_VALUE "
					+ "	ORDER BY "
					+ "		" + orderBy + " " + asc;
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()) {
				IndividualValueVo vo = new IndividualValueVo();
				vo.setName(rs.getString("NAME"));
				vo.setH(rs.getInt("H"));
				vo.setA(rs.getInt("A"));
				vo.setB(rs.getInt("B"));
				vo.setC(rs.getInt("C"));
				vo.setD(rs.getInt("D"));
				vo.setS(rs.getInt("S"));
				
				result.add(vo);
			}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public IndividualValueVo selectOne(String name) {
		
		IndividualValueVo result = new IndividualValueVo();
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\LGRnD\\Desktop\\db");
			
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM TB_INDIVIDUAL_VALUE");
			while(rs.next()) {
				result.setName(rs.getString("NAME"));
				result.setH(rs.getInt("H"));
				result.setA(rs.getInt("A"));
				result.setB(rs.getInt("B"));
				result.setC(rs.getInt("C"));
				result.setD(rs.getInt("D"));
				result.setS(rs.getInt("S"));
			}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
