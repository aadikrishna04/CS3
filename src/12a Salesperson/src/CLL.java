public class CLL {
    private class Node {
        Point p;
        Node next;

        public Node(Point p) {
            this.p = p;
            this.next = null;
        }
    }

    private Node tail;
    private int size;

    public CLL() {
        this.tail = null;
        this.size = 0;
    }

    public CLL(Node n) {
        this.tail = n;
        if (tail != null) {
            tail.next = tail;
        }
        size = 1;
    }

    public CLL(Point a, Point b, Point c, Point d) {
		Node a2 = new Node(a);
		Node b2 = a2.next = new Node(b);
		Node c2 = b2.next = new Node(c);
		Node d2 = c2.next = new Node(d);
		tail = d2;
		tail.next = a2;
		size = 4;
	}

    public void show() {
		for (int s = 0; s < size(); s++) {
			System.out.println(tail.p);
			tail = tail.next;
		}
	}

    public void insertInOrder(Node n) {
        if (tail == null) {
            n.next = n;
        } else {
            n.next = tail.next;
            tail.next = n;
        }
        tail = n;
        size++;
    }
}