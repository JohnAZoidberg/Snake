import javafx.scene.paint.Color;

public class Token {
    protected Position position;
    private Color color;
    private Board board;

    public Token(Board board, Position position, Color color) {
        this.board = board;
        this.position = position;
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public Board getBoard() {
        return board;
    }
}
