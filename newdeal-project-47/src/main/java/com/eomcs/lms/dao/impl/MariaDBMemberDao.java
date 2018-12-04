
package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MariaDBMemberDao implements MemberDao {
  //프로그램의 유연성을 위해서 그냥 Interface로 설정해준다(List)
public List<Member> findAll() throws Exception{
  DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
  try {    
    
    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
    PreparedStatement stmt = con.prepareStatement("select mno, name from member");
    ResultSet rs = stmt.executeQuery();
    
    List<Member> list = new ArrayList<>();
    //DBMS에서 한개의 레코드를 가져온다.
    while (rs.next()) {
      Member member = new Member();
      member.setNo(rs.getInt("mno"));
      member.setName(rs.getString("name"));
      list.add(member);
    }
    
    return list;
    
  } catch (Exception e){
    throw e;
  }
}
public Member findByNo(int no) throws Exception{

  DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
  try ( Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
      PreparedStatement stmt = con.prepareStatement("select bno, cont, cdt, view, mno, lno"
          + " from board"
          + " where bno=?"); ){
    stmt.setInt(1, no);
    try(ResultSet rs = stmt.executeQuery()){  
      if (rs.next()) {
      Member member = new Member();
      member.setNo(rs.getInt("bno"));
      return member;
    }else {
      return null;
    }}
  } catch (Exception e){
    throw e;
  } 

}
/*public int insert(Member member) throws Exception{
  DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
  try (
      Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
      PreparedStatement stmt = con.prepareStatement("insert into board(cont,mno,lno)"
            + "values(?,?,?)");
      ){
    stmt.setString(1, member.getContents());
    stmt.setInt(2, member.getWriterNo());
    stmt.setInt(3, member.getLessonNo());
      return stmt.executeUpdate();
  }
}
public int update(Member member) throws Exception {
  
  PreparedStatement stmt=null;
  Connection con=null;
  try {
    DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
    con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
    
    stmt = con.prepareStatement("update board set email=? where bno=?");
    stmt.setString(1, member.getContents());
    stmt.setInt(2, member.getNo());
    return stmt.executeUpdate();

  } finally {
    try {stmt.close();} catch (Exception e) {}
    try {con.close();} catch (Exception e) {}
  }
}*/
public int delete(int no) throws Exception{
  Connection con=null;
  PreparedStatement stmt=null;
  try {
    DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
    con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
    stmt = con.prepareStatement("delete from board where bno=?");
    stmt.setInt(1, no);
    return stmt.executeUpdate();
    //retrun 값은 삭제된 값
  } finally {

    try {stmt.close();} catch (Exception e) {}
    try {con.close();} catch (Exception e) {}
  }
}
@Override
public int insert(Member member) throws Exception {
  // TODO Auto-generated method stub
  return 0;
}
@Override
public int update(Member member) throws Exception {
  // TODO Auto-generated method stub
  return 0;
}
}
