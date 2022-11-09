package U01_Stacks_03_MazeSolver;

import java.util.*;

public class MyStack implements StackADT {
    Square[] stack;
    private int size;

    public MyStack() {
        this(10);
    }

    public MyStack(int initCap) {
        stack = new Square[initCap];
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Square peek() {

        if (size == 0) {
            throw new EmptyStackException();
        } else {
            return stack[size];
        }
    }

    public Square pop() {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            return stack[size--];
        }
    }

    public void push(Square item) {
        if (size == stack.length - 1) {
            doubleCapacity();
        } else {
            size++;
            stack[size] = item;
        }
    }

    private void doubleCapacity() {
        Square[] nStack = new Square[stack.length * 2];

        for (int i = 0; i < stack.length; i++) {
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

        for (Square i : stack) {
            if (i != null) {
                string = i + "\n" + string;
            }
        }
        return string;
    }

    @Override
    public void clear() {
        for (int i = 0; i < stack.length; i++) {
            stack[i] = null;
        }
        size = 0;
    }
}
