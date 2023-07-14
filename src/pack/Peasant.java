package pack;

import java.util.ArrayList;

public class Peasant extends Units {
    public Peasant(int x, int y) {
        super(150, 150, 4, 7, 10, 1, 1, x, y);
    }


    @Override
    public String getInfo() {
        return "Крестьянин " + this.curHP + " ОЗ из " + this.maxHP + ", Скорость " + this.speed + ", Защита " + this.defence + ", Урон " + this.damage + ", Инициатива " + this.initiative + ", Перезарядка " + this.cooldown;
    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        Units tmp1 = findNearest(allies);
        Units tmp2 = findNearest(enemy);
//        System.out.println(tmp1.getInfo() + " расстояние " + coordinates.findDistance(tmp1.coordinates));
//        System.out.println(tmp2.getInfo() + " расстояние " + coordinates.findDistance(tmp2.coordinates));
        if (tmp2.curHP <= 0){
            tmp2.curHP = 0;
            System.out.println(tmp2.getClass()+" убит");
        } else {
            for (Units unit: allies) {
                if (unit instanceof Peasant && unit.state == "Stand"){

                }
            }
        }
    }


}
