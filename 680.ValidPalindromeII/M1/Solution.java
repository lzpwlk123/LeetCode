
//双指针，思路很简单
//难点就在于 a b两处的顺序。要意识到谁前谁后是不一样的。有的字符串a前b后，就可以是回文，但有的a前b后不是，b前a后又是了
// 比如 "cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu"
// 如果删去 开头的c，那就不是回文。但如果删去结尾的u，那就是了。

// 最后，给出别人的，思路一样，但简化的代码validPalindrome2

class Solution {
    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int head = 0;
        int tail = s.length();
        int blood = 1;
        boolean ans1 = true;
        boolean ans2 = true;
        while(head < tail){
            if(chars[head] == chars[tail - 1]){
                head++;
                tail--;
                continue;
            }
            if(blood == 1 && chars[head + 1] == chars[tail - 1] ){   // a
                blood -= 1;
                head++;
                continue;
            }
            if(blood == 1 && chars[head] == chars[tail - 2] ){     //b
                blood -= 1;
                tail--;
                continue;
            }
            ans1 = false;
            break;
        }

        head = 0;
        tail = s.length();
        blood = 1;
        while(head < tail){
            if(chars[head] == chars[tail - 1]){
                head++;
                tail--;
                continue;
            }
            if(blood == 1 && chars[head] == chars[tail - 2] ){
                blood -= 1;
                tail--;
                continue;
            }
            if(blood == 1 && chars[head + 1] == chars[tail - 1] ){
                blood -= 1;
                head++;
                continue;
            }
            ans2 = false;
            break;
        }
        if (ans1 || ans2) return true;
        else return false;
    }

    //简洁版
    public boolean validPalindrome2(String s) {
        for(int i = 0, j = s.length()-1; i < j ; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                //分两种情况，一是右边减一，二是左边加一
                return isPalindrome(s,i,j-1) || isPalindrome(s, i+1, j);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}