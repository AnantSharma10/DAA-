public class MS {
    private int[] array;
    private int[] tempArray;

    public MS(int[] array) {
        this.array = array;
        this.tempArray = new int[array.length];
    }

    public void sort() {
        mergeSort(0, array.length - 1);
    }

    private void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tempArray[i] = array[i];
        }

        int h = low;
        int i = low;
        int j = mid + 1;

        while (h <= mid && j <= high) {
            if (tempArray[h] <= tempArray[j]) {
                array[i] = tempArray[h];
                h++;
            } else {
                array[i] = tempArray[j];
                j++;
            }
            i++;
        }

        while (h <= mid) {
            array[i] = tempArray[h];
            i++;
            h++;
        }

        while (j <= high) {
            array[i] = tempArray[j];
            i++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] inputArray = {12, 11, 13, 5, 6, 7};
        MS mergeSort = new MS(inputArray);
        System.out.println("Given Array:");
        printArray(inputArray);
        mergeSort.sort();
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
