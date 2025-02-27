package com.mark.codingtest.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <pre>
 * 입력
 * 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
 *
 * 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고,
 * 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.
 *
 * 출력
 * 첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
 *
 * 예제 입력 1
 * 3
 * 21 Junkyu
 * 21 Dohyun
 * 20 Sunyoung
 * 예제 출력 1
 * 20 Sunyoung
 * 21 Junkyu
 * 21 Dohyun
 * </pre>
 */
public class B10814_나이순정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        User[] users = new User[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            User user = new User(Integer.parseInt(st.nextToken()), st.nextToken());
            users[i] = user;
        }

        Arrays.sort(users, (a, b) -> {
            if (a.age != b.age) {
                return a.age - b.age;
            } else {
                return 0;
            }
        });

        for (User user : users) {
            bw.write(user.age + " " + user.name + "\n");
        }

        bw.close();
    }

    static class User {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
