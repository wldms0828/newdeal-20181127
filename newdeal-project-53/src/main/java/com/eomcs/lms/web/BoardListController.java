package com.eomcs.lms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
//이 클래스의 객체는 Spring IoC 컨테이너가 관리하도록 설정한다.

@Component("/board/list")
public class BoardListController implements PageController{
  BoardDao boardDao;
  
public BoardListController(BoardDao boardDao) {
  this.boardDao = boardDao;
}
@Override
   public String execute(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
  
      List<Board> list = boardDao.findAll();
      response.setContentType("text/html;charset=UTF-8");
      request.setAttribute("list", list);
      // 프론트 컨트롤러를 앞단에 두는 이유는 중복코드를 제거하고 훨씬 가벼워 진 코드를 볼 수 있기 때문이다.
      return "/board/list.jsp";
    
  }
} 



