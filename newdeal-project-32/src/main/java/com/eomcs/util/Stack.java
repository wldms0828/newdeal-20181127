package com.eomcs.util;

public class Stack<E> extends LinkedList<E> implements Cloneable {

  private int maxSize;
  
  public Stack() {
    maxSize = 100;
  }
  
  public Stack(int maxSize) {
    this.maxSize = maxSize;
  }
  
  @Override
  public Stack<E> clone() {
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    return (Stack<E>) temp;
  }
  
  public void push(E value) {
    if (size() == maxSize)
      remove(0);
    add(value);
  }
  
  public E pop() {
    return remove(size() - 1);
  }
  public Iterator<E> iterator(){
    return new Iterator<>() {
      Stack<?> stack;
      //어떤 것이든 받겠다는 의미로 ?
      int count;
      {//인스턴스 블록
        this.stack=Stack.this.clone();
      }
      
      @Override
      public boolean hasNext() {
        return this.count < Stack.this.size();
        //중첩클래스로 사용하면 바깥클래스의 멤버를 마음데로 가져다 쓸 수 있지만 꼭 바깥의 것이라고 선언 해주자.
      }

      @SuppressWarnings("unchecked")
      @Override
      public E next() {
        this.count++;
        return (E) stack.pop();
      }
      
    };
    //딱 한번만 쓰는 클래스를 길게 쓰는 것은 의미가 없다
  }
  
  //중첩클래스
  //오로지 stack에서만 사용할 클래스라면 중첩클래스로 만들어서 사용하자
/*  class IteratorImpl<T> implements Iterator<T>{
    Stack<?> stack;
    //어떤 것이든 받겠다는 의미로 ?
    int count;
    {//인스턴스 블록
      this.stack=Stack.this.clone();
    }
    
    @Override
    public boolean hasNext() {
      return this.count < Stack.this.size();
      //중첩클래스로 사용하면 바깥클래스의 멤버를 마음데로 가져다 쓸 수 있지만 꼭 바깥의 것이라고 선언 해주자.
    }

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
      this.count++;
      return (T) stack.pop();
    }
    
  }*/
  /*
  public static void main(String[] args) throws Exception {
    Stack<String> stack = new Stack<>();
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    stack.push("ddd");
    stack.push("eee");
    stack.push("fff");
    
    Stack<String> temp1 = stack.clone();
    while (temp1.size() > 0) {
      System.out.println(temp1.pop());
    }
    System.out.println("----------------------");
    
    Stack<String> temp2 = stack.clone();
    while (temp2.size() > 0) {
      System.out.println(temp2.pop());
    }
  }*/

}
