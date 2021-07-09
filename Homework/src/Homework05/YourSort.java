package Homework05;

/* YourSort.java */

class YourSort {
 
	private static void insertionSort(int[] a, int low, int high) {
	    for (int p = low + 1; p <= high; p++) {
	      int tmp = a[p];
	      int j;
	      for (j = p; j > low && tmp < a[j - 1]; j--)
	        a[j] = a[j - 1]; 
	      a[j] = tmp;
	    } 
	  }
 
    private static int partition(int arr[], int low,
                                int high)
    {
        int pivot = arr[high];
        int i = low;
        int j = low;
 
        while (i <= high) {
            if (arr[i] > pivot)
                i++;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        return j - 1;
    }
 
    private static void sort(int arr[], int low, int high) {
        while (low < high) {
            // Check if array size on which we will be working is less than 10
            if (high - low < 10) {
                insertionSort(arr, low, high);
                break;
            }
            else {
                int pivot = partition(arr, low, high);
 
                // We will do recursion on small size
                // subarray So we can check pivot - low  and
                // pivot - high
 
                if (pivot - low < pivot - high) {
                    sort(arr, low, pivot - 1);
                    low = pivot + 1;
                }
                else {
                    sort(arr, pivot + 1, high);
                    high = pivot - 1;
                }
            }
        }
    }
    
    public static void sort(int[] a) {
    	sort(a, 0, a.length - 1);
      }
   
}
 
