// Time Complexity : O(nlogn)

// Space Complexity : O(logn) - depth of stack

// Did this code successfully run on Leetcode : yes

// Any problem you faced while coding this : No

class IterativeQuickSort { 
    void swap(int arr[], int i, int j) 
    { 
	//Try swapping without extra variable 
        if (arr[i] != arr[j]) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        //Compare elements and swap.
        int pivot = arr[h];
        int i = l - 1;
        for(int j = l; j <= h - 1; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, h);
        return i + 1;
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        //Try using Stack Data Structure to remove recursion.
        Stack<Integer> stack = new Stack();
        stack.push(l);
        stack.push(h);

        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();
            // run partition function to generate the index to split.
            int j = partition(arr, low, high);

            // split the array on the left and right side of the partition satisfying the
            // greater than and less than condition for split.
            if (j - 1 > low) {
                stack.push(low);
                stack.push(j - 1);

            }
            if (j + 1 < high) {
                stack.push(j + 1);
                stack.push(high);
            }
        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 