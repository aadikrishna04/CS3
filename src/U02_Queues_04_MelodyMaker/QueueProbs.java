package U02_Queues_04_MelodyMaker;

import java.util.*;

public class QueueProbs {
    Queue<Integer> evenFirst(Queue<Integer> nums) {
        Queue<Integer> evens = new LinkedList<Integer>();
        Queue<Integer> odds = new LinkedList<Integer>();
        while (nums.isEmpty() != true) {
            int num = nums.poll();
            if (num % 2 == 0) {
                evens.offer(num);
            } else {
                odds.offer(num);
            }
        }
        while (evens.isEmpty() != true) {
            int num = evens.poll();
            nums.offer(num);
        }

        while (odds.isEmpty() != true) {
            int num = odds.poll();
            nums.offer(num);
        }

        return nums;
    }

    public boolean numPalindrome(Queue<Integer> nums) {
        ArrayList<Integer> forwards = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> backwards = new Stack<Integer>();

        while (nums.isEmpty() != true) {
            int num = nums.poll();
            forwards.add(num);
            stack.push(num);
        }

        while (stack.isEmpty() != true) {
            backwards.push(stack.pop());
        }

        return forwards.toString().equals(backwards.toString());
    }

    public Stack<Integer> sieve(int n) {
        Queue<Integer> nums = new LinkedList<Integer>();
        Stack<Integer> primes = new Stack<Integer>();
        for (int i = 2; i <= n; i++) {
            nums.offer(i);
        }

        while (nums.isEmpty() != true) {
            int num = nums.poll();
            if (isPrime(num)) {
                primes.push(num);
            }
        }
        return primes;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
