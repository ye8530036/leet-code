/**
 * 题目：2022. 将一维数组转变成二维数组
 * 时间：1-1
 * 思路：首先计算数组数量是否满足m*n不满足返回空数组
 * 再将数组循环遍历每n个复制放入新二维数组中
 */


class Construct2DArray_2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m*n){
            return new int[0][];
        }
        int[][] ans = new int[m][n];
        for (int i=0;i< original.length;i++){
            System.arraycopy(original,i,ans[i/n],0,n);
        }
        return ans;
    }
}
