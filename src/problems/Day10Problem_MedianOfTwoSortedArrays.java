package problems;

public class Day10Problem_MedianOfTwoSortedArrays {
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n3 = n1 + n2;
/*
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                arr3[k++] = nums1[i++];
            } else {
                arr3[k++] = nums2[j++];
            }
        }

        while (i < n1) {
            arr3[k++] = nums1[i++];
        }

        while (j < n2) {
            arr3[k++] = nums2[j++];
        }

        System.out.println(Arrays.toString(arr3));

        if (n3 % 2 == 0) {
            System.out.println("Even");
            System.out.println(arr3[n3 / 2]);
            System.out.println(arr3[(n3 / 2) - 1]);
//            System.out.println(arr3[n3 / 2] + arr3[(n3 / 2) - 1]);
            return (double) (arr3[n3 / 2] + arr3[(n3 / 2) - 1]) / 2.0;
        }
        System.out.println("Odd");
        return (arr3[n3 / 2]);
*/
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

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 7, 10, 12};
        int[] arr2 = {2, 3, 6, 15};
        double res = findMedianSortedArrays(arr1, arr2);
        System.out.println(res);
    }
}
