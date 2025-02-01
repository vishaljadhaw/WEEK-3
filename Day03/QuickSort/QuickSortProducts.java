
public class QuickSortProducts {
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        double[] productPrices = {299.99, 199.50, 450.75, 150.25, 399.00};
        
        System.out.println("Unsorted Product Prices:");
        for (double price : productPrices) {
            System.out.print(price + " ");
        }
        System.out.println();
        
        quickSort(productPrices, 0, productPrices.length - 1);
        
        System.out.println("Sorted Product Prices:");
        for (double price : productPrices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}

