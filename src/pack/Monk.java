package pack;

import java.util.ArrayList;
import java.util.Random;

public class Monk extends Units {
    public Monk(int x, int y) {
        super(100, 100, 6, 4, 10, 6, 1, x, y);
    }

    int mana = new Random().nextInt(50, 150);
    int manaCost;

    @Override
    public String getInfo() {
        return "Монах " + this.curHP + " ОЗ из " + this.maxHP + ", Мана " + this.mana + ", Скорость " + this.speed + ", Защита " + this.defence + ", Урон " + this.damage + ", Инициатива " + this.initiative + ", Перезарядка " + this.cooldown;
    }
    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        Units tmp1 = findNearest(allies);
        Units tmp2 = findNearest(enemy);
//        System.out.println(tmp1.getInfo() + " расстояние " + coordinates.findDistance(tmp1.coordinates));
//        System.out.println(tmp2.getInfo() + " расстояние " + coordinates.findDistance(tmp2.coordinates));
    }

}

