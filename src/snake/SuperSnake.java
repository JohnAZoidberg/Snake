package snake;

import engine.Board;
import engine.PlayableToken;
import engine.Position;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class SuperSnake extends PlayableToken {
    private SuperSnake(Board board, Position position, Color color) {
        super(board, position, color);
    }

    public SuperSnake(Board board, Position position) {
        super(board, position, Color.DARKGOLDENROD);
    }

    @Override
    public void move(Direction direction) {
        move(direction, 2, false);
        if (((SnakeBoard) getBoard()).removeIntersectingDot(getPosition())) {
            System.out.println("Eaten by SuperSnake");
        }
    }

    @Override
    public void act(ArrayList<Board.Action> actions) {

    }
}
