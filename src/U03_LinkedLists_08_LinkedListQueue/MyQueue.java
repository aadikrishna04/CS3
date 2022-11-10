package U03_LinkedLists_08_LinkedListQueue;

import U03_LinkedLists_07_MyLinkedList.MyLinkedList;

public class MyQueue<T> implements QueueADT<T> {
    private MyLinkedList<T> queue;

    public MyQueue() {
        queue = new MyLinkedList<T>();
    }

    public MyQueue(T... vals) {
        queue = new MyLinkedList<T>(vals);
    }

    public T poll() {
        return queue.remove(0);
    }

    public void clear() {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            queue.remove(0);
        }
    }

    public T peek() {
        return queue.get(size() - 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return queue.size();
    }

    public void offer(T val) {
        queue.add(val);
    }
}
