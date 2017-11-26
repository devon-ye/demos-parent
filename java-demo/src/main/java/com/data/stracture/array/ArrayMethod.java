package com.data.stracture.array;

public class ArrayMethod {

    public static void main(String[] args) {
        int arr[] = {3, 6, 7, 3, 1, 9, 2, 0, 3};
        int minNum = minNum(arr);
        System.out.println("rssult minNum=" +minNum);
    }

    public static int minNum(int arr[]) {
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int maxNum(int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


}
