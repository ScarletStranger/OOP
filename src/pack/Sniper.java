package pack;

import java.util.ArrayList;

public class Sniper extends Units {
    public Sniper(int x, int y) {
        super(100, 100, 6, 4, 10, 6, 1, x, y);
    }

    public int arrowCount = 20;

    public int getArrowCount(){
        int arrow = arrowCount;
        return arrow;
    }

    @Override
    public String getInfo() {
        return "Снайпер имеет " + this.arrowCount + " стрел " + this.curHP + " ОЗ из " + this.maxHP + ", Скорость " + this.speed + ", Защита " + this.defence + ", Урон " + this.damage + ", Инициатива " + this.initiative + ", Перезарядка " + this.cooldown;
    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
        if (arrowCount <= 0)
            System.out.println("Закончились стрелы");
            else{
            Units tmp1 = findNearest(allies);
            Units tmp2 = findNearest(enemy);
//            System.out.println(tmp1.getInfo() + " расстояние " + coordinates.findDistance(tmp1.coordinates));
//            System.out.println(tmp2.getInfo() + " расстояние " + coordinates.findDistance(tmp2.coordinates));
            if (tmp2.curHP <= 0){
                tmp2.curHP = 0;
                System.out.println(tmp2.getClass()+" убит");
                enemy.remove(tmp2);
            }
            else{
                arrowCount --;
                tmp2.curHP = tmp2.curHP-(damage+tmp2.defence);
                System.out.println(tmp2.getInfo());
                if(allies.contains(Peasant.class))
                    System.out.println("Переход хода");
            }
        }
    }
}

