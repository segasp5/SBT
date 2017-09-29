public class Rect {
    private double a;
    private double b;

    public Rect() {
        a = b = 0;
    }

    public Rect(double a) {
        this.a = this.b = a;
    }

    public Rect(double a, double b) {
        this.a = a;
        this.b = b;
    }

    double area() {
        return a * b * Math.PI;
    }
}