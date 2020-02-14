package io.github.bum752.programmers.hash;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 완주하지 못한 선수
// https://programmers.co.kr/learn/courses/30/lessons/42576
public class Player {

	public String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < participant.length - 1; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return participant[participant.length - 1];
	}

	@Test
	public void 테스트1() {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};

		Assertions.assertEquals("leo", solution(participant, completion));
	}

	@Test
	public void 테스트2() {
		String[] participant = {"marina", "josipa", "nikola", "vinko", "fillipa"};
		String[] completion = {"josipa", "fillipa", "marina", "nikola"};

		Assertions.assertEquals("vinko", solution(participant, completion));
	}

	@Test
	public void 테스트3() {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};

		Assertions.assertEquals("mislav", solution(participant, completion));
	}
}