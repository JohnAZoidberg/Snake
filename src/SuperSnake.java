import javafx.scene.paint.Color;

public class SuperSnake extends Token implements Playable {
    private SuperSnake(Board board, Position position, Color color) {
        super(board, position, color);
    }

    public SuperSnake(Board board, Position position) {
        super(board, position, Color.DARKGOLDENROD);
    }

    public void move(Action action) {
        Dimension grid = getBoard().getGridSize();
        switch (action) {
            case UP:
                if (position.getY() > 0) {
                    position.addPosition(new Position(0, -2));
                }
                break;
            case DOWN:
                if (position.getY() + 1 < grid.getHeight()) {
                    position.addPosition(new Position(0, 2));
                }
                break;
            case LEFT:
                if (position.getX() > 0) {
                    position.addPosition(new Position(-2, 0));
                }
                break;
            case RIGHT:
                if (position.getX() + 1 < grid.getWidth()) {
                    position.addPosition(new Position(2, 0));
                }
                break;
        }
    }
}
