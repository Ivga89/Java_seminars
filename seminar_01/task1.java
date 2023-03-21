package seminar_01;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите число n: ");
        int n = iScanner.nextInt();
        
        // треугольное число
        int triang = 0;
        for(int i = 1; i <= n; i++) {
            triang += i;
        }
        // факториал
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            fact *= i;
        }
        
        System.out.println("n-ое треугольное число = " + triang);
        System.out.println("n! = " + fact);
        iScanner.close();
    }
}