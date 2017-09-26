package engine;

public class Position extends Tuple<Double> {
    public Position(double x, double y) {
        super(x, y);
    }

    public double getX() {
        return left;
    }

    public double getY() {
        return right;
    }

    public void setNewPosition(Position newPos) {
        this.left = newPos.getX();
        this.right = newPos.getY();
    }

    public void addPosition(Position newPos) {
        this.left += newPos.getX();
        this.right += newPos.getY();
    }

    public boolean equals(Position pos) {
        return getX() == pos.getX() && getY() == pos.getY();
    }

    @Override
    public String toString() {
      return String.format("(%f, %f)", left, right);
    }
}
