/**
 * 题目：506. 相对名次
 * 时间：12-2
 * 算法：排序+数组
 */




import java.util.Arrays;

class Find_Relative_Ranks_506 {
    public String[] findRelativeRanks(int[] score) {
        //记录数组的程度来限制循环
        int n = score.length;
        //赋值一二三名的字符
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        //创建一个二维数组；左边用以记录数组，右边用来当做下标来
        int[][] arr = new int[n][2];
        for (int i=0;i<n;i++){
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        //将二维数组升序排序并下标随之变化
        Arrays.sort(arr,(a,b)->b[0]-a[0]);
        String[] ans = new String[n];
        for (int i=0;i<n;i++){
            if (i>=3){
                ans[arr[i][1]]= Integer.toString(i+1);
            }else{
                ans[arr[i][1]] =desc[i];
            }
        }
        return ans;
    }
}
