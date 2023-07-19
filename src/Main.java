import pack.GameInterface;
import pack.TeamType;
import pack.units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main implements GameInterface {
    public static ArrayList<Units> all = new ArrayList<>();
    public static ArrayList<Units> allies = GenerateCharacter();
    public static ArrayList<Units> enemies = GenerateCharacter2();

    public static void main(String[] args) {
        all.addAll(allies);
        all.addAll(enemies);

        all.sort(Comparator.comparingInt(o -> o.initiative));
        allies.sort(Comparator.comparingInt(o -> o.initiative));
        enemies.sort(Comparator.comparingInt(o -> o.initiative));


        Scanner in = new Scanner(System.in);
        while (true) {
            View.view();

            if (isTeamAllDead(allies)) {
                System.out.println("Победили синие");
                return;
            } else if (isTeamAllDead(enemies)) {
                System.out.println("Победили зеленые");
                return;
            }

            in.nextLine();
            for (Units unit : all) {
                if (enemies.contains(unit)) {
                    unit.step(allies, enemies);
                } else {
                    unit.step(enemies, allies);
                }
            }

        }
    }

    private static boolean isTeamAllDead(ArrayList<Units> team) {
        int allHp = 0;
        for (Units unit : team) {
            allHp += unit.curHP;
        }
        return allHp <= 0;
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
        for (int i = 1; i < 11; i++) {
            int r = new Random().nextInt(7);
            switch (r) {
                case 0 -> teams.add(new Crossbowman(1, i, TeamType.ALLIES));
                case 1 -> teams.add(new Mage(1, i, TeamType.ALLIES));
                case 2 -> teams.add(new Monk(1, i, TeamType.ALLIES));
                case 3 -> teams.add(new Peasant(1, i, TeamType.ALLIES));
                case 4 -> teams.add(new Rogue(1, i, TeamType.ALLIES));
                case 5 -> teams.add(new Sniper(1, i, TeamType.ALLIES));
                case 6 -> teams.add(new Spearman(1, i, TeamType.ALLIES));
            }
        }
        return teams;
    }


    public static ArrayList<Units> GenerateCharacter2() {
        ArrayList<Units> teams = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            int r = new Random().nextInt(7);
            switch (r) {
                case 0 -> teams.add(new Crossbowman(10, i, TeamType.ENEMIES));
                case 1 -> teams.add(new Mage(10, i, TeamType.ENEMIES));
                case 2 -> teams.add(new Monk(10, i, TeamType.ENEMIES));
                case 3 -> teams.add(new Peasant(10, i, TeamType.ENEMIES));
                case 4 -> teams.add(new Rogue(10, i, TeamType.ENEMIES));
                case 5 -> teams.add(new Sniper(10, i, TeamType.ENEMIES));
                case 6 -> teams.add(new Spearman(10, i, TeamType.ENEMIES));
            }
        }
        return teams;
    }
}