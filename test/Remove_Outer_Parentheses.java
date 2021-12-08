/**
 * 题目：1021. 删除最外层的括号
 * 时间：12-8
 * 算法：遍历，利用level来筛选外层
 */





class Remove_Outer_Parentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : s.toCharArray()){
            if (c == ')'){
                level--;
            }
            //忽略最外层的（
            if (level>=1) {
                //将除外层的括号加入sb
                sb.append(c);
            }
            if (c =='('){
                level++;
            }
        }
        return sb.toString();
    }
}
