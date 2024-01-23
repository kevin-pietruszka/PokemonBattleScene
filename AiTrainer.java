import java.util.Random;
/**
 * @author Kevin Pietruszka
 * @version 1.0
 */
public class AiTrainer extends Trainer {

    /**
     * Creates new Ai object
     * @param p list of pokemon for AI
     */
    public AiTrainer(Pokemon[] p) {
        super(p);
    }

    /**
     * Decides best move
     * @return highest power move
     */
    public Move decideMove() {
        Pokemon using = this.getCurrPokemon();

        Move[] moves = using.getMoves();

        Random gen = new Random();

        int index = gen.nextInt(4);

        return moves[index];
    }

    /**
     * Selects the next pokemon in order of occurence
     * @return true if there exists a healthy pokemon
     */
    public boolean nextPokemon() {
        Pokemon[] p = this.getPokemons();
        for (int i = 0; i < p.length; i++) {
            try {
                swapPokemon(i);
            } catch (NotEnoughHealthException e) {
                continue;
            }
            return true;
        }
        return false;
    }
}