package U02_Queues_04_MelodyMaker;

import java.util.LinkedList;
import java.util.Queue;

public class Runner {
    public static void main(String[] args) {
        QueueProbs qp = new QueueProbs();

        // Test makeQueue
        int[] arr1 = { 3, 5, 4, 17, 6, 83, 1, 84, 16, 37 };
        System.out.println(qp.evenFirst(makeQueue(arr1)));

        // Test numPalindrome
        int[] arr2 = { 3, 8, 17, 9, 17, 8, 3 };
        System.out.println(qp.numPalindrome(makeQueue(arr2)));

        // Test sieve
        System.out.println(qp.sieve(100));
    }

    private static Queue<Integer> makeQueue(int[] array) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (Integer i : array) {
            queue.offer(i);
        }

        return queue;
    }
}
