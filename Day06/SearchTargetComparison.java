public class SearchTargetComparison {

    public static int linearSearch(int[] arr, int target){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static void manageSearchType(String searchType, int[] arr, int target){

        int result = -1;
        long startTime = System.nanoTime();
        if(searchType.equalsIgnoreCase("linear")){
            result = linearSearch(arr, target);
        }
        else if(searchType.equalsIgnoreCase("binary")){
            result = binarySearch(arr, target);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(searchType + " search taken time: " + duration/1000000.0 + " ms.");

        if(result == -1){
            System.out.println("Target value not found!");
        } else {
            System.out.println("Target found at index " + result);
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int target = 50000;
        int[] dataset1K = new int[1000];
        int[] dataset10K = new int[10_000];
        int[] dataset1000K = new int[1_000_000];

        //Filling values in different sizes datasets
        for(int i = 0;i < dataset1K.length;i++) dataset1K[i] = i+1;
        for(int i = 0;i < dataset10K.length;i++) dataset10K[i] = i+1;
        for(int i = 0;i < dataset1000K.length;i++) dataset1000K[i] = i+1;

        //perform linear and binary search on each dataset and compare their performance
        System.out.println("Dataset size -> 1,000");
        manageSearchType("linear", dataset1K, target);
        manageSearchType("binary", dataset1K, target);

        System.out.println("Dataset size -> 10,000");
        manageSearchType("linear", dataset10K, target);
        manageSearchType("binary", dataset10K, target);

        System.out.println("Dataset size -> 1,000,000");
        manageSearchType("linear", dataset1000K, target);
        manageSearchType("binary", dataset1000K, target);
    }
}
