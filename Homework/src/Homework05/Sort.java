package Homework05;

public final class Sort {
  public static void insertionSort(int[] a) {
    for (int p = 1; p < a.length; p++) {
      int tmp = a[p];
      int j = p;
      for (; j > 0 && tmp < a[j - 1]; j--)
        a[j] = a[j - 1]; 
      a[j] = tmp;
    } 
  }
  
  public static void shellsort(int[] a) {
    for (int gap = a.length / 2; gap > 0; 
      gap = (gap == 2) ? 1 : (int)(gap / 2.2D)) {
      for (int i = gap; i < a.length; i++) {
        int tmp = a[i];
        int j = i;
        for (; j >= gap && tmp < a[j - gap]; j -= gap)
          a[j] = a[j - gap]; 
        a[j] = tmp;
      } 
    } 
  }
  
  public static void bubbleSort(int[] a) {
    for (int i = a.length; --i >= 0; ) {
      boolean swapped = false;
      for (int j = 0; j < i; j++) {
        if (a[j] > a[j + 1]) {
          int T = a[j];
          a[j] = a[j + 1];
          a[j + 1] = T;
          swapped = true;
        } 
      } 
      if (!swapped)
        return; 
    } 
  }
  
  public static void heapsort(int[] a) {
    int i;
    for (i = a.length / 2; i >= 0; i--)
      siftDown(a, i, a.length); 
    for (i = a.length - 1; i > 0; i--) {
      swapReferences(a, 0, i);
      siftDown(a, 0, i);
    } 
  }
  
  private static int leftChild(int i) {
    return 2 * i + 1;
  }
  
  private static void siftDown(int[] a, int i, int n) {
    int tmp;
    for (tmp = a[i]; leftChild(i) < n; ) {
      int child = leftChild(i);
      if (child != n - 1 && a[child] < a[child + 1])
        child++; 
      if (tmp < a[child]) {
        a[i] = a[child];
        i = child;
      } 
    } 
    a[i] = tmp;
  }
  
  public static void mergeSort(int[] a) {
    int[] tmpArray = new int[a.length];
    mergeSort(a, tmpArray, 0, a.length - 1);
  }
  
  private static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
    if (left < right) {
      int center = (left + right) / 2;
      mergeSort(a, tmpArray, left, center);
      mergeSort(a, tmpArray, center + 1, right);
      merge(a, tmpArray, left, center + 1, right);
    } 
  }
  
  private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
    int leftEnd = rightPos - 1;
    int tmpPos = leftPos;
    int numElements = rightEnd - leftPos + 1;
    while (leftPos <= leftEnd && rightPos <= rightEnd) {
      if (a[leftPos] < a[rightPos]) {
        tmpArray[tmpPos++] = a[leftPos++];
        continue;
      } 
      tmpArray[tmpPos++] = a[rightPos++];
    } 
    while (leftPos <= leftEnd)
      tmpArray[tmpPos++] = a[leftPos++]; 
    while (rightPos <= rightEnd)
      tmpArray[tmpPos++] = a[rightPos++]; 
    for (int i = 0; i < numElements; i++, rightEnd--)
      a[rightEnd] = tmpArray[rightEnd]; 
  }
  
  public static void quicksort(int[] a) {
    quicksort(a, 0, a.length - 1);
  }
  
  public static void swapReferences(int[] a, int index1, int index2) {
    int tmp = a[index1];
    a[index1] = a[index2];
    a[index2] = tmp;
  }
  
  private static void quicksort(int[] a, int lo0, int hi0) {
    int lo = lo0;
    int hi = hi0;
    if (hi0 > lo0) {
      swapReferences(a, lo0, (lo0 + hi0) / 2);
      int mid = a[(lo0 + hi0) / 2];
      while (lo <= hi) {
        while (lo < hi0 && a[lo] < mid)
          lo++; 
        while (hi > lo0 && a[hi] > mid)
          hi--; 
        if (lo <= hi) {
          swapReferences(a, lo, hi);
          lo++;
          hi--;
        } 
      } 
      if (lo0 < hi)
        quicksort(a, lo0, hi); 
      if (lo < hi0)
        quicksort(a, lo, hi0); 
    } 
  }
  
  private static void insertionSort(int[] a, int low, int high) {
    for (int p = low + 1; p <= high; p++) {
      int tmp = a[p];
      int j;
      for (j = p; j > low && tmp < a[j - 1]; j--)
        a[j] = a[j - 1]; 
      a[j] = tmp;
    } 
  }
  
  public static void selectionSort(int[] A) {
    for (int i = A.length - 1; i > 0; i--) {
      int maxIndex = 0;
      for (int j = 1; j <= i; j++) {
        if (A[maxIndex] < A[j])
          maxIndex = j; 
      } 
      swapReferences(A, i, maxIndex);
    } 
  }
}
