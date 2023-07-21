package pack.units;

import pack.Coordinates;
import pack.TeamType;

import java.util.ArrayList;

public class Crossbowman extends Units {
    public int arrowCount = 10;

    public Crossbowman(int x, int y, TeamType teamType) {
        super(100, 100, 4, 15, 4, x, y, teamType);
    }
    @Override
    public void move(Coordinates nearest, ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (coordinates.x < nearest.x && isCoordinateFree(coordinates.x + 1, enemy, allies)) {
            coordinates.x += 1;
        } else if (isCoordinateFree(coordinates.x - 1, enemy, allies)) {
            coordinates.x -= 1;
        }
        else coordinates.y -= 1;
    }

    private boolean isCoordinateFree(int targetCoordinateX, ArrayList<Units> enemy, ArrayList<Units> allies) {
        ArrayList<Units> all = new ArrayList<>();
        all.addAll(enemy);
        all.addAll(allies);
        for (Units units : all) {
            if (units.curHP <= 0)
                return true;
            if (units.coordinates.x == targetCoordinateX) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public void step(ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (curHP <= 0) {
            curHP = 0;
            state = "Dead";
            return;
        }
        if (arrowCount <= 0) {
            Units tmp = findNearest(enemy);
            if (tmp == null)
                return;
            if (coordinates.findDistance(tmp.coordinates) <= 1) {
                state = "Attack";
                tmp.curHP = tmp.curHP - ((damage/2) - tmp.defence);
                if (tmp.curHP <= 0)
                    tmp.curHP = 0;
            } else {
                move(tmp.coordinates, enemy, allies);
                state = "Moving";
            }
        } else {
            Units tmp = findNearest(enemy);
            if (tmp == null)
                return;
            state = "Attack";
            arrowCount--;
            tmp.curHP = tmp.curHP - (damage - tmp.defence);
            if (tmp.curHP <= 0)
                tmp.curHP = 0;
            if (allies.contains(Peasant.class))
                System.out.println("Переход хода");
        }
    }

    @Override
    public String getInfo() {
        return "Арбалетчик " + coordinates.toString() + " " + this.curHP + "/" + this.maxHP + ", стрел " + this.arrowCount + " " + state;
    }
}



