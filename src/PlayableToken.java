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
}
