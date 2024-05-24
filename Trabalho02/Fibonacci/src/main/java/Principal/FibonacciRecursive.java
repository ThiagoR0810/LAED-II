/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

public class FibonacciRecursive {
    static int recursiveCalls = 0;

    public static int fibonacci(int n) {
        recursiveCalls++;
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
    }

    public static void main(String[] args) {
        int limit = 1000;
        System.out.println("n\tF(n)\tRecursive Calls");
        for (int i = 1; i <= limit; i++) {
            recursiveCalls = 0;
            int result = fibonacci(i);
            System.out.println(i + "\t" + result + "\t" + recursiveCalls);
        }
    }
}
