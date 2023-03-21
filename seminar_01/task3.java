package seminar_01;
// Задача 3: Реализовать простой калькулятор
import java.util.Scanner;
public class task3 {
   public static void main(String[] args) {
      Scanner iScanner = new Scanner(System.in);
      System.out.println("Введите первое число:");
      double num1 = iScanner.nextDouble();
      System.out.println("Введите второе число:");
      double num2 = iScanner.nextDouble();
      System.out.println("Введите операцию (+, -, *, /):");
      String operation = iScanner.next();
      double result = 0.0;
      iScanner.close();
      
      switch(operation) {
         case "+":
            result = num1 + num2;
            break;
         case "-":
            result = num1 - num2;
            break;
         case "*":
            result = num1 * num2;
            break;
         case "/":
            result = num1 / num2;
            break;
         default:
            System.out.println("Неверная операция!");
            return;
      }
      
      System.out.println("Результат: " + result);
      
   }
}
