/**
 * Class to hold the trainers items
 * @author Kevin Pietruszka
 * @version 1.0
 */
public class Bag {

    private Item[] items;

    /**
     * Constructor
     */
    public Bag() {
        Item[] k = {
            new Item("Hyper Potion", "HEALTH", 70, 3),
            new Item("XAttack", "ATTACK", 10, 5),
            new Item("XDefense", "DEFENSE", 10, 5)
        };
        items = k;
    }

    /**
     * @return the items
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * @param i index
     * @return desired Item
     */
    public Item getIndex(int i) {
        return items[i];
    }

    /**
     * @return returns true if all of the items have 0 quantity
     */
    public boolean outOfItems() {
        for (Item e:items) {
            if (e.getQuantity() > 0) {
                return false;
            }
        }
        return true;
    }
}