package pack;

import java.util.ArrayList;
import java.util.Random;

public class Mage extends Units {
    public Mage(int x, int y, TeamType teamType) {
        super(100, 100, 3, 60, 5, x, y, teamType);
    }

    int mana = new Random().nextInt(10, 21);

    @Override
    public String getInfo() {
        return "Волшебник " + coordinates.toString() + " " + this.curHP + "/" + this.maxHP + ", Мана " + this.mana + " " + state;
    }

    @Override
    public void step(ArrayList<Units> enemy, ArrayList<Units> allies) {
        Units tmp2 = findNearest(enemy);
        if (curHP > 0 && mana > 0) {
            state = "Attack";
            mana--;
            tmp2.curHP = tmp2.curHP - (damage - tmp2.defence);
        } else if (curHP > 0 && mana < 0) {
            System.out.println("Недостаточно маны");
        } else {
            curHP = 0;
            state = "Dead";
        }
    }
}



