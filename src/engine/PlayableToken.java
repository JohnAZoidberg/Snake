package engine;

import javafx.scene.paint.Color;

import java.util.ArrayList;

abstract public class PlayableToken extends Token {
    public enum Direction {
        UP, DOWN, LEFT, RIGHT, STILL
    }

    private Direction direction = Direction.STILL;

    public PlayableToken(Board board, Position position, Color color) {
        super(board, position, color);
    }


    public void setDirection(Direction d) {
        direction = d;
    }

    public Direction getDirection() {
        return direction;
    }

    // TODO actually loop when loop == true
    // TODO instead of moving off the board

    // TODO check if were off the board by calculation the new location
    // TODO otherwise it only works if we move by one square
    protected void move(Direction direction, int distance, boolean loop) {
        Dimension grid = getBoard().getGridSize();
        setDirection(direction);
        switch (direction) {
            case UP:
                if (loop || position.getY() > 0) {
                    position.addPosition(new Position(0, -distance));
                }
                break;
            case DOWN:
                if (loop || position.getY() + 1 < grid.getHeight()) {
                    position.addPosition(new Position(0, distance));
                }
                break;
            case LEFT:
                if (loop ||position.getX() > 0) {
                    position.addPosition(new Position(-distance, 0));
                }
                break;
            case RIGHT:
                if (loop || position.getX() + 1 < grid.getWidth()) {
                    position.addPosition(new Position(distance, 0));
                }
                break;
        }
    }

    protected void move(Direction direction) {
        move(direction, 1, false); // Standard behaviour is to move one square and not loop
    }

    protected void move(int distance, boolean loop) {
      move(getDirection(), distance, loop);
    }

    abstract public void act(ArrayList<Board.Action> actions);
}
