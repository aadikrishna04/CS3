import java.util.*;
import java.io.*;

public class WorstFit {
    private static class Disk implements Comparable<Disk> {
        private int spaceLeft;
        private int id;
        private static int nextId;
        private ArrayList<Integer> files;

        public Disk() {
            files = new ArrayList<Integer>();
            spaceLeft = 1000000;
            id = nextId++;
        }

        public boolean add(int fileSize) {
            files.add(fileSize);
            spaceLeft -= fileSize;
            return true;
        }

        public boolean hasSpace(int fileSize) {
            return spaceLeft >= fileSize;
        }

        @Override
        public int compareTo(Disk o) {
            return Integer.compare(this.spaceLeft, o.spaceLeft);
        }

        @Override
        public String toString() {
            return id + ". Space Left: " + spaceLeft + " " + files.toString();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/input20.txt"));
        PriorityQueue<Disk> disks = new PriorityQueue<Disk>();
        ArrayList<Integer> files = new ArrayList<Integer>();

        while (scanner.hasNextInt()) {
            files.add(scanner.nextInt());
        }

        Collections.sort(files);
        for (int fileSize : files) {
            boolean added = false;
            for (Disk d : disks) {
                if (d.hasSpace(fileSize)) {
                    d.add(fileSize);
                    break;
                }
            }
            if (!added) {
                Disk newDisk = new Disk();
                newDisk.add(fileSize);
                disks.add(newDisk);
            }
        }
        int lenDisks = disks.size();
        double totalSize = 0.0;
        for (int i : files) {
            totalSize += i;
        }

        totalSize /= 1000000;
        System.out.println("Total Size: " + totalSize);
        System.out.println("Disks Req'd: " + lenDisks);

        for (int i = 0; i < disks.size(); i++) {
            System.out.println(disks.poll().toString());
        }
    }
}