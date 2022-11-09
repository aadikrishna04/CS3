package U00_Review_00_ShoppingCart;

public class ItemOrder {
    private Item item;
    private int qty;

    public ItemOrder(Item item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    double getPrice() {
        return this.item.priceFor(qty);
    }

    public Item getItem() {
        return item;
    }

    @Override
    public boolean equals(Object obj) {
        ItemOrder io = (ItemOrder) (obj);

        if (io.item.equals(item)) {
            return true;
        } else {
            return false;
        }
    }
}
