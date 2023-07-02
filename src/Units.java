public abstract class Units {
    public double maxHP, curHP;
    public int speed;
    public int defence;
    public int damage;
    public int initiative;
    public int cooldown;

    public Units(double maxHP,
                 double curHP,
                 int speed,
                 int defence,
                 int damage,
                 int initiative,
                 int cooldown) {
        this.maxHP = this.curHP = maxHP;
        this.speed = speed;
        this.defence = defence;
        this.damage = damage;
        this.initiative = initiative;
        this.cooldown = cooldown;
    }

    public boolean Move() {
        if (speed > 0)
            return true;
        return false;
    }
}
