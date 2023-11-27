package com.mark.codingtest.introductorycourse;

import org.junit.jupiter.api.Test;

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

    }
}
