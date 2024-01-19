import java.util.Scanner;

/**
 * Converts Celsius To Fahrenheit
 * @Author Saravana
 * @Version 1.0
 */
public class CelsiusToFahrenheit {
    public static void main(String[] args) {
//        int celsius = 0;

//        if(args.length == 1 ) {
//            celsius = Integer.parseInt(args[0]);
//        }
//        else if(args.length == 2) {
//            celsius = Integer.parseInt(args[1]);
//        }
//        else {
//            System.out.println("Invalid Arguments.");
//        }
//            System.exit(0);

//        switch (args.length) {
//            case 1:
//                celsius = Integer.parseInt(args[0]);
//                break;
//            case 2:
//                celsius = Integer.parseInt(args[1]);
//                break;
//            default:
//                System.out.println("Invalid Arguments.");
//                System.exit(0);
//        }

        // while
        // do..while
        // for
        // foreach

        boolean flag = true;
        int counter = 0 ;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter no of iterations:");
        int counterMax = in.nextInt();

//        while(counter < counterMax) {
//        while(true) {
        String val = null;

//        do {

        for(int i =0; i < counterMax; i++) {
            System.out.print("Enter value in Celsius: ");
            int celsius = in.nextInt();

            int fh = (celsius * 9 / 5) + 32;
            System.out.println(celsius + " degree Celsius is equal to " + fh + " in Fahrenheit");

//            counter++;

//            System.out.println("Do you want to continue? Y/N");
//             val = in.next();

        }
//        while (val.equalsIgnoreCase("Y"));

//        for(int i =0; i < 5; i++) {
//            System.out.println(i);
//        }
    }
}
