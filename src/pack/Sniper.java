package pack;

import java.util.ArrayList;

public class Sniper extends Units {
    public Sniper(int x, int y, TeamType teamType) {
        super(100, 100, 10, 60, 6, x, y, teamType);
    }

    public int arrowCount = 20;

    @Override
    public String getInfo() {
        return "Снайпер " + coordinates.toString() + " " + this.curHP + "/" + this.maxHP + ", стрел " + this.arrowCount + " " + state;
    }

    public int getArrowCount() {
        return arrowCount;
    }

    @Override
    public void step(ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (curHP <= 0) {
            curHP = 0;
            state = "Dead";
        }
        if (arrowCount <= 0)
            state = "Stand";
        else {
            Units tmp2 = findNearest(enemy);
            state = "Attack";
            arrowCount--;
            tmp2.curHP = tmp2.curHP - (damage - tmp2.defence);
            if (allies.contains(Peasant.class))
                return;
        }

    }
}
