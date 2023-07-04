import java.util.ArrayList;
import java.util.Random;

public class Main implements GameInterface {
    public static void main(String[] args) {

        ArrayList<Units> team1 = GenerateCharacter();
        ArrayList<Units> team2 = GenerateCharacter();
        team1.forEach(n -> System.out.println(n.GetInfo()));
        team2.forEach(n -> System.out.println(n.GetInfo()));

    }

    public static ArrayList<Units> GenerateCharacter() {
        int teamCount = 10;
        Random rand = new Random();

        ArrayList<Units> teams = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(7);
            switch (val) {
                case 0:
                    teams.add(new Crossbowman());
                    break;
                case 1:
                    teams.add(new Mage());
                    break;
                case 2:
                    teams.add(new Monk());
                    break;
                case 3:
                    teams.add(new Peasant());
                    break;
                case 4:
                    teams.add(new Rogue());
                    break;
                case 5:
                    teams.add(new Sniper());
                    break;
                case 6:
                    teams.add(new Spearman());
                    break;
            }
        }
        return teams;
    }

    @Override
    public void Move() {

    }

    @Override
    public String GetInfo() {
        return null;
    }


//    public static String MeleeCharacter(){
//        String melee = String.valueOf(MeleeCharacter.values()[new Random().nextInt(MeleeCharacter.values().length)]);
//        return melee;
//    }
//    public static String RangedCharacter(){
//        String ranged = String.valueOf(MeleeCharacter.values()[new Random().nextInt(MeleeCharacter.values().length)]);
//        return ranged;
//    }
}