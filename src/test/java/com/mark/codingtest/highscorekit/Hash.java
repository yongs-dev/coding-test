package com.mark.codingtest.highscorekit;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Hash {

    /**
     * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
     * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
     * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
     * ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
     * ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
     * ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]     "mislav"
     */
    @Test
    public void 완주하지_못한_선수_solution() {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        for (String comp : completion) {
            map.put(comp, map.get(comp) - 1);
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() != 0) {
                answer = e.getKey();
                break;
            }
        }

        assertThat(answer).isEqualTo("mislav");
    }

    /**
     * 홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
     * 홍 박사님 연구실의 폰켓몬은 종류에 따라 번호를 붙여 구분합니다. 따라서 같은 종류의 폰켓몬은 같은 번호를 가지고 있습니다.
     * 예를 들어 연구실에 총 4마리의 폰켓몬이 있고, 각 폰켓몬의 종류 번호가 [3번, 1번, 2번, 3번]이라면
     * 이는 3번 폰켓몬 두 마리, 1번 폰켓몬 한 마리, 2번 폰켓몬 한 마리가 있음을 나타냅니다.
     * 이때, 4마리의 폰켓몬 중 2마리를 고르는 방법은 다음과 같이 6가지가 있습니다.
     * 첫 번째(3번), 두 번째(1번) 폰켓몬을 선택
     * 첫 번째(3번), 세 번째(2번) 폰켓몬을 선택
     * 첫 번째(3번), 네 번째(3번) 폰켓몬을 선택
     * 두 번째(1번), 세 번째(2번) 폰켓몬을 선택
     * 두 번째(1번), 네 번째(3번) 폰켓몬을 선택
     * 세 번째(2번), 네 번째(3번) 폰켓몬을 선택
     *
     * 당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에, 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.
     * N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, N/2마리의 폰켓몬을 선택하는 방법 중,
     * 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
     * [3,1,2,3]	    2
     * [3,3,3,2,2,4]	3
     * [3,3,3,2,2,2]	2
     */
    @Test
    public void 폰켓몬() {
        int[] nums = {3, 3, 3, 2, 2, 4};
        int answer = 0;
        int length = nums.length / 2;   // 최대 nums / 2 마리

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        answer = Math.min(length, set.size());
        assertThat(answer).isEqualTo(3);
    }

    /**
     * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
     * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
     * 구조대 : 119
     * 박준영 : 97 674 223
     * 지영석 : 11 9552 4421
     * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
     * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
     * ["119", "97674223", "1195524421"]	false
     * ["123","456","789"]	true
     * ["12","123","1235","567","88"]	false
     */
    @Test
    public void 전화번호_목록() {
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean answer = true;

        Arrays.sort(phone_book);
        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }

        assertThat(answer).isFalse();
    }

    /**
     * 코니는 매일 다른 옷을 조합하여 입는것을 좋아합니다. 예를 들어 코니가 가진 옷이 아래와 같고,
     * 오늘 코니가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야합니다.
     * 얼굴	동그란 안경, 검정 선글라스
     * 상의	파란색 티셔츠
     * 하의	청바지
     * 겉옷	긴 코트
     *
     * 코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다. 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
     * 착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
     * 코니는 하루에 최소 한 개의 의상은 입습니다.
     * 코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
     *
     * [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
     * [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	3
     */
    @Test
    public void 의상() {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        for (int value : map.values()) {
            // 각 옷 종류를 입지 않는 경우를 고려하기 위해 +1 추가
            answer *= value + 1;
        }

        // 전체 옷을 입은 케이스를 하나 빼준다.
        answer = answer - 1;
        assertThat(answer).isEqualTo(5);
    }

    /**
     * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
     * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
     *
     * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
     * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
     * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
     *
     * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
     * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
     * ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
     */
    @Test
    public void 베스트_앨범() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // key 값만 가져와서 genre에 넣어주기
        List<String> genre = new ArrayList<>(map.keySet());

        // key 값에 해당하는 value를 내림차순으로 정렬
        genre.sort((o1, o2) -> map.get(o2) - map.get(o1));

        List<Integer> list = new ArrayList<>();
        for (String g : genre) {
            // 해당 장르의 음악중에서 play 횟수가 가장 큰 인덱스를 찾는다
            int max = 0;
            int firstIdx = -1;
            for (int i = 0; i < genres.length; i++) {
                if (g.equals(genres[i]) && max < plays[i]) {
                    max = plays[i];
                    firstIdx = i;
                }
            }

            // 해당 장르의 음악 중에서 play 횟수가 두번째로 큰 인덱스를 찾는다
            max = 0;
            int secondIdx = -1;
            for (int i = 0; i < genres.length; i++) {
                if (g.equals(genres[i]) && max < plays[i] && i != firstIdx) {
                    max = plays[i];
                    secondIdx = i;
                }
            }

            list.add(firstIdx);
            if (secondIdx >= 0) list.add(secondIdx); // secondIdx는 존재할 수도, 안할 수 도 있다
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        assertThat(answer).containsExactly(4, 1, 3, 0);
    }
}
