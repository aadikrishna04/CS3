package U00_Review_00_ShoppingCart;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Item> catalog;
    private String name;

    public Catalog(String name) {
        this.name = name;
        catalog = new ArrayList<Item>();
    }

    public String getName() {
        return this.name;
    }

    public void add(Item item) {
        catalog.add(item);
    }

    public int size() {
        return catalog.size();
    }

    public Item get(int index) {
        return catalog.get(index);
    }
}
