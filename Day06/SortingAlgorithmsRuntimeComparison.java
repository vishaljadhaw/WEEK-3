import java.util.ArrayList;

public class SortingAlgorithmsRuntimeComparison {

    //Bubble sort
    public static void bubbleSort(int[] arr){
        int n = arr.length;

        boolean isSwapped = false; //To optimize
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped) return;
        }
    }

    //Recursive Merge Sort
    public static void mergeSort(int[] arr, int low, int high){
        if(low == high) return;
        int mid = low + (high-low)/2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low , mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid + 1;

        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            } else{
                temp.add(arr[right]);
                right++;
            }
        }

        //copy remaining elements from either array
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        //copy back elements from temp to original array
        for(int i = low; i <= high;i++){
            arr[i] = temp.get(i-low);
        }
    }
    //Quick Sort
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1; //This will make room for the elements smaller than pivot
        for(int j = low;j < high;j++){
            if(arr[j] < arr[high]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++; //for the correct position of pivot

        //put pivot in its correct place
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i;
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    public static void manageSortType(String sortType, int[] arr){


        long startTime = System.nanoTime();
        if(sortType.equalsIgnoreCase("bubble")){
            bubbleSort(arr);
        } else if(sortType.equalsIgnoreCase("merge")){
            mergeSort(arr, 0, arr.length-1);
        } else if(sortType.equalsIgnoreCase("quick")){
            quickSort(arr, 0, arr.length-1);
        } else{
            System.out.println("Enter a valid sort type!");
            return;
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time taken for " + sortType.toLowerCase() + " sort : " + duration / 1000000.0 + " ms.");
    }


    public static void main(String[] args){
        int[] dataset1K = new int[1000];
        int[] dataset10K = new int[10_000];
        int[] dataset1000K = new int[1_000_000];

        for(int i = 999;i >= 0;i--) dataset1K[i] = i+1;
        for(int i = 9999; i >= 0; i--) dataset10K[i] = i+1;
        for(int i = 9_99_999; i >= 0; i--) dataset1000K[i] = i+1;

        System.out.println("Dataset size -> 1,000");
        manageSortType("bubble", dataset1K);
        manageSortType("merge", dataset1K);
        manageSortType("quick", dataset1K);

        System.out.println("Dataset size -> 10,000");
        manageSortType("bubble", dataset10K);
        manageSortType("merge", dataset10K);
        manageSortType("quick", dataset10K);

        System.out.println("Dataset size -> 1,000,000");
        manageSortType("bubble", dataset1000K);
        manageSortType("merge", dataset1000K);
        manageSortType("quick", dataset1000K);
    }
}

