public class Circle extends Shape {
    public Circle(double diameter) {
        super(diameter, diameter);
    }

    public double getArea() {
        double radius = width / 2;
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return width * Math.PI;
    }
}