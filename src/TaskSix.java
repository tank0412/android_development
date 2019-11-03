import java.util.Scanner;

public class TaskSix {
    public void doJob() {
        System.out.println("Task 6");
        Scanner scanner = new Scanner(System.in);
        int[] setOfDigits = new int[15];
        for(int i = 0; i < setOfDigits.length; ++i) {
            setOfDigits[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i < setOfDigits.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = setOfDigits[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i+1; j < setOfDigits.length; j++) {
                //Если находим, запоминаем его индекс
                if (setOfDigits[j] < min) {
                    min = setOfDigits[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = setOfDigits[i];
                setOfDigits[i] = setOfDigits[min_i];
                setOfDigits[min_i] = tmp;
            }
        }


        for(int i = 0; i < setOfDigits.length; ++i) {
            System.out.println(setOfDigits[i]);
        }
    }
}
