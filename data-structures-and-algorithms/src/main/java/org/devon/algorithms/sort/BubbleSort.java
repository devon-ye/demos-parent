package org.devon.algorithms.sort;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/4 23:29
 * @since 1.0.0
 */
public class BubbleSort extends AbstractSort implements Sort {

    public static <T> T[] sort(T[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 0, length = array.length - 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (less(array[j], array[j + 1])) {
                    exch(array, j + 1, j);
                }
            }
        }
        return array;
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[index] != nums[i]){
                nums[index+1] = nums[i];
            }
        }
        return index+1;
    }

    public int removeDuplicates2(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        int index = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[index]){
                index++;
                nums[index] = nums[i];
            }
        }

        return index+1;

    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,2});
    }
}
