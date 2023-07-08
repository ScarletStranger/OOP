package pack;

import java.util.ArrayList;

public class Sniper extends Units {
    public Sniper(int x, int y) {
        super(100, 100, 6, 4, 10, 6, 1, x, y);
    }

    private int arrowCount;

    @Override
    public void move(ArrayList<Units> team1) {
        Units tmp = findNearest(team1);
        System.out.println(tmp.getInfo() + " расстояние " + coordinates.findDistance(tmp.coordinates));
    }
}
