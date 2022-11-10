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
		System.out.println(curr.gem);
		while (curr != null) {
			Gem value = curr.gem;
			// System.out.println(value.getType());
			StdDraw.picture(GemGame.indexToX(indexOf(curr.gem)), y, "src/U03_LinkedLists_09_GemMatching/gem_" + value.getType()  + ".png");
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(GemGame.indexToX(indexOf(curr.gem)), y, "" + value);
			curr = curr.next;
		}
	}

	public int score() {
		return 0;
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

	public static void main(String[] args) {
		GemList list = new GemList();
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);
		
		// list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		// System.out.println("\n" + list);
		// System.out.println("size = " + list.size() + ", score = " + list.score());
		// list.draw(0.8);
		
		// list.insertBefore(new Gem(GemType.BLUE, 20), 99); //not a mistake, should
		// still work
		// System.out.println("\n" + list);
		// System.out.println("size = " + list.size() + ", score = " + list.score());
		// list.draw(0.7);
		
		// list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		// System.out.println("\n" + list);
		// System.out.println("size = " + list.size() + ", score = " + list.score());
		// list.draw(0.6);
		
		// list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		// System.out.println("\n" + list);
		// System.out.println("size = " + list.size() + ", score = " + list.score());
		// list.draw(0.5);
		
		// list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		// System.out.println("\n" + list);
		// System.out.println("size = " + list.size() + ", score = " + list.score());
		// list.draw(0.4);
		
		// list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		// System.out.println("\n" + list);
		// System.out.println("size = " + list.size() + ", score = " + list.score());
		// list.draw(0.3);
	}
}
