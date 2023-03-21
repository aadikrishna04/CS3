import java.util.HashSet;
import java.util.Set;

public class MyBST {
    private class Node {
        Integer val;
        Node left, right;

        public Node(Integer val) {
            this.val = val;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

    Node root;
    Set<Integer> backing = new HashSet<>();

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return (node != null) ? 1 + size(node.left) + size(node.right) : 0;
    }

    private Node insert(Node curr, Node next) {
        if (curr == null) {
            return next;
        } else if (next.val < curr.val) {
            curr.left = insert(curr.left, next);
        } else if (next.val > curr.val) {
            curr.right = insert(curr.right, next);
        }

        return curr;
    }

    public void insert(Integer n) {
        root = insert(root, new Node(n));
    }

    public boolean contains(Integer n) {
        // Check backing set to see if it contains n
        return backing.contains(n);

    }

    private Integer getMax(Node next) {
        if (next == null) {
            return null;
        }

        if (next.right == null) {
            return next.val;
        }

        return getMax(next.right);
    }

    public Integer getMax() {
        return getMax(root);
    }

    private Integer getMin(Node next) {
        if (next == null) {
            return null;
        }

        if (next.left == null) {
            return next.val;
        }

        return getMin(next.left);
    }

    public Integer getMin() {
        return getMin(root);
    }

    private Node delete(Node next, Integer n) {
        if (next == null) {
            return null;
        }

        if (n < next.val)
            next.left = delete(next.left, n);
        else if (n > next.val)
            next.right = delete(next.right, n);
        else {
            if (next.left == null)
                return next.right;
            else if (next.right == null)
                return next.left;

            next.val = getMax(next.left);

            next.left = delete(next.left, next.val);
        }

        return next;
    }

    public void delete(Integer n) {
        root = delete(root, n);
    }

    private Node successor(Node n) {
        Node min = n;
        while (root.left != null) {
            min = root.left;
            n = n.left;
        }
        return min;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        } else {
            inOrder(node.left);
            System.out.println(node.val + " ");
            inOrder(node.right);
        }
    }

    public void print() {
        print(root, 0);
    }

    private void print(Node node, int depth) {
        if (node == null) {
            return;
        } else {
            int spaces = depth * 4;
            print(node.right, depth);
            while (spaces > 0) {
                System.out.println(" ");
                spaces--;
            }
            System.out.println(node.val + "\n");
            print(node.left, depth);
        }
    }
}