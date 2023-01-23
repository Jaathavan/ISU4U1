public class SortAnalysis {
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();

        //create 4 2d arrays 
        int[][] random;
        int[][] nearlySorted;
        int[][] reversed;
        int[][] fewUniqueValues;
        double ranTime = 0;
        double nsTime = 0;
        double revTime = 0;
        double fuvTime = 0;
        
        for (int i=10; i <= 100000; i*=10) {
            //initialize with size 10 and each array size
            random = new int[10][i]; 
            nearlySorted = new int[10][i];
            reversed = new int[10][i];
            fewUniqueValues = new int[10][i];
            
            //fill in array
            for (int j=0; j < 10; j++) {
                random[j] = ArrayGen.randomizedArray(i);
                nearlySorted[j] = ArrayGen.nearlySortedArray(i);
                reversed[j] = ArrayGen.reversedArray(i);
                fewUniqueValues[j] = ArrayGen.nearlySortedArray(i);
            }
            
            
            //bubble sort
            System.out.println("Array Size: "  + i);
            System.out.println();
            System.out.println("Bubble sort: ");
            
            for (int k=0; k < 10; k++) {
                sw.start();
                Sorts.bubbleSort(random[k]);
                sw.stop();

                //for first output rerun as it's always an outlier
                if (k == 0) {
                    random[k] = ArrayGen.randomizedArray(i);
                    sw.start();
                    Sorts.bubbleSort(random[k]);
                    sw.stop();
                }
                System.out.println("Random " + (k+1) + ": " + sw.getElapsedTime());
                ranTime += sw.getElapsedTime();
                
                sw.start();
                Sorts.bubbleSort(nearlySorted[k]);
                sw.stop();
                System.out.println("NearlySorted " + (k+1) + ": " + sw.getElapsedTime());
                nsTime += sw.getElapsedTime();

                sw.start();
                Sorts.bubbleSort(reversed[k]);
                sw.stop();
                System.out.println("Reversed " + (k+1) + ": " + sw.getElapsedTime());
                revTime += sw.getElapsedTime();

                sw.start();
                Sorts.bubbleSort(fewUniqueValues[k]);
                sw.stop();
                System.out.println("FewUniqueValues " + (k+1) + ": " + sw.getElapsedTime());
                fuvTime += sw.getElapsedTime();

                System.out.println();
            }

            System.out.println("Average Bubble Sort: ");
            System.out.println("Average Time Random: " + ranTime/10);
            System.out.println("Average Time NearlySorted: " + nsTime/10);
            System.out.println("Average Time Reversed: " + revTime/10);
            System.out.println("Average Time FewUniqueValues: " + fuvTime/10);
            System.out.println();

            //reset variables and arrays
            ranTime = 0;
            nsTime = 0;
            revTime = 0;
            fuvTime = 0;
            for (int j=0; j < 10; j++) {
                random[j] = ArrayGen.randomizedArray(i);
                nearlySorted[j] = ArrayGen.nearlySortedArray(i);
                reversed[j] = ArrayGen.reversedArray(i);
                fewUniqueValues[j] = ArrayGen.nearlySortedArray(i);
            }


            //selection sort
            System.out.println("Array Size: "  + i);
            System.out.println();
            System.out.println("Selection sort: ");
            
            
            for (int k=0; k < 10; k++) {
                sw.start();
                Sorts.selectSort(random[k]);
                sw.stop();
                System.out.println("Random " + (k+1) + ": " + sw.getElapsedTime());
                ranTime += sw.getElapsedTime();

                sw.start();
                Sorts.selectSort(nearlySorted[k]);
                sw.stop();
                System.out.println("NearlySorted " + (k+1) + ": " + sw.getElapsedTime());
                nsTime += sw.getElapsedTime();

                sw.start();
                Sorts.selectSort(reversed[k]);
                sw.stop();
                System.out.println("Reversed " + (k+1) + ": " + sw.getElapsedTime());
                revTime += sw.getElapsedTime();

                sw.start();
                Sorts.selectSort(fewUniqueValues[k]);
                sw.stop();
                System.out.println("FewUniqueValues " + (k+1) + ": " + sw.getElapsedTime());
                fuvTime += sw.getElapsedTime();

                System.out.println();
            }

            System.out.println("Average Selection Sort: ");
            System.out.println("Average Time Random: " + ranTime/10);
            System.out.println("Average Time NearlySorted: " + nsTime/10);
            System.out.println("Average Time Reversed: " + revTime/10);
            System.out.println("Average Time FewUniqueValues: " + fuvTime/10);
            System.out.println();

            //reset variables and arrays
            ranTime = 0;
            nsTime = 0;
            revTime = 0;
            fuvTime = 0;
            for (int j=0; j < 10; j++) {
                random[j] = ArrayGen.randomizedArray(i);
                nearlySorted[j] = ArrayGen.nearlySortedArray(i);
                reversed[j] = ArrayGen.reversedArray(i);
                fewUniqueValues[j] = ArrayGen.nearlySortedArray(i);
            }


            //insertion sort
            System.out.println("Array Size: "  + i);
            System.out.println();
            System.out.println("Insertion sort: ");
            
            
            for (int k=0; k < 10; k++) {
                sw.start();
                Sorts.insertSort(random[k]);
                sw.stop();
                System.out.println("Random " + (k+1) + ": " + sw.getElapsedTime());
                ranTime += sw.getElapsedTime();

                sw.start();
                Sorts.insertSort(nearlySorted[k]);
                sw.stop();
                System.out.println("NearlySorted " + (k+1) + ": " + sw.getElapsedTime());
                nsTime += sw.getElapsedTime();

                sw.start();
                Sorts.insertSort(reversed[k]);
                sw.stop();
                System.out.println("Reversed " + (k+1) + ": " + sw.getElapsedTime());
                revTime += sw.getElapsedTime();

                sw.start();
                Sorts.insertSort(fewUniqueValues[k]);
                sw.stop();
                System.out.println("FewUniqueValues " + (k+1) + ": " + sw.getElapsedTime());
                fuvTime += sw.getElapsedTime();

                System.out.println();
            }

            System.out.println("Average Insertion Sort: ");
            System.out.println("Average Time Random: " + ranTime/10);
            System.out.println("Average Time NearlySorted: " + nsTime/10);
            System.out.println("Average Time Reversed: " + revTime/10);
            System.out.println("Average Time FewUniqueValues: " + fuvTime/10);
            System.out.println();

            //reset variables and arrays
            ranTime = 0;
            nsTime = 0;
            revTime = 0;
            fuvTime = 0;
            for (int j=0; j < 10; j++) {
                random[j] = ArrayGen.randomizedArray(i);
                nearlySorted[j] = ArrayGen.nearlySortedArray(i);
                reversed[j] = ArrayGen.reversedArray(i);
                fewUniqueValues[j] = ArrayGen.nearlySortedArray(i);
            }

            //merge sort
            System.out.println("Array Size: "  + i);
            System.out.println();
            System.out.println("Merge sort: ");
            
            
            for (int k=0; k < 10; k++) {
                sw.start();
                Sorts.mergeSort(random[k]);
                sw.stop();
                System.out.println("Random " + (k+1) + ": " + sw.getElapsedTime());
                ranTime += sw.getElapsedTime();

                sw.start();
                Sorts.mergeSort(nearlySorted[k]);
                sw.stop();
                System.out.println("NearlySorted " + (k+1) + ": " + sw.getElapsedTime());
                nsTime += sw.getElapsedTime();

                sw.start();
                Sorts.mergeSort(reversed[k]);
                sw.stop();
                System.out.println("Reversed " + (k+1) + ": " + sw.getElapsedTime());
                revTime += sw.getElapsedTime();

                sw.start();
                Sorts.mergeSort(fewUniqueValues[k]);
                sw.stop();
                System.out.println("FewUniqueValues " + (k+1) + ": " + sw.getElapsedTime());
                fuvTime += sw.getElapsedTime();

                System.out.println();
            }

            System.out.println("Average Merge Sort: ");
            System.out.println("Average Time Random: " + ranTime/10);
            System.out.println("Average Time NearlySorted: " + nsTime/10);
            System.out.println("Average Time Reversed: " + revTime/10);
            System.out.println("Average Time FewUniqueValues: " + fuvTime/10);
            System.out.println();

            //reset variables and arrays
            ranTime = 0;
            nsTime = 0;
            revTime = 0;
            fuvTime = 0;
            for (int j=0; j < 10; j++) {
                random[j] = ArrayGen.randomizedArray(i);
                nearlySorted[j] = ArrayGen.nearlySortedArray(i);
                reversed[j] = ArrayGen.reversedArray(i);
                fewUniqueValues[j] = ArrayGen.nearlySortedArray(i);
            }

            //quick sort
            System.out.println("Array Size: "  + i);
            System.out.println();
            System.out.println("Quick sort: ");
            
            
            for (int k=0; k < 10; k++) {
                sw.start();
                Sorts.quickSort(random[k]);
                sw.stop();
                System.out.println("Random " + (k+1) + ": " + sw.getElapsedTime());
                ranTime += sw.getElapsedTime();

                sw.start();
                Sorts.quickSort(nearlySorted[k]);
                sw.stop();
                System.out.println("NearlySorted " + (k+1) + ": " + sw.getElapsedTime());
                nsTime += sw.getElapsedTime();

                sw.start();
                Sorts.quickSort(reversed[k]);
                sw.stop();
                System.out.println("Reversed " + (k+1) + ": " + sw.getElapsedTime());
                revTime += sw.getElapsedTime();

                sw.start();
                Sorts.quickSort(fewUniqueValues[k]);
                sw.stop();
                System.out.println("FewUniqueValues " + (k+1) + ": " + sw.getElapsedTime());
                fuvTime += sw.getElapsedTime();

                System.out.println();
            }

            System.out.println("Average Quick Sort: ");
            System.out.println("Average Time Random: " + ranTime/10);
            System.out.println("Average Time NearlySorted: " + nsTime/10);
            System.out.println("Average Time Reversed: " + revTime/10);
            System.out.println("Average Time FewUniqueValues: " + fuvTime/10);
            System.out.println();

            //reset variables and arrays
            ranTime = 0;
            nsTime = 0;
            revTime = 0;
            fuvTime = 0;
            for (int j=0; j < 10; j++) {
                random[j] = ArrayGen.randomizedArray(i);
                nearlySorted[j] = ArrayGen.nearlySortedArray(i);
                reversed[j] = ArrayGen.reversedArray(i);
                fewUniqueValues[j] = ArrayGen.nearlySortedArray(i);
            }
        }
    }
}