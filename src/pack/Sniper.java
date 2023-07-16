package pack;

import java.util.ArrayList;

public class Sniper extends Units {
    public Sniper(int x, int y) {
        super(100, 100, 10, 6, 6, x, y);
    }
    public int arrowCount = 20;

    @Override
    public String getInfo() {
        return "Снайпер имеет " + this.arrowCount + " стрел " + this.curHP + " ОЗ из " + this.maxHP + ", Защита " + this.defence + ", Урон " + this.damage + ", Инициатива " + this.initiative;
    }

    public int getArrowCount(){
        return arrowCount;
    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        Units tmp2 = findNearest(enemy);
        if (curHP <= 0) {
            curHP = 0;
            System.out.println("Снайпер убит");
            if (arrowCount <= 0)
                System.out.println("Закончились стрелы");
            else {
                arrowCount--;
                tmp2.curHP = tmp2.curHP - (damage + tmp2.defence);
                if (allies.contains(Peasant.class))
                    System.out.println("Переход хода");
            }
        }
    }
}
