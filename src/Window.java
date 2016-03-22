import java.awt.*;

public class Window {
    private static final int PIXEL_RATIO = 10;
    private String title;
    private Dimension dimension;

    public Window(String title, Dimension dimension) {
        this.title = title;
        this.dimension = dimension;
    }

    public Dimension getGrid() {
        return new Dimension(dimension.width / PIXEL_RATIO, dimension.height / PIXEL_RATIO);
    }

    public String getTitle() {
        return title;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
