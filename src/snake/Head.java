package snake;

import engine.Action;
import engine.Board;
import engine.PlayableToken;
import engine.Position;
import javafx.scene.paint.Color;

public class Head extends PlayableToken {
    private Head(Board board, Position position, Color color) {
        super(board, position, color);
    }

    public Head(Board board, Position position) {
        super(board, position, Color.BLUE);
    }

    public void act(Action action) {
        move(action, 1, false);
    }
}
