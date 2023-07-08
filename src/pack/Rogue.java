package pack;

import java.util.ArrayList;

public class Rogue extends Units {
    public Rogue(int x, int y) {
        super(150, 150, 4, 7, 10, 4, 1, x, y);
    }

    @Override
    public void move(ArrayList<Units> team1) {
        Units tmp = findNearest(team1);
        System.out.println(tmp.getInfo() + " расстояние " + coordinates.findDistance(tmp.coordinates));
    }

}
