/**
 * Exception to stop from switching to a fainted pokemon
 * @author Kevin Pietruszka
 * @version 1.0
 */
public class NotEnoughHealthException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     */
    public NotEnoughHealthException() {
        super("He can not play");
    }
}