/**
 * Represents an usuable item
 * @author Kevin Pietruszka
 * @version 1.0
 */
public class Item {

    private String name;
    private String use;
    private int effect;
    private int quantity;

    /**
     * Constructor
     * @param n name
     * @param u intended use
     * @param e points to change by
     * @param num num of the item
     */
    public Item(String n, String u, int e, int num) {
        name = n;
        use = u;
        effect = e;
        quantity = num;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Uses the item on the using pokemon
     * @param user the pokemon that is affected
     */
    public void use(Pokemon user) {

        if (quantity <= 0) {
            return;
        }

        System.out.println("Trainer used " + getName() + "\n");

        if (use.equals("HEALTH")) {
            user.heal(effect);
        } else if (use.equals("DEFENSE")) {
            user.increaseDefense(effect);
        } else if (use.equals("ATTACK")) {
            user.increaseAttack(effect);
        }

        this.quantity -= 1;
    }
}