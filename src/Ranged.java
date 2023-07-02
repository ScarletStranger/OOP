public class Ranged extends Units{

    public Ranged() {
        super(100, 100, 6, 4,  10, 6, 1);

    }

    private void double MeleeAttack(double damage){
        return damage = Math.round(damage*0.5);
    }

}
