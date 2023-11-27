package com.mark.codingtest.introductorycourse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleTest {

    /**
     * 문자열 my_string이 매개변수로 주어집니다. my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.
     * "jaron"	"noraj"
     * "bread"	"daerb"
     */
    @Test
    public void 문자열_뒤집기() {
        String my_string = "jaron";
        String answer = "";

        for (int i=my_string.length()-1; i>=0; i--) {
            answer += my_string.charAt(i);
        }

        assertThat(answer).isEqualTo("noraj");
    }


    /**
     * 정수가 들어 있는 배열 num_list가 매개변수로 주어집니다. num_list의 원소의 순서를 거꾸로 뒤집은 배열을 return하도록 solution 함수를 완성해주세요.
     * [1, 2, 3, 4, 5]	        [5, 4, 3, 2, 1]
     * [1, 1, 1, 1, 1, 2]	    [2, 1, 1, 1, 1, 1]
     * [1, 0, 1, 1, 1, 3, 5]	[5, 3, 1, 1, 1, 0, 1]
     */
    @Test
    public void 배열_뒤집기() {
        int[] num_list = new int[]{1,2,3,4,5};
        int[] answer = new int[num_list.length];

        for (int i=0; i<num_list.length; i++) {
            answer[i] = num_list[num_list.length - 1 - i];
        }
    }

    /**
     * 이스 아메리카노는 한잔에 5,500원입니다. 머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때, 머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와 남는 돈을 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
     * 5,500	[1, 0]
     * 15,000	[2, 4000]
     */
    @Test
    public void 아메리카노_잔수_남은돈() {
        int money = 15000;
        int[] answer = new int[2];

        answer[0] = money / 5500;
        answer[1] = money % 5500;

        assertThat(answer[0]).isEqualTo(2);
        assertThat(answer[1]).isEqualTo(4000);
    }

    /**
     * 정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때, array에 n이 몇 개 있는 지를 return 하도록 solution 함수를 완성해보세요.
     * [1, 1, 2, 3, 4, 5]	1	2
     * [0, 2, 3, 4]	        1	0
     */
    @Test
    public void 중복된_숫자_개수() {
        int[] array = new int[]{1, 1, 2, 3, 4, 5};
        int target = 1;
        int count = 0;

        for (int num : array) {
            if (num == target) {
                count++;
            }
        }

        assertThat(count).isEqualTo(2);
    }

    /**
     * 문자열 str1, str2가 매개변수로 주어집니다. str1 안에 str2가 있다면 1을 없다면 2를 return하도록 solution 함수를 완성해주세요.
     * "ab6CDE443fgh22iJKlmn1o"	"6CD"	1
     * "ppprrrogrammers"	    "pppp"	2
     * "AbcAbcA"	            "AAA"	2
     */
    @Test
    public void 문자열안에_문자열() {
        String str1 = "ab6CDE443fgh22iJKlmn1o";
        String str2 = "6CD";

        int answer = str1.contains(str2) ? 1 : 2;

        assertThat(answer).isEqualTo(1);
    }

    /**
     * 머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다. 피자를 나눠먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return 하는 solution 함수를 완성해보세요.
     * 7	1
     * 1	1
     * 15	3
     */
    @Test
    public void 피자_나눠_먹기_1() {
        int n = 7;
        int answer = (int) Math.ceil((float) n / 7);

        assertThat(answer).isEqualTo(1);
    }

    /**
     * 중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값을 의미합니다. 예를 들어 1, 2, 7, 10, 11의 중앙값은 7입니다. 정수 배열 array가 매개변수로 주어질 때, 중앙값을 return 하도록 solution 함수를 완성해보세요.
     * array의 길이는 홀수입니다.
     * [1, 2, 7, 10, 11]	7
     * [9, -1, 0]	        0
     */
    @Test
    public void 중앙값_구하기() {
        int[] array = new int[]{1, 2, 7, 10, 11};
        int answer = 0;

        Arrays.sort(array);
        answer = array[array.length >> 1];

        assertThat(answer).isEqualTo(7);
    }

    /**
     * 사분면은 한 평면을 x축과 y축을 기준으로 나눈 네 부분입니다. 사분면은 아래와 같이 1부터 4까지 번호를 매깁니다.
     * x 좌표와 y 좌표가 모두 양수이면 제1사분면에 속합니다.
     * x 좌표가 음수, y 좌표가 양수이면 제2사분면에 속합니다.
     * x 좌표와 y 좌표가 모두 음수이면 제3사분면에 속합니다.
     * x 좌표가 양수, y 좌표가 음수이면 제4사분면에 속합니다.
     *
     * [2, 4]	1
     * [-7, 9]	2
     */
    @Test
    public void 점의_위치_구하기() {
        int[] dot = new int[]{-7, 9};
        int answer = 4;

        if (dot[0] > 0 && dot[1] > 0) {
            answer = 1;
        } else if(dot[0] < 0 && dot[1] > 0) {
            answer = 2;
        } else if (dot[0] < 0 && dot[1] < 0) {
            answer = 3;
        }

        assertThat(answer).isEqualTo(2);
    }
}
