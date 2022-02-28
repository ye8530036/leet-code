import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 题目：1654. 到家的最少跳跃次数
 * 它可以 往前 跳恰好 a个位置（即往右跳）。
 * 它可以 往后跳恰好 b个位置（即往左跳）。
 * 它不能 连续 往后跳 2 次。
 * 它不能跳到任何forbidden数组中的位置。
 * 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
 * 算法：BFS
 * layer记录当前跳数
 * visited保存的状态是(当前位置,当前向后跳的次数)。
 */


class MinimumJumps_1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        final int LIMIT = 8000;
        boolean[][] visited = new boolean[8001][2];
        Set<Integer> forbid = new HashSet<>(forbidden.length);
        for(int i:forbidden){
            forbid.add(i);
        }
        Deque<int []> q =new LinkedList<>();//当前位置, 向后跳次数
        q.offer(new int[]{0,0});
        int layer = -1;
        while (!q.isEmpty()){
            int qs =q.size();
            layer++;
            for (int i=0;i<qs;i++){
                int[] p = q.poll();
                int cur = p[0],backwardCount = p[1];
                if (cur == x){
                    return layer;
                }
                if (visited[cur][backwardCount]){
                    continue;
                }
                visited[cur][backwardCount] = true;
                if (cur + a <=LIMIT &&!forbid.contains(cur+a)){
                    q.offer(new int[]{cur+a,0});
                }
                if (cur-b>=0 && backwardCount<1 &&!forbid.contains(cur-b)){
                    q.offer(new int[]{cur-b,backwardCount+1});
                }
            }
        }
        return -1;
    }
}
