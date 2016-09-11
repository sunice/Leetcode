package com.leetcode.MainTry;

import java.util.HashMap;

/**
 * Created by Yan on 12/1/15.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        HashMap<Character, Integer> secStats = new HashMap<>();
        HashMap<Character, Integer> gueStats = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                continue;
            }
            if (getHintCore(secStats, gueStats, guess.charAt(i)))
                cows++;
            if (getHintCore(gueStats, secStats, secret.charAt(i)))
                cows++;
        }
        return bulls + "A" + cows + "B";
    }

    private boolean getHintCore(HashMap<Character, Integer> mapA, HashMap<Character, Integer> mapB, char c) {
        if (mapA.containsKey(c)) {
            int val = mapA.get(c) - 1;
            if (val == 0)
                mapA.remove(c);
            else
                mapA.put(c, val);
            return true;
        }
        else {
            if (mapB.containsKey(c))
                mapB.put(c, mapB.get(c) + 1);
            else
                mapB.put(c, 1);
            return false;
        }
    }

    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows test = new BullsAndCows();
        System.out.println(test.getHint("1807", "7810"));
    }
}
