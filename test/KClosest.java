import java.util.Arrays;
import java.util.Random;

/**
 * 最接近原点的 K 个点
 * 9-16
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * 思路：分治
 * 算法：快排
 * 我们定义函数 random_select(left, right, k) 表示划分数组 points 的 [left,right] 区间，并且需要找到其中第 k 个距离最小的点。
 * 在一次划分操作完成后，设 pivot 的下标为 i，即区间 [left,i−1] 中的点的距离都小于等于 pivot，而区间 [i+1,right] 的点的距离都大于pivot。此时会有三种情况：
 * 如果 k = i-left+1，那么说明 pivot 就是第 k 个距离最小的点，我们可以结束整个过程；
 * 如果 k <i−left+1，那么说明第 k个距离最小的点在 pivot 左侧，因此递归调用 random_select(left, i - 1, k)；
 * 如果 k >i−left+1，那么说明第 k个距离最小的点在 pivot 右侧，因此递归调用 random_select(i + 1, right, k - (i - left + 1))。
 *
 *
 */
class KClosest {
    Random rand = new Random();
    public int[][] kClosest(int[][] points, int k) {
        int n =points.length;
        random_select(points,0,n-1,k);
        return Arrays.copyOfRange(points,0,k);
    }
    public void random_select(int[][] points, int left, int right, int k) {
        int pivotId = left +rand.nextInt(right -left+1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points,right,pivotId);
        int i=left -1;
        for (int j = left;j<right;++j){
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist<=pivot){
                ++i;
                swap(points,i,j);
            }
        }
        ++i;
        swap(points,i,right);
        if (k<i-left+1){
            random_select(points,left,i-1,k);
        }
        else if (k>i-left+1){
            random_select(points,i+1,right,k-(i-left+1));
        }
    }
    //将左右调换
    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}
