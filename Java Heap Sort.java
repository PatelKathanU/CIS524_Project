// Java Implementation of Heap Sort to sort Student objects by score
import java.util.Arrays;

// Define a Student class
class Student {
    String name;
    int score;

    // Constructor
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Override toString
    public String toString() {
        return name + ": " + score;
    }
}

// Main Class for Heap Sort
public class HeapSortJava {
    
    // Utility function to swap two elements
    private static void swap(Student[] arr, int i, int j) {
        Student temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to maintain the max-heap property
    private static void heapify(Student[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than the root
        if (left < n && arr[left].score > arr[largest].score) {
            largest = left;
        }

        // If right child is greater than the current largest
        if (right < n && arr[right].score > arr[largest].score) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);  //Swap root with largest
            heapify(arr, n, largest);  // Recursively heapify the affected sub-tree
        }
    }

    // Main heap sort function
    public static void heapSort(Student[] arr) {
        int n = arr.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);           // Move current root to end
            heapify(arr, i, 0);        // Heapify the reduced heap
        }
    }

    // MAin method to test heap sort
    public static void main(String[] args) {
        // Create an array of Student Object
        Student[] students = {
            new Student("Kathan", 95),
            new Student("Jaishil", 85),
            new Student("Preet", 88),
            new Student("Harsh", 72),
            new Student("Saurin", 85)
        };

        // Call heapSort function
        heapSort(students);

        // Print Sorted Array
        System.out.println("Sorted students by score:");
        System.out.println(Arrays.toString(students));
    }
}
