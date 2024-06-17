//
    public class QuickSort {
        private int[] array;
    
        public QuickSort(int[] array) {
            this.array = array;
        }
    
        public void sort() {
            quickSort(0, array.length - 1);
        }
    
        private void quickSort(int p, int q) {
            if (p < q) {
                int j = partition(p, q);
                quickSort(p, j - 1);
                quickSort(j + 1, q);
            }
        }
    
        private int partition(int p, int q) {
            int pivot = array[p];
            int i = p;
            int j = q + 1;
    
            while (true) {
                while (array[++i] < pivot) {
                    if (i == q) break;
                }
    
                while (array[--j] > pivot) {
                    if (j == p) break;
                }
    
                if (i >= j) break;
    
                swap(i, j);
            }
    
            swap(p, j);
            return j;
        }
    
        private void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    
        public static void main(String[] args) {
            int[] inputArray = {102, 99, 14, 3, 6, 1};
            QuickSort quickSort = new QuickSort(inputArray);
            System.out.println("Given Array:");
            printArray(inputArray);
            quickSort.sort();
            System.out.println("\nSorted array:");
            printArray(inputArray);
        }
    
        private static void printArray(int[] array) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    

