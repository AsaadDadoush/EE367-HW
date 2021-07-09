package Homework05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

class SortPerf {
  private static final long INIT_SEED = 1234567L;
  
  public static void main(String[] argv) throws IOException {
    String outFileName = "";
    char op = 'r';
    int incN = 0;
    int maxN = 0;
    int numTrials = 0;
    String sortAlg = "";
    if (argv.length != 6) {
      printUsage();
      return;
    } 
    try {
      sortAlg = argv[0];
      incN = Integer.parseInt(argv[1]);
      maxN = Integer.parseInt(argv[2]);
      op = Character.valueOf(argv[3].charAt(0)).charValue();
      numTrials = Integer.parseInt(argv[4]);
      outFileName = argv[5];
    } catch (Exception e) {
      printUsage();
      return;
    } 
    System.out.println(sortAlg + ", " + incN + ", " + maxN + ", " + op + ", " + numTrials + ", " + outFileName);
    PrintWriter timings = new PrintWriter(new FileOutputStream(outFileName));
    timings.println("# Results for " + numTrials + " trials");
    timings.println("# n   time (msec)");
    timings.println("# ---------------");
    timeSort(timings, incN, maxN, op, numTrials, sortAlg);
    timings.close();
    System.out.println("done!  results in `" + outFileName + "'");
  }
  
  private static void timeSort(PrintWriter timings, int incN, int maxN, char op, int numTrials, String sortAlg) {
    int k = numTrials;
    Timer stopWatch = new Timer();
    int n;
    for (n = incN; n <= maxN; n += incN) {
      stopWatch.reset();
      int[][] data = new int[numTrials + 1][];
      int t;
      for (t = 0; t <= numTrials; t++)
        data[t] = randomData(n); 
      Sort.quicksort(data[numTrials]);
      if (op == 'b') {
        int i = 0;
        int j = n - 1;
        while (i <= j) {
          int temp = data[numTrials][i];
          data[numTrials][i] = data[numTrials][j];
          data[numTrials][j] = temp;
          i++;
          j--;
        } 
      } 
      if (op == 's' || op == 'b')
        for (t = 0; t < numTrials; t++) {
          for (int s = 0; s < n; s++)
            data[t][s] = data[numTrials][s]; 
        }  
      if (sortAlg.equals("insert")) {
        stopWatch.start();
        for (t = 0; t < k; t++)
          Sort.insertionSort(data[t]); 
        stopWatch.stop();
      } else if (sortAlg.equals("select")) {
        stopWatch.start();
        for (t = 0; t < k; t++)
          Sort.selectionSort(data[t]); 
        stopWatch.stop();
      } else if (sortAlg.equals("bubble")) {
        stopWatch.start();
        for (t = 0; t < k; t++)
          Sort.bubbleSort(data[t]); 
        stopWatch.stop();
      } else if (sortAlg.equals("merge")) {
        stopWatch.start();
        for (t = 0; t < k; t++)
          Sort.mergeSort(data[t]); 
        stopWatch.stop();
      } else if (sortAlg.equals("quick")) {
        stopWatch.start();
        for (t = 0; t < k; t++)
          Sort.quicksort(data[t]); 
        stopWatch.stop();
      } else if (sortAlg.equals("heap")) {
        stopWatch.start();
        for (t = 0; t < k; t++)
          Sort.heapsort(data[t]); 
        stopWatch.stop();
      } else if (sortAlg.equals("best")) {
        stopWatch.start();
        for (t = 0; t < k; t++)
          YourSort.sort(data[t]); 
        stopWatch.stop();
      } else {
        printUsage();
        return;
      } 
      long totalTime = stopWatch.elapsed();
      timings.println(n + "  " + totalTime);
    } 
  }
  
  private static void printData(int[] A) {
    for (int i = 0; i < A.length - 1; i++)
      System.out.print(A[i] + ", "); 
    if (A.length - 1 >= 0)
      System.out.println(A[A.length - 1]); 
  }
  
  private static int[] randomData(int n) {
    Random randGen = new Random(1234567L);
    int[] newData = new int[n];
    for (int i = 0; i < n; i++)
      newData[i] = randGen.nextInt(); 
    return newData;
  }
  
  private static void printUsage() {
    System.out.println("Usage:");
    System.out.println(" java SortPerf <sort> <incr> <max> <op> <runs> <outfile>");
    System.out.println("    sort - one of insert, merge, quick, or best");
    System.out.println("    incr - the initial array size and increment");
    System.out.println("    max - the maximum array size");
    System.out.println("    op - the operation needed, 'r':random, 's':sorted, 'b':reversed");
    System.out.println("    runs - the number of runs for each size");
    System.out.println("    outfile - is the name of the timing output file");
  }
}
