package pack;

import java.util.ArrayList;
import java.util.Random;

public class Monk extends Units {
    public Monk(int x, int y) {
        super(100, 100, 3, 5, 3, x, y);
    }
    int mana = new Random().nextInt(10, 21);
    @Override
    public String getInfo() {
        return "Монах " + this.curHP + " ОЗ из " + this.maxHP + ", Мана " + this.mana + ", Защита " + this.defence + ", Урон " + this.damage + ", Инициатива " + this.initiative + ", Перезарядка ";
    }
    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (curHP > 0 && mana > 0) {
            for (Units unit:allies) {
                if (unit.curHP < maxHP){
                    mana--;
                    curHP += damage;
                }
            }
        } else if (curHP > 0 && mana < 0) {
            System.out.println("Недостаточно маны");
        } else {
            curHP = 0;
            System.out.println("Монах умер");
        }
    }

}

