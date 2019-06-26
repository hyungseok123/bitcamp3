package com.bitcafe.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitcafe.DTO.AttendanceDTO;

public class AttendanceDAO {
	private static AttendanceDAO dao = new AttendanceDAO();
    public static AttendanceDAO getDAO()
    {
    	return dao;
    }
    private AttendanceDAO() {}
	
	
    public int getCount(Connection conn) throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		sql.append("  select count(*) from attendance"  );
		int datacount=0;
		
		
		try (PreparedStatement pstmt=conn.prepareStatement(sql.toString());
		         	ResultSet rs=pstmt.executeQuery();)
              {
			   if(rs.next())
			   {
				   datacount=rs.getInt(1);
			   }
			
		}
		return datacount;
	}
    
    
    
    public List<AttendanceDTO> attendanceList(Connection conn, int startrow, int endrow) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		List<AttendanceDTO> arr = new ArrayList<>();
		StringBuilder sql=new StringBuilder();
		sql.append("        select *               ");
		sql.append(" from (                        ");
		sql.append("    select rownum as rnum      ");
		sql.append("         ,attendance_no        ");
		sql.append("         ,attendance_content   ");
		sql.append("     ,attendance_writedate     ");
		sql.append("     ,member_no                ");	
		sql.append("     from   attendance a       ");
		sql.append("      where rownum<=?   )      ");
        sql.append(" where rnum>=?                 ");		
		
		
		try {
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, endrow);
			pstmt.setInt(2, startrow);
			rs = pstmt.executeQuery();
		
			while(rs.next())
			{
				AttendanceDTO dto = new AttendanceDTO();
				dto.setAttendance_no(rs.getInt("attendance_no"));
				dto.setAttendance_content(rs.getString("attendance_content"));
				dto.setAttendance_writedate(rs.getDate("attendance_writedate"));
				dto.setMember_no(rs.getInt("member_no"));
				arr.add(dto);
			}
		}catch(SQLException e)
		{
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
		
		
		return arr;
	}
	
     public AttendanceDTO  ReadData(Connection conn, int num)
     {
    	 PreparedStatement pstmt=null;
    	 StringBuilder sql=new StringBuilder();
    	 ResultSet rs=null;
    	 sql.append(" select    attendance_no                  ");
    	 sql.append("          ,attendance_content             ");
    	 sql.append("          ,attendance_writedate           ");
    	 sql.append("          ,member_no           ");
    	 sql.append(" from  attendance                     ");
    	 sql.append(" where  attendance_no=?                   ");
    	 AttendanceDTO data=new AttendanceDTO();
    	 try{
    		 pstmt=conn.prepareStatement(sql.toString());
    		 pstmt.setInt(1, num);
    		 rs=pstmt.executeQuery();
    		 if(rs.next())
    		 {
    		   data.setAttendance_no(rs.getInt("attendance_no"));
    		   data.setAttendance_content(rs.getString("attendance_content"));
    		   data.setAttendance_writedate(rs.getDate("attendance_writedate"));
    		  
    		 }
    	 }catch(SQLException e)
    	 {
    		throw  new RuntimeException();
    	 }finally{
    		 rsClose(rs);
            pstmtClose(pstmt);
    		 
    	 }
    	 return data;
     }

     
     private void  pstmtClose(PreparedStatement pstmt)
	 {
		 if(pstmt!=null) try{ pstmt.close();} catch(SQLException e){}
	 }
     private void rsClose(ResultSet rs)
     {
    	 if(rs!=null) try{ rs.close();} catch(SQLException e){}
     }
	
     public int AttendanceInsert(Connection conn, String attendance, int member_no)
     {
    	   PreparedStatement pstmt=null;
    	   StringBuilder sb=new StringBuilder();
    	   sb.append("  insert   into   attendance 							      ");
    	   sb.append("                          (member_no,attendance_content, attendance_writedate)  ");
    	   sb.append(" values(?,?,now())                  ");
    	   int r=0;
    	   try{
    		   pstmt=conn.prepareStatement(sb.toString());
    		   pstmt.setInt(1, member_no);
    		   pstmt.setString(2, attendance);
    		   
    		   r=pstmt.executeUpdate();
    		   
    	   }catch(SQLException e)
    	   {
    		   System.out.println(e);
    		   throw new RuntimeException();
    	   }finally{
    		   pstmtClose(pstmt);
    	   }
    	   return r;
     }

	public int AttendanceDelete(Connection conn, AttendanceDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		
	
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from attendance          ");
		sql.append("   where member_no =?              ");
		int result =0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				)
		{
			pstmt.setInt(1, dto.getMember_no());
		   result = pstmt.executeUpdate();
		}
		return result;
	
		
		
	}
	public int AttendanceUpdate(Connection conn, AttendanceDTO dto) throws SQLException
    {
    	StringBuilder sql = new StringBuilder();
    	sql.append("  update attendance                                ");
    	sql.append("      set                                           ");
    	sql.append("      attendance_no=?                               ");
    	sql.append("     ,attendanco_content=?, attendance_writedate=?   ");
    	sql.append("       where member_no=?        ");
    	int result=0;
    	try(
    			
    			PreparedStatement pstmt = conn.prepareStatement(sql.toString());)
    	{
    		
    		pstmt.setInt(1, dto.getAttendance_no());
    		pstmt.setString(2, dto.getAttendance_content());
    		pstmt.setDate(3, dto.getAttendance_writedate());
    	   pstmt.setInt(4, dto.getMember_no());
    	   result = pstmt.executeUpdate();
    	   
    	}
    	
    	
    	
    	
    	
    	return result;
    }
	
	
	
	
	
}
