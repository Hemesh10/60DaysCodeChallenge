package problems;

import java.util.ArrayList;
import java.util.List;

public class Day22Problem_AddToArrayFormOfInteger {
    static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        int i = num.length - 1;

        while (k != 0) {
            int digit = k % 10;
            int value;
            if (i >= 0) {
                value = num[i] + digit + carry;
                num[i] = -1;
                i--;
            } else {
                value = digit + carry;
            }
            res.add(value % 10);
            carry = value / 10;
            k = k / 10;
        }

        while (carry != 0) {
            int digit;
            if (i >= 0) {
                digit = num[i] + carry;
                i--;
            } else {
                digit = carry;
            }
            res.add(digit % 10);
            carry = digit / 10;
        }

        for (int j = i ; j >= 0 ; j--) {
            res.add(num[j]);
        }

//        res = res.reversed();

        int low = 0, high = res.size() - 1;
        while (low < high) {
            int temp = res.get(low);
            res.set(low, res.get(high));
            res.set(high, temp);
            low++;
            high--;
        }

        return res;
    }
    public static void main(String[] args) {
        int[] num = {9, 9, 9};
        int k = 1;

        List<Integer> res = addToArrayForm(num, k);
        System.out.println(res);
    }
}
