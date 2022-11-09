package U01_Stacks_02_MyStack;

import java.util.*;

public class MyStack {
    Integer[] stack;
    private int size;

    public MyStack() {
        this(10);
    }

    public MyStack(int initCap) {
        stack = new Integer[initCap];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer peek() {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            return stack[size];
        }
    }

    public Integer pop() {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            return stack[size--];
        }
    }

    public void push(Integer item) {
        if (size == stack.length - 1) {
            doubleCapacity();
        } else {
            size++;
            stack[size] = item;
        }
    }

    private void doubleCapacity() {
        Integer[] nStack = new Integer[stack.length * 2];

        for (Integer i = 0; i < stack.length; i++) {
            nStack[i] = stack[i];
        }

        stack = nStack;
    }

    @Override
    public String toString() {
        if (stack.length == 0) {
            return "[]";
        }

        String string = "";

        for (Integer i : stack) {
            if (i != null) {
                string = i + "\n" + string;
            }
        }
        return string;
    }
}