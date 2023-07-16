import pack.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main implements GameInterface {
    public static ArrayList<Units> all = new ArrayList<>();
    public static ArrayList<Units> team1 = GenerateCharacter();
    public static ArrayList<Units> team2 = GenerateCharacter2();

    public static void main(String[] args) {
        all.addAll(team1);
        all.addAll(team2);
        all.sort(new Comparator<Units>() {
            @Override
            public int compare(Units o1, Units o2) {
                return Integer.compare(o2.initiative, o1.initiative);
            }
        });
        Scanner in = new Scanner(System.in);
        while (true) {
            View.view();
            in.nextLine();
            for (Units unit : all) {
                if (team2.contains(unit))
                    unit.move(team1, team2);
                else
                    unit.move(team2, team1);
            }
        }
    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
    }

    @Override
    public String getInfo() {
        return null;
    }

    public static ArrayList<Units> GenerateCharacter() {
        ArrayList<Units> teams = new ArrayList<>();

        teams.add(new Crossbowman(1, 1));
        teams.add(new Mage(1, 2));
        teams.add(new Monk(1, 3));
        teams.add(new Peasant(1, 4));
        teams.add(new Rogue(1, 5));
        teams.add(new Sniper(1, 6));
        teams.add(new Spearman(1, 7));
        teams.add(new Peasant(1, 8));
        teams.add(new Rogue(1, 9));
        teams.add(new Sniper(1, 10));
        return teams;

    }


    public static ArrayList<Units> GenerateCharacter2() {
        ArrayList<Units> teams = new ArrayList<>();
        teams.add(new Crossbowman(10, 1));
        teams.add(new Mage(10, 2));
        teams.add(new Monk(10, 3));
        teams.add(new Peasant(10, 4));
        teams.add(new Rogue(10, 5));
        teams.add(new Sniper(10, 6));
        teams.add(new Spearman(10, 7));
        teams.add(new Peasant(10, 8));
        teams.add(new Rogue(10, 9));
        teams.add(new Sniper(10, 10));
        return teams;
    }
}