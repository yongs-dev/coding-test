package com.mark.codingtest.introductorycourse;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntroductoryTest {

    @Test
    public void defaultTest() {

    }

    /**
     * 문자열 my_string이 매개변수로 주어집니다. my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.
     * "jaron"	"noraj"
     * "bread"	"daerb"
     */
    @Test
    public void 문자열_뒤집기() {
        String my_string = "jaron";
        String answer = "";

        for (int i = my_string.length()-1; i >= 0; i--) {
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
        int[] num_list = {1,2,3,4,5};
        int[] answer = new int[num_list.length];

        for (int i = 0; i < num_list.length; i++) {
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
        int[] array = {1, 1, 2, 3, 4, 5};
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
        int[] array = {1, 2, 7, 10, 11};
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
        int[] dot = {-7, 9};
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

    /**
     * 정수 배열 numbers가 매개변수로 주어집니다. numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요.
     * [1, 2, 3, 4, 5]	            [2, 4, 6, 8, 10]
     * [1, 2, 100, -99, 1, 2, 3]	[2, 4, 200, -198, 2, 4, 6]
     */
    @Test
    public void 배열_두배_만들기() {
        int[] numbers = {1, 2, 100, -99, 1, 2, 3};
        int[] multiplyNumbers = Arrays.stream(numbers).map(n -> n * 2).toArray();

        assertThat(multiplyNumbers).containsExactly(2, 4, 200, -198, 2, 4, 6);
    }

    /**
     * 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.
     * 10	[1, 3, 5, 7, 9]
     * 15	[1, 3, 5, 7, 9, 11, 13, 15]
     */
    @Test
    public void 짝수는_싫어요() {
        int n = 11;
        int index = 0;
        int length = n % 2 == 1 ? n / 2 + 1 : n / 2;
        int[] array = new int[length];

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 1) {
                array[index] = i;
                index++;
            }
        }

        assertThat(array).containsExactly(1, 3, 5, 7, 9, 11);
    }

    /**
     * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
     * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
     * 삼각형의 세 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 세 변으로 삼각형을 만들 수 있다면 1, 만들 수 없다면 2를 return하도록 solution 함수를 완성해주세요.
     *
     * [1, 2, 3]	2
     * [3, 6, 2]	2
     * [199, 72, 222]	1
     */
    @Test
    public void 삼각형의_완성조건_1() {
        int[] sides = {199, 72, 222};
        Arrays.sort(sides);

        boolean possible = sides[2] < sides[0] + sides[1];

        assertThat(possible).isTrue();
    }

    /**
     * 머쓱이네 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라줍니다. 피자 조각 수 slice와 피자를 먹는 사람의 수 n이 매개변수로 주어질 때,
     * n명의 사람이 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.
     *
     * 7    10  2
     * 4    12	3
     */
    @Test
    public void 피자_나눠_먹기_3() {
        int slice = 7;
        int n = 10;

        assertThat(2).isEqualTo((int) Math.ceil((double) n / slice));
    }

    /**
     * 문자열 my_string과 문자 letter이 매개변수로 주어집니다. my_string에서 letter를 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
     *
     * "abcdef"	"f"	"abcde"
     * "BCBdbe"	"B"	"Cdbe"
     */
    @Test
    public void 특정_문자_제거() {
        String my_string = "abcdef";
        String letter = "f";

        my_string = my_string.replace(letter, "");

        assertThat(my_string).isEqualTo("abcde");
    }

    /**
     * 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다. 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
     *
     * "bus"	            "bs"
     * "nice to meet you"	"nc t mt y"
     */
    @Test
    public void 모음_제거() {
        StringBuilder sb = new StringBuilder();
        String my_string = "nice to meet you";
        List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');

        for (char my_char : my_string.toCharArray()) {
            if (!vowel.contains(my_char)) {
                sb.append(my_char);
            }
        }

        assertThat(sb.toString()).isEqualTo("nc t mt y");
    }

    /**
     * 두 배열이 얼마나 유사한지 확인해보려고 합니다. 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return하도록 solution 함수를 완성해주세요.
     *
     * ["a", "b", "c"]	["com", "b", "d", "p", "c"]	2
     * ["n", "omg"]	    ["m", "dot"]	            0
     */
    @Test
    public void 배열의_유사도() {
        String[] s1 = new String[]{"a", "b", "c"};
        String[] s2 = new String[]{"com", "b", "d", "p", "c"};
        int count = 0;

        for (String str1 : s1) {
            for (String str2 : s2) {
                if (str1.equals(str2)) {
                    count++;
                    break;
                }
            }
        }

        assertThat(count).isEqualTo(2);
    }

    /**
     * 순서쌍이란 두 개의 숫자를 순서를 정하여 짝지어 나타낸 쌍으로 (a, b)로 표기합니다. 자연수 n이 매개변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서쌍의 개수를 return하도록 solution 함수를 완성해주세요.
     * 20	6
     * 100	9
     */
    @Test
    public void 순서쌍의_개수() {
        int n = 100;
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {   // n을 i로 나눴을 때 나머지가 0이면 순서쌍 (a,b)에서 a=i, b=n/i가 됨
                cnt++;
            }
        }

        assertThat(cnt).isEqualTo(9);
    }

    /**
     * 정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때, numbers의 num1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 return 하도록 solution 함수를 완성해보세요.
     * [1, 2, 3, 4, 5]	1	3	[2, 3, 4]
     * [1, 3, 5]	    1	2	[3, 5]
     *
     */
    @Test
    public void 배열_자르기() {
        int[] numbers = {1, 2, 3, 4, 5};
        int num1 = 1;
        int num2 = 3;

        int[] splitArray = Arrays.copyOfRange(numbers, num1, num2 + 1);

        assertThat(splitArray).containsExactly(2, 3, 4);
    }

    /**
     * 문자열 my_string이 매개변수로 주어집니다. my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
     * "aAb1B2cC34oOp"	10
     * "1a2b3c4d123"	16
     */
    @Test
    public void 숨어있는_숫자의_덧셈() {
        String my_string = "aAb1B2cC34oOp";
        int answer = 0;

        for (char c : my_string.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += Character.getNumericValue(c);
            }
        }

        assertThat(answer).isEqualTo(10);
    }

    /**
     * 어떤 세균은 1시간에 두배만큼 증식한다고 합니다. 처음 세균의 마리수 n과 경과한 시간 t가 매개변수로 주어질 때 t시간 후 세균의 수를 return하도록 solution 함수를 완성해주세요.
     * 2	10	2048
     * 7	15	229,376
     */
    @Test
    public void 세균_증식() {
        int n = 7;
        int t = 15;

        for (int i=0; i<t; i++) {
            n *= 2;
        }

        assertThat(n).isEqualTo(229376);
    }

    /**
     * 정수 n과 정수 배열 numlist가 매개변수로 주어질 때, numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.
     * 3	[4, 5, 6, 7, 8, 9, 10, 11, 12]	[6, 9, 12]
     * 12	[2, 100, 120, 600, 12, 12]	[120, 600, 12, 12]
     */
    @Test
    public void n의_배수_고르기() {
        int n = 3;
        int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        List<Integer> list = new ArrayList<>();

        for (int element : numlist) {
            if (element % n == 0) {
                list.add(element);
            }
        }

        assertThat(list.stream().mapToInt(Integer::intValue).toArray()).containsExactly(6, 9, 12);
        assertThat(Arrays.stream(numlist).filter(e -> e % n == 0).toArray()).containsExactly(6, 9, 12);
    }

    /**
     * 문자열 my_string이 매개변수로 주어질 때, 대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.
     * "cccCCC"	    "CCCccc"
     * "abCdEfghIJ"	"ABcDeFGHij"
     */
    @Test
    public void 대문자와_소문자() {
        String my_string = "cccCCC";
        StringBuilder sb = new StringBuilder();

        for (char c : my_string.toCharArray()) {
            sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }

        assertThat(sb.toString()).isEqualTo("CCCccc");
    }

    /**
     * 암호화된 문자열 cipher를 주고받습니다.
     * 그 문자열에서 code의 배수 번째 글자만 진짜 암호입니다.
     * 문자열 cipher와 정수 code가 매개변수로 주어질 때 해독된 암호 문자열을 return하도록 solution 함수를 완성해주세요.
     *
     * "dfjardstddetckdaccccdegk"	4	"attack"
     * "pfqallllabwaoclk"	        2	"fallback"
     */
    @Test
    public void 암호_해독() {
        String cipher = "dfjardstddetckdaccccdegk";
        int code = 4;
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<cipher.length(); i++) {
            if ((i + 1) % code == 0) {
                sb.append(cipher.charAt(i));
            }
        }

        assertThat(sb.toString()).isEqualTo("attack");
    }

    /**
     * 개미 군단이 사냥을 나가려고 합니다. 개미군단은 사냥감의 체력에 딱 맞는 병력을 데리고 나가려고 합니다. 장군개미는 5의 공격력을, 병정개미는 3의 공격력을 일개미는 1의 공격력을 가지고 있습니다.
     * 예를 들어 체력 23의 여치를 사냥하려고 할 때, 일개미 23마리를 데리고 가도 되지만, 장군개미 네 마리와 병정개미 한 마리를 데리고 간다면 더 적은 병력으로 사냥할 수 있습니다.
     * 사냥감의 체력 hp가 매개변수로 주어질 때, 사냥감의 체력에 딱 맞게 최소한의 병력을 구성하려면 몇 마리의 개미가 필요한지를 return하도록 solution 함수를 완성해주세요.
     *
     * 23	5
     * 24	6
     * 999	201
     */
    @Test
    public void 개미_군단() {
        int targetHp = 999;
        int answer = 0;

        for (int i = 5; i >= 1; i = i - 2) {
            answer += targetHp / i;
            targetHp = targetHp % i;
        }

        assertThat(answer).isEqualTo(201);
    }

    /**
     * 가위는 2 바위는 0 보는 5로 표현합니다. 가위 바위 보를 내는 순서대로 나타낸 문자열 rsp가 매개변수로 주어질 때,
     * rsp에 저장된 가위 바위 보를 모두 이기는 경우를 순서대로 나타낸 문자열을 return하도록 solution 함수를 완성해보세요.
     *
     * "2"	    "0"
     * "205"	"052"
     */
    @Test
    public void 가위_바위_보() {
        String rsp = "205";
        StringBuilder sb = new StringBuilder();

        for (char c : rsp.toCharArray()) {
            if (c == '2') {
                sb.append('0');
            } else if (c == '0') {
                sb.append('5');
            } else {
                sb.append('2');
            }
        }

        assertThat(sb.toString()).isEqualTo("052");
    }

    /**
     * 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.
     *
     * [1, 2, -3, 4, -5]	        15
     * [0, -31, 24, 10, 1, 9]	    240
     * [10, 20, 30, 5, 5, 20, 5]	600
     */
    @Test
    public void 최댓값_만들기_2() {
        int[] numbers = {0, -31, 24, 10, 1, 9};
        Arrays.sort(numbers);

        assertThat(Math.max(numbers[numbers.length - 1] * numbers[numbers.length - 2], numbers[0] * numbers[1])).isEqualTo(240);
    }

    /**
     * 상자의 가로, 세로, 높이가 저장되어있는 배열 box와 주사위 모서리의 길이 정수 n이 매개변수로 주어졌을 때
     * 상자에 들어갈 수 있는 주사위의 최대 개수를 return 하도록 solution 함수를 완성해주세요.
     *
     * [1, 1, 1]	1	1
     * [10, 8, 6]	3	12
     */
    @Test
    public void 주사위_개수() {
        int[] box = {10, 8, 6};
        int n = 3;
        int answer = (box[0] / n) * (box[1] / n) * (box[2] / n);

        assertThat(answer).isEqualTo(12);
    }

    /**
     * "*"의 높이와 너비를 1이라고 했을 때, "*"을 이용해 직각 이등변 삼각형을 그리려고합니다. 정수 n 이 주어지면 높이와 너비가 n 인 직각 이등변 삼각형을 출력하도록 코드를 작성해보세요.
     * n = 3
     * *
     * **
     * ***
     */
    @Test
    public void 직각삼각형_출력하기() {
        int n = 3;

        for (int i=1; i<=n; i++) {
            System.out.println("*".repeat(i));
        }
    }

    /**
     * 정수 배열 array가 매개변수로 주어질 때, 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.
     * [1, 8, 3]	    [8, 1]
     * [9, 10, 11, 8]	[11, 2]
     */
    @Test
    public void 가장_큰_수_찾기() {
        int[] array = {9, 10, 11, 8};
        int[] answer = {0, 0};

        for (int i=0; i<array.length; i++) {
            if (array[i] > answer[0]) {
                answer[0] = array[i];
                answer[1] = i;
            }
        }

        assertThat(answer).containsExactly(11, 2);
    }

    /**
     * 문자열 my_string이 매개변수로 주어질 때, my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.
     * "hi12392"	[1, 2, 2, 3, 9]
     * "p2o4i8gj2"	[2, 2, 4, 8]
     * "abcde0"	[0]
     */
    @Test
    public void 문자열_정렬하기_1() {
        String my_string = "hi12392";
        int[] answer;
        List<Integer> list = new ArrayList<>();

        for (char c : my_string.toCharArray()) {
            if (Character.isDigit(c)) {
                list.add(Character.getNumericValue(c));
            }
        }

        answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);

        assertThat(answer).containsExactly(1, 2, 2, 3, 9);
    }

    /**
     * 문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때, my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
     * "hello"	    1	2	"hlelo"
     * "I love you"	3	6	"I l veoyou"
     */
    @Test
    public void 인덱스_바꾸기() {
        String my_string = "I love you";
        int num1 = 3;
        int num2 = 6;

        char[] array = my_string.toCharArray();
        array[num1] = my_string.charAt(num2);
        array[num2] = my_string.charAt(num1);

        assertThat(String.valueOf(array)).isEqualTo("I l veoyou");
    }

    /**
     * a는 0, b는 1, c는 2, ..., j는 9입니다. 예를 들어 23살은 cd, 51살은 fb로 표현합니다.
     * 나이 age가 매개변수로 주어질 때 나이를 return하도록 solution 함수를 완성해주세요.
     * 23	"cd"
     * 51	"fb"
     * 100	"baa"
     */
    @Test
    public void 외계행성의_나이() {
        int age = 100;

        StringBuilder sb = new StringBuilder();
        String age_str = String.valueOf(age);
        String str = "abcdefghij";

        for (char c : age_str.toCharArray()) {
            for (int i=0; i<str.length(); i++) {
                if (Character.getNumericValue(c) == i) {
                    sb.append(str.charAt(i));
                    break;
                }
            }
        }

        assertThat(sb.toString()).isEqualTo("baa");
    }

    /**
     * 정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다. 배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 배열을 return하도록 solution 함수를 완성해주세요.
     * [1, 2, 3]	                "right"	[3, 1, 2]
     * [4, 455, 6, 4, -1, 45, 6]	"left"	[455, 6, 4, -1, 45, 6, 4]
     */
    @Test
    public void 배열_회전시키기() {
        int[] numbers = {4, 455, 6, 4, -1, 45, 6};
        String direction = "left";

        int length = numbers.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            if ("right".equals(direction)) {
                result[(i + 1) % length] = numbers[i];
            } else {
                result[i] = numbers[(i + 1) % length];
            }
        }

        assertThat(result).containsExactly(455, 6, 4, -1, 45, 6, 4);
    }

    /**
     * 정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
     * 24	[1, 2, 3, 4, 6, 8, 12, 24]
     * 29	[1, 29]
     */
    @Test
    public void 약수_구하기() {
        int n = 24;
        int[] array = IntStream.rangeClosed(1, n).filter(i -> n % i == 0).toArray();
        assertThat(array).containsExactly(1, 2, 3, 4, 6, 8, 12, 24);
    }

    /**
     * 머쓱이네 피자가게는 피자를 여섯 조각으로 잘라 줍니다. 피자를 나눠먹을 사람의 수 n이 매개변수로 주어질 때,
     * n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.
     * 6	1
     * 10	5
     * 4	2
     */
    @Test
    public void 피자_나눠_먹기_2() {
        int n = 10;
        int answer = 0;

        for (int i=1; i<=n; i++) {
            if (6 * i % n == 0) {
                answer = i;
                break;
            }
        }

        assertThat(answer).isEqualTo(5);
    }

    /**
     * num을 이루는 숫자 중에 k가 있으면 num의 그 숫자가 있는 자리 수를 return하고 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
     * 29183	1	3
     * 232443	4	4
     * 123456	7	-1
     */
    @Test
    public void 숫자_찾기() {
        int num = 29183;
        int k = 1;
        int answer = 0;

        String strNum = Integer.toString(num);
        answer = strNum.indexOf(Integer.toString(k));

        assertThat(answer < 0 ? -1 : answer + 1).isEqualTo(3);
    }

    /**
     * 369 게임입니다. 머쓱이가 말해야하는 숫자 order가 매개변수로 주어질 때, 머쓱이가 쳐야할 박수 횟수를 return 하도록 solution 함수를 완성해보세요.
     * 3	    1
     * 29423	2
     */
    @Test
    public void 삼육구_게임() {
        int order = 368;
        int answer = 0;

        String orderStr = Integer.toString(order);

        for (int i=0; i<orderStr.length(); i++) {
            if (orderStr.charAt(i) == '3' || orderStr.charAt(i) == '6' || orderStr.charAt(i) == '9') {
                answer++;
            }
        }

        assertThat(answer).isEqualTo(2);
    }

    /**
     * my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
     * "Bcad"	"abcd"
     * "heLLo"	"ehllo"
     * "Python"	"hnopty"
     */
    @Test
    public void 문자열_정렬하기_2() {
        String my_string = "Bcad";
        String answer = "";

        char[] array = my_string.toLowerCase().toCharArray();
        Arrays.sort(array);
        answer = new String(array);

        assertThat(answer).isEqualTo("abcd");
    }

    /**
     * 약수의 개수가 세 개 이상인 수를 합성수라고 합니다. 자연수 n이 매개변수로 주어질 때
     * n이하의 합성수의 개수를 return하도록 solution 함수를 완성해주세요.
     * 10	5
     * 15	8
     */
    @Test
    public void 합성수_찾기() {
        int n = 15;
        int answer = 0;

        for (int i=1; i<=n; i++) {
            for (int j=2; j<i; j++) {
                if (i % j == 0) {
                    answer++;
                    break;
                }
            }
        }

        assertThat(answer).isEqualTo(8);
    }

    /**
     * my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.
     * "people"	"peol"
     * "We are the world"	"We arthwold"
     */
    @Test
    public void 중복된_문자_제거() {
        String my_string = "people";
        String answer = "";

        for (int i=0; i<my_string.length(); i++) {
            if (my_string.indexOf(my_string.charAt(i)) == i) {
                answer += my_string.charAt(i);
            }
        }

        assertThat(answer).isEqualTo("peol");
    }

    /**
     * num_list를 다음 설명과 같이 2차원 배열로 바꿔 return하도록 solution 함수를 완성해주세요.
     * num_list가 [1, 2, 3, 4, 5, 6, 7, 8] 로 길이가 8이고 n이 2이므로 num_list를 2 * 4 배열로 다음과 같이 변경합니다.
     * 2차원으로 바꿀 때에는 num_list의 원소들을 앞에서부터 n개씩 나눠 2차원 배열로 변경합니다.
     * [1, 2, 3, 4, 5, 6, 7, 8]	            2	[[1, 2], [3, 4], [5, 6], [7, 8]]
     * [100, 95, 2, 4, 5, 6, 18, 33, 948]	3	[[100, 95, 2], [4, 5, 6], [18, 33, 948]]
     */
    @Test
    public void 이차원으로_만들기() {
        int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = 2;
        int[][] answer = new int[num_list.length / n][n];

        for (int i = 0; i < num_list.length; i++) {
            answer[i / n][i % n] = num_list[i];
        }

        int[][] expected = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        assertThat(answer).isEqualTo(expected);
    }

    /**
     * before의 순서를 바꾸어 after를 만들 수 있으면 1을, 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.
     * "olleh"	"hello"	1
     * "allpe"	"apple"	0
     */
    @Test
    public void A로_B만들기() {
        String before = "olleh";
        String after = "hello";
        int answer = 0;

        char[] beforeArray = before.toCharArray();
        char[] afterArray = after.toCharArray();

        Arrays.sort(beforeArray);
        Arrays.sort(afterArray);

        answer = String.valueOf(beforeArray).equals(String.valueOf(afterArray)) ? 1 : 0;

        assertThat(answer).isEqualTo(1);
    }

    /**
     * 문자열 letter가 매개변수로 주어질 때, letter를 영어 소문자로 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
     * ".... . .-.. .-.. ---"	"hello"
     */
    @Test
    public void 모스부호_1() {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String letter = ".... . .-.. .-.. ---";
        String[] array = letter.split(" ");

        for (String str : array) {
            for (int i=0; i< morse.length; i++) {
                if (morse[i].equals(str)) {
                    answer += Character.toString(i + 'a');
                }
            }
        }

        assertThat(answer).isEqualTo("hello");
    }

    /**
     * 정수 n이 주어질 때 i! ≤ n 만족하는 가장 큰 정수 i를 return 하도록 solution 함수를 완성해주세요.
     * 3628800	10
     * 7	    3
     */
    @Test
    public void 팩토리얼() {
        int n = 7;
        int answer = 0;
        int factorial = 1;

        for (int i=1; i<=10; i++) {
            factorial *= i;

            if (factorial == n) {
                answer = i;
                break;
            } else if(n < factorial) {
                answer = i-1;
                break;
            }
        }

        assertThat(answer).isEqualTo(3);
    }

    /**
     * 1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 5번 등장합니다. 정수 i, j, k가 매개변수로 주어질 때,
     * i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.
     *
     * 1	13	1	5
     * 10	50	5	5
     * 3	10	2	0
     */
    @Test
    public void k의_개수() {
        int i = 1;
        int j = 13;
        int k = 1;
        int answer = 0;

        for (int num = i; num <= j; num++){
            int tmp = num;
            while (tmp != 0) {
                if (tmp % 10 == k) {
                    answer++;
                }
                tmp /= 10;
            }
        }

        assertThat(answer).isEqualTo(6);
    }

    /**
     * my_string은 소문자, 대문자, 자연수로만 구성되어있습니다. my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
     * "aAb1B2cC34oOp"	37
     * "1a2b3c4d123Z"	133
     */
    @Test
    public void 숨어있는_숫자의_덧셈_2() {
        String my_string = "aAb1B2cC34oOp";
        int answer = Arrays.stream(my_string.split("[^0-9]+"))
                .filter(s -> s != null && !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();

        assertThat(answer).isEqualTo(37);
    }

    /**
     * 정수 배열 array와 정수 n이 매개변수로 주어질 때, array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.
     * 가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.
     * [3, 10, 28]	20	28
     * [10, 11, 12]	13	12
     */
    @Test
    public void 가까운_수() {
        int[] array = {3, 10, 28};
        int n = 20;
        int answer = 0;
        int beforeValue = Integer.MAX_VALUE;

        for (int i=array.length-1; i>=0; i--) {
            int value = Math.abs(n - array[i]);

            if (value < beforeValue) {
                beforeValue = value;
                answer = array[i];
            } else if (value == beforeValue && array[i] < answer) {
                answer = array[i];
            }
        }

        assertThat(answer).isEqualTo(28);
    }

    /**
     * 정수 배열 emergency가 매개변수로 주어질 때 응급도가 높은 순서대로 진료 순서를 정한 배열을 return하도록 solution 함수를 완성해주세요.
     * [3, 76, 24]	            [3, 1, 2]
     * [1, 2, 3, 4, 5, 6, 7]	[7, 6, 5, 4, 3, 2, 1]
     * [30, 10, 23, 6, 100]     [2, 4, 3, 5, 1]
     */
    @Test
    public void 진료순서_정하기() {
        int[] emergency = {30, 10, 23, 6, 100};
        int[] clone = emergency.clone();
        int[] answer = new int[emergency.length];

        Arrays.sort(emergency);

        for (int i=0; i<emergency.length; i++) {
            for (int j=0; j<emergency.length; j++) {
                if (emergency[i] == clone[j]) {
                    answer[j] = emergency.length-i;
                    break;
                }
            }
        }

        assertThat(answer).containsExactly(2, 4, 3, 5, 1);
    }

    /**
     * s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요. 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.
     * "abcabcadc"	"d"
     * "abdc"	    "abcd"
     * "hello"	    "eho"
     */
    @Test
    public void 한_번만_등장한_문자() {
        String s = "abcabcadc";
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Set<String> set = new TreeSet<>();
        map.forEach((key, value) -> {
            if (value == 1) set.add(Character.toString(key));
        });

        answer = String.join("", set);

        assertThat(answer).isEqualTo("d");
    }

    /**
     * 숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다. 문자열에 있는 숫자를 차례대로 더하려고 합니다.
     * 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다. 숫자와 "Z"로 이루어진 문자열 s가 주어질 때, 머쓱이가 구한 값을 return 하도록 solution 함수를 완성해보세요.
     * "1 2 Z 3"	    4
     * "10 20 30 40"	100
     * "10 Z 20 Z 1"	1
     * "10 Z 20 Z"	    0
     * "-1 -2 -3 Z"	    -3
     */
    @Test
    public void 컨트롤_제트() {
        String s = "10 Z 20 Z 1";
        int answer = 0;
        String[] array = s.split(" ");
        Stack<Integer> stack = new Stack();

        for (String string : array) {
            if (string.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(string));
            }
        }

        answer = stack.stream().mapToInt(Integer::intValue).sum();

        assertThat(answer).isEqualTo(1);
    }

    /**
     * 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.
     * [7, 77, 17]	4
     * [10, 29]	    0
     */
    @Test
    public void 칠의_개수() {
        int[] array = {10, 7, 177, 27, 7777};
        int answer = 0;

        for (int num : array) {
            while (num > 0) {
                if (num % 10 == 7) {
                    answer++;
                }
                num /= 10;
            }
        }

        assertThat(answer).isEqualTo(8);
    }

    /**
     * 이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때, 두 이진수의 합을 return하도록 solution 함수를 완성해주세요.
     * "10"	    "11"	"101"
     * "1001"	"1111"	"11000"
     */
    @Test
    public void 이진수_더하기() {
        String bin1 = "1001";
        String bin2 = "1111";
        String answer = Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));

        assertThat(answer).isEqualTo("11000");
    }

    /**
     * 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다. 따라서 12의 소인수는 2와 3입니다.
     * 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
     * 12	[2, 3]
     * 17	[17]
     * 420	[2, 3, 5, 7]
     */
    @Test
    public void 소인수분해() {
        int n = 12;
        int[] answer;

        Set<Integer> set = new TreeSet<>();
        for (int i=2; i<=n; i++) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }

        answer = set.stream().mapToInt(Integer::intValue).toArray();

        assertThat(answer).containsExactly(2, 3);
    }

    /**
     * my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.
     * "abc1Addfggg4556b"	6	["abc1Ad", "dfggg4", "556b"]
     * "abcdef123"	        3	["abc", "def", "123"]
     */
    @Test
    public void 잘라서_배열로_저장하기() {
        String my_str = "abc1Addfggg4556b";
        int n = 6;
        String[] answer;
        List<String> list = new ArrayList<>();

        for (int i=0; i<my_str.length(); i=i+n) {
            int endIndex = Math.min(i + n, my_str.length());
            list.add(my_str.substring(i, endIndex));
        }

        answer = list.toArray(String[]::new);

        assertThat(answer).containsExactly("abc1Ad", "dfggg4", "556b");
    }

    /**
     * 공은 1번부터 던지며 오른쪽으로 한 명을 건너뛰고 그다음 사람에게만 던질 수 있습니다.
     * 친구들의 번호가 들어있는 정수 배열 numbers와 정수 K가 주어질 때,
     * k번째로 공을 던지는 사람의 번호는 무엇인지 return 하도록 solution 함수를 완성해보세요.
     *
     * [1, 2, 3, 4]	        2	3
     * [1, 2, 3, 4, 5, 6]	5	3
     * [1, 2, 3]	        3	2
     */
    @Test
    public void 공_던지기() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int k =5;
        int answer = 0;
        int index = 0;

        for (int i=0; i<k-1; i++) {
            index +=2;
        }

        index %= numbers.length;
        answer = numbers[index];

        assertThat(answer).isEqualTo(3);
    }

    /**
     * my_string은 "3 + 5"처럼 문자열로 된 수식입니다. 문자열 my_string이 매개변수로 주어질 때, 수식을 계산한 값을 return 하는 solution 함수를 완성해주세요.
     * "3 + 4"	7
     */
    @Test
    public void 문자열_계산하기() {
        String my_string = "3 + 4";
        int answer = 0;

        String[] array = my_string.split(" ");
        answer = Integer.parseInt(array[0]);

        // 문자 숫자 문자 숫자 문자....
        for (int i=1; i<array.length-1; i+=2) {
            if (array[i].equals("+")) {
                answer += Integer.parseInt(array[i+1]);
            } else {
                answer -= Integer.parseInt(array[i+1]);
            }
        }

        assertThat(answer).isEqualTo(7);
    }

    /**
     * 문자열 numbers가 매개변수로 주어질 때, numbers를 정수로 바꿔 return 하도록 solution 함수를 완성해 주세요.
     * "onetwothreefourfivesixseveneightnine"	123456789
     * "onefourzerosixseven"	14067
     */
    @Test
    public void 영어가_싫어요() {
        String numbers = "onetwothreefourfivesixseveneightnine";
        String[] splitArray = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};

        for (int i=0; i<splitArray.length; i++) {
            numbers = numbers.replaceAll(splitArray[i], String.valueOf(i));
        }

        long answer = Long.parseLong(numbers);

        assertThat(answer).isEqualTo(123456789);
    }

    /**
     * 구슬은 모두 다르게 생겼습니다. 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때,
     * balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.
     * 3	2	3
     * 5	3	10
     */
    @Test
    public void 구슬을_나누는_경우의_수() {
        // 서로 다른 n개중 m개를 뽑는 공식  n! / ((n-m)! * m!)
        int balls = 5;
        int share = 3;
        int answer = 1;

        if (balls != share) {
            BigInteger num1 = new BigInteger("1"); // 변수선언, parameter는 String 타입으로

            for (int i=0; i<share; i++) {
                BigInteger num2 = new BigInteger(Integer.toString(i + 1));    //숫자도 String으로 변형하여 넣자.
                BigInteger num3 = new BigInteger(Integer.toString(balls - i));
                num1 = num1.multiply(num3);  //곱을 하는 메서드는 multiply. 분자에 해당
                num1 = num1.divide(num2);   //나눗셈은 divide. 분모에 해당

            }
            answer = num1.intValue(); // 마지막으로 형변환을 int로 해주었다.
        }

        assertThat(answer).isEqualTo(10);
    }

    /**
     * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
     * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
     * 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.
     * [1, 2]	1
     * [3, 6]	5
     * [11, 7]	13
     */
    @Test
    public void 삼각형의_완성조건_2() {
        int[] sides = {11, 7};
        int answer = 0;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);


        for (int i=max-min+1; i<=max; i++) {
            ++answer;
        }

        for (int i=max+1; i<min+max; i++) {
            ++answer;
        }

        assertThat(answer).isEqualTo(13);
    }

    /**
     * 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다.
     * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.
     *
     * ["p", "o", "s"]	    ["sod", "eocd", "qixm", "adio", "soo"]	2
     * ["z", "d", "x"]	    ["def", "dww", "dzx", "loveaw"]	        1
     * ["s", "o", "m", "d"]	["moos", "dzx", "smm", "sunmmo", "som"]	2
     */
    @Test
    public void 외계어_사전() {
        String[] spell = {"z", "d", "x"};
        String[] dic = {"def", "dww", "dzx", "loveaw"};

        int answer = 0;
        int count = 0;
        int length = spell.length;

        for (String dWord : dic) {
            for (String sWord : spell) {
                if (dWord.contains(sWord)) {
                    count++;
                }
            }

            if (count == length) {
                answer = 1;
                break;
            } else {
                answer = 2;
            }

            count = 0;
        }

        assertThat(answer).isEqualTo(1);
    }

    /**
     * 머쓱이는 큰 종이를 1 x 1 크기로 자르려고 합니다.
     * 예를 들어 2 x 2 크기의 종이를 1 x 1 크기로 자르려면 최소 가위질 세 번이 필요합니다.
     * 2	2	3
     * 2	5	9
     * 1	1	0
     */
    @Test
    public void 종이_자르기() {
        int m = 2;
        int n = 5;
        int answer = m * n - 1;

        assertThat(answer).isEqualTo(9);
    }

    /**
     * up, down, left, right 방향키가 있으며 각 키를 누르면 위, 아래, 왼쪽, 오른쪽으로 한 칸씩 이동합니다.
     * 예를 들어 [0,0]에서 up을 누른다면 캐릭터의 좌표는 [0, 1],
     * down을 누른다면 [0, -1], left를 누른다면 [-1, 0], right를 누른다면 [1, 0]입니다.
     * 머쓱이가 입력한 방향키의 배열 keyinput와 맵의 크기 board이 매개변수로 주어집니다. 캐릭터는 항상 [0,0]에서 시작할 때 키 입력이 모두 끝난 뒤에 캐릭터의 좌표 [x, y]를 return하도록 solution 함수를 완성해주세요.
     *
     * ["left", "right", "up", "right", "right"]	[11, 11]	[2, 1]
     * ["down", "down", "down", "down", "down"]	[7, 9]	[0, -4]
     */
    @Test
    public void 캐릭터의_좌표() {
        String[] keyinput = {"down", "down", "down", "down", "down"};
        int[] board = {7, 9};
        int[] answer = {0, 0};
        int xLimit = board[0] / 2; // 3
        int yLimit = board[1] / 2; // 4

        for (String str : keyinput) {
            if (str.equals("left") && answer[0] > -xLimit) {
                answer[0]--;
            } else if (str.equals("right") && answer[0] < xLimit) {
                answer[0]++;
            } else if (str.equals("up") && answer[1] < yLimit) {
                answer[1]++;
            } else if (str.equals("down") && answer[1] > -yLimit) {
                answer[1]--;
            }
        }

        assertThat(answer).containsExactly(0, -4);
    }

    /**
     * 직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열 dots가 매개변수로 주어질 때,
     * 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요.
     *
     * [[1, 1], [2, 1], [2, 2], [1, 2]]	    1
     * [[-1, -1], [1, 1], [1, -1], [-1, 1]]	4
     */
    @Test
    public void 직사각형_넓이_구하기() {
        int[][] dots = new int[][]{{-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        int x = dots[0][0];
        int y = dots[0][1];
        int width = 0;
        int height = 0;

        for (int[] dot : dots) {
            if (x != dot[0]) {
                width = Math.abs(x - dot[0]);
            }

            if (y != dot[1]) {
                height = Math.abs(y - dot[1]);
            }
        }

        int answer = width * height;

        assertThat(answer).isEqualTo(4);
    }

    /**
     * 머쓱이가 입력한 아이디와 패스워드가 담긴 배열 id_pw와 회원들의 정보가 담긴 2차원 배열 db가 주어질 때,
     * 다음과 같이 로그인 성공, 실패에 따른 메시지를 return하도록 solution 함수를 완성해주세요.
     * 아이디와 비밀번호가 모두 일치하는 회원정보가 있으면 "login"을 return합니다.
     * 로그인이 실패했을 때 아이디가 일치하는 회원이 없다면 “fail”를, 아이디는 일치하지만 비밀번호가 일치하는 회원이 없다면 “wrong pw”를 return 합니다.
     * ["meosseugi", "1234"]	    [["rardss", "123"], ["yyoom", "1234"], ["meosseugi", "1234"]]	                "login"
     * ["programmer01", "15789"]	[["programmer02", "111111"], ["programmer00", "134"], ["programmer01", "1145"]]	"wrong pw"
     * ["rabbit04", "98761"]	    [["jaja11", "98761"], ["krong0313", "29440"], ["rabbit00", "111333"]]	        "fail"
     */
    @Test
    public void 로그인_성공() {
        String[] id_pw = new String[]{"meosseugi", "1234"};
        String[][] db = new String[][]{{"rardss", "123"}, {"yyoom", "1234"},{"meosseugi", "1234"}};
        String answer = "fail";

        for (String[] data : db) {
            if (data[0].equals(id_pw[0]) && data[1].equals(id_pw[1])) {
                answer = "login";
                break;
            } else if (data[0].equals(id_pw[0]) && !data[1].equals(id_pw[1])) {
                answer = "wrong pw";
                break;
            }
        }

        assertThat(answer).isEqualTo("login");
    }

    /**
     * 영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다. 영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때,
     * 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.
     * [[80, 70], [90, 50], [40, 70], [50, 80]]	                                    [1, 2, 4, 3]
     * [[80, 70], [70, 80], [30, 50], [90, 100], [100, 90], [100, 100], [10, 30]]	[4, 4, 6, 2, 2, 1, 7]
     */
    @Test
    public void 등수_매기기() {
        int[][] score = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
        int[] average = new int[score.length];
        int[] answer = new int[score.length];

        for (int i=0; i<score.length; i++) {
            average[i] = (score[i][0] + score[i][1]) / 2;
        }

        for (int i=0; i<average.length; i++) {
            int order = 1;
            for (int j=0; j<average.length; j++) {
                if (average[i] < average[j]) {
                    order++;
                }
                answer[i] = order;
            }
        }

        assertThat(answer).containsExactly(4, 4, 6, 2, 2, 1, 7);
    }

    /**
     * 프로그래머스 치킨은 치킨을 시켜먹으면 한 마리당 쿠폰을 한 장 발급합니다. 쿠폰을 열 장 모으면 치킨을 한 마리 서비스로 받을 수 있고,
     * 서비스 치킨에도 쿠폰이 발급됩니다. 시켜먹은 치킨의 수 chicken이 매개변수로 주어질 때 받을 수 있는 최대 서비스 치킨의 수를 return하도록 solution 함수를 완성해주세요.
     * 100	    11
     * 1,081	120
     */
    @Test
    public void 치킨_쿠폰() {
        int chicken = 1081;
        int bonus = 10;
        int answer = 0;

        while (chicken >= bonus) {
            int newChick = chicken / bonus;
            int restChick = chicken % bonus;
            chicken = newChick + restChick;
            answer += newChick;
        }

        assertThat(answer).isEqualTo(120);
    }

    /**
     * 소수점 아래 숫자가 계속되지 않고 유한개인 소수를 유한소수라고 합니다. 분수를 소수로 고칠 때 유한소수로 나타낼 수 있는 분수인지 판별하려고 합니다.
     * 기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
     * 두 정수 a와 b가 매개변수로 주어질 때, a/b가 유한소수이면 1을, 무한소수라면 2를 return하도록 solution 함수를 완성해주세요.
     * 7	20	1
     * 11	22	1
     * 12	21	2
     */
    @Test
    public void 유한소수_판별() {
        int a = 11;
        int b = 22;
        int answer = 2;

        // 최대 공약수 구하기
        int gcd = 1;
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        int newA = a / gcd;
        int newB = b / gcd;

        while (newB % 2 == 0 && newB != 1) {
            newB = newB / 2;
        }

        while (newB % 5 == 0 && newB != 1) {
            newB = newB / 5;
        }

        if (newB == 1) {
            answer = 1;
        }

        assertThat(answer).isEqualTo(1);
    }

    /**
     * 3x 마을 사람들은 3을 저주의 숫자라고 생각하기 때문에 3의 배수와 숫자 3을 사용하지 않습니다. 3x 마을 사람들의 숫자는 다음과 같습니다.
     * 10진법	3x 마을에서 쓰는 숫자	10진법	3x 마을에서 쓰는 숫자
     * 1	    1	                6	    8
     * 2	    2	                7	    10
     * 3	    4	                8	    11
     * 4	    5	                9	    14
     * 5	    7	                10  	16
     *
     */
    @Test
    public void 저주의_숫자_3() {
        int n = 15;
        int answer = 0;

        for (int i=1; i<=n; i++) {
            if (String.valueOf(i).contains("3") || i % 3 == 0) {
                n++;
            }
        }

        answer = n;
        assertThat(answer).isEqualTo(25);
    }

    /**
     * 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다. 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다.
     * 정수가 담긴 배열 numlist와 정수 n이 주어질 때 numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록 solution 함수를 완성해주세요.
     * [1, 2, 3, 4, 5, 6]	            4	[4, 5, 3, 6, 2, 1]
     * [10000,20,36,47,40,6,10,7000]	30	[36, 40, 20, 47, 10, 6, 7000, 10000]
     */
    @Test
    public void 특이한_정렬() {
        int[] numlist = {1, 2, 3, 4, 5, 6};
        int n = 4;
        int[] answer = {};

        Arrays.sort(numlist);

        for (int i=0; i<numlist.length; i++) {
            for (int j=0; j<numlist.length; j++) {
                if (Math.abs(n - numlist[i]) <= Math.abs(n - numlist[j])) {
                    int temp = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = temp;
                }
            }
        }

        answer = numlist;

        assertThat(answer).containsExactly(4, 5, 3, 6, 2, 1);
    }

    /**
     * 한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다. 다항식을 계산할 때는 동류항끼리 계산해 정리합니다.
     * 덧셈으로 이루어진 다항식 polynomial이 매개변수로 주어질 때, 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성해보세요.
     * 같은 식이라면 가장 짧은 수식을 return 합니다.
     * "3x + 7 + x"	"4x + 7"
     * "x + x + x"	"3x"
     */
    @Test
    public void 다항식_더하기() {
        String polynomial = "x + x + x";
        String answer = "";

        String[] array = polynomial.split(" \\+ ");
        int sumX = 0;
        int sumConstant = 0;

        for (String str : array) {
            if (str.contains("x")) {
                if ("x".equals(str)) {
                    sumX += 1;
                } else if ("-x".equals(str)) {
                    sumX -= 1;
                }else {
                    sumX += Integer.parseInt(str.substring(0, str.indexOf("x")));
                }
            } else {
                sumConstant += Integer.parseInt(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (sumX != 0) {
            if (sumX != 1) {
                sb.append(sumX);
            }
            sb.append("x");
        }

        if (sumConstant != 0) {
            if (sb.length() > 0) {
                sb.append(" + ");
            }
            sb.append(sumConstant);
        }

        answer = sb.toString();

        assertThat(answer).isEqualTo("3x");
    }

    /**
     * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 정수 배열 array가 매개변수로 주어질 때,
     * 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.
     * [1, 2, 3, 3, 3, 4]	3
     * [1, 1, 2, 2]	        -1
     * [1]	                1
     */
    @Test
    public void 최빈값_구하기() {
        int[] array = {1, 2, 3, 3, 3, 4};
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        // 빈도가 가장 높은 숫자의 빈도수를 찾는다
        for (int frequency : map.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        int mode = 0;
        int count = 0;

        // 빈도가 가장 높은 숫자가 여러 개인지 확인하고, 그렇다면 -1을 반환한다
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mode = entry.getKey();
                count++;
            }
        }

        answer = count > 1 ? -1 : mode;
        assertThat(answer).isEqualTo(3);
    }

    /**
     * 덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다.
     * 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return하도록 solution 함수를 완성해주세요.
     * ["3 - 4 = -3", "5 + 6 = 11"]	                                ["X", "O"]
     * ["19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"]	["O", "O", "X", "O"]
     */
    @Test
    public void OX퀴즈() {
        String[] quiz = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};
        String[] answer = new String[quiz.length];

        for (int i=0; i<quiz.length; i++) {
            boolean solution = false;
            String[] str = quiz[i].split(" ");

            int X = Integer.parseInt(str[0]);
            int Y = Integer.parseInt(str[2]);
            int Z = Integer.parseInt(str[4]);
            String operator = str[1];

            if (operator.equals("+") && X + Y == Z) {
                solution = true;
            } else if (operator.equals("-") && X - Y == Z) {
                solution = true;
            }

            answer[i] = solution ? "O" : "X";
        }

        assertThat(answer).containsExactly("O", "O", "X", "O");
    }

    /**
     * 등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.
     * [1, 2, 3, 4]	5
     * [2, 4, 8]	16
     */
    @Test
    public void 다음에_올_숫자() {
        int[] common = {1, 2, 3, 4};
        int answer = 0;
        int n = common.length - 1;

        answer = common[n] - common[n-1] == common[n-1] - common[n-2]
                ? common[n] + (common[n] - common[n-1])
                : common[n] * (common[n] / common[n-1]);

        assertThat(answer).isEqualTo(16);
    }

    /**
     * 연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다. 두 정수 num과 total이 주어집니다.
     * 연속된 수 num개를 더한 값이 total이 될 때, 정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.
     * 3	12	[3, 4, 5]
     * 5	15	[1, 2, 3, 4, 5]
     * 4	14	[2, 3, 4, 5]
     * 5	5	[-1, 0, 1, 2, 3]
     */
    @Test
    public void 연속된_수의_합() {
        int num = 4;
        int total = 14;
        int[] answer = new int[num];
        int middleValue = total / num;
        int middleIndex = num % 2 == 0 ? num / 2 - 1 : num / 2;

        answer[middleIndex] = middleValue;
        for (int i=middleIndex-1; i>=0; i--) {
            answer[i] = answer[i+1] - 1;
        }

        for (int i=middleIndex+1; i<num; i++) {
            answer[i] += answer[i-1] + 1;
        }

        assertThat(answer).containsExactly(2, 3, 4, 5);
    }

    /**
     * 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
     * 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
     * 1	2	3	4	[5, 4]
     * 9	2	1	3	[29, 6]
     */
    @Test
    public void 분수의_덧셈() {
        int numer1 = 9;
        int denom1 = 2;
        int numer2 = 1;
        int denom2 = 3;
        int[] answer = new int[2];

        int sumNumer = numer1 * denom2 + numer2 * denom1;
        int sumDenom = denom1 * denom2;
        int max = 1;

        for (int i=1; i<=sumNumer && i<=sumDenom; i++) {
            if (sumNumer % i == 0 && sumDenom % i == 0) {
                max = i;
            }
        }

        answer[0] = sumNumer / max;
        answer[1] = sumDenom / max;

        assertThat(answer).containsExactly(29, 6);
    }

    /**
     * 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
     * 지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
     * 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
     * [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]	16
     * [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]	13
     * [[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]	0
     */
    @Test
    public void 안전지대() {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};
        int answer = 0;

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int a=(i-1); a<=(i+1); a++) {
                        for (int b=(j-1); b<=(j+1); b++) {
                            if (a > -1 && a < board.length && b > -1 && b <board[a].length && board[a][b] != 1) {
                                board[a][b] = 2;
                            }
                        }
                    }
                }
            }
        }

        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    answer++;
                }
            }
        }

        // 배열 출력
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        assertThat(answer).isEqualTo(13);
    }

    /**
     * 선분 3개가 평행하게 놓여 있습니다. 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]]
     * 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
     * [[0, 1],  [2, 5],  [3, 9]]	2
     * [[-1, 1], [1, 3],  [3, 9]]	0
     * [[0, 5],  [3, 9],  [1, 10]]	8
     */
    @Test
    public void 겹치는_선분의_길이() {
        int[][] lines = new int[][]{{0, 1}, {2, 5}, {3, 9}};
        int answer = 0;

        int[] rail = new int[200];
        for (int[] line : lines) {
            for (int j = (line[0] + 100); j < (line[1] + 100); j++) {
                rail[j]++;
            }
        }

        for (int value : rail) {
            if (value > 1) answer++;
        }

        assertThat(answer).isEqualTo(2);
    }

    /**
     * 점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
     * [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
     * 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
     * 두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요.
     * [[1, 4], [9, 2], [3, 8], [11, 6]]	1
     * [[3, 5], [4, 1], [2, 4], [5, 10]]	0
     */
    @Test
    public void 평행() {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        int answer = 0;

        int xDiff1 = dots[1][0] - dots[0][0];
        int yDiff1 = dots[1][1] - dots[0][1];
        int xDiff2 = dots[3][0] - dots[2][0];
        int yDiff2 = dots[3][1] - dots[2][1];

        if (Math.abs(xDiff1 * yDiff2) == Math.abs(xDiff2 * yDiff1)) {
            answer = 1;
        } else {
            answer = 0;
        }

        assertThat(answer).isEqualTo(1);
    }

    /**
     * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
     * 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
     * ["aya", "yee", "u", "maa", "wyeoo"]	1
     * ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	3
     */
    @Test
    public void 옹알이_1() {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        int answer = 0;

        for (int i =0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", "1");
            babbling[i] = babbling[i].replace("woo", "1");
            babbling[i] = babbling[i].replace("ye", "1");
            babbling[i] = babbling[i].replace("ma", "1");
            babbling[i] = babbling[i].replace("1", "");
            if(babbling[i].isEmpty()) {
                answer += 1;
            }
        }

        assertThat(answer).isEqualTo(3);
    }
}
