package io.github.bum752.programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 프린터
// https://programmers.co.kr/learn/courses/30/lessons/42587
public class Printer {

	public int solution(int[] priorities, int location) {
		Queue<Integer> priorityQueue = Arrays.stream(priorities).boxed().collect(Collectors.toCollection(LinkedList::new));
		List<Integer> answerList = IntStream.range(0, priorities.length).boxed().collect(Collectors.toList());
		int index = 0;

		while (!priorityQueue.isEmpty()) {
			Integer priority = priorityQueue.poll();
			boolean existsHigherPriority = priorityQueue.stream().anyMatch(integer -> integer > priority);

			if (existsHigherPriority) {
				priorityQueue.add(priority);
				answerList.add(answerList.get(index));
				answerList.remove(index);
			} else {
				index++;
			}
		}

		for (int i = 0; i < answerList.size(); i++) {
			if (answerList.get(i) == location) {
				return i + 1;
			}
		}

		return -1;
	}

	@Test
	public void 테스트1() {
		int[] priorities = new int[]{2, 1, 3, 2};
		int location = 2;

		Assertions.assertEquals(1, solution(priorities, location));
	}

	@Test
	public void 테스트2() {
		int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
		int location = 0;

		Assertions.assertEquals(5, solution(priorities, location));
	}

	@Test
	public void 테스트3() {
		int[] priorities = new int[]{1, 2, 3};
		int location = 0;

		Assertions.assertEquals(3, solution(priorities, location));
	}

	@Test
	public void 테스트4() {
		int[] priorities = new int[]{2, 2, 2, 1, 3, 4};
		int location = 3;

		Assertions.assertEquals(6, solution(priorities, location));
	}
}
