package pack.units;

import pack.TeamType;

import java.util.ArrayList;

public class Peasant extends Units {
    public Peasant(int x, int y, TeamType teamType) {
        super(120, 120, 1, 1, 2, x, y, teamType);
    }

    @Override
    public String getInfo() {
        return "Крестьянин " + coordinates.toString() + " " + this.curHP + "/" + this.maxHP + " " + state;
    }

    @Override
    public void step(ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (curHP <= 0) {
            curHP = 0;
            state = "Dead";
        } else {
            state = "Busy";
            for (Units unit : allies) {
                if (unit instanceof Sniper) {
                    ((Sniper) unit).arrowCount++;
                    break;
                }
                if (unit instanceof Crossbowman) {
                    ((Crossbowman) unit).arrowCount++;
                }
            }
        }
    }
}
