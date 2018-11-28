package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    // Scanner 가 엔터를 치면 메모리에 값이 저장되어 다음값을 읽어드린다(메모리상의 0A)
    System.out.print("번호를 입력하세요.");
    int no = Integer.parseInt(scanner.nextLine());
    
    System.out.print("수업명을 입력하세요");
    String title = scanner.nextLine();
    
    System.out.print("내용을 입력하세요");
    String contents = scanner.nextLine();
    
    System.out.print("강의 시작일을 입력하세요");
    Date startDate = Date.valueOf(scanner.nextLine());
    
    System.out.print("강의 종료일을 입력하세요");
    Date endDate= Date.valueOf(scanner.nextLine());
    
    System.out.print("총 강의 시간");
    int totalHours = Integer.parseInt(scanner.nextLine());
    
    System.out.print("일 강의 시간");
    int dayHours = Integer.parseInt(scanner.nextLine());
    
    System.out.print("번호 : " + no);
    System.out.printf("수업명 : %s\n", title);
    System.out.printf("내용 : %s\n", contents);
    System.out.printf("시작일 : %s\n", startDate);
    System.out.printf("종료일 : %s\n", endDate);
    System.out.printf("총 수업시간 : %s\n", totalHours);
    System.out.printf("총 강의시간 : %s\n", dayHours);
    
    scanner.close();
    // "이스케이프 문자" : 문자열안에 삽입되는 명령어
    
    
    //객체는 사람 메소드는 사람에게 일을 시킨다
  }
 
}
