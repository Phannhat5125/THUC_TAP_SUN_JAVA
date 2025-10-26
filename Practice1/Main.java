public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 15);
        Circle circle = new Circle(4);

        System.out.println("Rectangle Area: " + rect.getArea());
        System.out.println("Rectangle Perimeter: " + rect.getPerimeter());

        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Circle Circumference: " + circle.getCircumference());
    }
}