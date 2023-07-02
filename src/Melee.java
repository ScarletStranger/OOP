public class Melee extends Units{
    public Melee() {
        super(150, 150, 4,  7,  10, 4, 1);
    }
    private double takeRangedDamage(){}
    private void takeDamage(double damage){
        if (Melee.this.damage==takeRangedDamage()) {
            double curHP = Math.round(defence + (defence * 0.5));
        } else {
            curHP -= damage;
        }
    }
}
