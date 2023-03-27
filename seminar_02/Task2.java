package seminar_02;


import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;


/* 2) Реализуйте алгоритм сортировки пузырьком числового массива,
    результат после каждой итерации запишите в лог-файл. */
public class Task2 {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Task2.class.getName());
        
        try {
            FileHandler fh = new FileHandler("LogFile.log");
            logger.addHandler(fh);
        } catch (SecurityException | IOException e) { 
            e.printStackTrace(); // это автоматически появилось, пока нет понимания что это
        }

        // создаем случайный массив
        int size = 10;
        int[] rndArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            rndArray[i] = random.nextInt(100);
        }
        for (int item : rndArray) {
            System.out.print(item + " ");
        }


        // сортировка пузырьком
        for (int i = 0; i < rndArray.length; i++) {
            for (int j = i + 1; j < rndArray.length - 1; j++) {
                if (rndArray[j] < rndArray[i]) {
                    int temp = rndArray[j];
                    rndArray[j] = rndArray[i];
                    rndArray[i] = temp;
                    logger.info("Test log");
                }
            }
        }
        System.out.println();
        for (int item : rndArray) {
            System.out.print(item + " ");
        }

        
    }
}
