import java.util.Collections;
import java.util.ArrayList;
/**
 * Created by р on 17.02.2015.
 */
public class Juice {
    ArrayList<String>components;
    public Juice() {

    }
    public Juice(ArrayList<String>comp) {
        components = comp;
    }
    public boolean canBeAfter(Juice next) {
        for (String curComponent:components) {
            if (Collections.binarySearch(next.components, curComponent) < 0 ) {
                return false;
            }
        }
        return true;
    }
    public String toString() {
        String result = new String();
        for (String component:components) {
            result += component + " ";
        }
        return result;
    }

}
