//回文数
class Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int res = 0;
        int ret = x;
        while(ret!=0) {
            //每次取末尾数字
            int tmp = ret%10;
            res = res*10 + tmp;
            ret /= 10;
        }
         return res == x;
    }
}