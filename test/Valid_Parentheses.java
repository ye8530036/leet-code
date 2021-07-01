import java.util.*;

//有效的括号
// 7-1
class Valid_Parentheses {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);// 顺序读取字符
            if (pairs.containsKey(ch)) { //(containsKey方法——判断是否包含指定的键名)判断ch是右括号
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {// 取其对应的左括号直接和栈顶比如果不同&&栈为空
                    return false; // 直接返回
                }
                stack.pop(); // 相同则抵消，出栈
            } else {
                stack.push(ch); // 左括号，直接入栈
            }
        }
        return stack.isEmpty();// 看左右是否抵消完


    }
}
//取巧做法
//class Valid_Parentheses {
//    public boolean isValid(String s) {
//        int length = s.length() / 2;
//        for (int i = 0; i < length; i++) {
//            s = s.replace("()", "").replace("{}", "").replace("[]", "");
//        }
//
//        return s.length() == 0;
//    }
//}