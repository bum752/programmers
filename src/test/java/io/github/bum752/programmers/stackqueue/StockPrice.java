package io.github.bum752.programmers.stackqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 주식가격
// https://programmers.co.kr/learn/courses/30/lessons/42584
public class StockPrice {

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			int price = prices[i];
			for (int j = i + 1; j < prices.length; j++) {
				answer[i]++;
				if (price > prices[j]) {
					break;
				}
			}
			if (i < prices.length - 1 && answer[i] == 0) {
				answer[i] = 1;
			}
		}

		return answer;
	}

	@Test
	public void 테스트1() {
		int[] price = new int[]{1, 2, 3, 2, 3};

		Assertions.assertArrayEquals(new int[]{4, 3, 1, 1, 0}, solution(price));
	}

	@Test
	public void 테스트2() {
		int[] price = new int[]{1, 2, 3, 4, 5};

		Assertions.assertArrayEquals(new int[]{4, 3, 2, 1, 0}, solution(price));
	}

	@Test
	public void 테스트3() {
		int[] price = new int[]{5, 4, 3, 2, 1};

		Assertions.assertArrayEquals(new int[]{1, 1, 1, 1, 0}, solution(price));
	}

	@Test
	public void 테스트4() {
		int[] price = new int[]{1, 2, 3, 2, 3, 1};

		Assertions.assertArrayEquals(new int[]{5, 4, 1, 2, 1, 0}, solution(price));
	}

	@Test
	public void 테스트5() {
		int[] price = new int[]{3, 1};

		Assertions.assertArrayEquals(new int[]{1, 0}, solution(price));
	}

	@Test
	public void 테스트6() {
		int[] price = new int[]{2, 3, 4, 5, 4};

		Assertions.assertArrayEquals(new int[]{4, 3, 2, 1, 0}, solution(price));
	}
}
