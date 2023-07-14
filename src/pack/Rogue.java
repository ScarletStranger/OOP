package pack;

import java.util.ArrayList;

public class Rogue extends Units {
    public Rogue(int x, int y) {
        super(150, 150, 4, 7, 10, 4, 1, x, y);
    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        Units tmp1 = findNearest(allies);
        Units tmp2 = findNearest(enemy);
//        System.out.println(tmp1.getInfo() + " расстояние " + coordinates.findDistance(tmp1.coordinates));
//        System.out.println(tmp2.getInfo() + " расстояние " + coordinates.findDistance(tmp2.coordinates));
    }
    @Override
    public String getInfo() {
        return "Разбойник " + this.curHP + " ОЗ из " + this.maxHP + ", Скорость " + this.speed + ", Защита " + this.defence + ", Урон " + this.damage + ", Инициатива " + this.initiative + ", Перезарядка " + this.cooldown;
    }
}
