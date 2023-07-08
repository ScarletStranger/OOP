package pack;

import java.util.ArrayList;

public class Crossbowman extends Units {
    public int boltCount;

    public Crossbowman(int x, int y) {
        super(100, 100, 6, 4, 10, 6, 1, x, y);
    }

    @Override
    public void move(ArrayList<Units> team1) {
        Units tmp = findNearest(team1);
        System.out.println(tmp.getInfo() + " расстояние " + coordinates.findDistance(tmp.coordinates));
    }
}


