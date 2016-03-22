import javafx.scene.paint.Color;

public class Head extends PlayableToken {
    private Head(Board board, Position position, Color color) {
        super(board, position, color);
    }

    public Head(Board board, Position position) {
        super(board, position, Color.BLUE);
    }

    public void act(Action action) {
        Dimension grid = getBoard().getGridSize();
        switch (action) {
            case UP:
                if (position.getY() > 0) {
                    position.addPosition(new Position(0, -1));
                }
                break;
            case DOWN:
                if (position.getY() + 1 < grid.getHeight()) {
                    position.addPosition(new Position(0, 1));
                }
                break;
            case LEFT:
                if (position.getX() > 0) {
                    position.addPosition(new Position(-1, 0));
                }
                break;
            case RIGHT:
                if (position.getX() + 1 < grid.getWidth()) {
                    position.addPosition(new Position(1, 0));
                }
                break;
        }
    }
}
