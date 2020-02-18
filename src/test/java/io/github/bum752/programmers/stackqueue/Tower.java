package io.github.bum752.programmers.stackqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 탑
// https://programmers.co.kr/learn/courses/30/lessons/42588
public class Tower {

	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];

		for (int i = 0; i < heights.length; i++) {
			for (int j = i + 1; j < heights.length; j++) {
				if (heights[i] > heights[j]) {
					answer[j] = i + 1;
				}
			}
		}

		return answer;
	}

	@Test
	public void 테스트1() {
		int[] heights = new int[]{6, 9, 5, 7, 4};

		Assertions.assertArrayEquals(new int[]{0, 0, 2, 2, 4}, solution(heights));
	}

	@Test
	public void 테스트2() {
		int[] heights = new int[]{3, 9, 9, 3, 5, 7, 2};

		Assertions.assertArrayEquals(new int[]{0, 0, 0, 3, 3, 3, 6}, solution(heights));
	}

	@Test
	public void 테스트3() {
		int[] heights = new int[]{1, 5, 3, 6, 7, 6, 5};

		Assertions.assertArrayEquals(new int[]{0, 0, 2, 0, 0, 5, 6}, solution(heights));
	}
}
