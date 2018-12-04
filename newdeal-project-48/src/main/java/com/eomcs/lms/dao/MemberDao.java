package com.eomcs.lms.dao;

import com.eomcs.lms.domain.Member;

public interface MemberDao {
  public Member findByEmailPassword(String email, String password) throws Exception;
}
