public class InvalidDimensionException extends GeometricException {
    private final double invalidValue;

    public InvalidDimensionException(String dimensionName, double invalidValue) {
        super(String.format("Invalid value for %s: %.2f (must be strictly positive).", dimensionName, invalidValue));
        this.invalidValue = invalidValue;
    }

    public double getInvalidValue() {
        return invalidValue;
    }
}