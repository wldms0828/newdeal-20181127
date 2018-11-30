package com.eomcs.util;

public class StackIterator<E> implements Iterator<E> {
  Stack<E> stack;
  int count;
  int size;
  public StackIterator(Stack<E> stack) {
    this.stack=stack;
    size=stack.size();
  }

  @Override
  public boolean hasNext() {
    return this.count < this.size;
  }

  @Override
  public E next() {
    this.count++;
    return stack.pop();
  }

}
