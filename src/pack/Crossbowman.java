package pack;

import java.util.ArrayList;

public class Crossbowman extends Units {
    public int arrowCount = 20;

    public Crossbowman(int x, int y) {
        super(100, 100, 4, 5, 4, x, y);
    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (curHP <= 0) {
            curHP = 0;
            System.out.println("Арбалетчик убит");
        }
        if (arrowCount <= 0)
            System.out.println("Закончились стрелы");
        else {
            Units tmp2 = findNearest(enemy);
            arrowCount--;
            tmp2.curHP = tmp2.curHP - (damage + tmp2.defence);
            if (allies.contains(Peasant.class))
                System.out.println("Переход хода");
        }

    }

    public int getArrowCount() {
        return arrowCount;
    }

    @Override
    public String getInfo() {
        return "Арбалетчик" + this.curHP + "/" + this.maxHP + ", стрел " + this.arrowCount;
    }
}


