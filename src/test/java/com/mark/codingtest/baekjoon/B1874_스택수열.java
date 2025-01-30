package com.mark.codingtest.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class B1874_스택수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int num = 1;
        boolean result = true;
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < A.length; i++) {
            int val = A[i];

            if (val >= num) {
                while (val >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }

                stack.pop();
                sb.append("-\n");
            } else {
                int n = stack.pop();
                if (n > val) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }

        if (result) System.out.println(sb);
    }
}
