package com.zh.algs.ds.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/3
 */
public class String2Num {

    /**
     * Description:
     * start  signed  in_number  end
     * start      start  signed  in_number  end
     * signed     end    signed  in_number  end
     * in_number  end    end     in_number  end
     * end        end    end     end        end
     */

    private Map<String, String[]> map;

    private static final String START = "start";
    private static final String SIGNED = "signed";
    private static final String IN_NUMBER = "in_number";
    private static final String END = "end";

    public long ans = 0;
    public int sign = 1;
    public String state;

    public String2Num() {
        this.map = new HashMap<>();
        map.put(START, new String[]{START, SIGNED, IN_NUMBER, END});
        map.put(SIGNED, new String[]{END, SIGNED, IN_NUMBER, END});
        map.put(IN_NUMBER, new String[]{END, END, IN_NUMBER, END});
        map.put(END, new String[]{END, END, END, END});
        this.state = START;
    }

    public int string2Number(String input) {
        string2NumberUtil(input);
        return sign * (int) ans;
    }

    public void string2NumberUtil(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            get(chars[i]);
        }
    }

    private void get(char aChar) {
        state = map.get(state)[getIndex(aChar)];
        if (state.equals(IN_NUMBER)) {
            ans = ans * 10 + aChar - '0';
            if (sign == 1) {
                ans = Math.max(ans, Integer.MAX_VALUE);
            } else {
                ans = Math.max(ans, -(long) Integer.MIN_VALUE);
            }
        }

    }

    private int getIndex(char aChar) {

        if (aChar == ' ') {
            return 0;
        } else if (aChar == '+' || aChar == '-') {
            return 1;
        } else if (aChar >= '0' && aChar <= '9') {
            return 2;
        } else {
            return 3;
        }
    }


}
