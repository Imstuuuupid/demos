package demos.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 归并排序
 * @author xzx
 * @date 2021/02/23 10/20
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {1, 6, 4, 2, 7, 3, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(nums, start, middle);
            mergeSort(nums, middle + 1, end);
            merge(nums, start, middle, end);
        }
    }

    public void merge(int[] nums, int start, int middle, int end) {
        int[] temp = new int[nums.length];
        int left = start;
        int right = middle + 1;
        int count = start;
        while (left <= middle && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[count++] = nums[left++];
            } else {
                temp[count++] = nums[right++];
            }
        }

        while (left <= middle) {
            temp[count++] = nums[left++];
        }

        while (right <= end) {
            temp[count++] = nums[right++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }


}
