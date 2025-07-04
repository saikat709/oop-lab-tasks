
public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Shape();
        Shape shape2 = new Shape("blue", false);

        shape1.setFilled(false);
        shape1.setColor("red");

        System.out.println("Shape 1 color: " +  shape1.getColor());
        System.out.println("Shape 2 color: " +  shape2.getColor());

        System.out.println("Shape 1 is filled: " + String.valueOf(shape1.isFilled()));
        System.out.println("Shape 2 is filled: " + String.valueOf(shape2.isFilled()));

        System.out.println(shape1.toString());
        System.out.println(shape2.toString());

    }
}