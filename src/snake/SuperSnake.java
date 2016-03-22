package snake;

import engine.Action;
import engine.Board;
import engine.PlayableToken;
import engine.Position;
import javafx.scene.paint.Color;

public class SuperSnake extends PlayableToken {
    private SuperSnake(Board board, Position position, Color color) {
        super(board, position, color);
    }

    public SuperSnake(Board board, Position position) {
        super(board, position, Color.DARKGOLDENROD);
    }

    public void act(Action action) {
        move(action, 2, false);
    }
}
