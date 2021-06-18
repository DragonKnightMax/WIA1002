package Lab.L2.Q5;

public class Circle implements Comparable<Circle> {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Radius of circle: " + radius;
    }

    @Override
    public int compareTo(Circle o) {
        return Double.compare(radius, o.getRadius());
    }
}
