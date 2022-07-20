import java.util.ArrayList;
import java.util.List;

/**
 * 题目：1260. 二维网格迁移
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * 由于迁移过程存在明显规律性，因此我们可以直接 O(1) 算得每一列最终所在的列下标 tcol = (i + k) % m（其中 i 为原本的列下标）
 * 同时 O(1) 算得当前列的首行元素在新列中的行下标 trow = ((i + k) / m) % n，之后就是简单的遍历赋值操作。
 *
 */

public class ShiftGrid_1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //n行m列
        int n = grid.length, m = grid[0].length;
        int[][] mat = new int[n][m];
        for (int i=0;i<m;i++){
            //迁移规则
            int tcol = (i + k) % m, trow = ((i + k)/ m) % n,idx = 0;
            while (idx != n)
                mat[(trow++) % n ][tcol] = grid[idx++][i];
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0;i<n;i++){
            //迁移
            List<Integer> list = new ArrayList<>();
            for (int j=0;j<m;j++){
                list.add(mat[i][j]);
            }
            //得到新的二维网格
            ans.add(list);
        }
        return ans;
    }
}
