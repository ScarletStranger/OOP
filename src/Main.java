import pack.*;

import java.util.ArrayList;
import java.util.Random;

public class Main implements GameInterface {
    public static void main(String[] args) {
        ArrayList<Units> team1 = GenerateCharacter();
        ArrayList<Units> team2 = GenerateCharacter();
        team1.forEach(n -> System.out.println(n.getInfo()));
        System.out.println("----------------------");
        team2.forEach(n -> System.out.println(n.getInfo()));
        System.out.println("----------------------");
        team1.get(0).move(team2);
        team2.get(0).move(team1);
    }

    @Override
    public void move(ArrayList<Units> team1) {

    }

    @Override
    public String getInfo() {
        return null;
    }
    public static ArrayList<Units> GenerateCharacter() {
        int teamCount = 10;
        Random rand = new Random();

        ArrayList<Units> teams = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(7);
            int coorx = rand.nextInt(101);
            int coory = rand.nextInt(101);
            switch (val) {
                case 0:
                    teams.add(new Crossbowman(coorx, coory));
                    break;
                case 1:
                    teams.add(new Mage(coorx, coory));
                    break;
                case 2:
                    teams.add(new Monk(coorx, coory));
                    break;
                case 3:
                    teams.add(new Peasant(coorx, coory));
                    break;
                case 4:
                    teams.add(new Rogue(coorx, coory));
                    break;
                case 5:
                    teams.add(new Sniper(coorx, coory));
                    break;
                case 6:
                    teams.add(new Spearman(coorx, coory));
                    break;
            }
        }
        return teams;
    }
}