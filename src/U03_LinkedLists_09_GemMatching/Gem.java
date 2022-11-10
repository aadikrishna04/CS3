package U03_LinkedLists_09_GemMatching;
import java.util.*;

enum GemType {
	GREEN, BLUE, ORANGE; // define the different types of Gems, comma delimited
}


public class Gem {
	private GemType type;
	private int value;

	public Gem(GemType type, int value) {
		this.type = type;
		this.value = value;
	}

	public Gem() {
		Random rand = new Random();
		if (rand.nextInt(3) == 0) {
			type = GemType.GREEN;
		} else if (rand.nextInt(3) == 1) {
			type = GemType.BLUE;
		} else {
			type = GemType.ORANGE;
		}

		int[] points = {0, 5, 15, 20, 25, 30, 35, 40, 45, 50};

		value = points[rand.nextInt(points.length)];
	}

	public String toString() {
		String returnable = "";
		returnable += type + " " + value;
		return returnable;
	}

	public GemType getType() {
		return type;
	}

	public int getPoints() {
		return value;
	}


	public void draw(double x, double y) {
		StdDraw.picture(x, y, "src/U03_LinkedLists_09_GemMatching/gem_" + type + ".png");
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x, y, "" + value);
	}
}
