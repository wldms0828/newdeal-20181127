package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardAddCommand implements Command {
  
  Scanner keyboard;
  
  public BoardAddCommand(Scanner keyboard) {
    this.keyboard=keyboard;
  }
  
  public void execute() {
    Connection con=null;
    Statement stmt=null;
    try {
      System.out.print("내용? ");
      String content = keyboard.nextLine();
      
      System.out.print("작성자 번호? ");
      String writeNo = keyboard.nextLine();
     
      System.out.print("수업번호 ? ");
      String lessonNo=keyboard.nextLine();
      
      //mariadb JDBC 드라이버 구현체를 로딩
      DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
      //DBMS연결하기
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb","study","1111");
      
      //SQL 전송을 담당할 객체 준비
      stmt = con.createStatement();
      
      //SQL 서버에 전송 => 서버에서 결과를 가져올 일을 할 객체를 리턴
      stmt.executeUpdate("insert into board(cont,mno,lno)"
          + "values('"+content+"',"
          + writeNo + ","
          + lessonNo + ")");
      
      System.out.println("입력했습니다!!");
      //DBMS에서 한개의 레코드를 가져온다.

    } catch (Exception e){
      e.printStackTrace();
    } finally {

      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }

    

    }
  }




