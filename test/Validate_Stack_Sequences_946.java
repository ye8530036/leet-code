import java.util.Stack;

/**
 * 题目：验证栈序列_946
 * 时间：3-16
 * 算法：贪心
 */
class Validate_Stack_Sequences_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int j=0;
        for (int x:pushed){
            //将pushed队列中的元素逐个push到栈中
            stack.push(x);
            //并检测该元素是不是下一个要pop出来的元素
            //如果是就pop出来
            while (j<N &&!stack.isEmpty() &&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        //最后检测是否所有元素都被pop出栈了
        return j==N;
    }
}
