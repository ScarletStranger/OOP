package pack;

import java.util.ArrayList;

public class Spearman extends Units {
    public Spearman(int x, int y) {
        super(150, 150, 8, 4, 1, x, y);
    }
    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (curHP<=0){
            curHP = 0;
            System.out.println("Копейщик умер");
        } else {
            Units tmp = findNearest(enemy);
        }
    }
    @Override
    public String getInfo() {
        return "Копейщик " + this.curHP + "/" + this.maxHP;
    }
}
