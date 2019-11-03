public class TaskSeven {
    public void doJob() {
    int[] set = new int[6];

    try {
        System.out.println(set[6]);
    }
    catch (ArrayIndexOutOfBoundsException exp) {
        System.out.println(exp);
    }
    }
}
