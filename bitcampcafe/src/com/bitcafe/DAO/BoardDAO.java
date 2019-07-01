package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitcafe.DTO.BoardDTO;

public class BoardDAO {
	
	private static BoardDAO dao = new BoardDAO();
	public static BoardDAO getDao() {
		return dao;
	}
	private BoardDAO() {}
	
	public List<BoardDTO> BoardgetList(Connection conn, int category_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		ArrayList<BoardDTO> arr = new ArrayList<>();
		sql.append(" select                           ");
		sql.append("        board_no               	  ");
		sql.append("        ,board_title           	  ");
		sql.append("        ,board_content         	  ");
		sql.append("        ,board_writedate       	  ");
		sql.append("        ,board_viewcount       	  ");
		sql.append("        ,board_favcount        	  ");
		sql.append("        ,c.category_no         	  ");
		sql.append(" 		,c.category_name       	  ");
		sql.append("        ,m.member_no              ");
		sql.append(" 		,m.member_nickname        ");
		sql.append(" from board b join member m       ");
		sql.append(" on b.member_no = m.member_no     ");
		sql.append("              join category c     ");
		sql.append(" on b.category_no = c.category_no ");
		if (category_no != 0)
		sql.append(" where b.category_no = ?            ");
		sql.append(" order by b.board_no desc         ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			if (category_no != 0) pstmt.setInt(1, category_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setBoard_no(rs.getInt("board_no"));
				data.setBoard_title(rs.getString("board_title"));
				data.setBoard_writedate(rs.getDate("board_writedate"));
				data.setBoard_content(rs.getString("board_content"));
				data.setBoard_viewcount(rs.getInt("board_viewcount"));
				data.setBoard_favcount(rs.getInt("board_favcount"));
				data.setCategory_no(rs.getInt("category_no"));
				data.setMember_no(rs.getInt("member_no"));
				data.setMember_nickname(rs.getString("member_nickname"));
				data.setCategory_name(rs.getString("category_name"));
				arr.add(data);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return arr;

	}

	public int BoardInsertData(Connection conn, BoardDTO dto) {
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into board                   ");
		sql.append("  (                                  ");
		sql.append("         board_title                 ");
		sql.append("        ,board_content               ");
		sql.append("        ,board_writedate             ");
		sql.append("        ,board_viewcount             ");
		sql.append("        ,board_favcount              ");
		sql.append("        ,category_no                 ");
		sql.append("        ,member_no                   ");
		sql.append("                                  )  ");
		sql.append("  values (?, ?, now(), 0, 0, ?, ? )  ");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBoard_title());
			pstmt.setString(2, dto.getBoard_content());
			pstmt.setInt(3, dto.getCategory_no());
			pstmt.setInt(4, dto.getMember_no());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
		}
		return result;
	}
	
	public BoardDTO BoardGetDetail(Connection conn, int board_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO result = new BoardDTO();
		StringBuilder sql = new StringBuilder();
		sql.append(" select                           ");
		sql.append("        board_no               	  ");
		sql.append("        ,board_title           	  ");
		sql.append("        ,board_content         	  ");
		sql.append("        ,board_writedate       	  ");
		sql.append("        ,board_viewcount       	  ");
		sql.append("        ,board_favcount        	  ");
		sql.append("        ,c.category_no         	  ");
		sql.append(" 		,c.category_name       	  ");
		sql.append("        ,m.member_no              ");
		sql.append(" 		,m.member_nickname        ");
		sql.append(" from board b join member m       ");
		sql.append(" on b.member_no = m.member_no     ");
		sql.append("              join category c     ");
		sql.append(" on b.category_no = c.category_no ");
		sql.append(" where board_no = ?               ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.setBoard_no(rs.getInt("board_no"));
				result.setBoard_title(rs.getString("board_title"));
				result.setBoard_writedate(rs.getDate("board_writedate"));
				result.setBoard_content(rs.getString("board_content"));
				result.setBoard_viewcount(rs.getInt("board_viewcount"));
				result.setBoard_favcount(rs.getInt("board_favcount"));
				result.setCategory_no(rs.getInt("category_no"));
				result.setMember_no(rs.getInt("member_no"));
				result.setMember_nickname(rs.getString("member_nickname"));
				result.setCategory_name(rs.getString("category_name"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return result;
	}
	public int BoardDeleteData(Connection conn, int board_no) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from board  ");
		sql.append(" where board_no = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board_no);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			throw e;
		} finally {
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}  
		return result;
	}
	public String boardCategoryName(Connection conn, int category_no) throws SQLException {
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select category_name from category ");
		sql.append(" where category_no = ?              ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, category_no);
			rs = pstmt.executeQuery();
			if (rs.next()) result = rs.getString("category_name");
		} catch(SQLException e) {
			throw e;
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}  
		return result;
	}
	public int boardMyboard(Connection conn, int member_no) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(board_no)       ");
		sql.append(" from board b join member m   ");
		sql.append(" on b.member_no = m.member_no ");
		sql.append(" where m.member_no = ?        ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, member_no);
			rs = pstmt.executeQuery();
			if (rs.next()) result = rs.getInt(1);
		} catch(SQLException e) {
			throw e;
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}  
		return result;
	}
	public int boardMyComment(Connection conn, int member_no) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(comment_no)     ");
		sql.append(" from comment c join member m ");
		sql.append(" on c.member_no = m.member_no ");
		sql.append(" where m.member_no = ?        ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, member_no);
			rs = pstmt.executeQuery();
			if (rs.next()) result = rs.getInt(1);
		} catch(SQLException e) {
			throw e;
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}  
		return result;
	}	
	public int BoardUpdateData(Connection conn, BoardDTO dto) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" update board          ");
		sql.append(" set board_content = ? ");
		sql.append("     ,board_title = ?  ");
		sql.append(" where board_no = ?    ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBoard_content());
			pstmt.setString(2, dto.getBoard_title());
			pstmt.setInt(3, dto.getBoard_no());
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			throw e;
		} finally {
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}  
		return result;
	}
	
	
	//페이징에 필요한 카운트
	public int BoardgetCount(Connection conn, int category_no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*)                       ");
		sql.append(" from board inner join member          ");
		sql.append(" on board.member_no = member.member_no ");
		if (category_no != 0)
		sql.append(" where category_no = ?                 ");
	
		int datacount = 0;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			if (category_no != 0) pstmt.setInt(1, category_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				datacount = rs.getInt(1);
			}
		} catch(SQLException e) {
			throw e;
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
		}  
		return datacount;
	}// getCount
	
	//페이징
	public List<BoardDTO> BoardgetData(Connection conn, int startrow, int endrow, int category_no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select  @rownum:=@rownum+1 as rnum, board_no, board_title, board_content, board_writedate, board_viewcount, member_nickname");
		sql.append(" from board inner join member ");
		sql.append(" on board.member_no = member.member_no ");
		sql.append(" where (@rownum:="+(startrow-1)+")="+(startrow-1)+" ");
		if (category_no != 0) sql.append(" and category_no = ? ");
		sql.append(" order by board_no desc ");
		sql.append(" limit "+(startrow-1)+","+(endrow-startrow+1)+" ");
		List<BoardDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.toString());
			if (category_no != 0) pstmt.setInt(1, category_no);
			rs = pstmt.executeQuery();
			System.out.println("동작2"); //
				while(rs.next()) {
					BoardDTO dto = new BoardDTO();
					dto.setBoard_no(rs.getInt("board_no"));
					dto.setBoard_title(rs.getString("board_title"));
					dto.setBoard_content(rs.getString("board_content"));
					dto.setBoard_writedate(rs.getDate("board_writedate"));
					dto.setBoard_viewcount(rs.getInt("board_viewcount"));
					dto.setMember_nickname(rs.getString("member_nickname"));
					list.add(dto);
				}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}
}
