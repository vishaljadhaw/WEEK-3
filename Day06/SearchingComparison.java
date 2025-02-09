
import java.util.*;

public class SearchingComparisons {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};

        for (int size : sizes) {
            System.out.println("Dataset Size: " + size);

            List<Integer> arrayList = new ArrayList<>();
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            Random random = new Random();

            for (int i = 0; i < size; i++) {
                int num = random.nextInt(size * 10);
                arrayList.add(num);
                hashSet.add(num);
                treeSet.add(num);
            }

            int searchElement = arrayList.get(random.nextInt(size));

            // Measure search time for ArrayList (Linear Search)
            long startTime = System.nanoTime();
            arrayList.contains(searchElement);
            long endTime = System.nanoTime();
            System.out.println("ArrayList Search Time: " + (endTime - startTime) / 1000000.0 + " ms");

            // Measure search time for HashSet
            startTime = System.nanoTime();
            hashSet.contains(searchElement);
            endTime = System.nanoTime();
            System.out.println("HashSet Search Time: " + (endTime - startTime) / 1000000.0 + " ms");

            // Measure search time for TreeSet
            startTime = System.nanoTime();
            treeSet.contains(searchElement);
            endTime = System.nanoTime();
            System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1000000.0 + " ms");
        }
    }
}

