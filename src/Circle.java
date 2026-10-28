public class Circle extends Shape {
    private final Point center;
    private final double radius;

    public Circle(String color, Point center, double radius) 
            throws GeometricException {
        super(color);
        if (center == null) {
            throw new IllegalArgumentException("Center point cannot be null.");
        }
        if (radius <= 0.0) {
            throw new InvalidDimensionException("radius", radius);
        }
        this.center = new Point(center);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public Point getCenter() { return new Point(center); }
    public double getRadius() { return radius; }

    @Override
    public String toString() {
        return String.format("Circle[%s, Center=%s, Radius=%.2f, Area=%.2f]",
                super.toString(), center, radius, calculateArea());
    }
}