/**
 * 从左到右删和从右到左删满足对称性，同样的输入nn，从左到右删完剩下的数和从右到左删完剩下的数满足中心对称
 * 所以 f(n) + f'(n) = n + 1
 *
 * 从左到右删完以后，剩下的数都是偶数，可以统一除二最后返回的数再乘二处理，因为该从右往左删了，故f(n) = 2 * f'(n/2)
 *
 */


class LastRemaining_390 {
    public int lastRemaining(int n) {
        return n==1 ? 1 : 2*(n/2 +1-lastRemaining(n/2));
    }
}
