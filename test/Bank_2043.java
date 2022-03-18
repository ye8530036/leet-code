/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */

/**
 * 题目：2043. 简易银行系统
 * 你的任务是为一个很受欢迎的银行设计一款程序，以自动化执行所有传入的交易（转账，存款和取款）。
 * 银行共有 n 个账户，编号从 1 到 n 。
 * 每个账号的初始余额存储在一个下标从 0 开始的整数数组 balance中，其中第 (i + 1) 个账户的初始余额是 balance[i] 。
 * 请你执行所有 有效的 交易。如果满足下面全部条件，则交易 有效 ：
 * 指定的账户数量在 1 和 n 之间，且取款或者转账需要的钱的总数 小于或者等于 账户余额。
 * 时间：3-18
 */


class Bank_2043 {
    long[] val;
    boolean check(int a){
        return a>=1 && a<= val.length;
    }
    public void Bank(long[] balance) {
        val = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!check(account1) || !check(account2)){
            return false;
        }
        if (val[account1-1]>=money){
             val[account1-1]-=money;
             val[account2-1]+=money;
             return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (!check(account)) return false;
        val[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!check(account)) return false;
        if (val[account-1] >= money){
            val[account-1] -=money;
            return true;
        }
        return false;
    }
}
