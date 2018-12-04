package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberListCommand implements Command{
  Scanner keyboard;
  MemberDao memberDao;
  public MemberListCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard=keyboard;
    this.memberDao=memberDao;
  }
public void execute() {
  List<Member> list;
  try {
    list = memberDao.findAll();
    for (Member member : list) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          member.getNo(), member.getName(), 
          member.getEmail(), member.getTel(), member.getRegisteredDate());
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
  
}
}
