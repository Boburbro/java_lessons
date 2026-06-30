import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        int[] arr = new int[10];
//        System.out.println(Arrays.toString(arr));
//        changeValur(arr);
//        System.out.println(Arrays.toString(arr));

        Integer a = 5;
        System.out.println(a);
        changeSingleValue(a);
        System.out.println(a);


    }


    public static void changeValur(int[] items) {
        items[1] = 10;
    }

    public static void changeSingleValue(Integer n){
        n = 10;
    }
}