package StringConcatenationPerformance;

public class StringConcatenationPerformanceComparison {

    public static void manageConcatenations(int count){

        long startTime1 = System.nanoTime();
        String str = "";
        for(int i = 0;i < count;i++){
            str += "hello";
        }
        long endTime1 = System.nanoTime();

        long duration1 = endTime1-startTime1;

        long startTime2 = System.nanoTime();
        StringBuilder strb = new StringBuilder();
        for(int i = 0;i < count;i++){
            strb.append("hello");
        }
        long endTime2 = System.nanoTime();

        long duration2 = endTime2-startTime2;

        long startTime3 = System.nanoTime();
        StringBuffer strbf = new StringBuffer();
        for(int i = 0; i < count; i++){
            strbf.append("hello");
        }
        long endTime3 = System.nanoTime();

        long duration3 = endTime3-startTime3;

        System.out.print("\n------Comparison Results------");
        System.out.print("\n Time taken by string concatenation: " + duration1 / 1000000.0 + "ms.");
        System.out.print("\n Time taken by string builder append: " + duration2 / 1000000.0 + "ms.");
        System.out.print("\n Time taken by string buffer append: " + duration3 / 1000000.0 + "ms.");
        System.out.println();
    }
    public static void main(String[] args) {

        //Comparisons on count of 1000, 10000, 1000000 concatenation operations
        manageConcatenations(1000);
        manageConcatenations(10_000);
        manageConcatenations(1_000_000);
    }
}
