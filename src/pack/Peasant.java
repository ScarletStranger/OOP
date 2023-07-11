package pack;

import java.util.ArrayList;

public class Peasant extends Units {
    public Peasant(int x, int y) {
        super(150, 150, 4, 7, 10, 4, 1, x, y);
    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        Units tmp1 = findNearest(allies);
        Units tmp2 = findNearest(enemy);
        System.out.println(tmp1.getInfo() + " расстояние " + coordinates.findDistance(tmp1.coordinates));
        System.out.println(tmp2.getInfo() + " расстояние " + coordinates.findDistance(tmp2.coordinates));
    }


}
