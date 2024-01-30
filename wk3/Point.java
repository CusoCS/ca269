interface Order {
    public boolean lessThan(Order other);
}

public class Point implements Order {
    private double x, y;
    
    public Point(double newX, double newY) {
        x = newX;
        y = newY;
    }
 
    public double getX() {
        return x;
     }
    public double getY() {
        return y;
    }

    public boolean checker(Object object){
        return object instanceof Point;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}