package engine;

abstract public class Tuple<T> {
    protected T left;
    protected T right;

    public Tuple(T left, T right) {
        this.left = left;
        this.right = right;
    }
}
