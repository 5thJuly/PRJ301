
public class Recursion {

    private Recursion left;
    //1)Recursive function to compute the sum of all numbers from 1 to n
    private Recursion right;
    
    int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
    //2) Recursive function to find and return the minimum element in an array:
    int findmin(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        int min = findmin(a, n - 1);
        if (a[n - 1] < min) {
            return a[n - 1];
        } else {
            return min;
        }
    }
    //3) Recursive function to compute and return the sum of all elements in an array
    int findsum(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        return a[n - 1] + findsum(a, n - 1);
    }
    // 4) Recursive function to determine whether an array is a palindrome
    boolean isPalindrome(int a[], int start, int end) {
        if (start >= end) {
            return true;
        }
        if (a[start] != a[end]) {
            return false;
        }
        return isPalindrome(a, start + 1, end - 1);
    }
    // 5) Recursive function for binary search in a sorted array
    int binarySearch(int arr[], int target, int low, int high) {
        if (low > high) {
            return -1;  // Target not found
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;  // Target found at index mid
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, low, mid - 1);  // Search in the left half
        } else {
            return binarySearch(arr, target, mid + 1, high);  // Search in the right half
        }
    }
    // 6) Recursive method for calculating the Greatest Common Divisor (GCD)
    int gcd(int a, int b) {
        if (b == 0) {
            return a;  // Base case: GCD is found
        }
        return gcd(b, a % b);  // Recursively calculate GCD
}
    // 7. Implement the power function recursively
    double power(double x, int n) {
        if (n == 0) {
            return 1; // Base case: any number to the power of 0 is 1
        } else if (n > 0) {
            return x * power(x, n - 1); // Recursive case: multiply x by power(x, n - 1)
        } else {
            return 1 / power(x, -n); // Recursive case: invert x and multiply by power(x, -n)
        }
    }
    // 8. Implement the factorial function recursively as fact
    int fact(int n) {
        if (n == 0) {
            return 1; // Base case: factorial of 0 is 1
        }
        return n * fact(n - 1); // Recursive case: multiply n by factorial of (n - 1)
    }
    //9. Implement Fibonacci recursively as f
    int fib(int n) {
        if (n <= 1) {
           return n; // Base case: Fibonacci of 0 is 0, Fibonacci of 1 is 1
        }
        return fib(n - 1) + fib(n - 2); // Recursive case: sum of previous two Fibonacci numbers
    }
    
    // 10. Write recursive method addReciprocals that takes an integer as a parameter and returns the sum of
    // the first n reciprocals addReciprocals(n) returns (1.0 + 1.0/2.0 + 1.0/3.0 + 1.0/4.0 + ... + 1.0/n)

    double addReciprocals(int n) {
        if (n == 1) {
            return 1.0;
        }
        return 1.0 / n + addReciprocals(n - 1);
    }
    
    // 11. Stirling numbers: A stirling number of the first kind is defined as follows
    //  s(0,0) = 1
    //  s(n,0) = 0, for all n > 0
    //  s(n+1,k) = s(n,k-1) - n*s(n,k), for all n ≥ 0 and k > 0
    
    int stirling(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        } else if (n > 0 && k == 0) {
            return 0;
        } else {
            return stirling(n - 1, k - 1) - n * stirling(n - 1, k);
        }
    }
    
    // 12. Tree height. Given a labeled binary tree (represented by a pointer to a TreeNode) calculate its height.
   Node root;
    
    int treeHeight(Recursion node) {
        if (node == null) {
            return 0; // Base case: Height of an empty tree is 0
        }

        int leftHeight = treeHeight(node.left);
        int rightHeight = treeHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // 13. Tree size. Given a labeled binary tree (represented by a pointer to a TreeNode) calculate its size.
    int treeSize(Node node) {
        if (node == null) {
            return 0; // Base case: Size of an empty tree is 0
        }

        int leftSize = treeSize(node.left);
        int rightSize = treeSize(node.right);

        return 1 + leftSize + rightSize;
    }
}
