package U03_LinkedLists_09_GemMatching;

import java.awt.Font;
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

	public static void main(String[] args) {
		final int maxGems = 16;

		// Create a gem of each type
		Gem green = new Gem(GemType.GREEN, 10);
		Gem blue = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green + ", " + green.getType() + ", " +
				green.getPoints());
		System.out.println(blue + ", " + blue.getType() + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " +
				orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);

		// A row of random gems
		for (int i = 0; i < maxGems; i++) {
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
