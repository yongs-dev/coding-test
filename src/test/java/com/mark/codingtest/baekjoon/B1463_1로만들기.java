package com.mark.codingtest.baekjoon;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * <b>DP(Dynamic-Programming)</b><br>
 */
@Slf4j
public class B1463_1로만들기 {

    @Test
    public void test() {
        int n = 10;
        int[] numbers = new int[n + 1];

        numbers[1] = 0;

        for (int i = 2; i <= n; i++) {
            numbers[i] = numbers[i - 1] + 1;

            if (i % 3 == 0) {
                numbers[i] = Math.min(numbers[i], numbers[i / 3] + 1);
            }

            if (i % 2 == 0) {
                numbers[i] = Math.min(numbers[i], numbers[i / 2] + 1);
            }
        }

        log.info("{}", numbers[n]);
    }
}
