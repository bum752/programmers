package io.github.bum752.programmers.hash;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 위장
// https://programmers.co.kr/learn/courses/30/lessons/42578
public class Spy {

	public int solution(String[][] clothes) {
		Map<String, Integer> clothesMap = new HashMap<>();

		for (String[] c : clothes) {
			String clothesType = c[1];
			Integer clothesCount = clothesMap.getOrDefault(clothesType, 0);
			clothesCount += 1;
			clothesMap.put(clothesType, clothesCount);
		}

		int answer = clothesMap.keySet().stream().mapToInt(key -> clothesMap.get(key) + 1).reduce(1, (a, b) -> a * b);
		return answer - 1;
	}

	@Test
	public void 테스트1() {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

		Assertions.assertEquals(5, solution(clothes));
	}

	@Test
	public void 테스트2() {
		String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

		Assertions.assertEquals(3, solution(clothes));
	}

	@Test
	public void 테스트3() {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"crow_mask", "face"},
				{"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

		Assertions.assertEquals(23, solution(clothes));
	}

	@Test
	public void 테스트4() {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"crow_mask", "face"},
				{"blue_sunglasses", "face"}, {"smoky_makeup", "face"}, {"A", "none"}};

		Assertions.assertEquals(47, solution(clothes));
	}
}