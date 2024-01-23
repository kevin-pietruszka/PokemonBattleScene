import javafx.scene.image.Image;

/**
 * Class for making the trainers used
 * @author Kevin Pietruszka
 * @version 1.0
 */
public class CreateTrainers {

    private Trainer user;
    private AiTrainer cpu;

    /**
     * Constructor to initialize the two trainers
     */
    public CreateTrainers() {
        Move[] rayquazaMoves = {
            new Move("Fly", 90, "FLYING"),
            new Move("Extreme Speed", 80, "NORMAL"),
            new Move("Dragon Pulse", 85, "DRAGON"),
            new Move("Hyper Beam", 125, "NORMAL")
        };
        Image r = new Image("/rayquaza.jpg", true);
        Pokemon rayquaza = new Pokemon("Rayquaza", 70, 105, 150, 90, "FLYING", rayquazaMoves, r);
        Move[] groundonMoves = {
            new Move("Fire Blast", 110, "FIRE"),
            new Move("Earthquake", 100, "GROUND"),
            new Move("Mud Shot", 55, "GROUND"),
            new Move("Lava Plume", 80, "FIRE")
        };
        Image g = new Image("/groundon.jpg", true);
        Pokemon groundon = new Pokemon("Groundon", 70, 100, 150, 140, "GROUND", groundonMoves, g);
        Move[] kyogreMoves = {
            new Move("Hydro Pump", 110, "WATER"),
            new Move("Body Slam", 85, "NORMAL"),
            new Move("Water Pulse", 60, "WATER"),
            new Move("Ice Beam", 90, "ICE")
        };
        Image k = new Image("/kyogre.jpg", true);
        Pokemon kyogre = new Pokemon("Kyogre", 70, 100, 100, 90, "WATER", kyogreMoves, k);
        Pokemon[] userPokemon = {rayquaza, groundon, kyogre};
        this.user = new Trainer(userPokemon);
        Move[] magikarpMoves = {
            new Move("Splash", 0, "WATER"),
            new Move("Splash", 0, "WATER"),
            new Move("Splash", 0, "WATER"),
            new Move("Splash", 0, "WATER")
        };
        Image m = new Image("/magikarp.jpg", true);
        Pokemon mag1 = new Pokemon("Magikarp", 100, 225, 10, 60, "WATER", magikarpMoves, m);
        Pokemon mag2 = new Pokemon("Magikarp", 50, 150, 10, 40, "WATER", magikarpMoves, m);
        Pokemon mag3 = new Pokemon("Magikarp", 75, 275, 10, 50, "WATER", magikarpMoves, m);
        Pokemon mag4 = new Pokemon("Magikarp", 85, 190, 10, 52, "WATER", magikarpMoves, m);
        Pokemon mag5 = new Pokemon("Magikarp", 90, 210, 10, 55, "WATER", magikarpMoves, m);
        Move[] omoMoves = {
            new Move("Inheritance", 125, "LEGEND"),
            new Move("Polymorphism", 115, "LEGEND"),
            new Move("Encapsulation", 95, "LEGEND"),
            new Move("Abstraction", 80, "LEGEND")
        };
        Image o = new Image("/omojokun.jpg", true);
        Pokemon omojokun = new Pokemon("Omojokun", 100, 450, 75, 170, "LEGEND", omoMoves, o);
        Pokemon[] aiPokemon = {mag1, mag2, mag3, mag4, mag5, omojokun};
        this.cpu = new AiTrainer(aiPokemon);
    }

    /**
     * @return the user
     */
    public Trainer getUser() {
        return user;
    }

    /**
     * @return the cpu
     */
    public AiTrainer getCpu() {
        return cpu;
    }
}