import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;
    
    Lesson[] lessons = new Lesson[LENGTH];
    
    int i = 0;
    while (i < LENGTH) {
      System.out.println("명령 > ");
      String command = keyboard.nextLine();
      
      if(command.equals("quit")) {
          System.out.println("안녕!");
          break;
      }else {
        if(command.equals("/lesson/add")) {
          // 클래스로 정의한 새 데이터 타입의 메모리(인스턴스) 만들기
          Lesson lesson = new Lesson();
          
          // 사용자가 입력한 값을 메모리에 담는다.
          System.out.print("번호? ");
          lesson.no = Integer.parseInt(keyboard.nextLine());
          
          System.out.print("수업명? ");
          lesson.title = keyboard.nextLine();
          
          System.out.print("설명? ");
          lesson.contents = keyboard.nextLine();
          
          System.out.print("시작일? ");
          lesson.startDate = Date.valueOf(keyboard.nextLine());
          
          System.out.print("종료일? ");
          lesson.endDate = Date.valueOf(keyboard.nextLine());
          
          System.out.print("총수업시간? ");
          lesson.totalHours = Integer.parseInt(keyboard.nextLine());
          
          System.out.print("일수업시간? ");
          lesson.dayHours = Integer.parseInt(keyboard.nextLine());
          
          // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
          lessons[i] = lesson;
          i++;
        }else {
          if(command.equals("/lesson/list")) {
            for (int j = 0; j < i; j++) {
              System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
                  lessons[j].no, lessons[j].title, lessons[j].startDate, 
                  lessons[j].endDate, lessons[j].totalHours);
            }
          }else {
            if(command.equals("/lesson/view")) {
              System.out.println("수업상세정보");
            }else {
              System.out.println("유효하지 않은 명령입니다.");
            }
          }
        }
      }
      
      

      System.out.println();
    }
    
    keyboard.close();
    
    System.out.println(); // 빈 줄 출력
    
   
  }
}
