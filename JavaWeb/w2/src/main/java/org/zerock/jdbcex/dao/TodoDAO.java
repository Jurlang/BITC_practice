package org.zerock.jdbcex.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
	Database CRUD ( Create Read Update Delete )
*/
@Log4j2
public class TodoDAO {

	public String getTime(){
		String sql = "select now()";
		log.info("DAO_getTime_SQL : "+sql);
		String now = null;
		/*
			try - catch 문에서 try () 안에 source 작성을 하면 객체를 자동으로 close 해준다.
		*/
		try(Connection conn = ConnectionUtil.INSTANCE.getConnection();
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
	public String getTime2() throws Exception {
		String sql = "select now()";
		log.info("DAO_getTime2_SQL : "+sql);
		String now;
		/*
			@Cleanup 을 이용하여 자동으로 close() 가 된다.
		*/
		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement p = conn.prepareStatement(sql);
		@Cleanup ResultSet resultSet = p.executeQuery();

		resultSet.next();
		now = resultSet.getString(1);
		return now;
	}
	public List<TodoVO> selectAll() throws Exception{
		String sql = "Select * from tbl_todo";

		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement p = conn.prepareStatement(sql);
		log.info("DAO_selectALL_SQL : "+p);
		@Cleanup ResultSet resultSet = p.executeQuery();

		List<TodoVO> list = new ArrayList<>();

		while(resultSet.next()){
			TodoVO vo = TodoVO.builder()
					.tno(resultSet.getLong("tno"))
					.title(resultSet.getString("title"))
					.dueDate(resultSet.getDate("dueDate").toLocalDate())
					.finished(resultSet.getBoolean("finished"))
					.build();
			list.add(vo);
		}

		return list;
	}
	public TodoVO selectOne(TodoVO param) throws Exception{
		String sql = "Select * from tbl_todo where tno = ?";

		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement p = conn.prepareStatement(sql);
		p.setLong(1, param.getTno());
		log.info("DAO_selectONE_SQL : "+p);
		@Cleanup ResultSet resultSet = p.executeQuery();
		resultSet.next();
		return TodoVO.builder()
				.tno(resultSet.getLong("tno"))
				.title(resultSet.getString("title"))
				.dueDate(resultSet.getDate("dueDate").toLocalDate())
				.finished(resultSet.getBoolean("finished"))
				.build();
	}
	public void insert(TodoVO vo) throws Exception{
		String sql = "insert into tbl_todo(title,dueDate,finished) values( ?, ?, ? )";
		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, vo.getTitle());
		p.setDate(2, Date.valueOf(vo.getDueDate()));
		p.setBoolean(3, vo.isFinished());
		log.info("DAO_INSERT_SQL : "+p);
		p.executeQuery();
	}
	public void deleteOne(Long tno) throws Exception{
		String sql = "delete from tbl_todo where tno = ?";

		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement p = conn.prepareStatement(sql);
		p.setLong(1, tno);
		log.info("DAO_DELETE_SQL : "+p);
		p.executeQuery();
	}
	public void updateOne(TodoVO vo) throws Exception{
		String sql = "update tbl_todo set title = ?, dueDate = ?, finished = ? where tno = ?";

		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, vo.getTitle());
		p.setDate(2, Date.valueOf(vo.getDueDate()));
		p.setBoolean(3, vo.isFinished());
		p.setLong(4, vo.getTno());
		log.info("DAO_UPDATE_SQL : "+p);
		p.executeQuery();
	}
}
