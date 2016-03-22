import java.util.ArrayList;

abstract public class Board {
    private double width;
    private double height;
    protected ArrayList<Token> tokens = new ArrayList<>();

    public Board(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Dimension getGridSize() {
        return new Dimension(width, height);
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    abstract public void handleKeys(ArrayList<String> keys);
}
