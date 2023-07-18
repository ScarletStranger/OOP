import pack.*;
import pack.units.*;

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
                    unit.step(team1, team2);
                else
                    unit.step(team2, team1);
            }
        }
    }

    @Override
    public void step(ArrayList<Units> enemy, ArrayList<Units> allies) {
    }

    @Override
    public String getInfo() {
        return null;
    }

    public static ArrayList<Units> GenerateCharacter() {
        ArrayList<Units> teams = new ArrayList<>();

        teams.add(new Crossbowman(1, 1, TeamType.ALLIES));
        teams.add(new Mage(1, 2, TeamType.ALLIES));
        teams.add(new Monk(1, 3, TeamType.ALLIES));
        teams.add(new Peasant(1, 4, TeamType.ALLIES));
        teams.add(new Rogue(1, 5, TeamType.ALLIES));
        teams.add(new Sniper(1, 6, TeamType.ALLIES));
        teams.add(new Spearman(1, 7, TeamType.ALLIES));
        teams.add(new Peasant(1, 8, TeamType.ALLIES));
        teams.add(new Rogue(1, 9, TeamType.ALLIES));
        teams.add(new Sniper(1, 10, TeamType.ALLIES));
        return teams;

    }


    public static ArrayList<Units> GenerateCharacter2() {
        ArrayList<Units> teams = new ArrayList<>();
        teams.add(new Crossbowman(10, 1, TeamType.ENEMIES));
        teams.add(new Mage(10, 2, TeamType.ENEMIES));
        teams.add(new Monk(10, 3, TeamType.ENEMIES));
        teams.add(new Peasant(10, 4, TeamType.ENEMIES));
        teams.add(new Rogue(10, 5, TeamType.ENEMIES));
        teams.add(new Sniper(10, 6, TeamType.ENEMIES));
        teams.add(new Spearman(10, 7, TeamType.ENEMIES));
        teams.add(new Peasant(10, 8, TeamType.ENEMIES));
        teams.add(new Rogue(10, 9, TeamType.ENEMIES));
        teams.add(new Sniper(10, 10, TeamType.ENEMIES));
        return teams;
    }
}