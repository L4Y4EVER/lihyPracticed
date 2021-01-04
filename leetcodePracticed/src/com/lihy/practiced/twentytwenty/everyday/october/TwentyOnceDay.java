package com.lihy.practiced.twentytwenty.everyday.october;

/**
 * 第21天题
 *
 */
public class TwentyOnceDay {

    /**
     * 判断输入的内容中有无名字
     *
     * @param name 名字
     * @param typed 输入
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
