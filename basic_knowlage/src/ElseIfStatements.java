public class ElseIfStatements {
    public static void main(String[] args) {
        /// int age = 25;
        /// if (age > 18){
        ///     System.out.println("Siz 18 yoshdan kattasiz!");
        /// }
        /// else{
        ///     System.out.println("Siz 18 yoshdan kichiksiz!");
        /// }

        /// int a = 25;
        /// if (a % 2 == 0 && a > 0){
        ///     System.out.println("Bu son juft va musbat son");
        /// }
        /// else if (a % 2 != 0 && a >0){
        ///     System.out.println("Bu sonimiz toq va musbat");
        /// }
        /// else{
        ///     System.out.println("Bu boshqa bir son");
        /// }

        int a = 26;
        String result = a % 2 == 0 ? "Bu son juft son": "Bu son toq son";
        System.out.println(result);

    }

}
