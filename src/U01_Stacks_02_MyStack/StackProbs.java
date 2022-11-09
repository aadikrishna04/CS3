package U01_Stacks_02_MyStack;

import java.util.*;

public class StackProbs {
    public Stack<Integer> doubleUp(Stack<Integer> nums) {
        Stack<Integer> secondStack = new Stack<Integer>();
        for (int num : nums) {
            secondStack.push(num);
            secondStack.push(num);
        }

        return secondStack;
    }

    public Stack<Integer> posAndNeg(Stack<Integer> nums) {
        Stack<Integer> positives = new Stack<Integer>();
        Stack<Integer> negatives = new Stack<Integer>();

        for (int num : nums) {
            if (num < 0) {
                negatives.push(num);
            } else {
                positives.push(num);
            }
        }

        return mergeStacks(negatives, positives);
    }

    public Stack<Integer> shiftByN(Stack<Integer> nums, int n) {
        Stack<Integer> nAndAfter = new Stack<Integer>();
        for (int i = 0; i <= nums.size(); i++) {
            nAndAfter.push(nums.pop());
        }
        Collections.reverse(nAndAfter);
        return mergeStacks(nAndAfter, nums);

    }

    public String reverseVowels(String str) {
        ArrayList<Character> vowelChars = new ArrayList<Character>() {
            {
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
            }
        };
        Stack<Character> vowels = new Stack<Character>();
        char[] letters = str.toCharArray();

        for (char letter : letters) {
            if (vowelChars.contains(letter)) {
                vowels.push(letter);
            }
        }

        String reversedVowels = new String();

        for (char letter : letters) {
            if (vowelChars.contains(letter)) {
                reversedVowels += vowels.pop();
            } else {
                reversedVowels += letter;
            }
        }

        return reversedVowels;
    }

    public boolean bracketBalance(String str) {
        Stack<Character> stack = new Stack<Character>();
        char[] charray = str.toCharArray();

        for (int i = 0; i < charray.length; i++) {
            if (charray[i] == '(' || charray[i] == '[') {
                stack.push(charray[i]);
            }

            if (charray[i] == ')') {
                if (stack.size() <= 0 || stack.peek() != '(') {
                    return false;
                }

                stack.pop();
            }
            if (charray[i] == ']') {
                if (stack.size() <= 0 || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private Stack<Integer> mergeStacks(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> merged = new Stack<Integer>();
        for (int num : s1) {
            merged.push(num);
        }

        for (int num : s2) {
            merged.push(num);
        }

        return merged;
    }
}
