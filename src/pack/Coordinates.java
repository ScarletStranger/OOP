package pack;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int findDistance(Coordinates coordinates) {
        int dx = coordinates.x - x;
        int dy = coordinates.y - y;
        return (int) Math.sqrt((dx*dx) + (dy*dy));
    }

    @Override
    public String toString() {
        return "x = " + x + " y = " + y;
    }
}
