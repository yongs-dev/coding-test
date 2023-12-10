package com.mark.codingtest.highscorekit;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstSearch {

    /**
     * n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
     * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서
     * 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
     *
     * numbers	        target	return
     * [1, 1, 1, 1, 1]	3	    5
     * [4, 1, 2, 1]	    4	    2
     */

    int targetNumberAnswer = 0;

    @Test
    public void 타겟_넘버() {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        targetNumberDFS(numbers, target, 0, 0);

        assertThat(targetNumberAnswer).isEqualTo(2);
    }

    private void targetNumberDFS(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) { // 마지막 노드까지 탐색한 경우
            if(target == sum) {
                targetNumberAnswer++;
            }
        } else { // 탐색할 노드가 남아있는 경우
            targetNumberDFS(numbers, target, depth + 1, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
            targetNumberDFS(numbers, target, depth + 1, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
        }
    }

    /**
     * 게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
     * 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
     * maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
     * 처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
     */
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    @Test
    public void 게임_맵_최단거리() {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;

        gameMapShortestDistanceBFS(maps, visited);
        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) answer = -1;

        assertThat(answer).isEqualTo(11);
    }

    private void gameMapShortestDistanceBFS(int[][] maps, int[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
