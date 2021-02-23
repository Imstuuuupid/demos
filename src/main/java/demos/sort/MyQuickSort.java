package demos.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 自己写快排
 * @author xzx
 * @date 2021/02/23 09/49
 */
public class MyQuickSort {

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 7, 8};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()).toString());
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = getPivot(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    public int getPivot(int[] nums, int start, int end) {
        int pivot = nums[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low <= high && nums[high] >= pivot) {
                high--;
            }
            while (low <= high && nums[low] <= pivot) {
                low++;
            }
            if (low < high) {
                swap(nums, low, high);
            }
        }
        swap(nums, start, high);
        return high;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
