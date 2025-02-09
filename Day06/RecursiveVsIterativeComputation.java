public class RecursiveVsIterativeComputation {

    public static int fibonacciRecursive(int n){
        if(n <= 1) return n;
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    public static int fibonacciIterative(int n){
        int a = 0, b = 1, sum;
        for(int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void manageComparisons(String type, int n){
        long startTime = System.nanoTime();
        int result = -1;
        if(type.equalsIgnoreCase("recursive")){
            result = fibonacciRecursive(n);
            System.out.print("\n------Recursive approach results------");
        }
        else if(type.equalsIgnoreCase("iterative")){
            result = fibonacciIterative(n);
            System.out.print("\n------Iterative approach results------");
        } else {
            System.out.println("\nEnter a valid value of n");
            return;
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.print("\nFibonacci number for n = " + n + " is " + result);
        System.out.print("\nTime taken by " + type + " approach: " + duration/1000000.0 + " ms.");
        System.out.println();
    }
    public static void main(String[] args) {

        int n = 10;
        manageComparisons("recursive", n);
        manageComparisons("iterative", n);

        n = 30;
        manageComparisons("recursive", n);
        manageComparisons("iterative", n);

        n = 50;
        manageComparisons("recursive", n);
        manageComparisons("iterative", n);
    }
}
