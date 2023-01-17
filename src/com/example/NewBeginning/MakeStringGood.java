package com.example.NewBeginning;

import java.util.Stack;
import java.lang.Math;
public class MakeStringGood {
    public static String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!st.empty() && Math.abs(s.charAt(i) - st.peek()) == 32) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        String res = new String();
        while(!st.empty()){
            res = st.pop() + res;
        }
        return res;

    }
    public static void main(String[] args) {
         String  s = "c";
         String str = new String();
         str = makeGood(s);
        System.out.println(str);
    }
}

