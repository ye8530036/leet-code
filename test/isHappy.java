/**
 * 开心数
 * 9-14
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为 1，那么这个数就是快乐数。
 * 如果n是快乐数就返回 true ；不是，则返回 false 。
 * 示例：
 * 输入：19
 * 输出：true
 * 解释：
 * 1² + 9² = 82
 * 8² + 2² = 68
 * 6² + 8²= 100
 * 1² + 0² + 0²= 1
 * 思路：快慢指针（龟兔赛跑）
 * 我们不是只跟踪链表中的一个值，而是跟踪两个值，称为快跑者和慢跑者。在算法的每一步中，慢速在链表中前进 1 个节点，快跑者前进 2 个节点（对 getNext(n) 函数的嵌套调用）。
 * 如果 n 是一个快乐数，即没有循环，那么快跑者最终会比慢跑者先到达数字 1。
 * 如果 n 不是一个快乐的数字，那么最终快跑者和慢跑者将在同一个数字上相遇。
 */

public class isHappy {
    public int getNext(int n){
        int sum = 0;
        while(n>0){
            int a = n % 10;
            n = n / 10;
            sum += a*a;
        }
        return sum;
    }
    public boolean IsHappy(int n) {
        //乌龟跑1格
        int slow=n;
        //兔子跑2格
        int fast=getNext(n);
        while(fast != 1 && slow != fast){
            slow=getNext(slow);
            fast =getNext(getNext(fast));
        }
        return fast == 1;
    }
}
