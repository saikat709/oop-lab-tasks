public class Circle extends Shape {

    private int radius;
    private int center_x;
    private int center_y;

    public Circle(int radius, int center_x, int center_y) {
        super();
        this.radius = radius;
        this.center_x = center_x;
        this.center_y = center_y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCenter_x() {
        return center_x;
    }

    public void setCenter_x(int center_x) {
        this.center_x = center_x;
    }

    public int getCenter_y() {
        return center_y;
    }

    public void setCenter_y(int center_y) {
        this.center_y = center_y;
    }
}
