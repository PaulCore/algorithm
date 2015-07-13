package my.algorithm.sort;

import java.util.Arrays;

/**
 * Created by paul on 2015/7/13.
 */
public class QuickSort {
    public static void sort(int[] a, int low, int high){
        if (low < high){
            int pick = a[low];
            int left = low;
            int right = high;
            while (left < right){
                while (left < right && a[right] >= pick)
                    right -- ;
                if (left <right)
                    a[left++] = a[right];
                while (left < right && a[left] <= pick)
                    left++;
                if (left < right)
                    a[right--] = a[left];
            }
            a[left] = pick;
            sort(a,low,right-1);
            sort(a,right+1,high);
        }
    }
    public static void main(String[] args) {
        int[] a ={49,38,65,97,76,13,27,49};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
