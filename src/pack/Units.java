package pack;

import java.util.ArrayList;

public abstract class Units implements GameInterface {
    public double maxHP, curHP;
    public int speed;
    public int defence;
    public int damage;
    public int initiative;
    public int cooldown;
    Coordinates coordinates;

    public Units(double maxHP,
                 double curHP,
                 int speed,
                 int defence,
                 int damage,
                 int initiative,
                 int cooldown,
                 int x,
                 int y) {
        this.maxHP = this.curHP = maxHP;
        this.speed = speed;
        this.defence = defence;
        this.damage = damage;
        this.initiative = initiative;
        this.cooldown = cooldown;
        coordinates = new Coordinates(x, y);

    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {

    }

    @Override
    public String getInfo() {
        return "Юнит " + this.getClass() + " стоит на позиции " + this.coordinates + " имеет " + this.curHP + " ОЗ из " + this.maxHP + ", Скорость " + this.speed + ", Защита " + this.defence + ", Урон " + this.damage + ", Инициатива " + this.initiative + ", Перезарядка " + this.cooldown;
    }

    public Units findNearest(ArrayList<Units> team1) {
        int nearestDistance = Integer.MAX_VALUE;
        Units nearestUnit = null;
        for (int i = 0; i < team1.size(); i++) {
            if (coordinates.findDistance(team1.get(i).coordinates) < nearestDistance) {
                nearestUnit = team1.get(i);
                nearestDistance = coordinates.findDistance(team1.get(i).coordinates);
            }
        }
        return nearestUnit;
    }

}
