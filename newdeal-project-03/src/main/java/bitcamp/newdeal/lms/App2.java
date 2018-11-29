package bitcamp.newdeal.lms;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
/*    번호? 1
        이름? 홍길동
        이메일? hong@test.com
        암호? 1111
        사진? hong.png
        전화? 1111-2222

        계속 입력하시겠습니까?(Y/n) y
목록으로 출력할 항목은 번호,이름,이메일,전화,가입일이다.
*
*/
    
    final int DEFAULT_SIZE = 20;
    //남들이 바꿀 수 없게 final
    int[] no = new int[DEFAULT_SIZE];
    String[] name = new String[DEFAULT_SIZE];
    String[] email = new String[DEFAULT_SIZE];
    String[] pass = new String[DEFAULT_SIZE];
    String[] photo = new String[DEFAULT_SIZE];
    String[] phone = new String[DEFAULT_SIZE];
    Date date = new Date();
    SimpleDateFormat tdate = new SimpleDateFormat("yyyy-MM-dd");

    int len = 0;
    Scanner scanner = new Scanner(System.in);    
    // Scanner 가 엔터를 치면 메모리에 값이 저장되어 다음값을 읽어드린다(메모리상의 0A)

    for (int i=0;i<DEFAULT_SIZE;i++,len++) {
      System.out.print("번호를 입력하세요.");
      no[i] = Integer.parseInt(scanner.nextLine());

      System.out.print("이름을 입력하세요");
      name[i] = scanner.nextLine();

      System.out.print("이메일을 입력하세요");
      email[i] = scanner.nextLine();

      System.out.print("비밀번호를 입력하세요");
      pass[i] = scanner.nextLine();

      System.out.print("이미지명을 입력하세요");
      photo[i]= scanner.nextLine();

      System.out.print("전화번호를 입력하세요 ex) 010-0000-0000");
      phone[i] = scanner.nextLine();


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
      System.out.printf("%d, %s, %s, %s, %s", no[i],name[i],email[i],phone[i],tdate.format(date));
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
