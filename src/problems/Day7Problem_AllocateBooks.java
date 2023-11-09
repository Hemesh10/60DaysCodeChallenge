package problems;

// Allocate Books
/*
 Given an ArrayList 'arr' of integer numbers where, arr[i] represents the number of pages in the ‘i-th’ book.
 There are 'm' number of students, and the task is to allocate all the books to the students.

 Allocate books in such a way that:
 1. Each student gets at least one book.
 2. Each book should be allocated to only one student.
 3. Book allocation should be in a contiguous manner.

 You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student
 is minimum. If the allocation of the books is not possible, return -1
*/


import java.util.ArrayList;
public class Day7Problem_AllocateBooks {
    static int[] getMaximumAndSummation(ArrayList<Integer> arr) {
        int max = arr.get(0);
        int sum = 0;
        for (int i : arr) {
            sum += i;
            if (i > max) {
                max = i;
            }
        }
        return new int[]{max, sum};
    }

    static int studentsAllocated(ArrayList<Integer> arr, int pages) {
        int students = 1, booksPages = 0;
        for (int k = 0 ; k < arr.size() ; k++) {
            if (booksPages + arr.get(k) <= pages) {
                booksPages += arr.get(k);
            } else {
                students++;
                booksPages = arr.get(k);
            }
        }
        return students;
    }

    static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) return -1;
        int[] highAndSummation = getMaximumAndSummation(arr);
        int low = highAndSummation[0], high = highAndSummation[1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (studentsAllocated(arr, mid) <= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        // Test Case 1:
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(25);
        arr.add(46);
        arr.add(28);
        arr.add(49);
        arr.add(24);
        int m = 4;

        /*
         Test Case 2:
         ArrayList<Integer> arr = new ArrayList<>();
         arr.add(1);
         arr.add(17);
         arr.add(14);
         arr.add(9);
         arr.add(15);
         arr.add(9);
         arr.add(14);
         int m = 7;
        */

        /*
         Test Case 3:
         ArrayList<Integer> arr = new ArrayList<>();
         arr.add(8);
         arr.add(15);
         arr.add(3);
         int m = 2;
        */

        int res = findPages(arr, arr.size(), m);
        System.out.println(res);
    }
}
