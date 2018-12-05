package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LessonUpdateCommand implements Command {
  Scanner keyboard;
  public LessonUpdateCommand(Scanner keyboard) {
    this.keyboard=keyboard;
  }
public void execute() {
  
  Connection con =null;
  Statement stmt = null;
  ResultSet rs = null;
  try {
    DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
    con= DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
    stmt = con.createStatement();
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    rs = stmt.executeQuery(
        "select cont from lesson where lno="+no);
    String oldContent=rs.getString("cont");
    rs.close();

    
    System.out.print("수업번호 ? ");
    String lessonNo=keyboard.nextLine();
    
    System.out.printf("수업명(%s)? ");
    String title = keyboard.nextLine();
    
    System.out.printf("내용(%s)? ",oldContent);
    String content = keyboard.nextLine();
    
    System.out.printf("시작일(%s)? ");
    String std = keyboard.nextLine();
    
    System.out.printf("종료일(%s)? ");
    String etd = keyboard.nextLine();
    
    System.out.printf("총수업시간(%d)? ");
    String tot_hr = keyboard.nextLine();
    
    System.out.printf("일수업시간(%d)? ");
    String day_hr = keyboard.nextLine();
    
  } catch (Exception e) {
    e.printStackTrace();
  }
  finally {
    try {stmt.close();} catch (Exception e) {}
    try {con.close();} catch (Exception e) {}
  }

    System.out.println("수업을 변경했습니다.");
    
}
}
