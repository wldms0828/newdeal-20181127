package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class LessonAddCommand implements Command{
  Scanner keyboard;
  
  public LessonAddCommand(Scanner keyboard) {
    this.keyboard=keyboard;
  }
public void execute() {
  Connection con =null;
  Statement stmt = null;
  try {
    
    System.out.print("번호? ");
    String lno = keyboard.nextLine();

    System.out.print("수업명? ");
    String title = keyboard.nextLine();

    System.out.print("설명? ");
    String content = keyboard.nextLine();

    System.out.print("시작일? ");
    String startDate = keyboard.nextLine();

    System.out.print("종료일? ");
    String endDate= keyboard.nextLine();

    System.out.print("총수업시간? ");
    String tot_hr = keyboard.nextLine();


    DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
    con= DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
    stmt = con.createStatement();
    
    
    stmt.executeUpdate(
                    "insert into lesson(lno, title, cont, sdt, edt, tot_hr)"
                    + "values('"+lno+"',"
                        +title+","
                        +content+","
                        +startDate+","
                        +endDate+","
                        +tot_hr+")");
    
    System.out.println("수업 정보 입력했습니다!!");
  
  } catch (Exception e) {
    e.printStackTrace();
  }
  finally {
    try {stmt.close();} catch (Exception e) {}
    try {con.close();} catch (Exception e) {}
  }

}
}
