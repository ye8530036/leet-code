import java.util.Arrays;
import java.util.List;
/**
 * 杨辉三角
 * ８-6
 * 算法:滚动数组优化动态规划
 * 给定一个非负整数 numRows，生成「杨辉三角」的第 numRows 行数据。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 思路及算法:
 *
 * 公式:C(i, j) = C(i - 1, j - 1) + C(i - 1, j)
 *
 * 每个数字等于上一行的左右两个数字之和，可用此性质写出整个杨辉三角。即第 n 行的第 i 个数等于第 n-1 行的第 i-1 个数和第 i 个数之和。这也是组合数的性质之一
 *
 *
 *
 **/


class Pascal_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        Integer[] db = new Integer[rowIndex+1];
        //填充db数组中的每个元素都是1
        Arrays.fill(db,1);
        for (int i=2;i<db.length;i++)
        {
            //每一行的dp[i]是取决于上一行的 j 位置和 j-1 位置,所以要倒着更新
            for (int j=i-1;j>0;j--)
            {
                db[j] = db[j]+db[j-1];
            }
        }
        List<Integer> res = Arrays.asList(db);
        return res;
    }
}
