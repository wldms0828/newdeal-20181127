package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    
    final int DEFAULT_SIZE = 20;
    //남들이 바꿀 수 없게 final
    int[] no = new int[DEFAULT_SIZE];
    String[] title = new String[DEFAULT_SIZE];
    String[] contents = new String[DEFAULT_SIZE];
    Date[] startDate = new Date[DEFAULT_SIZE];
    Date[] endDate = new Date[DEFAULT_SIZE];
    int[] totalHours = new int[DEFAULT_SIZE];


    int len = 0;
    Scanner scanner = new Scanner(System.in);    
    // Scanner 가 엔터를 치면 메모리에 값이 저장되어 다음값을 읽어드린다(메모리상의 0A)

    for (int i=0;i<DEFAULT_SIZE;i++,len++) {
      System.out.print("번호를 입력하세요.");
      no[i] = Integer.parseInt(scanner.nextLine());

      System.out.print("수업명을 입력하세요");
      title[i] = scanner.nextLine();

      System.out.print("내용을 입력하세요");
      contents[i] = scanner.nextLine();

      System.out.print("강의 시작일을 입력하세요");
      startDate[i] = Date.valueOf(scanner.nextLine());

      System.out.print("강의 종료일을 입력하세요");
      endDate[i]= Date.valueOf(scanner.nextLine());

      System.out.print("총 강의 시간");
      totalHours[i] = Integer.parseInt(scanner.nextLine());

      
      len++;
      System.out.print("계속 입력하시겠습니까?(Y/n)");
      String input = scanner.nextLine();
      
      if(input.equals("") || input.equalsIgnoreCase("y")) {
        continue;
      }
      break;
      
    }

    scanner.close();
    for (int i = 0; i < len; i++) {
      System.out.printf("%d, %s, %s, %s ~ %s,%d\n", no[i],title[i],contents[i],startDate[i],endDate[i],totalHours[i]);
/*      System.out.print("번호 : " + no[i]);
      System.out.printf("수업명 : %s\n", title[i]);
      System.out.printf("내용 : %s\n", contents[i]);
      System.out.printf("시작일 : %s\n", startDate[i]);
      System.out.printf("종료일 : %s\n", endDate[i]);
      System.out.printf("총 수업시간 : %d\n", totalHours[i]);
      System.out.printf("총 강의시간 : %d\n", dayHours[i]);*/
    }
   

    
    // "이스케이프 문자" : 문자열안에 삽입되는 명령어


    //객체는 사람 메소드는 사람에게 일을 시킨다
  }


  /*  public static void main(String[] args) {
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
     System.out.println("강의명 :  "+sub);
       System.out.println("강의 시작일 :  "+sta);
       System.out.println("강의 종료일 :  "+end);
       System.out.println("총 강의시간 :  "+totalHours);
       System.out.println("일 강의시간 :  "+dayHours);
       System.out.printf("강의명 :  %s\n",sub);
       System.out.printf("강의 시작일 :  %s\n",sta);
       System.out.printf("강의 종료일 :  %s\n",end);
       System.out.printf("총 강의시간 :  %d\n",totalHours);
       System.out.printf("일 강의시간 :  %d\n",dayHours);

       keyIn.close();


    }*/

}
