public class StringMethods {

    public static void main(String[] args) {
//        String name = "    Bob Coder     ";
//        int nameLength = name.length();
//
//        char letter = name.charAt(0);
//
//        int index = name.indexOf("o");
//
//        int lastIndex = name.lastIndexOf("o");
//
//        System.out.println(nameLength);
//        System.out.println(letter);
//        System.out.println(index);
//        System.out.println(lastIndex);
//        System.out.println(name.toUpperCase());
//        System.out.println(name.toLowerCase());
//        System.out.println(name.trim());
//        System.out.println(name.replace("o", "a"));
//        System.out.println(name.isEmpty());
//        System.out.println(name.contains("C"));
//        System.out.println(name.equals("password"));


        String email = "Bro123@gamil.com";
        String username = email.substring(0, email.indexOf("@"));

        String domain = email.substring(email.indexOf("@")+1);
        System.out.println(username);
        System.out.println(domain);

    }
}
