/**
 * 合并两个有序数组
 * 7-23
 * 快排
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 *
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 */


import java.lang.reflect.Array;
import java.util.Arrays;

class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //循环合并两数组
        for (int i = 0; i != n; ++i)
        {
            nums1[m + i] = nums2[i];
        }
        //排序
        Arrays.sort(nums1);
    }
    /**
     *
     * 双指针
     *
     */
    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m-1;
        int len2 = n-1;
        int len  = m+n-1;
        while (len1>=0&&len2>=0){
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = nums1[len1]>nums2[len2] ? nums1[len1--] :nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2,0,nums1,0,len2 +1);
    }


}

