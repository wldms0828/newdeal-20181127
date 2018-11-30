package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  
  static final int LENGTH = 10; // 애매모호 한 경우는 그냥 default로 두기
  private Lesson[] list;
  private int size = 0; //배열의 값이 들어간 size
  
  public LessonList() {
    this.list = new Lesson[LENGTH];
  }
  public LessonList(int initialCapacity) {
    if(initialCapacity > LENGTH ) 
      this.list = new Lesson[initialCapacity];
    else
      this.list = new Lesson[LENGTH];
  }
  public Lesson[] toArray() {
    return Arrays.copyOf(list, size);
  }
  public void add(Lesson lesson) {
    if(size >= list.length) {
      int oldLength = list.length;
      int newCapacity=oldLength + oldLength >> 1;
      // oldLength + (int)(oldLength*0.5);
      Arrays.copyOf(list, newCapacity);
      // 배열의 크기를 늘리더라도 간단하게 증가시킬 수 있다.
    }
    list[size++] = lesson;
   
    //  list[size] = lesson;
    // size++; 
  }
}
