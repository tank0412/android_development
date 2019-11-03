public class TaskFive {
    public void doJob() {
        TaskFour taskFour = new TaskFour();
        int digit = taskFour.publishInfoAndGetDigit();
        int a = digit % 10;
        switch (digit / 10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: {
                System.out.println("It is 2");
                break;
            }
            case 6: {
                System.out.println("It is 3");
                break;
            }
            case 7: {
                advancedCheckThreeOrFour(a);
                break;
            }
            case 8: {
                System.out.println("It is 4");
                break;
            }
            case 9:{
                advancedCheckFourOrFive(a);
            }
        }
    }
    public void advancedCheckThreeOrFour(int d) {
        switch (d) {
            case 1:
            case 2:
            case 3:
            case 4:
            {
                System.out.println("It is 3");
                break;
            }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            {
                System.out.println("It is 4");
                break;
            }
        }

    }
    public void advancedCheckFourOrFive(int a) {
        switch (a) {
            case 0: {
                System.out.println("It is 4");
                break;
            }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            {
                System.out.println("It is 5");
                break;
            }
        }

    }
}
