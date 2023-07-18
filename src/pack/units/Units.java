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

    public void move(Coordinates coordinates, ArrayList<Units> allies) {
//        if (!coordinates.containsByPosition(coordinates.newPosition(coordinates), allies))
//        this.coordinates = coordinates.newPosition(coordinates);
        newPosition();
    }

    public void newPosition() {
        if (this.teamType.equals(TeamType.ENEMIES)) {
            this.coordinates.y += 1;
        } else this.coordinates.y -= 1;
    }

    //    public Coordinates newPosition(Coordinates coordinates) {
//        Coordinates tmpCoor = new Coordinates(x, y);
//        if (Math.abs(coordinates.x - x) > Math.abs(coordinates.y - y)) {
//            if (coordinates.x - x > 0)
//                tmpCoor.x += 1;
//            else
//                tmpCoor.x -= 1;
//        }
//        if (Math.abs(coordinates.x - x) < Math.abs(coordinates.y - y)) {
//            if (coordinates.y - y > 0)
//                tmpCoor.y += 1;
//            else
//                tmpCoor.y -= 1;
//        }
//        if (Math.abs(coordinates.x - x) == Math.abs(coordinates.y - y)) {
//            if (coordinates.x - x > 0) {
//                tmpCoor.x += 1;
//                tmpCoor.y += 1;
//            } else {
//                tmpCoor.x -= 1;
//                tmpCoor.y -= 1;
//            }
//        }
//        return tmpCoor;
//    }
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
            if (coordinates.findDistance(team1.get(i).coordinates) < nearestDistance) {
                nearestUnit = team1.get(i);
                nearestDistance = coordinates.findDistance(team1.get(i).coordinates);
            }
        }
        return nearestUnit;
    }

}
