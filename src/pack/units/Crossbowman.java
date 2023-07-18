package pack.units;

import pack.TeamType;

import java.util.ArrayList;

public class Crossbowman extends Units {
    public int arrowCount = 20;

    public Crossbowman(int x, int y, TeamType teamType) {
        super(100, 100, 4, 50, 4, x, y, teamType);
    }

    @Override
    public void step(ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (curHP <= 0) {
            curHP = 0;
            state = "Dead";
            return;
        }
        if (arrowCount <= 0) {
            state = "Stand";
        } else {
            Units tmp2 = findNearest(enemy);
            state = "Attack";
            arrowCount--;
            tmp2.curHP = tmp2.curHP - (damage - tmp2.defence);
            if (allies.contains(Peasant.class))
                System.out.println("Переход хода");
        }
    }

    @Override
    public String getInfo() {
        return "Арбалетчик " + coordinates.toString() + " " + this.curHP + "/" + this.maxHP + ", стрел " + this.arrowCount + " " + state;
    }
}


