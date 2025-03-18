package com.mark.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <pre>
 * 문제
 * 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
 *
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 * N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
 *
 * 출력
 * 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
 *
 * 둘째 줄에는 중앙값을 출력한다.
 *
 * 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
 *
 * 넷째 줄에는 범위를 출력한다.
 *
 * 예제 입력 1
 * 5
 * 1
 * 3
 * 8
 * -2
 * 2
 * 예제 출력 1
 * 2
 * 2
 * 1
 * 10
 * 예제 입력 2
 * 1
 * 4000
 * 예제 출력 2
 * 4000
 * 4000
 * 4000
 * 0
 * 예제 입력 3
 * 5
 * -1
 * -2
 * -3
 * -1
 * -2
 * 예제 출력 3
 * -2
 * -2
 * -1
 * 2
 * 예제 입력 4
 * 3
 * 0
 * 0
 * -1
 * 예제 출력 4
 * 0
 * 0
 * 0
 * 1
 * (0 + 0 + (-1)) / 3 = -0.333333... 이고 이를 첫째 자리에서 반올림하면 0이다. -0으로 출력하면 안된다.
 * </pre>
 */
public class B2108_통계학 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // -4000 ~ 4000 => 8001크기의 배열
        int[] A = new int[8001];
        int sum = 0;
        int min = 4001;   // 추적용 (문제 범위 넘어서는 값으로 초기화)
        int max = -4001;  // 추적용 (문제 범위 넘어서는 값으로 초기화)

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            A[num + 4000]++; // 카운팅
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // 1) 평균
        // round: 반올림 => 소수점 이하 첫째 자리에서 반올림
        int avg = (int) Math.round((double) sum / N);

        // 2) 중앙값: 카운팅 배열을 순회하며 누적 개수가 (N/2)+1에 도달하는 위치
        int median = 0;
        int count = 0;
        int half = (N + 1) / 2;  // 중간 위치(1-based 인덱스), N이 짝수여도 중간값은 N/2+1으로
        for (int i = 0; i < 8001; i++) {
            // i - 4000 -> 실제 값
            count += A[i];
            if (count >= half) {
                median = i - 4000;
                break;
            }
        }

        // 3) 최빈값: maxFreq를 찾은 뒤 다시 순회
        int maxFreq = 0;
        for (int i = 0; i < 8001; i++) {
            if (A[i] > maxFreq) {
                maxFreq = A[i];
            }
        }

        // maxFreq와 같은 빈도를 가진 값들을 모두 찾아보자
        ArrayList<Integer> freqList = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (A[i] == maxFreq) {
                freqList.add(i - 4000);
            }
        }

        int mode = 0;
        if (freqList.size() == 1) {
            // 최빈값이 하나
            mode = freqList.get(0);
        } else {
            // 여러 개면 두 번째로 작은 값(정렬된 상태이므로 인덱스 1)
            Collections.sort(freqList);
            mode = freqList.get(1);
        }

        // 4) 범위
        int range = max - min;

        // 결과 출력
        System.out.println(avg);    // 평균
        System.out.println(median); // 중앙값
        System.out.println(mode);   // 최빈값
        System.out.println(range);  // 범위
    }
}
