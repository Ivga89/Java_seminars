import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Task1 {
    // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.
    public static void main(String[] args) {
        
        String str = "Возврат перевернутой строки";
        LinkedList<String> ll = new LinkedList<>();
        String[] arr = str.split(" ");

        for (String word : arr) {
            ll.add(word);
        }
        System.out.println(ll);
        Collections.reverse(ll);
        System.out.println(ll);
    }
}
