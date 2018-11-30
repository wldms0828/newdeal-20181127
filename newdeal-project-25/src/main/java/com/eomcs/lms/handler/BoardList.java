package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class BoardList {
  static final int LENGTH = 10;
  private Board[] blist;
  private int size = 0;


  public BoardList() {
    blist = new Board[LENGTH];
  }
  public BoardList(int initialCapacity) {
    if(initialCapacity > LENGTH)
      blist=new Board[initialCapacity];
    else
      blist = new Board[LENGTH];
  }
  public Board[] toArray() {
    return Arrays.copyOf(blist, size);
  }
  public void add(Board board) {
    if(size >= blist.length) {
      int oldLength = blist.length;
      int newCapacity=oldLength + oldLength >> 1;
      Arrays.copyOf(blist, newCapacity);
    }
    blist[size++]=board;
  }
}
