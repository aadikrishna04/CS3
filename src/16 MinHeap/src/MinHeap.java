public class MinHeap {
    private Integer[] heap;
    private int size;

    static final int DEFAULT_CAPACITY = 100;

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MinHeap(int capacity) {
        heap = new Integer[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peekMinimum() {
        return heap[1];
    }

    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private void doubleCapacity() {
        if (size + 1 > heap.length) {
            Integer[] heap2 = new Integer[heap.length * 2];
            for (int i = 0; i < heap.length; i++) {
                heap2[i] = heap[i];
            }
            heap = heap2;
        } else
            return;
    }

    public void insert(int value) {
        doubleCapacity();
        heap[size + 1] = value;
        bubbleUp(size + 1);
        size++;
    }

    private void bubbleUp(int index) {
        if (heap[getParentIndex(index)] == null)
            return;
        if (heap[index] < heap[getParentIndex(index)]) {
            swap(index, getParentIndex(index));
            bubbleUp(getParentIndex(index));
        }
    }

    public int popMinimum() {
        int minimum = peekMinimum();
        heap[1] = heap[size];
        heap[size] = null;
        size--;
        siftDown(1);
        return minimum;
    }

    private void siftDown(int index) {
        
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 1; i <= getSize(); i++)
            output += heap[i] + ", ";
        return output.substring(0, output.lastIndexOf(","));
        // lazily truncate last comma
    }

    /**
     * method borrowed
     * with minor modifications
     * from the internet somewhere, for printing
     */
    public void display() {
        int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
        String dots = "...............................";
        System.out.println(dots + dots);
        while (j <= this.getSize()) {
            if (column == 0)
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');
            System.out.print((heap[j] == null) ? "" : heap[j]);
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else
                for (int k = 0; k < nBlanks * 2
                        -
                        2; k++)
                    System.out
                            .print(' ');
            j++;
        }
        System.out.println("\n" + dots + dots);
    }

    private void swap(int index1, int index2) {
        int temp = heap[index2];
        heap[index2] = heap[index1];
        heap[index1] = temp;
    }
}