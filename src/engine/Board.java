package engine;

import java.util.ArrayList;

abstract public class Board {
    public enum Action {
        UP, DOWN, LEFT, RIGHT, TOCK
    }

    private final double width;
    private final double height;

    private final ArrayList<Token> tokens = new ArrayList<>();

    public Board(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Dimension getGridSize() {
        return new Dimension(width, height);
    }

    /**
     *
     * @return all the tokens which are to be drawn on screen
     */
    public ArrayList<Token> getTokens() {
        return tokens;
    }

    protected void addToken(Token token) {
        tokens.add(token);
    }

    protected void addTokens(ArrayList<? extends Token> tokens) {
        this.tokens.addAll(tokens);
    }

    /**
     * This gets called by the App to notify that
     * the next step is around and things should change.
     * A a list of currently active {@link Action}s is provided.
     *
     * @param actions that are currently pushed down.
     */
    public void step(ArrayList<Action> actions) {
        for (Token token : tokens) {
            if (token instanceof PlayableToken) {
                ((PlayableToken) token).act(actions);
            }
        }
    }

    // TODO not yet necessary
    private ArrayList<? extends Token> getTokensAt(Position pos) {
        ArrayList<Token> tokens = new ArrayList<>();
        for (Token token : getTokens()) {
            if (token.getPosition().equals(pos)) {
                tokens.add(token);
            }
        }
        return tokens;
    }
}
