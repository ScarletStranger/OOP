package pack;

import pack.units.Units;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<Units> enemy, ArrayList<Units> allies);

    String getInfo();

}
