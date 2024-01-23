/*
 * I worked on the homework assignment alone, using only course materials.
 */
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Line;
import javafx.scene.control.ProgressBar;
import javafx.geometry.Pos;

/**
 * The application
 * @author Kevin Pietruszka
 * @version 9001
 */
public class PokeBattle extends Application {

    // Pokemon
    private Trainer user;
    private AiTrainer cpu;
    private Pokemon currentUserPokemon;
    private Pokemon currentCpuPokemon;

    // Round
    private int round = 1;

    // Updated icons
    private ImageView oppPokemonImage;
    private ProgressBar oppHealth;
    private Text oppName;

    private ImageView userPokemonImage;
    private ProgressBar userHealth;
    private Text userName;

    private Text msg;
    private Scene scene;
    private VBox root;

    /**
     * launches the app and calls the start method
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage mainStage) {

        System.out.println("Round " + this.round + ":");
        this.round++;

        CreateTrainers k = new CreateTrainers();
        user = k.getUser();
        cpu = k.getCpu();
        currentUserPokemon = user.getCurrPokemon();
        currentCpuPokemon = cpu.getCurrPokemon();

        oppPokemonImage = new ImageView();
        oppPokemonImage.setImage(currentCpuPokemon.getImage());
        oppPokemonImage.setFitWidth(210);
        oppPokemonImage.setFitHeight(170);
        oppPokemonImage.setPreserveRatio(true);

        oppHealth = new ProgressBar();
        oppHealth.setProgress(1.00);
        oppHealth.setMinWidth(100);

        oppName = new Text(String.format("%s, %s Lv%d",
            currentCpuPokemon.getName(),
            currentCpuPokemon.getType(),
            currentCpuPokemon.getLevel())
        );
        VBox oppStats = new VBox(5);
        oppStats.setMinWidth(210);
        oppStats.setAlignment(Pos.TOP_CENTER);
        oppStats.getChildren().addAll(oppName, oppHealth);

        HBox opposingPokemon = new HBox();
        opposingPokemon.setMinHeight(170);
        opposingPokemon.getChildren().addAll(oppStats, oppPokemonImage);

        userPokemonImage = new ImageView();
        userPokemonImage.setImage(currentUserPokemon.getImage());
        userPokemonImage.setFitWidth(210);
        userPokemonImage.setFitHeight(170);
        userPokemonImage.setPreserveRatio(true);

        userHealth = new ProgressBar();
        userHealth.setProgress(1.00);
        userHealth.setMinWidth(100);

        userName = new Text(String.format("%s, %s Lv%d",
            currentUserPokemon.getName(),
            currentUserPokemon.getType(),
            currentUserPokemon.getLevel())
        );
        VBox stats2 = new VBox(5);
        stats2.setMinWidth(210);
        stats2.setAlignment(Pos.TOP_CENTER);
        stats2.getChildren().addAll(userName, userHealth);

        HBox userPokemon = new HBox();
        userPokemon.setMinHeight(170);
        userPokemon.getChildren().addAll(userPokemonImage, stats2);


        Line divider = new Line();
        divider.setStartX(0);
        divider.setStartY(360);
        divider.setEndX(420);
        divider.setEndY(360);


        Button fight = new Button();
        fight.setText("FIGHT");
        fight.setMinWidth(100);
        fight.setOnAction(new FightEventHandler());
        Button bag = new Button();
        bag.setText("BAG");
        bag.setMinWidth(100);
        bag.setOnAction(new BagEventHandler());
        Button pokemon = new Button();
        pokemon.setText("POKEMON");
        pokemon.setMinWidth(100);
        pokemon.setOnAction(new PokemonEventHandler());
        Button run = new Button();
        run.setText("RUN");
        run.setMinWidth(100);
        run.setOnAction(new RunEventHandler());

        GridPane options = new GridPane();
        options.setVgap(5);
        options.setHgap(5);
        options.add(fight, 0, 0);
        options.add(bag, 0, 1);
        options.add(pokemon, 1, 0);
        options.add(run, 1, 1);

        msg = new Text(100, 500, "What will you do?");
        TextFlow msgBox = new TextFlow(new Text("\n"), msg);
        msgBox.setMinWidth(200);
        msgBox.setTextAlignment(TextAlignment.CENTER);
        msgBox.setLineSpacing(5);

        HBox bottom = new HBox(10);
        bottom.setMinWidth(420);
        bottom.getChildren().addAll(msgBox, options);

        root = new VBox(5);
        root.getChildren().addAll(opposingPokemon, userPokemon, divider, bottom);

        scene = new Scene(root, 420, 420);
        mainStage.setTitle("PokeBattle!");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     * Class to handle when the user clicks fight
     */
    private class FightEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            Move[] moves = currentUserPokemon.getMoves();
            Button move1 = new Button();
            move1.setText(moves[0].getName());
            move1.setMinWidth(420 / 2);
            move1.setMinHeight(420 / 2);
            move1.setOnAction(e -> {
                    currentCpuPokemon.takeDamage(moves[0], currentUserPokemon);
                    update(true);
                }
            );

