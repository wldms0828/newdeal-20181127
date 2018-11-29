package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App3 {
public static void main(String[] args) {
/*  번호? 1
      내용? 게시글입니다.

      번호: 1
      내용: 게시글입니다.
      작성일: 2019-01-01
      조회수: 0*/
  Scanner key = new Scanner(System.in);
  System.out.println("번호?");
  int no = Integer.parseInt(key.nextLine());
  System.out.println("내용?");
  String cont = key.nextLine();
  Date date = new Date();
  SimpleDateFormat tdate = new SimpleDateFormat("yyyy-MM-dd");
  
  key.close();
  System.out.println("번호 " + no);
  System.out.println("내용 :  " + cont);
  System.out.println("작성일 : " + tdate.format(date));
  System.out.println("조회수 : 0");
  
}
}
