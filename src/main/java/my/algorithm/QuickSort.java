package my.algorithm;

import java.util.Arrays;

/**
 * Created by paul on 2015/7/6.
 */
public class QuickSort {
    public static void sort(int[] a, int low, int high){
        int piv = a[low];
        int i = low, j = high;
        if (low < high){
            while (i < j ){
            while (i < j && a[j] >= piv)
                j--;
            if (i < j)
                a[i++] = a[j];
            while (i < j && a[i] <= piv)
                i++;
            if (i < j)
                a[j--] = a[i];
        }
        a[i] = piv;
        sort(a,low,i-1);
//        sort(a,i+1,high);
        }

    }

    public static void main(String[] args) {
        int[] a ={49,38,65,97,76,13,27,49};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
