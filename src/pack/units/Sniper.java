package pack.units;

import pack.Coordinates;
import pack.TeamType;

import java.util.ArrayList;

public class Sniper extends Units {
    public int arrowCount = 20;

    public Sniper(int x, int y, TeamType teamType) {
        super(100, 100, 5, 16, 6, x, y, teamType);
    }

    @Override
    public String getInfo() {
        return "Снайпер " + coordinates.toString() + " " + this.curHP + "/" + this.maxHP + ", стрел " + this.arrowCount + " " + state;
    }


    @Override
    public void move(Coordinates nearest, ArrayList<Units> enemy, ArrayList<Units> allies) {
    }

    @Override
    public void step(ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (curHP <= 0) {
            curHP = 0;
            state = "Dead";
            return;
        }
        if (arrowCount <= 0)
            state = "Stand";
        else {
            Units tmp = findNearest(enemy);
            if (tmp==null)
                return;
            state = "Attack";
            arrowCount--;
            tmp.curHP = tmp.curHP - (damage - tmp.defence);
            if (tmp.curHP <= 0)
                tmp.curHP = 0;
            if (allies.contains(Peasant.class))
                return;
        }
    }
}
