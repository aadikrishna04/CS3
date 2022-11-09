package U02_Queues_04_MelodyMaker;

import java.util.*;

public class Melody {
    private Queue<Note> notes;

    public Melody(Queue<Note> song) {
        notes = new LinkedList<Note>();
        while (!song.isEmpty()) {
            notes.offer(song.poll());
        }
    }

    public double getTotalDuration() {
        double duration = 0.0;
        Queue<Note> copy = new LinkedList<Note>(notes);
        boolean isRepeat = false;
        Queue<Note> repeatSection = new LinkedList<Note>();

        while (!copy.isEmpty()) {
            Note n = copy.poll();
            if (n.isRepeat() == true) {
                duration += 2 * n.getDuration();
                isRepeat = toggleBool(isRepeat);
            } else if (isRepeat == true) {
                duration += 2 * n.getDuration();
            } else {
                duration += n.getDuration();
            }
        }
        while (!repeatSection.isEmpty()) {
            notes.offer(repeatSection.poll());
        }

        return duration;
    }

    private boolean toggleBool(boolean b) {
        if (b == true) {
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        Queue<Note> copy = new LinkedList<Note>(notes);
        String returnable = "";

        while (!copy.isEmpty()) {
            returnable += copy.poll() + "\n";
        }
        return returnable;
    }

    public void changeTempo(double tempo) {
        for (Note n : notes) {
            n.setDuration(n.getDuration() * (1 / tempo));
        }
    }

    public void reverse() {
        Queue<Note> copy = new LinkedList<Note>(notes);
        Stack<Note> reversed = new Stack<Note>();

        while (!copy.isEmpty()) {
            reversed.push(copy.poll());
        }

        notes = new LinkedList<Note>(reversed);
    }

    public void append(Melody other) {
        Queue<Note> part2 = other.getNotes();
        while (!part2.isEmpty()) {
            notes.offer(part2.poll());
        }
    }

    public void play() {
        Queue<Note> copy = new LinkedList<Note>(notes);
        Queue<Note> part1 = new LinkedList<Note>();
        Queue<Note> part2 = new LinkedList<Note>();
        Queue<Note> repeats = new LinkedList<Note>();
        boolean isRepeat = false;
        boolean wasEverRepeat = false;

        while (!copy.isEmpty()) {
            Note n = copy.poll();
            if (n.isRepeat() == true) {
                repeats.offer(n);
                isRepeat = toggleBool(isRepeat);
                wasEverRepeat = true;
            } else if (isRepeat == true) {
                repeats.offer(n);
            } else {
                if (wasEverRepeat) {
                    part2.offer(n);
                } else {
                    part1.offer(n);
                }
            }
        }

        Queue<Note> secondRepetition = new LinkedList<Note>(repeats);

        while (!part1.isEmpty()) {
            part1.poll().play();
        }

        while (!repeats.isEmpty()) {
            repeats.poll().play();
        }

        while (!secondRepetition.isEmpty()) {
            secondRepetition.poll().play();
        }

        while (!part2.isEmpty()) {
            part2.poll().play();
        }
    }

    public Queue<Note> getNotes() {
        return notes;
    }
}
