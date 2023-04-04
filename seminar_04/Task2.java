import java.util.LinkedList;
import java.util.Queue;

public class Task2 {
    /* 
     * Реализуйте очередь с помощью LinkedList со следующими методами:
        • enqueue() — помещает элемент в конец очереди,
        • dequeue() — возвращает первый элемент из очереди и удаляет его,
        • first() — возвращает первый элемент из очереди, не удаляя.
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int n = 123;
        System.out.println(queue);
        enqueue(queue, n);
        System.out.println(queue);
        int m = dequeue(queue);
        System.out.println(m);
        System.out.println(queue);
        int k = first(queue);
        System.out.println(k);
        System.out.println(queue);
        
    }
    public static void enqueue (Queue<Integer> queue, int n) {
        ((LinkedList<Integer>) queue).addLast(n);
    }
    public static Integer dequeue (Queue<Integer> queue) {
        return ((LinkedList<Integer>) queue).pollFirst();
    }
    public static Integer first (Queue<Integer> queue) {
        return ((LinkedList<Integer>) queue).peekFirst();
    }
}
