package my.algorithm.sort;

import java.util.Arrays;

/**
 * Created by paul on 2015/7/7.
 */
public class ShellSort {
    public static void sort(int[] a, int n){
        for (int gap = n; gap > 0;gap /= 2){
            for (int i = gap ; i < a.length; i++){
                int data = a[i];
                int j = i - gap;
                while (j >= 0 && data < a[j]){
                    a[j+gap] = a[j];
                    j = j - gap;
                }
                a[j+gap] = data;

            }
        }
    }

    public static void main(String[] args) {
        int[] a ={49,38,65,97,76,13,27,49};
        sort(a,5);
        System.out.println(Arrays.toString(a));
    }
}
