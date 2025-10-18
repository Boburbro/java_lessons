public class Variable {
    public static void main(String[] args) {
        /// N O T E : just simple:
        /// int a = 15;
        /// int b = 25;
        /// int c = a + b;
        /// System.out.println(c); /// 60

        /// int a = 15;
        /// float b = a;
        /// System.out.println(b); /// 15.

        /// N O T E : u can use f or float and both is true
        /// float a = (float) 15.2;
        /// float a = 15.2f;
        /// float a = 15.2f;
        /// int b = (int) a;
        /// System.out.println(b);

        int a = 130;
        byte b = (byte) a;
        byte c = 10;
        byte d = (byte) (b + c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }
}
