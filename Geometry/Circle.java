public class Circle {
    private double r;

    public Circle(){
        this.r = 0;
    }
    public Circle(double r) {

        this.r = r;
    }

    double square() {
        return Math.PI * r * r;
    }
}
