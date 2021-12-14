/**
 * 题目：941. 有效的山脉数组
 * 时间：12-14
 * 算法：线性扫描
 * 按照题意要求一次扫描数组，按要求返回
 */


class Valid_Mountain_Array {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        //递增到山顶跳出
        while (i+1<n && arr[i]<arr[i+1]){
            i++;
        }
        //山峰不能在头或者尾
        if (i==0 || i == n-1){
            return false;
        }
        //从山顶开始递减
        while (i+1 < n && arr[i]>arr[i+1]){
            i++;
        }
        //如果顺利i为数组长度
        return i==n-1;
    }
}
