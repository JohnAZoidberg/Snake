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
}
