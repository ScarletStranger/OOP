package pack;

import java.util.ArrayList;
import java.util.Objects;

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
        return (int) Math.sqrt((dx * dx) + (dy * dy));
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }

    public boolean containsByPosition(Coordinates nextPosition, ArrayList<Units> allies) {
        for (Units unit : allies) {
            if (unit.coordinates.equals(nextPosition))
                return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
