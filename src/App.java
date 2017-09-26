import engine.Board;
import engine.Dimension;
import engine.Position;
import engine.Token;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import snake.SnakeBoard;

import java.util.ArrayList;

public class App extends Application {
    private static final double RES = 50.0;
    private Stage primaryStage;
    private ArrayList<String> input = new ArrayList<>();

    int time = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        drawBoard(new SnakeBoard(10, 10));
    }

    private void drawBoard(Board board) {
        String title = "Snake Game";
        primaryStage.setTitle(title);
        Group root = new Group();
        Dimension dim = board.getGridSize();
        Canvas canvas = new Canvas(dim.getWidth() * RES, dim.getHeight() * RES);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        setScene(root);

        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                time++;
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                ArrayList<Board.Action> actions = new ArrayList<>();
                actions.add(Board.Action.TOCK);
                for (String key : input) {
                    switch (key) {
                      case "K":
                      case "UP":
                          actions.add(Board.Action.UP);
                          break;
                      case "J":
                      case "DOWN":
                          actions.add(Board.Action.DOWN);
                          break;
                      case "H":
                      case "LEFT":
                          actions.add(Board.Action.LEFT);
                          break;
                      case "L":
                      case "RIGHT":
                          actions.add(Board.Action.RIGHT);
                          break;
                    }
                }
                if (time % 10 == 0)
                  board.step(actions);
                drawBoard(gc, board, dim.getWidth(), dim.getHeight());
                drawTokens(gc, board);
                // System.out.println(time + " - " + time % 60 + ": " + t);
            }
        }.start();

        primaryStage.show();
    }

    private void setScene(Group root) {
        Scene theScene = new Scene(root);
        theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e){
                String code = e.getCode().toString();
                System.out.println("Key pressed: " + code);

                // only add once... prevent duplicates
                if (!input.contains(code))
                    input.add(code);
            }
        });

        theScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                input.remove(code);
            }
        });
        primaryStage.setScene(theScene);
    }

    private void drawBoard(GraphicsContext gc, Board b, double width, double height) {
        gc.clearRect(0, 0, width * RES, height * RES);
        gc.setStroke(Color.RED);
        gc.setLineWidth(1);
        Dimension grid = b.getGridSize();
        // vertical lines
        for (int i = 0; i <= grid.getWidth(); i++) {
            gc.strokeLine(i * RES, 0,
                    i * RES, height * RES);
        }
        // horizontal lines
        for (int i = 0; i <= grid.getHeight(); i++) {
            gc.strokeLine(0, i * RES,
                    width * RES, i * RES);
        }
    }

    private void drawTokens(GraphicsContext gc, Board board) {
        ArrayList<Token> tokens = board.getTokens();
        for (Token token : tokens) {
            Position pos = token.getPosition();
            Color color = token.getColor();
            // System.out.print(color + ": (" + pos.getX() + ", " + pos.getY() + ")");

            gc.setFill(color);
            gc.setStroke(color);
            gc.fillOval(
                    (pos.getX() * RES) + RES * 0.25,
                    (pos.getY() * RES) + RES * 0.25,
                    RES * 0.5, RES * 0.5
            );
        }
        // System.out.println();
    }
}
