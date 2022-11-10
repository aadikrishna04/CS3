package U03_LinkedLists_09_GemMatching;

public class GemList {
	private class Node {
		private Gem gem;
		private Node next;

		public Node(Gem gem) {
			this.gem = gem;
			this.next = null;
		}
	}

	private Node head;
	private int size;

	public GemList() {
		this.head = null;
		size = 0;
	}

	public GemList(Gem gem) {
		this.head = new Node(gem);
		size = 1;
	}

	public int size() {
		return size;
	}

	public void draw(double y) {
		Node curr = head;
		while (curr != null) {
			Gem value = curr.gem;
			StdDraw.picture(GemGame.indexToX(indexOf(curr.gem)), y,
					"src/U03_LinkedLists_09_GemMatching/gem_" + value.getType() + ".png");
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(GemGame.indexToX(indexOf(value)), y, "" + value.getPoints());
			curr = curr.next;
		}
	}

	public void insertBefore(Gem gem, int index) {
		if (index >= size) {
			if (size == 0) {
				head = new Node(gem);
				size++;
			} else {
				Node curr = head;
				while (curr.next != null) {
					curr = curr.next;
				}
				curr.next = new Node(gem);
				size++;
			}
			return;
		}

		Node node = head, prev = null;
		if (index == 0) {
			Node n = new Node(gem);
			n.next = head;
			head = n;
			return;
		}

		for (int i = 0; i < index; i++) {
			prev = node;
			node = node.next;
		}

		Node n = new Node(gem);
		n.next = node;
		prev.next = n;
		size++;
	}

	public int score() {
		if (size == 0)
			return 0;

		int score = 0;
		int sumStreak = 0;
		int streak = 1;
		Node last = null;

		Node curr = head;
		while (curr != null) {
			if (last != null && curr.gem.getType() == last.gem.getType()) {
				if (streak == 1) {
					score -= last.gem.getPoints();
					sumStreak += last.gem.getPoints();
				}

				streak++;
				sumStreak += curr.gem.getPoints();
			} else {
				if (streak > 1) {
					score += streak * streak;
					streak = 0;
					streak = 1;
				}

				score += curr.gem.getPoints();
			}

			last = curr;
			curr = curr.next;
		}

		if (streak > 1) {
			score += streak * sumStreak;
		}
		return score;
	}

	private int indexOf(Gem target) {
		Node curr = head;
		int count = 0;
		while (curr != null) {
			if (curr.gem == target) {
				return count;
			} else {
				count++;
				curr = curr.next;
			}
		}
		return -1;
	}
}
