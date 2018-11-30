package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.ArrayList;

public class BoardHandler {
  
  Scanner keyboard;
  ArrayList<Board> list;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<Board>(20);
    //this.list = new ArrayList<>(20); 7버전 부터 생략해도 가능하다 위에 선언해 줬기 때문에
    
  }
  
  public void listBoard() {
    Board[] boards = new Board[list.size()];
    list.toArray(boards);
    // Object[] boards = list.toArray();
    //배열은 형변환casting 할 수 없다.
    //여기서 casting을 하면 compiler는 속일 수 있지만 class에서는 맞지 않기 때문에 오류가 난다.
    //obj배열 안에 board배열 주소가 담겨져 있지만 따로 형변환을 해 주어야 인식할 수 있다.
    // for (Object obj : boards) {
    //Board board = (Board)obj;

    for (Board board : boards) {

       //따라서 여기서 형 변환을 해 주어야 한다.
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());
    
    board.setCreatedDate(new Date(System.currentTimeMillis())); 
    
    board.setViewCount(0);
    
    list.add(board);
    
    System.out.println("저장하였습니다.");
  }

}
