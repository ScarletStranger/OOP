package pack.units;

import pack.TeamType;

import java.util.ArrayList;

public class Rogue extends Units {
    public Rogue(int x, int y, TeamType teamType) {
        super(150, 150, 10, 40, 7, x, y, teamType);
    }

    @Override
    public void step(ArrayList<Units> enemy, ArrayList<Units> allies) {
        Units tmp = findNearest(enemy);
        if (curHP <= 0) {
            curHP = 0;
            state = "Dead";
            return;
        }
        if (coordinates.findDistance(tmp.coordinates) <= 1) {
            state = "Attack";
            tmp.curHP = tmp.curHP - (damage - tmp.defence);
        } else {
            move(tmp.coordinates, allies);
            state = "Moving";
        }
    }

    @Override
    public String getInfo() {
        return "Разбойник " + coordinates.toString() + " " + this.curHP + "/" + this.maxHP + " " + state;
    }
}
