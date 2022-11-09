package U00_Review_00_ShoppingCart;

import java.util.*;

public class ShoppingCart {
    private ArrayList<ItemOrder> cart;

    public ShoppingCart() {
        cart = new ArrayList<ItemOrder>();
    }

    public void add(ItemOrder newOrder) {
        if (cart.indexOf(newOrder) != -1) {
            int position = cart.indexOf(newOrder);
            cart.set(position, newOrder);
        } else {
            cart.add(newOrder);
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getPrice();
        }
        return total;
    }
}