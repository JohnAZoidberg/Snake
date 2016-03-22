import javafx.scene.paint.Color;

public class Dot extends Token{
    public Dot(Board board, Position position, Color color) {
        super(board, position, color);
    }

    public Dot(Board board, Position position) {
        super(board, position, Color.RED);
    }
}
