public class Circle {
    // private instance variables
    private double radius;
    private String color;  // String is a built-in class in Java
    // we make them private to make sure that the data is encapsulated

    // Constructors
    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }
    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Getters and Setters for the private fields
    public double getRadius() {
        return this.radius;
    }
    public String getColor() {
        return this.color;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setColor(String color) {
        this.color = color;
    }

    // Describle itself
    public String toString() {
        return "Circle[radius=" + radius + ",color=" + color + "]";
    }

    // Return the area of this Circle
    public double getArea() {
        return radius * radius * Math.PI;
    }
}


