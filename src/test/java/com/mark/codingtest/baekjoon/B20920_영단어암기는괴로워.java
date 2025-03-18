package com.mark.codingtest.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 문제
 * 화은이는 이번 영어 시험에서 틀린 문제를 바탕으로 영어 단어 암기를 하려고 한다. 그 과정에서 효율적으로 영어 단어를 외우기 위해 영어 단어장을 만들려 하고 있다. 화은이가 만들고자 하는 단어장의 단어 순서는 다음과 같은 우선순위를 차례로 적용하여 만들어진다.
 *
 * 자주 나오는 단어일수록 앞에 배치한다.
 * 해당 단어의 길이가 길수록 앞에 배치한다.
 * 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
 *
 * M보다 짧은 길이의 단어의 경우 읽는 것만으로도 외울 수 있기 때문에 길이가
 * M이상인 단어들만 외운다고 한다. 화은이가 괴로운 영단어 암기를 효율적으로 할 수 있도록 단어장을 만들어 주자.
 *
 * 입력
 * 첫째 줄에는 영어 지문에 나오는 단어의 개수 N과
 * 외울 단어의 길이 기준이 되는 M이 공백으로 구분되어 주어진다. (1 <= N <= 100,000, 1 <= M <= 10)
 *
 * 둘째 줄부터
 * N + 1번째 줄까지 외울 단어를 입력받는다. 이때의 입력은 알파벳 소문자로만 주어지며 단어의 길이는
 * 10을 넘지 않는다.
 *
 * 단어장에 단어가 반드시 1개 이상 존재하는 입력만 주어진다.
 *
 * 출력
 * 화은이의 단어장에 들어 있는 단어를 단어장의 앞에 위치한 단어부터 한 줄에 한 단어씩 순서대로 출력한다.
 *
 * 예제 입력 1
 * 7 4
 * apple
 * ant
 * sand
 * apple
 * append
 * sand
 * sand
 *
 * 예제 출력 1
 * sand
 * apple
 * append
 *
 * 예제 입력 2
 * 12 5
 * appearance
 * append
 * attendance
 * swim
 * swift
 * swift
 * swift
 * mouse
 * wallet
 * mouse
 * ice
 * age
 *
 * 예제 출력 2
 * swift
 * mouse
 * appearance
 * attendance
 * append
 * wallet
 * </pre>
 */
public class B20920_영단어암기는괴로워 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            if (key.length() >= M) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> {
            int frequency = o2.getValue() - o1.getValue();
            if (frequency != 0) {
                return frequency;
            }

            int length = o2.getKey().length() - o1.getKey().length();
            if (length != 0) {
                return length;
            }

            return o1.getKey().compareTo(o2.getKey());
        });

        for (Map.Entry<String, Integer> entry : list) {
            bw.write(entry.getKey());
            bw.newLine();
        }

        bw.close();
    }
}
