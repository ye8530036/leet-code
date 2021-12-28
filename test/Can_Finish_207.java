/**
 * 题目：207.课程表
 * 时间：12-5
 * 思路：BFS（广度优先）
 * 将图的问题转换成哈希表，以及邻接矩阵的方法
 */

import java.util.*;

class Can_Finish_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       //课号和对应的入度，利用哈希表记录即
        //key：课号
        //value：依赖这门课的后续课（数组）
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        //依赖关系, 依赖当前课程的后序课程
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // 初始化入度和依赖关系
        for (int[] relate : prerequisites) {
            int cur = relate[1];
            int next = relate[0];
            //更新入度
            inDegree.put(next, inDegree.get(next) + 1);
            //当前节点的邻接表
            if (!adj.containsKey(cur)) {
                adj.put(cur, new ArrayList<>());
            }
            adj.get(cur).add(next);
        }
        //BFS主体将入度为0的课程放入队列, 队列中的课程就是没有先修, 可以学的课程
        Queue<Integer> q = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                q.offer(key);
            }
        }
        // 取出一个节点, 对应学习这门课程.
        // 遍历当前邻接表, 更新其入度; 更新之后查看入度, 如果为0, 加入到队列
        while (!q.isEmpty()) {
            int cur = q.poll();
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(cur)) {
                continue;
            }

            List<Integer> successorList = adj.get(cur);

            for (int k : successorList) {
                inDegree.put(k, inDegree.get(k) - 1);
                if (inDegree.get(k) == 0) {
                    q.offer(k);
                }
            }
        }
        //遍历入队, 如果还有课程的入度不为0, 返回fasle
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}
