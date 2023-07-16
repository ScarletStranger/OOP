package pack;

import java.util.ArrayList;

public class Peasant extends Units {
    public Peasant(int x, int y) {
        super(120, 120, 1, 1, 2, x, y);
    }
    @Override
    public String getInfo() {
        return "Крестьянин " + this.curHP + " ОЗ из " + this.maxHP + ", Защита " + this.defence + ", Урон " + this.damage + ", Инициатива " + this.initiative;
    }
    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (curHP <= 0) {
            curHP = 0;
            System.out.println("Крестьянин убит");
        } else {
            for (Units unit : allies) {
            }
        }
    }
}
