package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  
    public static void main(String[] args) {
       Scanner keyIn = new Scanner(System.in);
       
       System.out.println("번호?");
       int no = Integer.parseInt(keyIn.nextLine());
       System.out.println("강의명?");
       String sub = keyIn.nextLine();
       System.out.println("강의 시작일? yyyy-mm-dd");
       Date sta = Date.valueOf(keyIn.nextLine());
       System.out.println("강의 종료일?  yyyy-mm-dd");
       Date end = Date.valueOf(keyIn.nextLine());
       System.out.println("총 강의시간?");
       int totalHours = Integer.parseInt(keyIn.nextLine());
       System.out.println("일 강의시간?");
       int dayHours = Integer.parseInt(keyIn.nextLine());
       
       System.out.println("번호 "+no);
/*     System.out.println("강의명 :  "+sub);
       System.out.println("강의 시작일 :  "+sta);
       System.out.println("강의 종료일 :  "+end);
       System.out.println("총 강의시간 :  "+totalHours);
       System.out.println("일 강의시간 :  "+dayHours);*/
       System.out.printf("강의명 :  %s\n",sub);
       System.out.printf("강의 시작일 :  %s\n",sta);
       System.out.printf("강의 종료일 :  %s\n",end);
       System.out.printf("총 강의시간 :  %d\n",totalHours);
       System.out.printf("일 강의시간 :  %d\n",dayHours);
       
       keyIn.close();
       

    }
}
