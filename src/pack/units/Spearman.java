package pack.units;

import pack.Coordinates;
import pack.TeamType;

import java.util.ArrayList;

public class Spearman extends Units {
    public Spearman(int x, int y, TeamType teamType) {
        super(150, 150, 8, 14, 1, x, y, teamType);
    }

    @Override
    public void move(Coordinates nearest, ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (coordinates.x < nearest.x && isXFree(coordinates.x + 1, enemy, allies)) {
            coordinates.x += 1;
        } else if (isXFree(coordinates.x - 1, enemy, allies)) {
            coordinates.x -= 1;
        }
        else coordinates.y -= 1;
    }

    private boolean isXFree(int targetCoordinate, ArrayList<Units> enemy, ArrayList<Units> allies) {
        ArrayList<Units> all = new ArrayList<>();
        all.addAll(enemy);
        all.addAll(allies);

        for (Units units : all) {
            if (units.coordinates.x == targetCoordinate) {
                if (units.curHP <= 0)
                    return true;
                return false;
            }  else {
                return true;
            }
        }
        return false;
    }

    @Override
    public void step(ArrayList<Units> enemy, ArrayList<Units> allies) {
        Units tmp = findNearest(enemy);
        if (tmp == null)
            return;
        if (curHP <= 0) {
            curHP = 0;
            state = "Dead";
            return;
        }
        if (coordinates.findDistance(tmp.coordinates) <= 1) {
            state = "Attack";
            tmp.curHP = tmp.curHP - (damage - tmp.defence);
            if (tmp.curHP <= 0)
                tmp.curHP = 0;
        } else {
            move(tmp.coordinates, enemy, allies);
            state = "Moving";
        }
    }

    @Override
    public String getInfo() {
        return "Копейщик " + coordinates.toString() + " " + this.curHP + "/" + this.maxHP + " " + state;
    }
}
