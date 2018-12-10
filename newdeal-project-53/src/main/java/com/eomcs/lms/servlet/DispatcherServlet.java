package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.web.PageController;

@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  ApplicationContext iocContainer ;
  @Override
  public void init() {
    iocContainer = (ApplicationContext) this.getServletContext()
                                 .getAttribute("iocContainer");}
  
  @Override
  protected void service(
      //doGet, doPost 모두 처리해 준다
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
   // 클라이언트가 요청한 URL에서 명령을 추출하기
   // => /app/board/list ---> /board/list
    String controllerPath = request.getPathInfo();
    try {
      //클라이언트가 요청한 명령을 처리할 객체를 Spring IoC Container 에서 찾는다.
      
      //페이지 컨트롤러의 메소드를 호출한다.
      PageController controller = (PageController) iocContainer.getBean(controllerPath);    
      
     String viewUrl = controller.execute(request, response);
     if(viewUrl.startsWith("redirect:")) {
       response.sendRedirect(viewUrl.replace("redirect:", ""));
     }else {
       //pageController가 알려준 JSP를 include한다.
       RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
       rd.include(request, response);
     }
    
    } catch (Exception e) {
        throw new ServletException(e);
    }
   
     
    
  }
  
}








