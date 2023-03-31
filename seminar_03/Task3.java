package seminar_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task3 {
    // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lst.add(random.nextInt(10));
        }
        System.out.println(lst);
        int min = Collections.min(lst);
        int max = Collections.max(lst);
        int sum = 0;
        for (int i : lst) {
            sum += i;
        }
        int mid = sum / lst.size();
        System.out.println(min + " минимальное");
        System.out.println(max + " максимальное");
        System.out.println(mid + " среднее");
    }
}
