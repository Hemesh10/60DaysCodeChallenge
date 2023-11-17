package problems;

// K-th Element of Two Sorted Arrays

/*
   Given two Arraylist 'arr1' and 'arr2' of size 'n' and 'm' respectively and an element 'k'. Find
   the element that would be at the Kth position of the combined sorted array. Position 'k' is given
   according to 1-based indexing, but arraylist 'arr1' and 'arr2' are using 0-based indexing.
*/

import java.util.ArrayList;

public class Day11Problem_KthElementOfTwoSortedArrays {
     static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
         if (n > m) return kthElement(arr2, arr1, arr2.size(), arr1.size(), k);
         int i = 0, j = 0, counter = 1;
         int element = Integer.MIN_VALUE;

         System.out.println(arr1 + ", " + n);
         System.out.println(arr2 + ", " + m);

         while (i < n && j < m) {
            if (arr1.get(i) < arr2.get(j)) {
                if (counter == k) {
                    element = arr1.get(i);
                    break;
                }
                counter++;
                i++;
            } else {
                if (counter == k) {
                    element = arr2.get(j);
                    break;
                }
                counter++;
                j++;
            }
         }
         while (i < n) {
             if (element != Integer.MIN_VALUE) break;
             if (counter == k) {
                 element = arr1.get(i);
                 break;
             }
             counter++;
             i++;
         }
         while (j < n) {
             if (element != Integer.MIN_VALUE) break;
             if (counter == k) {
                 element = arr2.get(j);
                 break;
             }
             counter++;
             j++;
         }

        return element;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add(3);
        arr1.add(6);
        arr1.add(7);
        arr1.add(9);

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(4);
        arr2.add(8);
        arr2.add(10);

        int k = 4;

        int res = kthElement(arr1, arr2, arr1.size(), arr2.size(), k);
        System.out.println(res);
    }
}
