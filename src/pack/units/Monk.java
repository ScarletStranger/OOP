package pack.units;

import pack.Coordinates;
import pack.TeamType;

import java.util.ArrayList;
import java.util.Random;

public class Monk extends Units {
    int mana = new Random().nextInt(10, 21);

    public Monk(int x, int y, TeamType teamType) {
        super(100, 100, 3, 12, 3, x, y, teamType);
    }

    @Override
    public String getInfo() {
        return "Монах " + coordinates.toString() + " " + this.curHP + "/" + this.maxHP + ", Мана " + this.mana + " " + state;
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
        double minHealth = 1;
        if (mana > 0) {
            for (Units unit : allies) {
                if (unit.curHP / maxHP < minHealth && unit.curHP != 0) {
                    state = "Healing";
                    mana--;
                    unit.curHP += -damage;
                    minHealth = unit.curHP / unit.maxHP;
                }
            }
        }
        if (mana < 0) {
            mana += 1;
            state = "Busy";
        }
    }
}


