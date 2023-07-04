import java.util.Random;

public class Mage extends Units{
    public Mage() {
        super(100, 100, 6, 4,  10, 6, 1);
    }
    int mana = new Random().nextInt(50, 150);
    int manaCost;
    @Override
    public String GetInfo() {
        return this.getClass()+" "+this.curHP +" ОЗ из "+this.maxHP+", Мана "+this.mana+", Скорость "+this.speed+", Защита "+this.defence+", Урон "+this.damage+", Инициатива "+this.initiative+", Перезарядка "+this.cooldown;
    }
    //public int defaultSpellAttack(){}
    //public int Inferno(){}
}
