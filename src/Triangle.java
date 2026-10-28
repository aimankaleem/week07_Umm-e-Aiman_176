public class Triangle extends Shape {
    private final Point p1;
    private final Point p2;
    private final Point p3;

    public Triangle(String color, Point p1, Point p2, Point p3) 
            throws GeometricException {
        super(color);
        if (p1 == null || p2 == null || p3 == null) {
            throw new IllegalArgumentException("Vertices cannot be null.");
        }

        double a = p1.distanceTo(p2);
        double b = p2.distanceTo(p3);
        double c = p3.distanceTo(p1);

        // Check if endpoints coincide
        if (a < 1e-9 || b < 1e-9 || c < 1e-9) {
            throw new DegenerateShapeException("Coincident vertices detected: sides cannot be zero.");
        }

        // Triangle Inequality Theorem Guard
        if ((a + b <= c + 1e-9) || (a + c <= b + 1e-9) || (b + c <= a + 1e-9)) {
            throw new DegenerateShapeException("Triangle Inequality Violated: Points are collinear.");
        }

        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
        this.p3 = new Point(p3);
    }

    @Override
    public double calculatePerimeter() {
        return p1.distanceTo(p2) + p2.distanceTo(p3) + p3.distanceTo(p1);
    }

    @Override
    public double calculateArea() {
        double a = p1.distanceTo(p2);
        double b = p2.distanceTo(p3);
        double c = p3.distanceTo(p1);
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String toString() {
        return String.format("Triangle[%s, P1=%s, P2=%s, P3=%s, Area=%.2f]",
                super.toString(), p1, p2, p3, calculateArea());
    }
}