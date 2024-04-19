package org.zerock.w3.w3.member._5_dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.zerock.w3.w3.member._4_domain.MemberVO;
import org.zerock.w3.w3.web.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Log4j2
public class MemberDAO {
	public MemberVO getWithPassword(String mid, String mpw) throws Exception {
		String sql = "select * from tbl_member where mid = ? and mpw = ?";

		@Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();

		@Cleanup PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, mid);
		p.setString(2, mpw);
		log.info("getWithPassword_sql : " + p);

		@Cleanup ResultSet rs = p.executeQuery();

		rs.next();

		return MemberVO.builder()
				.mid(rs.getString("mid"))
				.mpw(rs.getString("mpw"))
				.mname(rs.getString("mname"))
				.build();
	}
}
