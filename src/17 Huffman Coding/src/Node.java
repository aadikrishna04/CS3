public class Node implements Comparable<Node> {
    private int frequency;
    Node left;
    Node right;

    public Node(int frequency, Node left, Node right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Node o) {
        return this.frequency - o.frequency;
    }
}