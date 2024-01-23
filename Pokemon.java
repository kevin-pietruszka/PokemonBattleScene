import javafx.scene.image.Image;

/**
 * Class to represent a pokemon
 * @author Kevin Pietruszka, the TAs
 * @version 2.0
 */
public class Pokemon {
    private String name;
    private int level;
    private double maxHP;
    private double currentHP;
    private int atk;
    private int def;
    private Move[] moves;
    private String type;
    private boolean fainted;
    private Image pic;

    /**
     * Constructor
     * @param n name
     * @param l level
     * @param h health
     * @param a attack
     * @param d defense
     * @param t type
     * @param move moves
     * @param i image
     */
    public Pokemon(String n, int l, double h, int a, int d, String t, Move[] move, Image i) {
        name = n;
        level = l;
        maxHP = h;
        atk = a;
        def = d;
        type = t;
        currentHP = maxHP;
        moves = move;
        pic = i;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return attack
     */
    public int getAtk() {
        return atk;
    }

    /**
     * @return maxHp
     */
    public double getMaxHP() {
        return maxHP;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @return current health
     */
    public double getCurrentHP() {
        return currentHP;
    }

    /**
     * @return the moves
     */
    public Move[] getMoves() {
        return moves;
    }

    /**
     * @return the image of the pokemon
     */
    public Image getImage() {
        return pic;
    }

    /**
     * sets the current health
     * @param currentHP the desired health
     */
    public void setCurrentHP(double currentHP) {
        this.currentHP = currentHP;
        if (this.currentHP <= 0) {
            fainted = true;
        }
    }

    /**
     * Generates the modifier attained from the move onto this pokemon
     * @param move attacking move
     * @return the modifier
     */
    public double compareType(Move move) {
        if (move.getType().equals("WATER")) {
            if (type.equals("FIRE")) {
                return 2.0;
            } else if (type.equals("GRASS")) {
                return 0.5;
            } else if (type.equals("DRAGON")) {
                return 0.5;
            }
        } else if (move.getType().equals("GRASS")) {
            if (type.equals("WATER")) {
                return 2.0;
            } else if (type.equals("FIRE")) {
                return 0.5;
            } else if (type.equals("FLYING")) {
                return 0.5;
            } else if (type.equals("DRAGON")) {
                return 0.5;
            }
        } else if (move.getType().equals("FIRE")) {
            if (type.equals("GRASS")) {
                return 2.0;
            } else if (type.equals("WATER")) {
                return 0.5;
            } else if (type.equals("DRAGON")) {
                return 0.5;
            } else if (type.equals("ICE")) {
                return 2.0;
            }
        } else if (move.getType().equals("FLYING")) {
            if (type.equals("GRASS")) {
                return 2.0;
            }
        } else if (move.getType().equals("GROUND")) {
            if (type.equals("GRASS")) {
                return 0.5;
            } else if (type.equals("FLYING")) {
                return 0;
            } else if (type.equals("FIRE")) {
                return 2.0;
            }
        } else if (move.getType().equals("ICE")) {
            if (type.equals("GRASS")) {
                return 2.0;
            } else if (type.equals("FIRE")) {
                return 0.5;
            } else if (type.equals("WATER")) {
                return 0.5;
            } else if (type.equals("DRAGON")) {
                return 2.0;
            } else if (type.equals("GROUND")) {
                return 2.0;
            } else if (type.equals("FLYING")) {
                return 2.0;
            }
        } else if (move.getType().equals("DRAGON")) {
            if (type.equals("DRAGON")) {
                return 2.0;
            }
        } else if (move.getType().equals("LEGEND")) {
            return 1.25;
        }

        return 1;
    }

    /**
     * Takes damage from another move using the damage algorithm
     * @param m attacking move
     * @param attacker the attacking pokemon
     * @return true if fainted
     */
    public boolean takeDamage(Move m, Pokemon attacker) {
        System.out.println(String.format("%s used %s!", attacker.getName(), m.getName()));
        if (m.getName().equals("Splash")) {
            System.out.println("It had no effect\n");
            return true;
        }

        if (compareType(m) > 1) {
            System.out.println("It's super effective\n");
        } else if (compareType(m) < 1) {
            System.out.println("It's not very effective\n");
        } else {
            System.out.println();
        }
        double l = attacker.getLevel();
        double p = m.getPower();
        double a = attacker.getAtk();
        double d = this.def;
        double modifier = this.compareType(m);

        // Uses the actual pokemon algorithm to decide damage
        double damage = ((((2 * l) / 5) * p * (a / d)) / 50 + 2) * modifier;
        this.currentHP -= damage;
        if (currentHP <= 0) {
            this.fainted = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return fainted
     */
    public boolean isFainted() {
        return fainted;
    }

    /**
     * @param fainted sets fainted
     */
    public void setFainted(boolean fainted) {
        this.fainted = fainted;
    }

    /**
     * Raises the pokemons attack
     * @param a the amount to increase
     */
    public void increaseAttack(int a) {
        this.atk += a;
    }

    /**
     * increases defense
     * @param d the amount to increase
     */
    public void increaseDefense(int d) {
        this.def += d;
    }

    /**
     * heals
     * @param h health to be restored
     */
    public void heal(int h) {
        currentHP += h;
        if (currentHP > maxHP) {
            currentHP = maxHP;
        }
    }
}

