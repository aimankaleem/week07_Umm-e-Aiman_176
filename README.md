# Week 07: Robust Exception Handling, Custom Hierarchies & Invariant Armor

## Student Information
- **Name:** Umm-e-Aiman
- **Seat Number:** 176
- **Course:** Object-Oriented Programming (Java)

---

## Architecture & Exception Hierarchy

1. **Custom Checked Exception Hierarchy:**
   - **`GeometricException` (extends `Exception`):** Base domain checked exception enforcing compile-time acknowledgment of construction or geometric failures.
   - **`InvalidDimensionException` (extends `GeometricException`):** Captures illegal non-positive measurements while preserving the erroneous value for inspection.

2. **Custom Unchecked Invariant Exception:**
   - **`DegenerateShapeException` (extends `RuntimeException`):** Signals structural invariant violations, such as collinear triangle coordinates failing the Triangle Inequality theorem.

3. **Exception Flow & Resource Cleanup:**
   - Demonstrates polymorphic catch mechanisms (`catch (InvalidDimensionException)` prioritized before `catch (GeometricException)`).
   - Validates unconditional execution of `finally` blocks during failure paths.

---

## Compilation & Execution Guide

```bash
# Compile all source files
javac src/*.java

# Run test driver
java -cp src Main

# Redirect output for assignment verification
java -cp src Main > SampleOutput.txt