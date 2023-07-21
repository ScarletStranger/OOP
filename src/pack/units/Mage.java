package pack.units;

import pack.Coordinates;
import pack.TeamType;

import java.util.ArrayList;
import java.util.Random;

public class Mage extends Units {
    int mana = new Random().nextInt(10, 21);

    public Mage(int x, int y, TeamType teamType) {
        super(100, 100, 3, 16, 5, x, y, teamType);
    }

    @Override
    public String getInfo() {
        return "Волшебник " + coordinates.toString() + " " + this.curHP + "/" + this.maxHP + ", Мана " + this.mana + " " + state;
    }



    @Override
    public void move(Coordinates nearest, ArrayList<Units> enemy, ArrayList<Units> allies) {

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
        if (mana > 0) {
            state = "Attack";
            mana--;
            tmp.curHP = tmp.curHP - (damage - tmp.defence);
            if (tmp.curHP <= 0) {
                tmp.curHP = 0;
                return;
            }
        }
        if (mana <= 0) {
            mana += 1;
            state = "Busy";
        }
    }
}



