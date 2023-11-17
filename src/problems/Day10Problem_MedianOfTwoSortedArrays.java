package problems;

// Median of Two Sorted Arrays

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//The overall run time complexity should be O(log (m+n)).

public class Day10Problem_MedianOfTwoSortedArrays {

/*  Brute Force and Optimal Solution :-
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n3 = n1 + n2;

--->    Brute Force Solution
//      int i = 0, j = 0, k = 0;
//      int[] arr3 = new int[n3];
//      while (i < n1 && j < n2) {
//          if (nums1[i] <= nums2[j]) {
//              arr3[k++] = nums1[i++];
//          } else {
//              arr3[k++] = nums2[j++];
//          }
//      }
//      while (i < n1) {
//          arr3[k++] = nums1[i++];
//      }
//      while (j < n2) {
//          arr3[k++] = nums2[j++];
//      }
//      System.out.println(Arrays.toString(arr3));
//      if (n3 % 2 == 0) {
//          System.out.println("Even");
//          System.out.println(arr3[n3 / 2]);
//          System.out.println(arr3[(n3 / 2) - 1]);
//          System.out.println(arr3[n3 / 2] + arr3[(n3 / 2) - 1]);
//          return (double) (arr3[n3 / 2] + arr3[(n3 / 2) - 1]) / 2.0;
//      }
//      System.out.println("Odd");
//      return (arr3[n3 / 2]);



--->    Optimized solution (space complexity) :-
        int index2 = n3 / 2;
        int index1 = index2 - 1;
        int counter = 0, i = 0, j = 0;
        int index1elem = Integer.MIN_VALUE, index2elem = Integer.MIN_VALUE;

        while (i < n1 && j < n2 ) {
            if (index1elem != Integer.MIN_VALUE && index2elem != Integer.MIN_VALUE) break;
            if (nums1[i] < nums2[j]) {
                if (counter == index1) index1elem = nums1[i];
                if (counter == index2) index2elem = nums1[i];
                counter++;
                i++;
            } else {
                if (counter == index1) index1elem = nums2[j];
                if (counter == index2) index2elem = nums2[j];
                counter++;
                j++;
            }
        }

        while (i < n1) {
            if (index1elem != Integer.MIN_VALUE && index2elem != Integer.MIN_VALUE) break;
            if (counter == index1) index1elem = nums1[i];
            if (counter == index2) index2elem = nums1[i];
            i++;
            counter++;
        }

        while (j < n2) {
            if (index1elem != Integer.MIN_VALUE && index2elem != Integer.MIN_VALUE) break;
            if (counter == index1) index1elem = nums2[j];
            if (counter == index2) index2elem = nums2[j];
            j++;
            counter++;
        }

        if (n3 % 2 == 0) {
            return (double) (index1elem + index2elem) / 2;
        }
        return index2elem;
    }
*/

// Optimized Solution (for both space and time complexity) :-
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1); // taking smaller sized array for bs for better time complexity

        int n = n1 + n2;
        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 0) { // even number of elements. So no specific median rather two medians in the middle
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0.0; //dummy return statement
    }

    public static void main(String[] args) {
        // Input Case 01:
        int[] arr1 = {1, 3, 4, 7, 10, 12};
        int[] arr2 = {2, 3, 6, 15};

        // Input Case 02:
        // int[] arr1 = {1, 3};
        // int[] arr2 = {2};

        // Input Case 03:
        // int[] arr1 = {1, 2};
        // int[] arr2 = {3, 4};

        double res = findMedianSortedArrays(arr1, arr2);
        System.out.println(res);
    }
}
