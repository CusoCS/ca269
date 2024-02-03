public class Point implements Comparable {
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

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    private boolean checkType(Object object) {
        return object instanceof Point;
    }

    public boolean equals(Point point) {
        if (this.x == point.x && this.y == point.y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lessThan(Point other) {
        if (this.equals(other)) {
            return false;
        } else if (x > other.getX()) {
            return false;
        } else if (y > other.getY()) {
            return false;
        } 
        return true;
    }

    public boolean lessThan(Order other) {
        if (!checkType(other)) {
            // raise error in ideal case ... but for now ...
            return false;
        }
        return lessThan((Point) other);
    }

    public int compareTo(Object other) {
        if (!checkType(other)) {
            // raise error in ideal case ... but for now ...
            return 0;
        }
        Point object = (Point) other;
        if (lessThan(object)) {
            return -1;
        }
        if (object.lessThan(this)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Order O1 = new Point(0, 0);
        Order O2 = new Point(1, 1);
        Order O3 = new Point(0, 1);

        System.out.println("O1 less than O2: " + O1.lessThan(O2)); // true
        System.out.println("O1 less than O3: " + O1.lessThan(O3)); // true
        System.out.println("O2 less than O3: " + O2.lessThan(O3)); // false
        System.out.println("O3 less than O3: " + O3.lessThan(O3)); // false

        Comparable C1 = new Point(0, 0);
        Comparable C2 = new Point(1, 1);
        Comparable C3 = new Point(0, 1);

        System.out.println("C1 less than C2: " + C1.compareTo(C2)); // -1
        System.out.println("C1 less than C3: " + C1.compareTo(C3)); // -1
        System.out.println("C2 less than C3: " + C2.compareTo(C3)); // 1
        System.out.println("C3 less than C3: " + C3.compareTo(C3)); // 0
    }
}