
/*
    费马平方和定理： 一个非负整数 c 能够表示为两个整数的平方和，当且仅当 c 的所有形如 4k+3 的质因子的幂次均为偶数。
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long i = 2; i * i <= c; i++){
            int count = 0;  // 计数：该因子的幂次
            if ( c % i == 0){    // i 是因子
                while (c % i == 0 ){
                    c /= i;   //这里让c不断减小
                    count++;
                }
                if ( i % 4 == 3 && count % 2 !=0) return  false;  //如果该因子是形如 4k+3 ，且其幂次为奇数
            }
        }
        return c % 4 != 3;  // 余下的c也是一个因子，且其幂次为1，所以如果它形如 4k+3,那么就返回false
    }
}