import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.isEmpty()) return s;
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] string = s.toCharArray();
        int head = 0;
        int tail = s.length() - 1;
        while(head < tail){
            while(!vowels.contains(string[head]) && head < tail) head++;
            while(!vowels.contains(string[tail]) && head < tail) tail--;
            if(head < tail){
                char temp = string[head];
                string[head] = string[tail];
                string[tail] = temp;
                head ++;
                tail --;
            }
        }
        return new String(string);
    }
}