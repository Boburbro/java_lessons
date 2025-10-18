public class SwitchStatementsPartTwo {

    public enum Days{sun, mon, tue, wed, thu, fri, sat}

    public static void main(String[] args) {
        Days[] dayNow = Days.values();
        for (Days day : dayNow){
            switch (day){
                case sun:System.out.println("Sunday");break;
                case mon:System.out.println("Monday");break;
                case tue:System.out.println("Tuesday");break;
                case wed:System.out.println("Wednesday");break;
                case thu:System.out.println("Thursday");break;
                case fri:System.out.println("Friday");break;
                case sat:System.out.println("Saturday");break;

            }
        }

    }
}
