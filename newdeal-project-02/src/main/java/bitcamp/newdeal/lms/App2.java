package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App2 {
public static void main(String[] args) {
/*  번호? 1
      이름? 홍길동
      이메일? hong@test.com
      암호? 1111
      사진? hong.png
      전화? 1111-2222

      번호: 1
      이름: 홍길동
      이메일: hong@test.com
      암호: 1111
      사진: hong.png
      전화: 1111-2222
      가입일: 2019-01-01*/
  Scanner key = new Scanner(System.in);
  System.out.println("번호?");
  int no = Integer.parseInt(key.nextLine());
  System.out.println("이름?");
  String name = key.nextLine();
  System.out.println("이메일?");
  String email = key.nextLine();
  System.out.println("암호?");
  String pass = key.nextLine();
  System.out.println("사진?");
  String photo = key.nextLine();
  System.out.println("전화? 010-0000-000");
  String phone = key.nextLine();
  System.out.println("가입일?");
  Date date = new Date();
  SimpleDateFormat date1 = new SimpleDateFormat("yyyy/MM/dd");
  
  System.out.println("번호  " + no);
  System.out.println("이름 :  " + name);
  System.out.println("이메일 :  " + email);
  System.out.println("암호  " + pass);
  System.out.println("사진  " + photo);
  System.out.println("전화번호  " + phone);
  System.out.println("가입일  " + date1.format(date));
  key.close();
  
  
}
}
