package U02_Queues_06_WordLadder;

import java.util.*;
import java.io.*;

public class WordLadder {
    private String start;
    private String end;

    private Queue<Stack<String>> stacksList;
    private ArrayList<String> allWords;
    private Set<String> used;

    private long startTime;

    WordLadder(String s1, String s2) throws Exception {
        start = s1.toUpperCase();
        end = s2.toUpperCase();

        startTime = System.currentTimeMillis();

        if (start.equals(end)) {
            System.out.println(
                    "Ladder found in " + ((float) (System.currentTimeMillis() - startTime) / 1000) + "s: " + start);
        } else if (start.length() != end.length()) {
            System.out
                    .println("No possible ladder between " + start + " and " + end + ". Words are different lengths.");
            System.exit(0);
        }

        stacksList = new LinkedList<>();
        allWords = new ArrayList<>();
        used = new HashSet<>();

        used.add(start);

        BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));

        String line = reader.readLine();

        while (line != null) {
            if (line.length() == start.length()) {
                allWords.add(line);
            }
            line = reader.readLine();
        }

        if (!allWords.contains(start)) {
            System.out.println("Invalid start word.");
            System.exit(0);
        } else if (!allWords.contains(end)) {
            System.out.println("Invalid end word.");
            System.exit(0);
        }

        stepOne();
        reader.close();
    }

    private void stepOne() {
        Stack<String> words = oneOffWords(start);
        while (!words.isEmpty()) {
            Stack<String> s = new Stack<>();

            s.push(start);
            used.add(words.peek());
            s.push(words.pop());

            stacksList.offer(s);
        }

        int solvedIndex = checkIfSolved();
        if (solvedIndex != -1) {
            while (solvedIndex != 0) {
                stacksList.poll();
                solvedIndex--;
            }
            System.out.println("Ladder found in " + ((float) (System.currentTimeMillis() - startTime) / 1000) + "s: "
                    + stringify());
        } else {
            subsequentSteps();
        }

    }

    @SuppressWarnings("unchecked")
    private void subsequentSteps() {
        Stack<String> s = stacksList.peek();
        Stack<String> words = oneOffWords(s.peek());

        while (!words.isEmpty()) {
            Stack<String> st = (Stack<String>) s.clone();
            used.add(words.peek());
            st.push(words.pop());
            stacksList.offer(st);
        }

        stacksList.poll();

        int solvedIndex = checkIfSolved();
        if (solvedIndex != -1) {
            while (solvedIndex != 0) {
                stacksList.poll();
                solvedIndex--;
            }
            System.out.println("Ladder found in " + ((float) (System.currentTimeMillis() - startTime) / 1000) + "s: "
                    + stringify());
        } else {
            subsequentSteps();
        }
    }

    @SuppressWarnings("unchecked")
    private int checkIfSolved() {
        int index = 0;
        Queue<Stack<String>> local = new LinkedList<>();

        for (Stack<String> s : stacksList) {
            Stack<String> c = (Stack<String>) s.clone();
            local.offer(c);
        }

        while (!local.isEmpty()) {
            if (local.poll().pop().equals(end)) {
                return index;
            }

            index++;
        }

        return -1;
    }

    private Stack<String> oneOffWords(String s1) {
        Stack<String> words = new Stack<>();

        for (String word : allWords) {
            if (isOneOff(s1, word) && !used.contains(word)) {
                words.push(word);
            }
        }

        return words;
    }

    private String stringify() {
        String returnable = "[";
        Stack<String> st = new Stack<>();

        while (!stacksList.peek().isEmpty()) {
            st.push(stacksList.peek().pop());
        }

        while (!st.isEmpty()) {
            if (st.size() == 1) {
                returnable += st.pop();
                return returnable + "]";
            }

            returnable += st.pop() + " --> ";
        }

        return returnable + "]";
    }

    private boolean isOneOff(String s1, String s2) {
        int charsDiff = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                charsDiff++;
            }
        }

        return charsDiff == 1;
    }
}
