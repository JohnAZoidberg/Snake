import javafx.scene.paint.Color;

abstract public class PlayableToken extends Token {

    public PlayableToken(Board board, Position position, Color color) {
        super(board, position, color);
    }

    /**
     *
     * @param action to be performed.
     */
    abstract public void act(Action action);

    // TODO actually loop when loop == true
    // TODO instead of moving off the board

    // TODO check if were off the board by calculation the new location
    // TODO otherwise it only works if we move by one square
    public void move(Action action, int distance, boolean loop) {
        Dimension grid = getBoard().getGridSize();
        switch (action) {
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
}
