import java.util.Random;

public abstract class Units implements GameInterface {
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
    @Override
    public void Move() {
    }

    @Override
    public String GetInfo() {
        return this.getClass()+" "+this.curHP +" ОЗ из "+this.maxHP+", Скорость "+this.speed+", Защита "+this.defence+", Урон "+this.damage+", Инициатива "+this.initiative+", Перезарядка "+this.cooldown;
    }


}
