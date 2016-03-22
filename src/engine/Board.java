package engine;

import java.util.ArrayList;

abstract public class Board {
    private double width;
    private double height;

    public Board(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Dimension getGridSize() {
        return new Dimension(width, height);
    }

    /**
     *
     * @return the tokens which are to be drawn on screen
     */
    abstract public ArrayList<Token> getTokens();

    /**
     * This gets called by the snake.App with a list of currently active keys.
     *
     * @param keys that are currently pushed down.
     */
    abstract public void handleKeys(ArrayList<String> keys);
}
