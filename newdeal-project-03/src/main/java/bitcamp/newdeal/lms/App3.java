package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App3 {
/*  목록으로 출력할 항목은 번호,내용,작성일,조회수이다.

  번호? 1
  내용? 게시글입니다.

  계속 입력하시겠습니까?(Y/n) y

  번호? 2
  내용? 두 번째 게시글입니다.

  계속 입력하시겠습니까?(Y/n) y

  번호? 3
  내용? 두 번째 게시글입니다.

  1, 게시글입니다.              , 2019-01-01, 0
  2, 두 번째 게시글입니다.        , 2019-01-01, 0
  3, 세 번째 게시글입니다.        , 2019-01-01, 0
  */
  
  public static void main(String[] args) {
    final int DEFAULT_SIZE = 20;
    //남들이 바꿀 수 없게 final
    int[] no = new int[DEFAULT_SIZE];
    String[] contents = new String[DEFAULT_SIZE];
    String[] view = new String[DEFAULT_SIZE];
    Date date = new Date();
    SimpleDateFormat tdate = new SimpleDateFormat("yyyy-MM-dd");

    int len = 0;
    Scanner scanner = new Scanner(System.in);    
    // Scanner 가 엔터를 치면 메모리에 값이 저장되어 다음값을 읽어드린다(메모리상의 0A)

    for (int i=0;i<DEFAULT_SIZE;i++,len++) {
      System.out.print("번호를 입력하세요.");
      no[i] = Integer.parseInt(scanner.nextLine());

      System.out.println("내용?");
      contents[i] = scanner.nextLine();
      
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
      System.out.printf("%d, %s, %s, %s ", no[i],contents[i],tdate.format(date),"0");

    }

  }


 
}
