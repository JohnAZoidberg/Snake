package snake;

import engine.*;

import java.util.ArrayList;

public class SnakeBoard extends Board {
    private Snake head;
    private SuperSnake supersnake;
    private ArrayList<Dot> dots = new ArrayList<>();

    public SnakeBoard(double width, double height) {
        super(width, height);

        head = new Snake(this, new Position(1, 1));
        supersnake = new SuperSnake(this, new Position(2, 2));
        dots.add(new Dot(this, new Position(1, 2)));

        addToken(head);
        addToken(supersnake);
        addTokens(dots);
    }

    public boolean removeIntersectingDot(Position pos) {
        for (Dot dot : dots) {
            if (pos.equals(dot.getPosition())) {
                dots.remove(dot);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Token> getTokens() {
        ArrayList<Token> t = new ArrayList<>(2);
        t.addAll(dots);
        addCompleteSnake(t, head);
        t.add(supersnake);
        return t;
    }

    private ArrayList<? super Snake> addCompleteSnake(ArrayList<? super Snake> list, Snake head) {
        if (head.getTail() == null) {
            return list;
        } else {
            list.add(head);
            return addCompleteSnake(list, head.getTail());
        }
    }
}
