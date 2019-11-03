import java.util.Scanner;

public class TaskThree {
    private String[] same = new String[5];
    public void doJob() {
        System.out.println("Task 3");
        String s1, s2, s3, s4, s5;
        Scanner scanner = new Scanner(System.in);
        s1 = scanner.nextLine();
        s2 = scanner.nextLine();
        s3 = scanner.nextLine();
        s4 = scanner.nextLine();
        s5 = scanner.nextLine();

        String[] vars = new String[5];
        vars[0] = s1;
        vars[1] = s2;
        vars[2] = s3;
        vars[3] = s4;
        vars[4] = s5;

        for(int i = 0; i < 5; ++i) {
            String temp =  vars[i];
            for(int j = 0; j < 5; ++j) {
                if(i != j) {
                    CompareAndSet(temp, vars[j], j);
                }
            }
        }
        if(same[0] == null && same[1] == null && same[2] == null && same[3] == null && same[4] == null) {
            System.out.println("Все разные");
            return;
        }

        for(int i = 0; i < 5; ++i) {
            if(same[i] != null) {
                System.out.println(same[i]);
            }
        }
    }
    private void CompareAndSet(String temp, String var, int j ) {
        if(temp.equals(var)) {
            same[j] = var;
        }
    }
}
