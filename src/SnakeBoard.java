import java.util.ArrayList;

public class SnakeBoard extends Board {
    private Head head;
    private SuperSnake supersnake;
    private ArrayList<Dot> dots = new ArrayList<>();

    public SnakeBoard(double width, double height) {
        super(width, height);

        head = new Head(this, new Position(1, 1));
        supersnake = new SuperSnake(this, new Position(2, 2));
        dots.add(new Dot(this, new Position(1, 2)));
    }

    @Override
    public void handleKeys(ArrayList<String> keys) {
        Action action = Action.NOTHING;
        if (keys.contains("LEFT")) {
            action = Action.LEFT;
        } else if (keys.contains("RIGHT")) {
            action = Action.RIGHT;
        } else if (keys.contains("UP")) {
            action = Action.UP;
        } else if (keys.contains("DOWN")) {
            action = Action.DOWN;
        } else if (keys.contains("SPACE")) {
            action = Action.SPACE;
        }

        head.move(action);
        supersnake.move(action);
        keys.clear();
    }

    @Override
    public ArrayList<Token> getTokens() {
        ArrayList<Token> t = new ArrayList<>(2);
        t.addAll(dots);
        t.add(head);
        t.add(supersnake);
        return t;
    }
}
