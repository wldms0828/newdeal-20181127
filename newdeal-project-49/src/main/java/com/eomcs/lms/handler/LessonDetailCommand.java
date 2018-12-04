package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LessonDetailCommand implements Command {
  Scanner keyboard;
  public LessonDetailCommand(Scanner keyboard) {
    this.keyboard=keyboard;
  }
public void execute() {
  Connection con =null;
  Statement stmt = null;
  ResultSet rs = null;
  
  try {
    
    System.out.print("번호? ");
    int no =  Integer.parseInt(keyboard.nextLine());
    
    DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
    con= DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
    stmt = con.createStatement();
    
    rs= stmt.executeQuery(
                    "select lno, title, cont, sdt, edt, tot_hr,day_hr, mno "
                    + " from lesson"
                    + " where lno like "+no);
    if(rs.next()) {
      System.out.printf("수업번호 : %d\n",rs.getInt("lno"));
      System.out.printf("제목 : %s\n",rs.getString("title"));
      System.out.printf("내용 : %s\n",rs.getString("cont"));
      System.out.printf("시작일자 : %s\n",rs.getString("sdt"));
      System.out.printf("종료일자 : %s\n",rs.getString("edt"));
      System.out.printf("총 수업시간 : %d\n",rs.getInt("tot_hr"));
      System.out.printf("일 수업시간 : %d\n",rs.getInt("day_hr"));
      System.out.printf("회원번호 : %d\n",rs.getInt("mno"));
    }else {
      System.out.println("해당 게시물이 없습니다.");
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
  finally {
    try {stmt.close();} catch (Exception e) {}
    try {con.close();} catch (Exception e) {}
    try {rs.close();} catch (Exception e) {}
  }
}
}
