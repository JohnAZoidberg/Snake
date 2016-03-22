import java.util.ArrayList;

public class SnakeBoard extends Board {
    private Head head;

    public SnakeBoard(double width, double height) {
        super(width, height);
        head = new Head(this, new Position(1, 1));


        tokens.add(new Dot(this, new Position(1, 2)));
    }

    @Override
    public void handleKeys(ArrayList<String> keys) {
        if (keys.contains("LEFT")) {
            head.move(Head.Direction.LEFT);
        } else if (keys.contains("RIGHT")) {
            head.move(Head.Direction.RIGHT);
        } else if (keys.contains("UP")) {
            head.move(Head.Direction.UP);
        } else if (keys.contains("DOWN")) {
            head.move(Head.Direction.DOWN);
        }
        keys.clear();
    }

    @Override
    public ArrayList<Token> getTokens() {
        ArrayList<Token> t = super.getTokens();
        t.add(head);
        return t;
    }
}
