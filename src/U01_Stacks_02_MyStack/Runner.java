package U01_Stacks_02_MyStack;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        StackProbs sp = new StackProbs();

        System.out.println(sp.doubleUp(makeStack(new int[] { 1, 3, 5, 0, -1 })));
        System.out.println(sp.posAndNeg(makeStack(new int[] { 2, 9, -4, 3, -1, 0, -6 })));
        System.out.println(sp.shiftByN(makeStack(new int[] { 7, 23, -7, 0, 22, -8, 4, 5 }), 3));
        System.out.println(sp.reverseVowels("hello how are you"));
        System.out.println(sp.bracketBalance("(([()])))"));
        System.out.println(sp.bracketBalance("([()[]()])()"));
    }

    public static Stack<Integer> makeStack(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int num : nums) {
            stack.push(num);
        }
        return stack;
    }
}
