/**
 * 题目：2055. 蜡烛之间的盘子
 * 时间：2022-3-8
 * 算法：前缀和+二分
 */

class PlatesBetweenCandles_2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        //将字符串s放入数组
        char [] cs = s.toCharArray();
        //记录数组长度，以及queries长度
        int n = cs.length,m = queries.length;
        //定义left和right为二分做准备
        int[] l = new int[n],r = new int[n];
        int[] sum =new int[n+1];
        //从前往后的扫描，将所有的蜡烛下标添加到数组
        for (int i=0,j=n-1,p=-1,q=-1;i<n;i++,j--){
            if (cs[i]=='|'){
                p=i;
            }
            if (cs[j]=='|'){
                q=j;
            }
            //p,q为预处理的左右蜡烛下标
            l[i] = p;
            r[j] = q;
            //所有预处理的蜡烛中盘子数量
            sum[i+1] = sum[i]+(cs[i]=='*'? 1:0);
        }
        int[] ans = new int[m];
        for (int i=0;i<m;i++){
            //定义二维数组
            int a = queries[i][0],b = queries[i][1];
            //找到区间 [a, b] 两边缘的蜡烛，分别记为 c 和 d
            int c = r[a],d = l[b];
            //统计盘子的数量
            if (c !=-1 && c<=d){
                ans[i]=sum[d+1]-sum[c];
            }
        }
        return ans;
    }
}
