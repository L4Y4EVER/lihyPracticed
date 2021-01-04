package com.lihy.practiced.twentytwenty.everyday.october;

public class NineteenthDay {

    public boolean backspaceCompare(String S, String T) {
        return reBuild(S).equals(reBuild(T));
    }

    private String reBuild(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c:str.toCharArray()){
            if (c != '#'){
                sb.append(c);
            }else {
                if (sb.length() != 0){
                    sb.deleteCharAt(sb.length() -1);
                }
            }
        }
        return sb.toString();
    }
}
