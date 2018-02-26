/*
 * A Cylinder is a Circle plus a height.
 */
public class Cylinder extends Circle {
    // private instance variable
    private double height;
    // it automatically inherits all the data fields in Circle
    // it also inherits the methods in Circle
    // this class only does not inherit private methods and fields.

    // Constructors
    public Cylinder() {
        super();  // invoke superclass' constructor Circle()
        this.height = 1.0;
    }
    public Cylinder(double height) {
        super();  // invoke superclass' constructor Circle()
        this.height = height;
    }
    public Cylinder(double height, double radius) {
        super(radius);  // invoke superclass' constructor Circle(radius)
        this.height = height;
    }
    public Cylinder(double height, double radius, String color) {
        super(radius, color);  // invoke superclass' constructor Circle(radius, color)
        this.height = height;
    }

    // Getter and Setter
    public double getHeight() {
        return this.height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    // Override the getArea() method inherited from superclass Circle
    @Override
    public double getArea() {
        return 2*Math.PI*getRadius()*height + 2*super.getArea();
    }
    // Need to change the getVolume() as well
    public double getVolume() {
        return super.getArea()*height;   // use superclass' getArea() because we need the base area to compute the volume
    }
    // Override the inherited toString()
    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ",height=" + height + "]";
    }
}