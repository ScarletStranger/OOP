package pack;

import java.util.ArrayList;
import java.util.Random;

public class Mage extends Units {
    public Mage(int x, int y) {
        super(100, 100, 6, 4, 10, 6, 1, x, y);
    }

    int mana = new Random().nextInt(50, 101);

    @Override
    public String getInfo() {
        return "Маг " + this.curHP + " ОЗ из " + this.maxHP + ", Мана " + this.mana + ", Скорость " + this.speed + ", Защита " + this.defence + ", Урон " + this.damage + ", Инициатива " + this.initiative + ", Перезарядка " + this.cooldown;
    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        Units tmp1 = findNearest(allies);
        Units tmp2 = findNearest(enemy);
//        System.out.println(tmp1.getInfo() + " расстояние " + coordinates.findDistance(tmp1.coordinates));
//        System.out.println(tmp2.getInfo() + " расстояние " + coordinates.findDistance(tmp2.coordinates));
        if (curHP > 0 && mana > 0) {
            mana--;
            tmp2.curHP = tmp2.curHP - (damage + tmp2.defence);
//            System.out.println(tmp2.getInfo());
        } else if (curHP > 0 && mana < 0) {
            System.out.println("Недостаточно маны");;
        } else {
            curHP = 0;
            for (Units unit : allies) {
                if (unit instanceof Mage == true) {
                    System.out.println("Маг умер");
                    return;
                }
            }
        }
    }
}

