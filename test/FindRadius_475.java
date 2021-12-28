/**
 * 题目：475，供暖器
 * 时间：12-20
 * 思路：二分优化这里要从房子位置和供暖器位置的差值的绝对值中选择半径的话，就要用到极小化极大的思想
 * 即每次选定一座房屋，然后找出离它最近的供暖器的位置，这个就是可以给它供暖的最小半径。
 * 对于每一座房屋，都这样选择，就可以获得若干个极小化半径。
 * 从这几个极小化半径中选择一个最大的半径，就可以给所有的房子供暖了
 */


import java.util.Arrays;

class FindRadius_475 {
    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        //排序
        Arrays.sort(heaters);
        for (int i=0;i<houses.length;++i){
            if (i>0 && houses[i]==houses[i-1]){
                continue;
            }
            int l=0,r = heaters.length-1;
            //二分查找找到极小化半径
            while (l<=r){
                int mid = l+((r-l)>>1);
                if (heaters[mid] >=houses[i]){
                   r = mid - 1;
                }else {
                   l = mid + 1;
                }
            }
            //极小化极大
            int min = 0;
            if (l>=heaters.length){
                min = houses[i] - heaters[l-1];
            }else if (l==0){
                min = heaters[l] - houses[i];
            }else {
                min = Math.min(heaters[l] - houses[i],houses[i] - heaters[l-1]);
            }
            res = Math.max(res,min);
        }
        return res;
    }
}
