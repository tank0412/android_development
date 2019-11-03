import java.util.Scanner;

public class TaskFour {
    public void doJob() {
        int digit = publishInfoAndGetDigit();

        if(digit < 60) {
            System.out.println("It is 2");
        }
        if(digit >= 60 && digit <= 74) {
            System.out.println("It is 3");
        }
        if(digit >= 75 && digit <=90) {
            System.out.println("It is 4");
        }
        if(digit >= 91 && digit <= 100) {
            System.out.println("It is 5");
        }

    }
    public int publishInfoAndGetDigit() {
        System.out.println("Mark table" + "\n" + "0-60 is 2");
        System.out.println("60-74 is 3 ");
        System.out.println("75-90 is 4");
        System.out.println("91-100 is 5");
        System.out.println("Enter your Points");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int digit = Integer.parseInt(input);
        return digit;
    }
}
