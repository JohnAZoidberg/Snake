package snake;

import engine.Board;
import engine.PlayableToken;
import engine.Position;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Snake extends PlayableToken {
    private Snake tail = null;

    private Snake(Board board, Position position, Color color) {
        super(board, position, color);
    }

    public Snake(Board board, Position position) {
        super(board, position, Color.BLUE);
    }

    @Override
    public void act(ArrayList<Board.Action> actions) {
        // if (actions.size() == 1 && actions.get(0) == Board.Action.TOCK) {
        //   move(1, true);
        // }
        for (Board.Action action : actions) {
            switch (action) {
                case UP:
                    move(Direction.UP);
                    break;
                case DOWN:
                    move(Direction.DOWN);
                    break;
                case LEFT:
                    move(Direction.LEFT);
                    break;
                case RIGHT:
                    move(Direction.RIGHT);
                    break;
                case Board.Action.TOCK:
                    move(Direction.RIGHT);
                    break;
            }
        }
    }

    @Override
    protected void move(Direction direction) {
        move(direction, 1, false); // equal to 'super(direction);'
        if (((SnakeBoard) getBoard()).removeIntersectingDot(getPosition())) {
            System.out.println("eaten");
            addTail();
        }
    }

    private void addTail() {
        if (tail == null) {
            tail = new Snake(getBoard(), position);
        } else {
            tail.addTail();
        }
    }

    public Snake getTail() {
        return tail;
    }
}
