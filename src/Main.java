public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   WEEK 7 LAB: ROBUST EXCEPTION HIERARCHIES       ");
        System.out.println("==================================================");

        // 1. Successful Instantiations
        System.out.println("\n[1] Constructing Valid Shapes:");
        try {
            Circle c = new Circle("Blue", new Point(0, 0), 5.0);
            Triangle t = new Triangle("Yellow", new Point(0, 0), new Point(4, 0), new Point(0, 3));
            System.out.println("Success: " + c);
            System.out.println("Success: " + t);
        } catch (GeometricException e) {
            System.err.println("Unexpected failure: " + e.getMessage());
        }

        // 2. Handling Custom Checked Exception (InvalidDimensionException)
        System.out.println("\n[2] Testing Checked Exception (Negative Radius):");
        try {
            System.out.println("Attempting: Circle with radius = -4.0");
            new Circle("Red", new Point(1, 1), -4.0);
        } catch (InvalidDimensionException e) {
            System.out.println("--> Caught InvalidDimensionException!");
            System.out.println("    Message: " + e.getMessage());
            System.out.println("    Offending Value: " + e.getInvalidValue());
        } catch (GeometricException e) {
            System.out.println("--> Caught Generic GeometricException: " + e.getMessage());
        } finally {
            System.out.println("    [Finally Block] Cleanup executed for dimension test.");
        }

        // 3. Handling Custom Unchecked Exception (DegenerateShapeException)
        System.out.println("\n[3] Testing Unchecked Invariant (Collinear Triangle):");
        try {
            System.out.println("Attempting: Collinear points (0,0), (2,2), (4,4)");
            new Triangle("Green", new Point(0, 0), new Point(2, 2), new Point(4, 4));
        } catch (DegenerateShapeException e) {
            System.out.println("--> Caught DegenerateShapeException!");
            System.out.println("    Invariant Violation: " + e.getMessage());
        } catch (GeometricException e) {
            System.out.println("--> Caught Checked Exception: " + e.getMessage());
        }

        // 4. Base Invariant Guard (Null Color)
        System.out.println("\n[4] Testing Base Checked Exception (Empty Color):");
        try {
            new Circle("   ", new Point(0, 0), 2.0);
        } catch (GeometricException e) {
            System.out.println("--> Caught Base GeometricException: " + e.getMessage());
        }
    }
}