package com.eomcs.lms.util;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class ArrayList<E> {
  //type을 나타내는 WhatType을 나타낸다.
  final int DEFAULT_CAPACITY = 10;
  Object[] list;
  int size = 0;
  
  public ArrayList() {
    list  = new Board[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY) 
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) {
    if(a.length<size) {
      return (E[])Arrays.copyOf(list, size, a.getClass());
      //a배열의 크기가 작을 수 도 있는데 만약 그런 경우에는 a클래스에서 확인하고 정해진 개수만 return해준다.
    }
    
    System.arraycopy(list, 0, a, 0, size);
    if(a.length > size) 
      a[size] =null;
    //a배열의 크기가 받아온 list의 사이즈 보다 크면 남아있는 칸을 위해서 마지막을 알려줘야 한다. 
    //그래서 마지막칸에 null을 넣어준다.
    return a;
    // 파라미터로 받은 배열을 리턴해 주면 WhatType으로 배열을 사용할 수 있다.
  }
  
  public void add(E item) {
    // type 자체를 변수로 받을 수 있다.
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }
    
    list[size++] = item;
  }
  public int size() {
    return this.size;
  }
}
