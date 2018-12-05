package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
//Spring Ioc컨테이너가 이 클래스의 객체를 생성하도록 클래스에 표시해 둔다.
@Component("/board/delete")
public class BoardDeleteCommand implements Command {
  
  Scanner keyboard;
  BoardDao boardDao;
  
  public BoardDeleteCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard=keyboard;
    this.boardDao=boardDao;
  }
  
  public void execute() {

    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      if(boardDao.delete(no)>0) {
        System.out.println("삭제했습니다!!");
      }else {System.out.println("해당 게시물이 없습니다.!");}
      //DBMS에서 한개의 레코드를 가져온다.

    } catch (Exception e){
      e.printStackTrace();
    } 
    }
    
    
  }
  




