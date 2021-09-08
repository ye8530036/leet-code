import java.util.Deque;
import java.util.LinkedList;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
 * 9-8
 * push(x)  —— 将元素 x 推入栈中。
 * pop()    —— 删除栈顶的元素。
 * top()    —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 */

class MinStack {
    Deque<Integer> aStack;
    Deque<Integer> minStack;

    public MinStack(){
        aStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);

    }
    public void push(int a){
        aStack.push(a);
        minStack.push(Math.min(minStack.peek(),a));
    }

    public void pop() {
        aStack.pop();
        minStack.pop();
    }

    public int top() {
        return aStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
