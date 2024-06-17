// iterative 
import java.util.Stack;

public class QuickSort2 {
    private int[] array;

    public QuickSort2(int[] array) {
        this.array = array;
    }

    public void sort() {
        quickSort(0, array.length - 1);
    }

    private void quickSort(int p, int q) {
        Stack<Integer> stack = new Stack<>();

        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()) {
            q = stack.pop();
            p = stack.pop();

            while (p < q) {
                int j = partition(p, q);

                if ((j - p) < (q - j)) {
                    stack.push(j + 1);
                    stack.push(q);
                    q = j - 1;
                } else {
                    stack.push(p);
                    stack.push(j - 1);
                    p = j + 1;
                }
            }
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
        int[] inputArray = {122, 11, 133, 55, 99, 1};
        QuickSort2 quickSort = new QuickSort2(inputArray);
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
