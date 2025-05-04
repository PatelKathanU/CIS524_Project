// JavaScript implementation of Heap Sort to sort student records by score

// Create an array of Student objects
const students = [
    { name: "Kathan", score: 95 },
    { name: "Jaishil", score: 85 },
    { name: "Preet", score: 87 },
    { name: "Harsh", score: 72 },
    { name: "Saurin", score: 85 },
  ];
  
  // Utility function to swap two elememts
  const swap = (arr, i, j) => {
    [arr[i], arr[j]] = [arr[j], arr[i]];
  };
  
  // Function to maintain max-heap property
  function heapify(arr, n, i) {
    let largest = i;
    const left = 2 * i + 1;
    const right = 2 * i + 2;

    // If left child is larger than the root
    if (left < n && arr[left].score > arr[largest].score) {
      largest = left;
    }

    // If right child is larger than the current largest
    if (right < n && arr[right].score > arr[largest].score) {
      largest = right;
    }

    // If largest is not root
    if (largest !== i) {
      swap(arr, i, largest);    // Swap root with the largest
      heapify(arr, n, largest); // Recursively heapify the subtree
    }
  }
  
  // Heap sort function
  function heapSort(arr) {
    const n = arr.length;
  
    // Build a max heap
    for (let i = Math.floor(n / 2 - 1); i >= 0; i--) {
      heapify(arr, n, i);
    }
  
    // Extract elements one by one
    for (let i = n - 1; i > 0; i--) {
      swap(arr, 0, i);  // Move currrnet root to end
      heapify(arr, i, 0); // Heapify the reduced heap
    }
  
    // Return sorted array
    return arr;
  }
  
  // Print the sorted array
  console.log("Sorted students by score:");
  console.log(heapSort(students));
  