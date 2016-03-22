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

    abstract public ArrayList<Token> getTokens();

    abstract public void handleKeys(ArrayList<String> keys);
}
