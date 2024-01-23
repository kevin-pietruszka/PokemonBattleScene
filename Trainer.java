/**
 * class to represent a trainer
 * @author Kevin Pietruszka
 * @version 1.0
 */
public class Trainer {

    private Pokemon[] pokemons;
    private Bag bag;

    /**
     * Creates a new Trainer
     * @param p list of pokemon
     */
    public Trainer(Pokemon[] p) {
        pokemons = p;
        bag = new Bag();
    }

    /**
     * @return The top pokemon
     */
    public Pokemon getCurrPokemon() {
        return pokemons[0];
    }

    /**
     * @return the pokemons
     */
    public Pokemon[] getPokemons() {
        return pokemons;
    }

    /**
     * @return the items
     */
    public Bag getBag() {
        return bag;
    }

    /**
     * Swaps the top pokemon with the desired
     * @param index which index the new pokemon is
     * @return the desired pokemon
     * @throws NotEnoughHealthException when desired is not available
     */
    public Pokemon swapPokemon(int index) throws NotEnoughHealthException {
        Pokemon temp = pokemons[index];
        if (pokemons[index].getCurrentHP() <= 0) {
            throw new NotEnoughHealthException();
        }
        pokemons[index] = pokemons[0];
        pokemons[0] = temp;
        return pokemons[0];
    }

    /**
     * Switches the current pokemon
     * @param p the desired pokemon to switch to
     * @return The pokemon
     */
    public Pokemon swapPokemon(Pokemon p) {
        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i] == p) {
                try {
                    swapPokemon(i);
                } catch (NotEnoughHealthException e) {
                    System.out.println("Not enough health");
                }
            }
        }

        return p;
    }

    /**
     * Checks to see if all pokemon are fainted
     * @return false if one is remaining
     */
    public boolean outOfPokemon() {
        for (Pokemon p: pokemons) {
            if (p.getCurrentHP() > 0) {
                return false;
            }
        }
        return true;
    }
}