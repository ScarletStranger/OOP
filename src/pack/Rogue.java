package pack;

import java.util.ArrayList;

public class Rogue extends Units {
    public Rogue(int x, int y) {
        super(150, 150,  10, 4, 7, x, y);
    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (curHP<=0){
            curHP = 0;
            System.out.println("Разбойник умер");
        } else {
            Units tmp = findNearest(enemy);
        }
    }
    @Override
    public String getInfo() {
        return "Разбойник " + this.curHP + "/" + this.maxHP;
    }
}
