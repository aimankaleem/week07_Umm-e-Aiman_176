public abstract class Shape {
    private final String color;

    public Shape(String color) throws GeometricException {
        if (color == null || color.trim().isEmpty()) {
            throw new GeometricException("Shape color cannot be null or empty.");
        }
        this.color = color.trim();
    }

    public String getColor() {
        return color;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    @Override
    public String toString() {
        return String.format("Shape[Color=%s]", color);
    }
}