package com.eomcs.util;

public class QueueIterator<E> implements Iterator<E> {
  Queue<E> queue;
  int count;
  int size;
  public QueueIterator(Queue<E> queue) {
    this.queue=queue;
    size=queue.size();
  }

  @Override
  public boolean hasNext() {
    return this.count < this.size;
  }

  @Override
  public E next() {
    this.count++;
    return queue.poll();
  }

}
