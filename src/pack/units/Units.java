package pack.units;

import pack.Coordinates;
import pack.GameInterface;
import pack.TeamType;

import java.util.ArrayList;

public abstract class Units implements GameInterface {
    public int maxHP, curHP;
    public int defence;
    public int damage;
    public int initiative;
    public String state = "Stand";
    public Coordinates coordinates;
    public TeamType teamType;

    public Units(int maxHP,
                 int curHP,
                 int defence,
                 int damage,
                 int initiative,
                 int x,
                 int y,
                 TeamType teamType) {
        this.maxHP = this.curHP = maxHP;
        this.defence = defence;
        this.damage = damage;
        this.initiative = initiative;
        coordinates = new Coordinates(x, y);
        this.teamType = teamType;
    }

    public abstract void move(Coordinates nearest, ArrayList<Units> enemy, ArrayList<Units> allies);

    @Override
    public void step(ArrayList<Units> enemy, ArrayList<Units> allies) {
    }

    @Override
    public String getInfo() {
        return null;
    }

    public Units findNearest(ArrayList<Units> team1) {
        int nearestDistance = Integer.MAX_VALUE;
        Units nearestUnit = null;
        for (int i = 0; i < team1.size(); i++) {
            if (coordinates.findDistance(team1.get(i).coordinates) < nearestDistance && team1.get(i).curHP > 0) {
                nearestUnit = team1.get(i);
                nearestDistance = coordinates.findDistance(team1.get(i).coordinates);
            }
        }
        return nearestUnit;
    }

}
