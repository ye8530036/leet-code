/**
 * 寻找两个正序数组的中位数
 * 10-29
 * 方法：二分法遍历 组合 数学公式来寻找中位数
 * 难度：困难
 * 思路：首先我们使用一个小trick，我们分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可，这对奇偶数均适用。
 * 加入 m+n 为奇数的话，那么其实 (m+n+1) / 2 和 (m+n+2) / 2 的值相等，相当于两个相同的数字相加再除以2，还是其本身。
 * 来找出中位数。
 * 寻找的方法我们使用二分法来遍历这两个数组。
 * 时间复杂度：O(log (m+n))【规定了时间复杂度】
 */
class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left  = (m+n+1)/2;
        int right = (m+n+2)/2;
        return (findktn(nums1,0,nums2,0,left)+findktn(nums1,0,nums2,0,right))/2.0;
    }
    //i,j分别用来标记nums1和nums2的起始位置
    public int findktn(int[] nums1,int i,int[] nums2,int j,int k){
        //nums1为空数组
        if (i>= nums1.length){
            return nums2[j+k-1];
        }
        //nums2为空数组
        if (j>= nums2.length){
            return nums1[i+k-1];
        }
        if (k == 1){
            return Math.min(nums1[i],nums2[j]);
        }
        //二分法寻找中位数
        int midval1 = (i + k/2 - 1 < nums1.length) ? nums1[i+k/2-1] : Integer.MAX_VALUE;
        int midval2 = (j + k/2 - 1 < nums2.length) ? nums2[j+k/2-1] : Integer.MAX_VALUE;
        if (midval1<midval2){
            return findktn(nums1,i+k/2,nums2,j,k-k/2);
        }
        else {
            return findktn(nums1,i,nums2,j+k/2,k-k/2);
        }
    }
}
