package com.cos.blog.domain.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;

import com.cos.blog.config.DB;
import com.cos.blog.domain.board.dto.SaveReqDto;
import com.mysql.cj.protocol.Resultset;

public class BoardDao {
	public int save(SaveReqDto dto) { // 글작성
		String sql = "INSERT INTO board(userId, title, content, createDate) VALUES(?,?,?, now())";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUserId());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}
	// SELECT 해서 Board 객체를 컬렉션에 담아서 리턴
	public List<Board> findAll(){
		List<Board> boards = new ArrayList<>();
		
		String sql = "select * from board order by id DESC;";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board boardEntity = Board.builder()
						.id(rs.getInt("id"))
						.userId(rs.getInt("userId"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				boards.add(boardEntity);
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		}finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	public Board detail(int id) {		
		String sql = "select * from board where id = ? ;";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, dto.getUserId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Board boardEntity = Board.builder()
						.id(rs.getInt("id"))
						.userId(rs.getInt("userId"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				return boardEntity;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
}
