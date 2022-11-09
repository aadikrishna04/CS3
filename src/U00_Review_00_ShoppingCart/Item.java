package U00_Review_00_ShoppingCart;

public class Item {

    private String name;
    private double price;
    private int bulkQty;
    private double bulkPrice;

    public Item(String name, double price) {
        this(name, price, 0, price);
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public Item(String name, double price, int bulkQty, double bulkPrice) {
        if (price < 0 || bulkQty < 0 || bulkPrice < 0)
            throw new IllegalArgumentException();

        this.name = name;
        this.price = price;
        this.bulkQty = bulkQty;
        this.bulkPrice = bulkPrice;
    }

    public double priceFor(int quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException();

        if (quantity >= bulkQty) {
            return quantity * bulkPrice;
        }

        return quantity * price;
    }

    @Override
    public boolean equals(Object obj) {
        if (((Item) (obj)).name.equals(name)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (bulkPrice == price) {
            return name + ", $" + price;
        } else {
            return name + ", $" + price + " (" + bulkQty + " for " + bulkPrice + ")";
        }
    }
}