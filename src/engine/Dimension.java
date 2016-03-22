package engine;

public class Dimension extends Tuple<Double> {
    public Dimension(double width, double height) {
        super(width, height);
    }

    public double getWidth() {
        return left;
    }

    public double getHeight() {
        return right;
    }
}
