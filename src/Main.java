import pack.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
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
//        team1.forEach(n -> System.out.println(n.getInfo()));
//        System.out.println("----------------------");
//        team2.forEach(n -> System.out.println(n.getInfo()));
//        System.out.println("----------------------");

    }

    @Override
    public void move(ArrayList<Units> enemy, ArrayList<Units> allies) {
    }

    @Override
    public String getInfo() {
        return null;
    }

    public static ArrayList<Units> GenerateCharacter() {
        Random rand = new Random();
        ArrayList<Units> teams = new ArrayList<>();
        int coorx = rand.nextInt(101);
        int coory = rand.nextInt(1, 12);
        for (int i = 0; i < 5; i++) {
            teams.add(new Crossbowman(1, coory));
            teams.add(new Mage(1, coory));
            teams.add(new Monk(1, coory));
            teams.add(new Peasant(1, coory));
            teams.add(new Rogue(1, coory));
            teams.add(new Sniper(1, coory));
            //teams.add(new Spearman(coorx, coory));
        }
        return teams;
    }

    public static ArrayList<Units> GenerateCharacter2() {
        Random rand = new Random();
        ArrayList<Units> teams = new ArrayList<>();
        int coorx = rand.nextInt(101);
        int coory = rand.nextInt(1, 12);
        for (int i = 0; i < 5; i++) {
            teams.add(new Crossbowman(10, coory));
            teams.add(new Mage(10, coory));
            teams.add(new Monk(10, coory));
            teams.add(new Peasant(10, coory));
            teams.add(new Rogue(10, coory));
            teams.add(new Sniper(10, coory));
            //teams.add(new Spearman(coorx, coory));
        }
        return teams;
    }
}