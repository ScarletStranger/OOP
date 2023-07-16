package pack;

import java.util.ArrayList;
import java.util.Random;

public class Mage extends Units {
    public Mage(int x, int y) {
        super(100, 100, 3, 6, 5, x, y);
    }

    int mana = new Random().nextInt(10, 21);

    @Override
    public String getInfo() {
        return "Маг " + this.curHP + " ОЗ из " + this.maxHP + ", Мана " + this.mana + ", Защита " + this.defence + ", Урон " + this.damage + ", Инициатива " + this.initiative;
    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        Units tmp2 = findNearest(enemy);
        if (curHP > 0 && mana > 0) {
            mana--;
            tmp2.curHP = tmp2.curHP - (damage + tmp2.defence);
        } else if (curHP > 0 && mana < 0) {
            System.out.println("Недостаточно маны");
        } else {
            curHP = 0;
            System.out.println("Маг умер");
        }
    }
}



