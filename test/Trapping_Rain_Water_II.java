import java.util.PriorityQueue;
/**
 * 优先队列+从外向内的广度优先搜索
 * 题目：接雨水2
 * 思路；首先分析最外圈的大小，比较一周方块队的高度，先将最外圈最小的出列
 * 在比较留下来的所有数，对比其高度，计算该方格与周边方格相差大小，计算最小差量
 * 最后统计差量值进行统计，则为能接的雨水体积；
 * 类似于广度优先算法；从外到内搜索差值最小的
 */
class Trapping_Rain_Water_II {
    public int trapRainWater(int[][] heightMap) {
        //解决特殊情况
        int r = heightMap.length;
        int c = heightMap[0].length;
        if (r<3 || c<3){
            return 0;
        }
        // 构建pq， 将最外圈放入pq ，优先队列中存放三元组 [x,y,h] 坐标和高度
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[2] -o2[2]));
        // 用一个vis数组来标记这个位置有没有被访问过
        boolean[][] visited = new boolean[r][c];
        // 先把最外一圈放进去
        for (int i=0;i<r;i++){
            for (int j=0;j<c; j++){
                if (i==0||i==r-1||j==0|j==c-1){
                    queue.offer(new int[]{i,j,heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        //循环从pq取出元素，遍历其左上右下结点，如果找到比他小的内部节点，就灌水到等高
        //元素出队，入队内部节点，标记visited
        int res = 0;
        while (!queue.isEmpty()){
            int[] cur =queue.poll();
            // 方向数组，把dx和dy压缩成一维来做
            int[] dir = {-1,0,1,0,-1};
            // 看一下周围四个方向，没访问过的话能不能往里灌水
            for (int i=0;i<4;i++){
                int nx = cur[0]+dir[i];
                int ny = cur[1]+dir[i+1];
                // 如果位置合法且没访问过
                if (nx >=0 && nx<r &&ny >=0 && ny<c && !visited[nx][ny]){
                    int temp = cur[2]-heightMap[nx][ny];
                    // 如果外围这一圈中最小的比当前这个还高，那就说明能往里面灌水啊
                    if (temp>0){
                        res +=temp;
                    }
                    // 如果灌水高度得是你灌水后的高度了，如果没灌水也要取高的
                    queue.offer(new int[]{nx,ny,Math.max(heightMap[nx][ny],cur[2])});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }
}

