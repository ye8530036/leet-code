/**
 * 题目：面试题 10.03. 搜索旋转数组
 * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * 输出: 8（元素5在该数组中的索引）
 * 算法：二分
 * 时间：2022-3-9
 */


class search_LCCI_10_03 {
    public int search(int[] arr, int target) {
        if (arr[0]==target){
            return 0;
        }
        //设定左右边界及中间量
        int l = 0;
        int r = arr.length-1;
        int mid = 0;
        while (l<=r){
            //二分,恰好中间就等于所需值
            mid = l+(r-l)/2;
            if (arr[mid]==target){
                while (mid>0&&arr[mid-1]==arr[mid]){
                  mid--;
                }
                return mid;
            }
            //target在[mid,r]
            if (arr[mid]<arr[r]){
                if (arr[mid]<target&&target<=arr[r]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
            //target在[l,mid]
            else if (arr[mid]>arr[r]){
                if (arr[l]<target&&target<=arr[mid]){
                    r=mid-1;
                }
                else {
                    l=mid+1;
                }
            }
            //arr[mid]==arr[r]说明要么r~0~mid都相等，要么mid~r都相等，无论哪种r 都可以舍去
            else {
                r--;
            }
        }
        return -1;
    }
}
