package demos.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 冒泡排序
 * @author xzx
 * @date 2021/02/23 09/57
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {1,5,2,3,6};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }


    public void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}
