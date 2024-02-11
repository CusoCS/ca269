enum Quadrant {
    Q1,
    Q2,
    Q3,
    Q4;
}

interface GridQuadrant {
    Quadrant getQuadrant();
}
interface CompareQuadrant {
    boolean isInSameQuadrant(Point point);
}
interface PointMaker {
    Point makePoint(double x, double y); // returns point with given x, y
    int countPointsCreated(); // returns count of points created via factory
}

class Point implements GridQuadrant, CompareQuadrant {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    @Override
    public Quadrant getQuadrant() {
        if (x == 0 && y == 0) {
            return null;
        } else if (x > 0 && y > 0) {
            return Quadrant.Q1;
        } else if (x < 0 && y > 0) {
            return Quadrant.Q2;
        } else if (x < 0 && y < 0) {
            return Quadrant.Q3;
        } else {
            return Quadrant.Q4;
        }
    }

    @Override
    public boolean isInSameQuadrant(Point point) {
        return this.getQuadrant() == point.getQuadrant();
    }
}

class PointFactory implements PointMaker {
    private int pointsCreatedCount = 0;

    @Override
    public Point makePoint(double x, double y) {
        pointsCreatedCount++;
        return new Point(x, y);
    }

    @Override
    public int countPointsCreated() {
        return pointsCreatedCount;
    }

    public static void main(String[] args) {
        PointFactory pointFactory = new PointFactory();

        Point p1 = pointFactory.makePoint(1, 1);
        Point p2 = pointFactory.makePoint(-1, 1);

        System.out.println(p1.getQuadrant()); // Output: Q1
        System.out.println(p2.getQuadrant()); // Output: Q2

        System.out.println(p1.isInSameQuadrant(new Point(2, 2))); // Output: true
        System.out.println(p1.isInSameQuadrant(new Point(-1, -1))); // Output: false

        System.out.println(p1.getX() == pointFactory.makePoint(1, 1).getX()); // Output: true
        System.out.println(pointFactory.countPointsCreated()); // Output: 3 ^ because just used function to make 1 more
    }
}