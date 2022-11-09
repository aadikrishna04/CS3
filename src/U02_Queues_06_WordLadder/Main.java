package U02_Queues_06_WordLadder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Start word: ");
        String w1 = input.readLine();
        System.out.println("Enter End word: ");
        String w2 = input.readLine();

        WordLadder ladder = new WordLadder(w1, w2);
    }
}
