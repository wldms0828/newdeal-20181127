package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;


public interface MemberDao {
  //프로그램의 유연성을 위해서 그냥 Interface로 설정해준다(List)
       List<Member> findAll() throws Exception;
       Member findByNo(int no) throws Exception;
       int insert(Member member) throws Exception;
       int update(Member member) throws Exception;
       int delete(int no) throws Exception;
}
