package pack;

import java.util.ArrayList;
import java.util.Random;

public class Mage extends Units {
    public Mage(int x, int y) {
        super(100, 100, 6, 4, 10, 6, 1, x, y);
    }

    int mana = new Random().nextInt(50, 150);
    int manaCost;

    @Override
    public String getInfo() {
        return this.getClass() + " " + this.curHP + " ОЗ из " + this.maxHP + ", Мана " + this.mana + ", Скорость " + this.speed + ", Защита " + this.defence + ", Урон " + this.damage + ", Инициатива " + this.initiative + ", Перезарядка " + this.cooldown;
    }
    @Override
    public void move(ArrayList<Units> team1) {
        Units tmp = findNearest(team1);
        System.out.println(tmp.getInfo() +" расстояние "+coordinates.findDistance(tmp.coordinates));
    }
}

