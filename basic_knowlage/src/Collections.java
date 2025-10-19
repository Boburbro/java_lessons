import java.util.ArrayList;
import java.util.List;

import java.util.HashSet;
import java.util.Set;

public class Collections {



    public static void main(String[] args) {

        float a = 2.5f;
        double b = 2.5;

        List<String> fruits = new ArrayList<String>();
        fruits.add("Olma");
        fruits.add("Banan");
        fruits.add("Olma");
        System.out.println(fruits);
        System.out.println(fruits.get(1));

        Set<String> fruitsSet = new HashSet<String>();
        fruitsSet.add("Olma");
        fruitsSet.add("Banan");
        fruitsSet.add("Olma");

        System.out.println(fruitsSet);

    }
}
