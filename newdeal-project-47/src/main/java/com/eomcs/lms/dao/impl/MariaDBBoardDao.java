package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class MariaDBBoardDao implements BoardDao {
  //프로그램의 유연성을 위해서 그냥 Interface로 설정해준다(List)
public List<Board> findAll() throws Exception{
  DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
  try {    
    
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("select bno, cont, cdt, view from board");
    
    List<Board> list = new ArrayList<>();
    //DBMS에서 한개의 레코드를 가져온다.
    while (rs.next()) {
      Board board = new Board();
      board.setNo(rs.getInt("bno"));
      board.setContents(rs.getString("cont"));
      board.setCreatedDate(rs.getDate("cdt"));
      board.setViewCount(rs.getInt("view"));
      list.add(board);
    }
    
    return list;
    
  } catch (Exception e){
    throw e;
  }
}
public Board findByNo(int no) throws Exception{

  DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
  try {
    
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
    Statement stmt = con.createStatement();    
    ResultSet rs = stmt.executeQuery("select bno, cont, cdt, view, mno, lno"
                          + " from board"
                          + " where bno="+no);
    
    if (rs.next()) {
      Board board = new Board();
      board.setNo(rs.getInt("bno"));
      board.setContents(rs.getString("cont"));
      board.setCreatedDate(rs.getDate("cdt"));
      board.setViewCount(rs.getInt("view"));
      board.setWriterNo(rs.getInt("mno"));
      board.setLessonNo(rs.getInt("lno"));
      return board;
    }else {
      return null;
    }
  } catch (Exception e){
    throw e;
  } 

}
public int insert(Board board) throws Exception{
  DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
  try (
      Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
      Statement stmt = con.createStatement();
      ){
      return stmt.executeUpdate("insert into board(cont,mno,lno)"
            + "values('"+board.getContents()+"',"
            + board.getWriterNo() + ","
            + board.getLessonNo() + ")");
  } catch (Exception e){
      throw e;
  } 
}
public int update(Board board) throws Exception {
  
  Statement stmt=null;
  Connection con=null;
  try {
    //mariadb JDBC 드라이버 구현체를 로딩
    DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
    //DBMS연결하기
    con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
    
    //SQL 전송을 담당할 객체 준비
    stmt = con.createStatement();
    
    //SQL 서버에 전송 => 서버에서 결과를 가져올 일을 할 객체를 리턴
    return stmt.executeUpdate("update board set cont='"
                        +board.getContents() +"' where bno="+ board.getNo());

  } finally {
    try {stmt.close();} catch (Exception e) {}
    try {con.close();} catch (Exception e) {}
  }
}
public int delete(int no) throws Exception{
  Connection con=null;
  Statement stmt=null;
  try {
    DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
    con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
    stmt = con.createStatement();
    return stmt.executeUpdate("delete from board where bno="+no);
    //retrun 값은 삭제된 값
  } finally {

    try {stmt.close();} catch (Exception e) {}
    try {con.close();} catch (Exception e) {}
  }
}
}
