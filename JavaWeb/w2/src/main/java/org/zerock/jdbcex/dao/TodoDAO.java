package org.zerock.jdbcex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
	Database 에서 데이터를 받아옴.
*/
public class TodoDAO {

	public String getTime(){
		String sql = "select now()";
		String now = null;
		/*
			try - catch 문에서 try () 안에 source 작성을 하면 객체를 자동으로 close 해준다.
		*/
		try( Connection conn = ConnectionUtil.INSTANCE.getConnection();
			 PreparedStatement p = conn.prepareStatement(sql);
			 ResultSet resultSet = p.executeQuery()
			){
			resultSet.next();
			now = resultSet.getString(1);
		}catch(Exception e){
			System.err.println("DB 접속 오류");
		}

		return now;
	}
}
