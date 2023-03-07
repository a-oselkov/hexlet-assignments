package exercise;

// BEGIN
public class Flat implements Home{
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }
    public double getLivingArea() {
        return area;
    }
    public double getBalconyArea() {
        return balconyArea;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public double getArea() {
        return this.getLivingArea() + this.getBalconyArea();
    }

    @Override
    public int compareTo(Home another) {
        if (this.getArea() > another.getArea()) {
            return 1;
        } else if (this.getArea() < another.getArea()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + floor + " этаже";
    }
}
// END
