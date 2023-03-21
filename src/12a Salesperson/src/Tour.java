public class Tour {
	private class Node {
		Point p;
		Node next;

		Node(Point p) {
			this.p = p;
			this.next = null;
		}
	}

	private int size;
	private Node tail;
	private Node head;

	/** create an empty tour */
	public Tour() {
		size = 0;
		head = null;
		tail = null;
	}

	/** create a four-point tour, for debugging */
	public Tour(Point a, Point b, Point c, Point d) {
		Node a2 = new Node(a);
		head = a2;
		Node b2 = a2.next = new Node(b);
		Node c2 = b2.next = new Node(c);
		Node d2 = c2.next = new Node(d);
		tail = d2;
		tail.next = a2;
		size = 4;
	}

	/** print tour (one point per line) to std output */
	public void show() {
		for (int s = 0; s < size(); s++) {
			System.out.println(head.p);
			head = head.next;
		}
	}

	/** draw the tour using StdDraw */
	public void draw() {
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(0, 600);
		StdDraw.setPenColor(StdDraw.RED);

		for (int s = 0; s < size(); s++) {
			head.p.drawTo(head.next.p);
			head = head.next;
		}
	}

	/** return number of nodes in the tour */
	public int size() {
		return size;
	}

	/**
	 * return the total distance "traveled", from start to all nodes and back to
	 * start
	 */
	public double distance() {
		double distance = 0;
		for (int s = 0; s < size(); s++) {
			distance += head.p.distanceTo(head.next.p);
			head = head.next;
		}

		return distance;
	}

	public void insertInOrder(Point p) {
		if (head == null) {
			tail = head = new Node(p);
			size++;
			return;
		}
		tail.next = new Node(p);
		tail = tail.next;
		size++;
	}

	/** insert p using nearest neighbor heuristic */
	public void insertNearest(Point p) {
		
	}

	/** insert p using smallest increase heuristic */
	public void insertSmallest(Point p) {
		// TODO
	}

	public static void main(String[] args) {
		Point a = new Point(100.0, 100.0);
		Point b = new Point(500.0, 100.0);
		Point c = new Point(500.0, 500.0);
		Point d = new Point(100.0, 500.0);
		Tour squareTour = new Tour();
		squareTour.insertInOrder(a);
		squareTour.insertInOrder(b);
		squareTour.insertInOrder(c);
		squareTour.insertInOrder(d);
		squareTour.show();
		System.out.println(squareTour.distance());
		squareTour.draw();
	}
}