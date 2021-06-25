package com.huang.springbootdemo.utils;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {
    public static List<Integer> getNIntBetweenRange(int min, int max, int N) {
        if (N > (max - min + 1)) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (count < N) {
            int randomNumber = (int) Math.round(Math.random() * (max - min) + min);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
                count++;
            }
        }
        return result;
    }
}
