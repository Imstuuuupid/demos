package demos.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 快排
 * 平均时间复杂度和最好时间复杂度均为 O(nlogn）
 * 当元素基本有序时的最坏时间复杂度为O(n²)，空间复杂度为 O(logn)
 * @author xzx
 * @date 2021/02/06 13/37
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 3, 8, 23, 41, 1, 5, 9};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }


    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivotIndex = getPivotIndex(nums, start, end);
            quickSort(nums, start, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, end);
        }
    }

    public int getPivotIndex(int[] nums, int start, int end) {
        int pivot = nums[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low <= high && nums[low] <= pivot) {
                low++;
            }
            while (low <= high && nums[high] > pivot) {
                high--;
            }
            if (low < high) {
                swap(nums, low, high);
            }
        }
        swap(nums, start, high);
        return high;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}
