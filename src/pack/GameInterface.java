package pack;

import java.util.ArrayList;

public interface GameInterface {
    void move(ArrayList<Units> enemy, ArrayList<Units> allies);
    String getInfo();

}