            Button move2 = new Button();
            move2.setText(moves[1].getName());
            move2.setMinWidth(420 / 2);
            move2.setMinHeight(420 / 2);
            move2.setOnAction(e -> {
                    currentCpuPokemon.takeDamage(moves[1], currentUserPokemon);
                    update(true);
                }
            );

            Button move3 = new Button();
            move3.setText(moves[2].getName());
            move3.setMinWidth(420 / 2);
            move3.setMinHeight(420 / 2);
            move3.setOnAction(e -> {
                    currentCpuPokemon.takeDamage(moves[2], currentUserPokemon);
                    update(true);
                }
            );
            Button move4 = new Button();
            move4.setText(moves[3].getName());
            move4.setMinWidth(420 / 2);
            move4.setMinHeight(420 / 2);
            move4.setOnAction(e -> {
                    currentCpuPokemon.takeDamage(moves[3], currentUserPokemon);
                    update(true);
                }
            );

            GridPane fightMoves = new GridPane();
            fightMoves.add(move1, 0, 0);
            fightMoves.add(move2, 1, 0);
            fightMoves.add(move3, 0, 1);
            fightMoves.add(move4, 1, 1);

            scene.setRoot(fightMoves);
        }
    }

    /**
     * Class to handle when the user clicks bag
     */
    private class BagEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            if (user.getBag().outOfItems()) {
                msg.setText("No more items remaining");
                return;
            }
            VBox itemsDisplay = new VBox();
            Item[] items = user.getBag().getItems();

            Button item1 = new Button();
            item1.setMinWidth(420);
            item1.setMinHeight(420 / 3);
            if (items[0].getQuantity() > 0) {
                item1.setText(items[0].getName() + " x" + items[0].getQuantity());
                item1.setOnAction(e -> {
                        items[0].use(currentUserPokemon);
                        update(true);
                    }
                );
            } else {
                item1.setText("Out of " + items[0].getName());
            }


            Button item2 = new Button();
            item2.setMinWidth(420);
            item2.setMinHeight(420 / 3);
            if (items[1].getQuantity() > 0) {
                item2.setText(items[1].getName() + " x" + items[1].getQuantity());
                item2.setOnAction(e -> {
                        items[1].use(currentUserPokemon);
                        update(true);
                    }
                );
            } else {
                item2.setText("Out of " + items[1].getName());
            }

            Button item3 = new Button();
            item3.setMinWidth(420);
            item3.setMinHeight(420 / 3);
            if (items[2].getQuantity() > 0) {
                item3.setText(items[2].getName() + " x" + items[2].getQuantity());
                item3.setOnAction(e -> {
                        items[2].use(currentUserPokemon);
                        update(true);
                    }
                );
            } else {
                item3.setText("Out of " + items[2].getName());
            }

            itemsDisplay.getChildren().addAll(item1, item2, item3);

            scene.setRoot(itemsDisplay);
        }
    }

    /**
     * Handles when the User clicks the pokemon button
     */
    private class PokemonEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            swap(true);
        }
    }

    /**
     * creates the swap screen
     * @param attack true if opponent attacks after swap
     */
    private void swap(boolean attack) {
        Pokemon[] p = user.getPokemons();
        GridPane pokemon = new GridPane();
        for (int i = 0; i < p.length; i++) {
            Pokemon t = p[i];
            Button b = new Button();
            b.setMinHeight(420 / 3);
            b.setMinWidth(420);
            if (p[i].getCurrentHP() <= 0) {
                b.setText(t.getName() + " has fainted.");
            } else if (p[i] == currentUserPokemon) {
                b.setText(t.getName() + " is already in use!");
            } else if (p[i].getCurrentHP() > 0) {
                b.setText(t.getName());
                b.setOnAction(event -> {
                        user.swapPokemon(t);
                        currentUserPokemon = user.getCurrPokemon();
                        if (attack) {
                            update(true);
                        } else {
                            update(false);
                        }
                    }
                );
            }
            pokemon.add(b, 0, i);
        }
        scene.setRoot(pokemon);
    }

    /**
     * Updates the screen
     * @param attack true if opponent attacks
     */
    private void update(boolean attack) {

        if (attack) {
            currentUserPokemon.takeDamage(cpu.decideMove(), currentCpuPokemon);
        }

        if (!user.outOfPokemon()) {
            if (currentUserPokemon.getCurrentHP() <= 0) {
                swap(false);
                return;
            }
        } else {
            gameOver("USER");
            return;
        }
        if (!cpu.outOfPokemon()) {
            if (currentCpuPokemon.getCurrentHP() <= 0) {
                cpu.nextPokemon();
                currentCpuPokemon = cpu.getCurrPokemon();
            }
        } else {
            gameOver("CPU");
            return;
        }
        System.out.println("Round " + this.round + ":");
        this.round++;
        userPokemonImage.setImage(currentUserPokemon.getImage());
        userName.setText(String.format("%s, %s Lv%d",
            currentUserPokemon.getName(),
            currentUserPokemon.getType(),
            currentUserPokemon.getLevel())
        );
        userHealth.setProgress(currentUserPokemon.getCurrentHP() / currentUserPokemon.getMaxHP());

        oppPokemonImage.setImage(currentCpuPokemon.getImage());
        oppName.setText(String.format("%s, %s Lv%d",
            currentCpuPokemon.getName(),
            currentCpuPokemon.getType(),
            currentCpuPokemon.getLevel())
        );
        oppHealth.setProgress(currentCpuPokemon.getCurrentHP() / currentCpuPokemon.getMaxHP());

        reset();
    }

    /**
     * Game ending screen that exits the program
     * @param loser USER if the player won the game
     */
    private void gameOver(String loser) {

        System.out.println("Game is over");

        String gameMsg = "";
        if (loser.equals("USER")) {
            gameMsg = "Trainer Kevin has won the battle.";
        } else if (loser.equals("CPU")) {
            gameMsg = "User trainer has won the battle.";
        }

        Text somethin = new Text(gameMsg);
        TextFlow goodbye = new TextFlow(new Text("\n"), somethin);
        goodbye.setMinWidth(420);
        goodbye.setMinHeight(420);
        goodbye.setTextAlignment(TextAlignment.CENTER);
        goodbye.setLineSpacing(180);

        scene.setRoot(new VBox(goodbye));
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> {
                System.exit(0);
            }
        );
        pause.play();
    }

    /**
     * Sets the scene to the master root
     */
    private void reset() {
        scene.setRoot(root);
    }

    /**
     * Handles when the User clicks the Run button
     */
    private class RunEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    }
}