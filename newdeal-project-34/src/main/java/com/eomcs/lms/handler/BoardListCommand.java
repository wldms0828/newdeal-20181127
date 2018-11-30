package com.eomcs.lms.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {
  
  List<Board> list;
  Scanner keyboard;
  

  public BoardListCommand(Scanner keyboard, ArrayList<Board> boards) {
    list=list;
    keyboard=keyboard;
}

  public void execute() {
    
    Board[] boards = list.toArray(new Board[] {});
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
    }
  }



}
